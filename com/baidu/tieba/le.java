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
/* loaded from: classes4.dex */
public class le {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(tc tcVar, md mdVar) {
        InterceptResult invokeLL;
        bd a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tcVar, mdVar)) == null) {
            if (tcVar != null && mdVar != null) {
                for (Field field : rc.b(tcVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = ne.a(rc.d(tcVar, name))) != null) {
                            Object obj = null;
                            if (mdVar instanceof JsonDataSource) {
                                obj = a.f(new ke(field.getGenericType()));
                            } else if (mdVar instanceof BundleDataSource) {
                                obj = a.d(new ke(field.getGenericType()));
                            } else if (mdVar instanceof IntentDataSource) {
                                obj = a.e(new ke(field.getGenericType()));
                            } else if (mdVar instanceof MapDataSource) {
                                obj = a.b(new ke(field.getGenericType()));
                            } else if (mdVar instanceof CursorDataSource) {
                                obj = a.a(new ke(field.getGenericType()));
                            } else if (mdVar instanceof ProtobufDataSource) {
                                obj = a.c(new ke(field.getGenericType()));
                            }
                            if (obj != null) {
                                mdVar.set(name, obj);
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
