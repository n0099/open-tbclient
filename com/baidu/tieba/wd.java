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
public class wd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(wc wcVar, dc dcVar) {
        InterceptResult invokeLL;
        Object objectByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, wcVar, dcVar)) == null) {
            if (dcVar != null && wcVar != null) {
                List<Field> b = bc.b(dcVar.getClass());
                Set<String> keys = wcVar.getKeys();
                for (Field field : b) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (keys.contains(name)) {
                                Object objectByType2 = wcVar.getObjectByType(name, field.getGenericType());
                                if (objectByType2 != null) {
                                    bc.i(dcVar, name, objectByType2);
                                }
                            } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                                Object objectByType3 = wcVar.getObjectByType(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                                if (objectByType3 != null) {
                                    bc.i(dcVar, name, objectByType3);
                                }
                            } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (objectByType = wcVar.getObjectByType(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                                bc.i(dcVar, name, objectByType);
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
