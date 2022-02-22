package com.bytedance.pangle.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.log.ZeusLogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<File> a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f53188b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int a = 4;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC2050a f53189b;

        /* renamed from: com.bytedance.pangle.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public interface InterfaceC2050a {
            Object a(File file, DexFile dexFile);
        }

        /* renamed from: com.bytedance.pangle.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C2051b implements InterfaceC2050a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Constructor<?> a;

            public C2051b(Class<?> cls) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cls};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.a = constructor;
                constructor.setAccessible(true);
            }

            @Override // com.bytedance.pangle.c.b.a.InterfaceC2050a
            public final Object a(File file, DexFile dexFile) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, dexFile)) == null) ? this.a.newInstance(file, new ZipFile(file), dexFile) : invokeLL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class c implements InterfaceC2050a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Constructor<?> a;

            public c(Class<?> cls) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cls};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.a = constructor;
                constructor.setAccessible(true);
            }

            @Override // com.bytedance.pangle.c.b.a.InterfaceC2050a
            public final Object a(File file, DexFile dexFile) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, dexFile)) == null) ? this.a.newInstance(file, file, dexFile) : invokeLL.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class d implements InterfaceC2050a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Constructor<?> a;

            public d(Class<?> cls) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cls};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.a = constructor;
                constructor.setAccessible(true);
            }

            @Override // com.bytedance.pangle.c.b.a.InterfaceC2050a
            public final Object a(File file, DexFile dexFile) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, dexFile)) == null) ? this.a.newInstance(file, Boolean.FALSE, file, dexFile) : invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(712826134, "Lcom/bytedance/pangle/c/b$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712826134, "Lcom/bytedance/pangle/c/b$a;");
            }
        }

        public a() {
            InterfaceC2050a dVar;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    dVar = new C2051b(cls);
                } catch (NoSuchMethodException unused) {
                    dVar = new d(cls);
                }
            } catch (NoSuchMethodException unused2) {
                dVar = new c(cls);
            }
            this.f53189b = dVar;
        }

        public static void a(ClassLoader classLoader, List<? extends File> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, list) == null) {
                Object obj = b.b(classLoader, "pathList").get(classLoader);
                a aVar = new a();
                int size = list.size();
                Object[] objArr = new Object[size];
                for (int i2 = 0; i2 < size; i2++) {
                    File file = list.get(i2);
                    InterfaceC2050a interfaceC2050a = aVar.f53189b;
                    String path = file.getPath();
                    File parentFile = file.getParentFile();
                    String name = file.getName();
                    objArr[i2] = interfaceC2050a.a(file, DexFile.loadDex(path, new File(parentFile, name.substring(0, name.length() - a) + ".dex").getPath(), 0));
                }
                try {
                    b.a(obj, "dexElements", objArr);
                } catch (NoSuchFieldException e2) {
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed find field 'dexElements' attempting 'pathElements'", e2);
                    b.a(obj, "pathElements", objArr);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(ClassLoader classLoader, List<? extends File> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, classLoader, list) == null) {
                int size = list.size();
                Field b2 = b.b(classLoader, "path");
                StringBuilder sb = new StringBuilder((String) b2.get(classLoader));
                String[] strArr = new String[size];
                File[] fileArr = new File[size];
                ZipFile[] zipFileArr = new ZipFile[size];
                DexFile[] dexFileArr = new DexFile[size];
                ListIterator<? extends File> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    File next = listIterator.next();
                    String absolutePath = next.getAbsolutePath();
                    sb.append(':');
                    sb.append(absolutePath);
                    int previousIndex = listIterator.previousIndex();
                    strArr[previousIndex] = absolutePath;
                    fileArr[previousIndex] = next;
                    zipFileArr[previousIndex] = new ZipFile(next);
                    dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
                }
                b2.set(classLoader, sb.toString());
                b.a(classLoader, "mPaths", strArr);
                b.a(classLoader, "mFiles", fileArr);
                b.a(classLoader, "mZips", zipFileArr);
                b.a(classLoader, "mDexs", dexFileArr);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-294229965, "Lcom/bytedance/pangle/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-294229965, "Lcom/bytedance/pangle/c/b;");
                return;
            }
        }
        a = new HashSet();
        f53188b = a(System.getProperty("java.vm.version"));
    }

    public static Field b(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    return declaredField;
                } catch (NoSuchFieldException unused) {
                }
            }
            throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
        }
        return (Field) invokeLL.objValue;
    }

    public static void a(PluginContext pluginContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, pluginContext) == null) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Installing application");
            if (f53188b) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex VM has multidex support, MultiDex support library is disabled.");
            } else if (Build.VERSION.SDK_INT >= 4) {
                try {
                    ApplicationInfo a2 = a((Context) pluginContext);
                    if (a2 == null) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                        return;
                    }
                    a(a2, pluginContext, new File(pluginContext.mPlugin.mHostApplicationInfoHookSomeField.sourceDir), "secondary-dexes", a2.packageName);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex install done");
                } catch (Exception e2) {
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDex installation failure", e2);
                    throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
                }
            } else {
                throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
            }
        }
    }

    public static Method b(Object obj, String str, Class... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, obj, str, clsArr)) == null) {
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    return declaredMethod;
                } catch (NoSuchMethodException unused) {
                }
            }
            throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
        }
        return (Method) invokeLLL.objValue;
    }

    public static void b(PluginContext pluginContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, pluginContext) == null) {
            File file = new File(pluginContext.getDataDir().getAbsolutePath() + "/files/secondary-dexes");
            if (file.isDirectory()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Clearing old secondary dex dir (" + file.getPath() + ").");
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to list secondary dex dir content (" + file.getPath() + ").");
                    return;
                }
                for (File file2 : listFiles) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                    if (file2.delete()) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Deleted old file " + file2.getPath());
                    } else {
                        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete old file " + file2.getPath());
                    }
                }
                if (!file.delete()) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete secondary dex dir " + file.getPath());
                    return;
                }
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Deleted old secondary dex dir " + file.getPath());
            }
        }
    }

    public static void a(@NonNull ApplicationInfo applicationInfo, PluginContext pluginContext, File file, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, applicationInfo, pluginContext, file, str, str2) == null) {
            synchronized (a) {
                if (!a.contains(file)) {
                    a.add(file);
                    if (Build.VERSION.SDK_INT > 20) {
                        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
                    }
                    try {
                        PluginClassLoader pluginClassLoader = pluginContext.mPlugin.mClassLoader;
                        if (pluginClassLoader == null) {
                            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Context class loader is null. Must be running in test mode. Skip patching.");
                        } else {
                            String str3 = applicationInfo.packageName;
                            b(pluginContext);
                            File a2 = a(pluginContext, pluginContext.getDataDir(), str);
                            com.bytedance.pangle.c.a aVar = new com.bytedance.pangle.c.a(file, a2);
                            IOException e2 = null;
                            try {
                                a(pluginClassLoader, a2, aVar.a(pluginContext, str2, false));
                            } catch (IOException e3) {
                                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDexFailed to install extracted secondary dex files, retrying with forced extraction", e3);
                                a(pluginClassLoader, a2, aVar.a(pluginContext, str2, true));
                            }
                            try {
                                aVar.close();
                            } catch (IOException e4) {
                                e2 = e4;
                            }
                            if (e2 != null) {
                                throw e2;
                            }
                        }
                    } catch (RuntimeException e5) {
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e5);
                    }
                }
            }
        }
    }

    /* renamed from: com.bytedance.pangle.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C2052b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(ClassLoader classLoader, List<? extends File> list, File file) {
            IOException[] iOExceptionArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, classLoader, list, file) == null) {
                Object obj = b.b(classLoader, "pathList").get(classLoader);
                ArrayList arrayList = new ArrayList();
                b.a(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Exception in makeDexElement", (IOException) it.next());
                    }
                    Field b2 = b.b(obj, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr2 = (IOException[]) b2.get(obj);
                    if (iOExceptionArr2 == null) {
                        iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                    } else {
                        IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                        arrayList.toArray(iOExceptionArr3);
                        System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                        iOExceptionArr = iOExceptionArr3;
                    }
                    b2.set(obj, iOExceptionArr);
                    IOException iOException = new IOException("I/O exception during makeDexElement");
                    iOException.initCause((Throwable) arrayList.get(0));
                    throw iOException;
                }
            }
        }

        public static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, obj, arrayList, file, arrayList2)) == null) ? (Object[]) b.b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2) : (Object[]) invokeLLLL.objValue;
        }
    }

    public static ApplicationInfo a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getApplicationInfo();
            } catch (RuntimeException e2) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDexFailure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
                return null;
            }
        }
        return (ApplicationInfo) invokeL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            boolean z = false;
            if (str != null) {
                Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
                if (matcher.matches()) {
                    try {
                        int parseInt = Integer.parseInt(matcher.group(1));
                        int parseInt2 = Integer.parseInt(matcher.group(2));
                        if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                            z = true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            StringBuilder sb = new StringBuilder("PluginMultiDex VM with version ");
            sb.append(str);
            sb.append(z ? " has multidex support" : " does not have multidex support");
            ZeusLogger.i(ZeusLogger.TAG_LOAD, sb.toString());
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void a(ClassLoader classLoader, File file, List<? extends File> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, classLoader, file, list) == null) || list.isEmpty()) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            C2052b.a(classLoader, list, file);
        } else if (i2 >= 14) {
            a.a(classLoader, list);
        } else {
            c.a(classLoader, list);
        }
    }

    public static File a(Context context, File file, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, file, str)) == null) {
            File file2 = new File(file, MultiDex.CODE_CACHE_NAME);
            try {
                a(file2);
            } catch (IOException unused) {
                file2 = new File(context.getFilesDir(), MultiDex.CODE_CACHE_NAME);
                a(file2);
            }
            File file3 = new File(file2, str);
            a(file3);
            return file3;
        }
        return (File) invokeLLL.objValue;
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, file) == null) {
            file.mkdir();
            if (file.isDirectory()) {
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }

    public static /* synthetic */ void a(Object obj, String str, Object[] objArr) {
        Field b2 = b(obj, str);
        Object[] objArr2 = (Object[]) b2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b2.set(obj, objArr3);
    }
}
