package com.baidu.webkit.sdk;

import android.os.Build;
import android.util.AndroidRuntimeException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public final class ZeusClassLoader extends BaseDexClassLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ANDROIDX = "androidx.";
    public static String ANDROID_SUPPORT_V4 = "zeus.support.v4.";
    public static String BAIDU_MONITOR = "com.baidu.monitor.";
    public static String COM_BAIDU_BLINK = "com.baidu.blink.";
    public static String COM_BAIDU_CYBERPLAYER = "com.baidu.cyberplayer.";
    public static String COM_BAIDU_DUMPER = "com.baidu.dumper.";
    public static String COM_BAIDU_ZEUS = "com.baidu.zeus.";
    public static String DESUGAR_RUNTIME = "com.google.devtools.build.android.desugar.runtime.";
    public static Class DexPathListClass = null;
    public static Class ElementClass = null;
    public static String ORG_CHROMIUM = "org.chromium.";
    public static String ORG_CHROMIUM_NET = "org.chromium.net.";
    public static final String TAG = "ZeusClassLoader";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1018398221, "Lcom/baidu/webkit/sdk/ZeusClassLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1018398221, "Lcom/baidu/webkit/sdk/ZeusClassLoader;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZeusClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(logBeforeCallSuper(str, "super()"), file, str2, classLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file, str2, classLoader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (File) objArr2[1], (String) objArr2[2], (ClassLoader) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 21 || !str.endsWith(".so")) {
            return;
        }
        makeAndSetDexElements(str, file, str2, classLoader);
    }

    public static void ensureReflectionInited() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            if (DexPathListClass == null || ElementClass == null) {
                Class<?> cls = Class.forName("dalvik.system.DexPathList");
                DexPathListClass = cls;
                Class<?>[] declaredClasses = cls.getDeclaredClasses();
                int length = declaredClasses.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Class<?> cls2 = declaredClasses[i2];
                    if (cls2.getSimpleName().equals("Element")) {
                        ElementClass = cls2;
                        break;
                    }
                    i2++;
                }
                if (ElementClass == null) {
                    throw new AndroidRuntimeException("DexPathList$Element not found!");
                }
            }
        }
    }

    public static Object getField(Class cls, Object obj, String str) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, obj, str)) == null) {
            Field declaredField = cls.getDeclaredField(str);
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            declaredField.setAccessible(isAccessible);
            return obj2;
        }
        return invokeLLL.objValue;
    }

    public static boolean isFileSuffixCheckExists() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                ensureReflectionInited();
                for (Field field : DexPathListClass.getDeclaredFields()) {
                    String name = field.getName();
                    Log.d(TAG, "f.getName=".concat(String.valueOf(name)));
                    if ("JAR_SUFFIX".equals(name) || "ZIP_SUFFIX".equals(name) || "APK_SUFFIX".equals(name)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String logBeforeCallSuper(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            Log.d(TAG, str2);
            return str;
        }
        return (String) invokeLL.objValue;
    }

    private void makeAndSetDexElements(String str, File file, String str2, ClassLoader classLoader) {
        Object newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, this, str, file, str2, classLoader) == null) {
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
    }

    public static void setField(Class cls, Object obj, String str, Object obj2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, cls, obj, str, obj2) == null) {
            Field declaredField = cls.getDeclaredField(str);
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            declaredField.setAccessible(isAccessible);
        }
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str) throws ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (str != null && (str.startsWith(ORG_CHROMIUM) || str.startsWith(COM_BAIDU_BLINK) || str.startsWith(COM_BAIDU_CYBERPLAYER) || str.startsWith(COM_BAIDU_ZEUS) || str.startsWith(COM_BAIDU_DUMPER) || str.startsWith(ANDROID_SUPPORT_V4) || str.startsWith(BAIDU_MONITOR) || str.startsWith(ANDROIDX) || str.startsWith(DESUGAR_RUNTIME))) {
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
                Log.e(TAG, "loadClass error. aClassName=".concat(String.valueOf(str)));
            }
            return super.loadClass(str);
        }
        return (Class) invokeL.objValue;
    }
}
