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
/* loaded from: classes6.dex */
public class ue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(pd pdVar, uc ucVar) {
        InterceptResult invokeLL;
        Object b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, pdVar, ucVar)) == null) {
            if (ucVar != null && pdVar != null) {
                List<Field> b2 = sc.b(ucVar.getClass());
                Set keys = pdVar.getKeys();
                for (Field field : b2) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (keys.contains(name)) {
                                Object b3 = pdVar.b(name, field.getGenericType());
                                if (b3 != null) {
                                    sc.i(ucVar, name, b3);
                                }
                            } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                                Object b4 = pdVar.b(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                                if (b4 != null) {
                                    sc.i(ucVar, name, b4);
                                }
                            } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (b = pdVar.b(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                                sc.i(ucVar, name, b);
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
