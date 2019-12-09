package com.baidu.tieba.l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.mobstat.Config;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public final class a {
    private static final String SECONDARY_FOLDER_NAME = "code_cache" + File.separator + "secondary-dexes";
    private static final Set<String> hxq = new HashSet();
    private static final boolean hxr = Ad(System.getProperty("java.vm.version"));

    public static void dJ(Context context) {
        Log.i("MultiDex", Config.INPUT_INSTALLED_PKG);
        if (hxr) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
        } else if (Build.VERSION.SDK_INT < 4) {
            throw new RuntimeException("Multi dex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4" + DefaultConfig.TOKEN_SEPARATOR);
        } else {
            try {
                ApplicationInfo applicationInfo = getApplicationInfo(context);
                if (applicationInfo != null) {
                    Set<String> set = hxq;
                    synchronized (hxq) {
                        String str = applicationInfo.sourceDir;
                        if (!hxq.contains(str)) {
                            hxq.add(str);
                            if (Build.VERSION.SDK_INT > 20) {
                                Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
                            }
                            try {
                                ClassLoader classLoader = context.getClassLoader();
                                if (classLoader == null) {
                                    Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                                    return;
                                }
                                dK(context);
                                File file = new File(applicationInfo.dataDir, SECONDARY_FOLDER_NAME);
                                List<File> a = com.baidu.tieba.l.b.a(context, applicationInfo, file, false);
                                if (dL(a)) {
                                    a(classLoader, file, a);
                                } else {
                                    Log.w("MultiDex", "Files were not valid zip files.  Forcing a reload.");
                                    List<File> a2 = com.baidu.tieba.l.b.a(context, applicationInfo, file, true);
                                    if (!dL(a2)) {
                                        throw new RuntimeException("Zip files were not valid.");
                                    }
                                    a(classLoader, file, a2);
                                }
                                Log.i("MultiDex", "install done");
                            } catch (RuntimeException e) {
                                Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e("MultiDex", "Multidex installation failure", e2);
                throw new RuntimeException("Multi dex installation failed (" + e2.getMessage() + ").");
            }
        }
    }

    private static ApplicationInfo getApplicationInfo(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, 128);
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    static boolean Ad(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        Log.i("MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static void a(ClassLoader classLoader, File file, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        if (!list.isEmpty()) {
            if (Build.VERSION.SDK_INT < 19) {
                if (Build.VERSION.SDK_INT < 14) {
                    c.a(classLoader, list);
                    return;
                } else {
                    C0448a.a(classLoader, list, file);
                    return;
                }
            }
            b.a(classLoader, list, file);
        }
    }

    private static boolean dL(List<File> list) {
        for (File file : list) {
            if (!com.baidu.tieba.l.b.B(file)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method b(Object obj, String str, Class... clsArr) throws NoSuchMethodException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
    }

    private static void dK(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (!file2.delete()) {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                } else {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void a(ClassLoader classLoader, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field findField = a.findField(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) findField.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            findField.set(classLoader, sb.toString());
            a.c(classLoader, "mPaths", strArr);
            a.c(classLoader, "mFiles", fileArr);
            a.c(classLoader, "mZips", zipFileArr);
            a.c(classLoader, "mDexs", dexFileArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0448a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void a(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object obj = a.findField(classLoader, "pathList").get(classLoader);
            a.c(obj, "dexElements", a(obj, new ArrayList(list), file));
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) a.b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, arrayList, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void a(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            IOException[] iOExceptionArr;
            Object obj = a.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            a.c(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field findField = a.findField(classLoader, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField.get(classLoader);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                findField.set(classLoader, iOExceptionArr);
            }
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) a.b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
        }
    }
}
