package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cls) == null) {
            try {
                if (Fragment.class.getName().contains("support")) {
                    ((SimpleArrayMap) a(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                    return;
                }
                Field a = a(Fragment.class, "sClassMap");
                if (a != null) {
                    ((SimpleArrayMap) a.get(null)).put(cls.getName(), cls);
                    return;
                }
                Class a2 = a("androidx.fragment.app.FragmentFactory");
                if (a2 == null) {
                    return;
                }
                Field a3 = a(a2, "sClassMap");
                if (a3 != null) {
                    ((SimpleArrayMap) a3.get(null)).put(cls.getName(), cls);
                    return;
                }
                Field a4 = a(a2, "sClassCacheMap");
                if (a4 != null) {
                    SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                    simpleArrayMap.put(cls.getName(), cls);
                    ((SimpleArrayMap) a4.get(null)).put(cls.getClassLoader(), simpleArrayMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Field a(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, str)) == null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
        return (Field) invokeLL.objValue;
    }

    public static Class a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return (Class) invokeL.objValue;
    }
}
