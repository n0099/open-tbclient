package com.bytedance.pangle.util;

import android.text.TextUtils;
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
/* loaded from: classes7.dex */
public class MethodUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] EMPTY_CLASS_ARRAY;
    public static Map sMethodCache;
    public static final HashMap sPrimitiveToWrapperMap;
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
        HashMap hashMap = new HashMap();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Method getAccessibleMethod(Class cls, String str, Class... clsArr) {
        InterceptResult invokeLLL;
        Method method;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, clsArr)) == null) {
            String key = getKey(cls, str, clsArr);
            synchronized (sMethodCache) {
                method = (Method) sMethodCache.get(key);
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
                                    for (int i = 0; i < clsArr.length; i++) {
                                        if (!isAssignableFrom(clsArr[i], parameterTypes[i])) {
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

    public static String getKey(Class cls, String str, Class... clsArr) {
        InterceptResult invokeLLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.toString());
            sb.append("#");
            sb.append(str);
            sb.append("#");
            if (cls.getClassLoader() != null) {
                obj = Integer.valueOf(cls.getClassLoader().hashCode());
            } else {
                obj = "";
            }
            sb.append(obj);
            if (clsArr != null && clsArr.length > 0) {
                for (Class cls2 : clsArr) {
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

    public static Constructor getMatchingAccessibleConstructor(Class cls, Class... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, clsArr)) == null) {
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
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

    public static Object invokeConstructor(Class cls, Object[] objArr, Class[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, objArr, clsArr)) == null) {
            Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, clsArr);
            if (matchingAccessibleConstructor != null) {
                return matchingAccessibleConstructor.newInstance(objArr);
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, obj, str, objArr)) == null) {
            return invokeMethod(obj, str, objArr, toClass(objArr));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, cls, str, objArr)) == null) {
            return invokeStaticMethod(cls, str, objArr, toClass(objArr));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, obj, str, objArr, clsArr)) == null) {
            Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
            if (accessibleMethod != null) {
                return accessibleMethod.invoke(obj, objArr);
            }
            throw new NoSuchMethodException(str);
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class[] clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, cls, str, objArr, clsArr)) == null) {
            Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
            if (accessibleMethod == null) {
                return null;
            }
            return accessibleMethod.invoke(null, objArr);
        }
        return invokeLLLL.objValue;
    }

    public static boolean isAssignableFrom(Class cls, Class cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cls, cls2)) == null) {
            if (cls2 == null) {
                return false;
            }
            if (cls == null) {
                if (cls2.isPrimitive()) {
                    return false;
                }
                return true;
            }
            if (cls.isPrimitive() && !cls2.isPrimitive()) {
                cls = (Class) sPrimitiveToWrapperMap.get(cls);
            }
            boolean isPrimitive = cls2.isPrimitive();
            Class cls3 = cls2;
            if (isPrimitive) {
                cls3 = cls2;
                if (!cls.isPrimitive()) {
                    cls3 = (Class) sPrimitiveToWrapperMap.get(cls2);
                }
            }
            return cls3.isAssignableFrom(cls);
        }
        return invokeLL.booleanValue;
    }

    public static Class[] toClass(Object... objArr) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, objArr)) == null) {
            if (objArr != null && objArr.length != 0) {
                Class[] clsArr = new Class[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i] == null) {
                        cls = null;
                    } else {
                        cls = objArr[i].getClass();
                    }
                    clsArr[i] = cls;
                }
                return clsArr;
            }
            return EMPTY_CLASS_ARRAY;
        }
        return (Class[]) invokeL.objValue;
    }
}
