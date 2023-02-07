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
/* loaded from: classes6.dex */
public class se {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(ad adVar, td tdVar) {
        InterceptResult invokeLL;
        id a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, adVar, tdVar)) == null) {
            if (adVar != null && tdVar != null) {
                for (Field field : yc.b(adVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = ue.a(yc.d(adVar, name))) != null) {
                            Object obj = null;
                            if (tdVar instanceof JsonDataSource) {
                                obj = a.f(new re(field.getGenericType()));
                            } else if (tdVar instanceof BundleDataSource) {
                                obj = a.d(new re(field.getGenericType()));
                            } else if (tdVar instanceof IntentDataSource) {
                                obj = a.e(new re(field.getGenericType()));
                            } else if (tdVar instanceof MapDataSource) {
                                obj = a.b(new re(field.getGenericType()));
                            } else if (tdVar instanceof CursorDataSource) {
                                obj = a.a(new re(field.getGenericType()));
                            } else if (tdVar instanceof ProtobufDataSource) {
                                obj = a.c(new re(field.getGenericType()));
                            }
                            if (obj != null) {
                                tdVar.set(name, obj);
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
