package com.baidu.webkit.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ReflectUtils implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static String sReflectErrorDetail = "none";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1132458036, "Lcom/baidu/webkit/internal/ReflectUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1132458036, "Lcom/baidu/webkit/internal/ReflectUtils;");
        }
    }

    public ReflectUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void expandPathList(File file, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, file, cls) == null) {
            try {
                Object pathList = getPathList((BaseDexClassLoader) cls.getClassLoader());
                Field declaredField = pathList.getClass().getDeclaredField("nativeLibraryDirectories");
                declaredField.setAccessible(true);
                File[] fileArr = (File[]) declaredField.get(pathList);
                Object newInstance = Array.newInstance(File.class, fileArr.length + 1);
                Array.set(newInstance, 0, file);
                for (int i = 1; i < fileArr.length + 1; i++) {
                    Array.set(newInstance, i, fileArr[i - 1]);
                }
                declaredField.set(pathList, newInstance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void expandPathList(String str, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, cls) == null) || str == null) {
            return;
        }
        expandPathList(new File(str), cls);
    }

    public static Object getField(Object obj, Class cls, String str) throws NoSuchFieldException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, cls, str)) == null) {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return invokeLLL.objValue;
    }

    public static Field getField(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, str)) == null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable th) {
                setReflectErrorDetail(th.toString());
                return null;
            }
        }
        return (Field) invokeLL.objValue;
    }

    public static Method getMethod(Class cls, String str, Class... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, str, clsArr)) == null) {
            try {
                Method method = cls.getMethod(str, clsArr);
                method.setAccessible(true);
                return method;
            } catch (Throwable th) {
                setReflectErrorDetail(th.toString());
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object getPathList(Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? getField(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList") : invokeL.objValue;
    }

    public static String getReflectErrorDetailAndReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = sReflectErrorDetail;
            sReflectErrorDetail = "none";
            return str == null ? "none" : str;
        }
        return (String) invokeV.objValue;
    }

    public static void setReflectErrorDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            sReflectErrorDetail = str;
        }
    }
}
