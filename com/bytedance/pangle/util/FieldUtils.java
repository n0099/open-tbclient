package com.bytedance.pangle.util;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes11.dex */
public class FieldUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Field> sFieldCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2056398469, "Lcom/bytedance/pangle/util/FieldUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2056398469, "Lcom/bytedance/pangle/util/FieldUtils;");
                return;
            }
        }
        sFieldCache = new HashMap();
    }

    public FieldUtils() {
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

    public static Field getField(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Field field;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, str)) == null) {
            String key = getKey(cls, str);
            synchronized (sFieldCache) {
                field = sFieldCache.get(key);
            }
            if (field != null) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            }
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    synchronized (sFieldCache) {
                        sFieldCache.put(key, declaredField);
                    }
                    return declaredField;
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static String getKey(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, str)) == null) {
            return cls.toString() + "#" + str;
        }
        return (String) invokeLL.objValue;
    }

    public static Object readField(Field field, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, field, obj)) == null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        }
        return invokeLL.objValue;
    }

    public static Object readStaticField(Field field) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, field)) == null) ? readField(field, (Object) null) : invokeL.objValue;
    }

    public static void writeField(Field field, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, field, obj, obj2) == null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            field.set(obj, obj2);
        }
    }

    public static void writeStaticField(Field field, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, field, obj) == null) {
            writeField(field, (Object) null, obj);
        }
    }

    public static Object readStaticField(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, cls, str)) == null) {
            Field field = getField(cls, str);
            if (field != null) {
                return readStaticField(field);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) {
        Field field;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, cls, str, obj) == null) || (field = getField(cls, str)) == null) {
            return;
        }
        writeStaticField(field, obj);
    }

    public static Object readField(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str)) == null) {
            Field field = getField(obj.getClass(), str);
            if (field != null) {
                return readField(field, obj);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static void writeField(Object obj, String str, Object obj2) {
        Field field;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, obj, str, obj2) == null) || (field = getField(obj.getClass(), str)) == null) {
            return;
        }
        writeField(field, obj, obj2);
    }
}
