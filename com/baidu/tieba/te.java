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
/* loaded from: classes5.dex */
public class te {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(od odVar, tc tcVar) {
        InterceptResult invokeLL;
        Object b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, odVar, tcVar)) == null) {
            if (tcVar == null || odVar == null) {
                return false;
            }
            List<Field> b2 = rc.b(tcVar.getClass());
            Set<String> keys = odVar.getKeys();
            for (Field field : b2) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name)) {
                        if (keys.contains(name)) {
                            Object b3 = odVar.b(name, field.getGenericType());
                            if (b3 != null) {
                                rc.i(tcVar, name, b3);
                            }
                        } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                            Object b4 = odVar.b(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                            if (b4 != null) {
                                rc.i(tcVar, name, b4);
                            }
                        } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (b = odVar.b(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                            rc.i(tcVar, name, b);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
