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
/* loaded from: classes8.dex */
public class v8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(d7 d7Var, w7 w7Var) {
        InterceptResult invokeLL;
        l7 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, d7Var, w7Var)) == null) {
            if (d7Var != null && w7Var != null) {
                for (Field field : b7.b(d7Var.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = x8.a(b7.d(d7Var, name))) != null) {
                            Object obj = null;
                            if (w7Var instanceof JsonDataSource) {
                                obj = a.f(new u8(field.getGenericType()));
                            } else if (w7Var instanceof BundleDataSource) {
                                obj = a.d(new u8(field.getGenericType()));
                            } else if (w7Var instanceof IntentDataSource) {
                                obj = a.e(new u8(field.getGenericType()));
                            } else if (w7Var instanceof MapDataSource) {
                                obj = a.b(new u8(field.getGenericType()));
                            } else if (w7Var instanceof CursorDataSource) {
                                obj = a.a(new u8(field.getGenericType()));
                            } else if (w7Var instanceof ProtobufDataSource) {
                                obj = a.c(new u8(field.getGenericType()));
                            }
                            if (obj != null) {
                                w7Var.set(name, obj);
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
