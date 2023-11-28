package com.baidu.tieba;

import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Class<?> cls, TbBaseMsg tbBaseMsg, Map<String, Object> map, Map<String, Object> map2, boolean z) {
        String name;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{cls, tbBaseMsg, map, map2, Boolean.valueOf(z)}) != null) || !TbBaseMsg.class.isAssignableFrom(cls)) {
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "clazz.declaredFields");
        for (Field field : declaredFields) {
            SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
            if (serializedName == null || (name = serializedName.value()) == null) {
                name = field.getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
            }
            if (z && field.getAnnotation(ov8.class) != null) {
                map.remove(name);
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && field.getAnnotation(nv8.class) != null) {
                map.remove(name);
                field.setAccessible(true);
                map2.put(name, field.get(tbBaseMsg));
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            a(superclass, tbBaseMsg, map, map2, z);
        }
    }

    public static final Map<String, Object> b(Map<String, ? extends Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            Map<String, Object> mutableMap = MapsKt__MapsKt.toMutableMap(map);
            Map<? extends String, ? extends Object> map2 = (Map) mutableMap.remove("content");
            if (map2 != null) {
                mutableMap.putAll(map2);
            }
            return mutableMap;
        }
        return (Map) invokeL.objValue;
    }

    public static final <TbMsg extends TbBaseMsg> Map<String, Object> c(TbMsg tbmsg, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, tbmsg, z)) == null) {
            Intrinsics.checkNotNullParameter(tbmsg, "<this>");
            Map<String, Object> mutableMap = MapsKt__MapsKt.toMutableMap(DataExt.toMap(tbmsg));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            mutableMap.put("content", linkedHashMap);
            a(tbmsg.getClass(), tbmsg, mutableMap, linkedHashMap, z);
            return mutableMap;
        }
        return (Map) invokeLZ.objValue;
    }

    public static /* synthetic */ Map d(TbBaseMsg tbBaseMsg, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return c(tbBaseMsg, z);
    }
}
