package com.baidu.webkit.sdk;

import android.os.Build;
import android.util.AndroidRuntimeException;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public final class ZeusClassLoader extends BaseDexClassLoader {
    public static String ANDROID_SUPPORT_V4 = "zeus.support.v4.";
    public static String BAIDU_MONITOR = "com.baidu.monitor.";
    public static String COM_BAIDU_BLINK = "com.baidu.blink.";
    public static String COM_BAIDU_CYBERPLAYER = "com.baidu.cyberplayer.";
    public static String COM_BAIDU_DUMPER = "com.baidu.dumper.";
    public static String COM_BAIDU_ZEUS = "com.baidu.zeus.";
    public static Class DexPathListClass = null;
    public static Class ElementClass = null;
    public static String ORG_CHROMIUM = "org.chromium.";
    public static String ORG_CHROMIUM_NET = "org.chromium.net.";
    public static final String TAG = "ZeusClassLoader";

    public ZeusClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(logBeforeCallSuper(str, "super()"), file, str2, classLoader);
        if (Build.VERSION.SDK_INT >= 21 || !str.endsWith(".so")) {
            return;
        }
        makeAndSetDexElements(str, file, str2, classLoader);
    }

    public static void ensureReflectionInited() throws Exception {
        if (DexPathListClass == null || ElementClass == null) {
            Class<?> cls = Class.forName("dalvik.system.DexPathList");
            DexPathListClass = cls;
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Class<?> cls2 = declaredClasses[i];
                if (cls2.getSimpleName().equals("Element")) {
                    ElementClass = cls2;
                    break;
                }
                i++;
            }
            if (ElementClass == null) {
                throw new AndroidRuntimeException("DexPathList$Element not found!");
            }
        }
    }

    public static Object getField(Class cls, Object obj, String str) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        declaredField.setAccessible(isAccessible);
        return obj2;
    }

    public static boolean isFileSuffixCheckExists() {
        try {
            ensureReflectionInited();
            for (Field field : DexPathListClass.getDeclaredFields()) {
                String name = field.getName();
                Log.d(TAG, "f.getName=" + name);
                if ("JAR_SUFFIX".equals(name) || "ZIP_SUFFIX".equals(name) || "APK_SUFFIX".equals(name)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String logBeforeCallSuper(String str, String str2) {
        Log.d(TAG, str2);
        return str;
    }

    private void makeAndSetDexElements(String str, File file, String str2, ClassLoader classLoader) {
        Object newInstance;
        try {
            ensureReflectionInited();
            String replace = new File(str).getName().replace(".so", ".dex");
            DexFile loadDex = DexFile.loadDex(str, file.getAbsolutePath() + File.separator + replace, 0);
            Constructor<?> constructor = ElementClass.getConstructors()[0];
            int length = constructor.getParameterTypes().length;
            if (length == 4) {
                newInstance = constructor.newInstance(new File(str), Boolean.FALSE, null, loadDex);
            } else if (length != 3) {
                throw new Exception("Unsupported:" + constructor.toGenericString());
            } else {
                newInstance = constructor.newInstance(new File(str), null, loadDex);
            }
            Object newInstance2 = Array.newInstance(ElementClass, 1);
            Array.set(newInstance2, 0, newInstance);
            Object field = getField(BaseDexClassLoader.class, this, "pathList");
            setField(DexPathListClass, field, "dexElements", newInstance2);
            if (Build.VERSION.SDK_INT >= 19) {
                setField(DexPathListClass, field, "dexElementsSuppressedExceptions", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new AndroidRuntimeException(e2);
        }
    }

    public static void setField(Class cls, Object obj, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
        declaredField.setAccessible(isAccessible);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str) throws ClassNotFoundException {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (str != null && (str.startsWith(ORG_CHROMIUM) || str.startsWith(COM_BAIDU_BLINK) || str.startsWith(COM_BAIDU_CYBERPLAYER) || str.startsWith(COM_BAIDU_ZEUS) || str.startsWith(COM_BAIDU_DUMPER) || str.startsWith(ANDROID_SUPPORT_V4) || str.startsWith(BAIDU_MONITOR))) {
                Class<?> findLoadedClass = findLoadedClass(str);
                if (findLoadedClass != null) {
                    ZeusPerformanceTiming.sumLoadClassTime(System.currentTimeMillis() - currentTimeMillis);
                    return findLoadedClass;
                }
                Class<?> findClass = findClass(str);
                if (findClass != null) {
                    ZeusWebViewPreloadClass.getInstance().appendLoadClass(str);
                    ZeusPerformanceTiming.sumLoadClassTime(System.currentTimeMillis() - currentTimeMillis);
                    return findClass;
                }
            }
        } catch (Throwable unused) {
            Log.e(TAG, "loadClass error. aClassName=" + str);
        }
        return super.loadClass(str);
    }
}
