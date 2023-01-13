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
public class ne {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(vc vcVar, od odVar) {
        InterceptResult invokeLL;
        dd a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, vcVar, odVar)) == null) {
            if (vcVar != null && odVar != null) {
                for (Field field : tc.b(vcVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = pe.a(tc.d(vcVar, name))) != null) {
                            Object obj = null;
                            if (odVar instanceof JsonDataSource) {
                                obj = a.f(new me(field.getGenericType()));
                            } else if (odVar instanceof BundleDataSource) {
                                obj = a.d(new me(field.getGenericType()));
                            } else if (odVar instanceof IntentDataSource) {
                                obj = a.e(new me(field.getGenericType()));
                            } else if (odVar instanceof MapDataSource) {
                                obj = a.b(new me(field.getGenericType()));
                            } else if (odVar instanceof CursorDataSource) {
                                obj = a.a(new me(field.getGenericType()));
                            } else if (odVar instanceof ProtobufDataSource) {
                                obj = a.c(new me(field.getGenericType()));
                            }
                            if (obj != null) {
                                odVar.set(name, obj);
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
