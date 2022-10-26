package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes6.dex */
public class te {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(uc ucVar, pd pdVar) {
        InterceptResult invokeLL;
        cd a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ucVar, pdVar)) == null) {
            if (ucVar != null && pdVar != null) {
                for (Field field : sc.b(ucVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = ve.a(sc.d(ucVar, name))) != null) {
                            Object obj = null;
                            if (pdVar instanceof rd) {
                                obj = a.f(new se(field.getGenericType()));
                            } else if (pdVar instanceof nd) {
                                obj = a.d(new se(field.getGenericType()));
                            } else if (pdVar instanceof qd) {
                                obj = a.e(new se(field.getGenericType()));
                            } else if (pdVar instanceof sd) {
                                obj = a.b(new se(field.getGenericType()));
                            } else if (pdVar instanceof od) {
                                obj = a.a(new se(field.getGenericType()));
                            } else if (pdVar instanceof td) {
                                obj = a.c(new se(field.getGenericType()));
                            }
                            if (obj != null) {
                                pdVar.a(name, obj);
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
