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
public class m9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(u7 u7Var, n8 n8Var) {
        InterceptResult invokeLL;
        c8 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, u7Var, n8Var)) == null) {
            if (u7Var != null && n8Var != null) {
                for (Field field : s7.b(u7Var.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = o9.a(s7.d(u7Var, name))) != null) {
                            Object obj = null;
                            if (n8Var instanceof JsonDataSource) {
                                obj = a.f(new l9(field.getGenericType()));
                            } else if (n8Var instanceof BundleDataSource) {
                                obj = a.d(new l9(field.getGenericType()));
                            } else if (n8Var instanceof IntentDataSource) {
                                obj = a.e(new l9(field.getGenericType()));
                            } else if (n8Var instanceof MapDataSource) {
                                obj = a.b(new l9(field.getGenericType()));
                            } else if (n8Var instanceof CursorDataSource) {
                                obj = a.a(new l9(field.getGenericType()));
                            } else if (n8Var instanceof ProtobufDataSource) {
                                obj = a.c(new l9(field.getGenericType()));
                            }
                            if (obj != null) {
                                n8Var.set(name, obj);
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
