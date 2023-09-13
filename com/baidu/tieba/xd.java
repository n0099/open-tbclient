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
public class xd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(fc fcVar, yc ycVar) {
        InterceptResult invokeLL;
        nc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, fcVar, ycVar)) == null) {
            if (fcVar != null && ycVar != null) {
                for (Field field : dc.b(fcVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = zd.a(dc.d(fcVar, name))) != null) {
                            Object obj = null;
                            if (ycVar instanceof JsonDataSource) {
                                obj = a.f(new wd(field.getGenericType()));
                            } else if (ycVar instanceof BundleDataSource) {
                                obj = a.d(new wd(field.getGenericType()));
                            } else if (ycVar instanceof IntentDataSource) {
                                obj = a.e(new wd(field.getGenericType()));
                            } else if (ycVar instanceof MapDataSource) {
                                obj = a.b(new wd(field.getGenericType()));
                            } else if (ycVar instanceof CursorDataSource) {
                                obj = a.a(new wd(field.getGenericType()));
                            } else if (ycVar instanceof ProtobufDataSource) {
                                obj = a.c(new wd(field.getGenericType()));
                            }
                            if (obj != null) {
                                ycVar.set(name, obj);
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
