package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.BundleDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.CursorDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.IntentDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.JsonDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.MapDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.ProtobufDataSource;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public class l9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(t7 t7Var, m8 m8Var) {
        InterceptResult invokeLL;
        b8 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, t7Var, m8Var)) == null) {
            if (t7Var != null && m8Var != null) {
                for (Field field : r7.b(t7Var.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = n9.a(r7.d(t7Var, name))) != null) {
                            Object obj = null;
                            if (m8Var instanceof JsonDataSource) {
                                obj = a.f(new k9(field.getGenericType()));
                            } else if (m8Var instanceof BundleDataSource) {
                                obj = a.d(new k9(field.getGenericType()));
                            } else if (m8Var instanceof IntentDataSource) {
                                obj = a.e(new k9(field.getGenericType()));
                            } else if (m8Var instanceof MapDataSource) {
                                obj = a.b(new k9(field.getGenericType()));
                            } else if (m8Var instanceof CursorDataSource) {
                                obj = a.a(new k9(field.getGenericType()));
                            } else if (m8Var instanceof ProtobufDataSource) {
                                obj = a.c(new k9(field.getGenericType()));
                            }
                            if (obj != null) {
                                m8Var.set(name, obj);
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
