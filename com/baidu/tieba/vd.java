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
public class vd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(dc dcVar, wc wcVar) {
        InterceptResult invokeLL;
        lc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dcVar, wcVar)) == null) {
            if (dcVar != null && wcVar != null) {
                for (Field field : bc.b(dcVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = xd.a(bc.d(dcVar, name))) != null) {
                            Object obj = null;
                            if (wcVar instanceof JsonDataSource) {
                                obj = a.f(new ud(field.getGenericType()));
                            } else if (wcVar instanceof BundleDataSource) {
                                obj = a.d(new ud(field.getGenericType()));
                            } else if (wcVar instanceof IntentDataSource) {
                                obj = a.e(new ud(field.getGenericType()));
                            } else if (wcVar instanceof MapDataSource) {
                                obj = a.b(new ud(field.getGenericType()));
                            } else if (wcVar instanceof CursorDataSource) {
                                obj = a.a(new ud(field.getGenericType()));
                            } else if (wcVar instanceof ProtobufDataSource) {
                                obj = a.c(new ud(field.getGenericType()));
                            }
                            if (obj != null) {
                                wcVar.set(name, obj);
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
