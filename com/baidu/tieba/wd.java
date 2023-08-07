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
public class wd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(ec ecVar, xc xcVar) {
        InterceptResult invokeLL;
        mc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ecVar, xcVar)) == null) {
            if (ecVar != null && xcVar != null) {
                for (Field field : cc.b(ecVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = yd.a(cc.d(ecVar, name))) != null) {
                            Object obj = null;
                            if (xcVar instanceof JsonDataSource) {
                                obj = a.f(new vd(field.getGenericType()));
                            } else if (xcVar instanceof BundleDataSource) {
                                obj = a.d(new vd(field.getGenericType()));
                            } else if (xcVar instanceof IntentDataSource) {
                                obj = a.e(new vd(field.getGenericType()));
                            } else if (xcVar instanceof MapDataSource) {
                                obj = a.b(new vd(field.getGenericType()));
                            } else if (xcVar instanceof CursorDataSource) {
                                obj = a.a(new vd(field.getGenericType()));
                            } else if (xcVar instanceof ProtobufDataSource) {
                                obj = a.c(new vd(field.getGenericType()));
                            }
                            if (obj != null) {
                                xcVar.set(name, obj);
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
