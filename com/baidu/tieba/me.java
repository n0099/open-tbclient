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
/* loaded from: classes5.dex */
public class me {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(uc ucVar, nd ndVar) {
        InterceptResult invokeLL;
        cd a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ucVar, ndVar)) == null) {
            if (ucVar != null && ndVar != null) {
                for (Field field : sc.b(ucVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = oe.a(sc.d(ucVar, name))) != null) {
                            Object obj = null;
                            if (ndVar instanceof JsonDataSource) {
                                obj = a.f(new le(field.getGenericType()));
                            } else if (ndVar instanceof BundleDataSource) {
                                obj = a.d(new le(field.getGenericType()));
                            } else if (ndVar instanceof IntentDataSource) {
                                obj = a.e(new le(field.getGenericType()));
                            } else if (ndVar instanceof MapDataSource) {
                                obj = a.b(new le(field.getGenericType()));
                            } else if (ndVar instanceof CursorDataSource) {
                                obj = a.a(new le(field.getGenericType()));
                            } else if (ndVar instanceof ProtobufDataSource) {
                                obj = a.c(new le(field.getGenericType()));
                            }
                            if (obj != null) {
                                ndVar.set(name, obj);
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
