package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
public class se {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(tc tcVar, od odVar) {
        InterceptResult invokeLL;
        bd a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tcVar, odVar)) == null) {
            if (tcVar == null || odVar == null) {
                return false;
            }
            for (Field field : rc.b(tcVar.getClass())) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name) && (a = ue.a(rc.d(tcVar, name))) != null) {
                        Object obj = null;
                        if (odVar instanceof qd) {
                            obj = a.f(new re(field.getGenericType()));
                        } else if (odVar instanceof md) {
                            obj = a.d(new re(field.getGenericType()));
                        } else if (odVar instanceof pd) {
                            obj = a.e(new re(field.getGenericType()));
                        } else if (odVar instanceof rd) {
                            obj = a.b(new re(field.getGenericType()));
                        } else if (odVar instanceof nd) {
                            obj = a.a(new re(field.getGenericType()));
                        } else if (odVar instanceof sd) {
                            obj = a.c(new re(field.getGenericType()));
                        }
                        if (obj != null) {
                            odVar.a(name, obj);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
