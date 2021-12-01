package com.bytedance.pangle.util;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes12.dex */
public class MethodUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?>[] EMPTY_CLASS_ARRAY;
    public static Map<String, Method> sMethodCache;
    public static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(353699530, "Lcom/bytedance/pangle/util/MethodUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(353699530, "Lcom/bytedance/pangle/util/MethodUtils;");
                return;
            }
        }
        sMethodCache = new HashMap();
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        sPrimitiveToWrapperMap = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        sPrimitiveToWrapperMap.put(Byte.TYPE, Byte.class);
        sPrimitiveToWrapperMap.put(Character.TYPE, Character.class);
        sPrimitiveToWrapperMap.put(Short.TYPE, Short.class);
        sPrimitiveToWrapperMap.put(Integer.TYPE, Integer.class);
        sPrimitiveToWrapperMap.put(Long.TYPE, Long.class);
        sPrimitiveToWrapperMap.put(Double.TYPE, Double.class);
        sPrimitiveToWrapperMap.put(Float.TYPE, Float.class);
        sPrimitiveToWrapperMap.put(Void.TYPE, Void.class);
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public MethodUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Method method;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, clsArr)) == null) {
            String key = getKey(cls, str, clsArr);
            synchronized (sMethodCache) {
                method = sMethodCache.get(key);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            while (cls != null) {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                }
                if (method == null) {
                    try {
                        for (Method method2 : cls.getDeclaredMethods()) {
                            if (method2 != null && TextUtils.equals(method2.getName(), str)) {
                                Class<?>[] parameterTypes = method2.getParameterTypes();
                                if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                    boolean z = true;
                                    for (int i2 = 0; i2 < clsArr.length; i2++) {
                                        if (!isAssignableFrom(clsArr[i2], parameterTypes[i2])) {
                                            z = false;
                                        }
                                    }
                                    if (z) {
                                        method = method2;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (method != null) {
                    method.setAccessible(true);
                    synchronized (sMethodCache) {
                        sMethodCache.put(key, method);
                    }
                    return method;
                }
                cls = cls.getSuperclass();
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.toString());
            sb.append("#");
            sb.append(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class<?> cls2 : clsArr) {
                    sb.append(cls2.toString());
                    sb.append("#");
                }
            } else {
                sb.append(Void.class.toString());
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, clsArr)) == null) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
                return declaredConstructor;
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        return (Constructor) invokeLL.objValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, objArr)) == null) ? (T) invokeConstructor(cls, objArr, toClass(objArr)) : (T) invokeLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, obj, str, objArr, clsArr)) == null) {
            Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
            if (accessibleMethod != null) {
                return accessibleMethod.invoke(obj, objArr);
            }
            throw new NoSuchMethodException(str);
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, cls, str, objArr, clsArr)) == null) {
            Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
            if (accessibleMethod != null) {
                return accessibleMethod.invoke(null, objArr);
            }
            return null;
        }
        return invokeLLLL.objValue;
    }

    public static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, cls, cls2)) == null) {
            if (cls2 == null) {
                return false;
            }
            if (cls == null) {
                return !cls2.isPrimitive();
            }
            if (cls.isPrimitive() && !cls2.isPrimitive()) {
                cls = sPrimitiveToWrapperMap.get(cls);
            }
            if (cls2.isPrimitive() && !cls.isPrimitive()) {
                cls2 = sPrimitiveToWrapperMap.get(cls2);
            }
            return cls2.isAssignableFrom(cls);
        }
        return invokeLL.booleanValue;
    }

    public static Class<?>[] toClass(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, objArr)) == null) {
            if (objArr != null && objArr.length != 0) {
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
                }
                return clsArr;
            }
            return EMPTY_CLASS_ARRAY;
        }
        return (Class[]) invokeL.objValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, objArr, clsArr)) == null) {
            Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, clsArr);
            if (matchingAccessibleConstructor != null) {
                return (T) matchingAccessibleConstructor.newInstance(objArr);
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, cls, str, objArr)) == null) ? invokeStaticMethod(cls, str, objArr, toClass(objArr)) : invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, str, objArr)) == null) ? invokeMethod(obj, str, objArr, toClass(objArr)) : invokeLLL.objValue;
    }
}
