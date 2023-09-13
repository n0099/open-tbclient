package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes8.dex */
public class yd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(yc ycVar, fc fcVar) {
        InterceptResult invokeLL;
        Object objectByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ycVar, fcVar)) == null) {
            if (fcVar != null && ycVar != null) {
                List<Field> b = dc.b(fcVar.getClass());
                Set<String> keys = ycVar.getKeys();
                for (Field field : b) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (keys.contains(name)) {
                                Object objectByType2 = ycVar.getObjectByType(name, field.getGenericType());
                                if (objectByType2 != null) {
                                    dc.i(fcVar, name, objectByType2);
                                }
                            } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                                Object objectByType3 = ycVar.getObjectByType(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                                if (objectByType3 != null) {
                                    dc.i(fcVar, name, objectByType3);
                                }
                            } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (objectByType = ycVar.getObjectByType(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                                dc.i(fcVar, name, objectByType);
                            }
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
