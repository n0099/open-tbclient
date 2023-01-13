package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"BDSoLoader", "UnsafeDynamicallyLoadedCode"})
/* loaded from: classes5.dex */
public class ma2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            Object e = e((PathClassLoader) context.getClassLoader());
            Field declaredField = e.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField.setAccessible(true);
            File[] fileArr = (File[]) declaredField.get(e);
            Object newInstance = Array.newInstance(File.class, fileArr.length + 1);
            Array.set(newInstance, 0, new File(str));
            for (int i = 1; i < fileArr.length + 1; i++) {
                Array.set(newInstance, i, fileArr[i - 1]);
            }
            declaredField.set(e, newInstance);
        }
    }

    public static void c(Context context, String str) throws NoSuchFieldException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
            Field declaredField = pathClassLoader.getClass().getDeclaredField("mLibPaths");
            declaredField.setAccessible(true);
            String[] strArr = (String[]) declaredField.get(pathClassLoader);
            Object newInstance = Array.newInstance(String.class, strArr.length + 1);
            Array.set(newInstance, 0, str);
            for (int i = 1; i < strArr.length + 1; i++) {
                Array.set(newInstance, i, strArr[i - 1]);
            }
            declaredField.set(pathClassLoader, newInstance);
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static void b(Context context, String str) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, str) != null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Object e = e((PathClassLoader) context.getClassLoader());
        Field declaredField = e.getClass().getDeclaredField("systemNativeLibraryDirectories");
        declaredField.setAccessible(true);
        List list = (List) declaredField.get(e);
        list.add(new File(str));
        declaredField.set(e, list);
        Field declaredField2 = e.getClass().getDeclaredField("nativeLibraryDirectories");
        declaredField2.setAccessible(true);
        ArrayList arrayList = (ArrayList) declaredField2.get(e);
        arrayList.add(new File(str));
        declaredField2.set(e, arrayList);
        Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
        Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
        Field declaredField3 = e.getClass().getDeclaredField("nativeLibraryPathElements");
        declaredField3.setAccessible(true);
        Object[] objArr = (Object[]) declaredField3.get(e);
        Object newInstance = Array.newInstance(cls, objArr.length + 1);
        if (constructor != null) {
            try {
                Array.set(newInstance, 0, constructor.newInstance(new File(str), Boolean.TRUE, null, null));
                for (int i = 1; i < objArr.length + 1; i++) {
                    Array.set(newInstance, i, objArr[i - 1]);
                }
                declaredField3.set(e, newInstance);
            } catch (IllegalArgumentException unused) {
                Method declaredMethod = e.getClass().getDeclaredMethod("makePathElements", List.class);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, arrayList);
                Field declaredField4 = e.getClass().getDeclaredField("nativeLibraryPathElements");
                declaredField4.setAccessible(true);
                declaredField4.set(e, invoke);
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static Object d(Object obj, Class cls, String str) throws NoSuchFieldException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, obj, cls, str)) == null) {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return invokeLLL.objValue;
    }

    public static Object e(Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            return d(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
        }
        return invokeL.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                Class.forName("dalvik.system.BaseDexClassLoader");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            if (f()) {
                try {
                    try {
                        a(context, str);
                        return;
                    } catch (Exception unused) {
                        b(context, str);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
                c(context, str);
            } catch (Exception unused2) {
            }
        }
    }

    public static boolean h(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, str, str2, z)) == null) {
            if (!z) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                }
            }
            try {
                System.load(str2 + File.separator + "lib" + str + ".so");
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
