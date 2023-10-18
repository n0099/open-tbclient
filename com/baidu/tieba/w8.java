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
public class w8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(w7 w7Var, d7 d7Var) {
        InterceptResult invokeLL;
        Object objectByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, w7Var, d7Var)) == null) {
            if (d7Var != null && w7Var != null) {
                List<Field> b = b7.b(d7Var.getClass());
                Set<String> keys = w7Var.getKeys();
                for (Field field : b) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (keys.contains(name)) {
                                Object objectByType2 = w7Var.getObjectByType(name, field.getGenericType());
                                if (objectByType2 != null) {
                                    b7.i(d7Var, name, objectByType2);
                                }
                            } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                                Object objectByType3 = w7Var.getObjectByType(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                                if (objectByType3 != null) {
                                    b7.i(d7Var, name, objectByType3);
                                }
                            } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (objectByType = w7Var.getObjectByType(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                                b7.i(d7Var, name, objectByType);
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
