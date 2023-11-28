package com.baidu.tieba;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes7.dex */
public class o9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final c8 a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new x7((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new m8((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new v7(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new l8((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new e8((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new i8((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new g8((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new j8((Set) obj);
                                            }
                                            if (!s7.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new h8((OrmObject) obj);
                                        }
                                        return new k8(((Short) obj).shortValue());
                                    }
                                    return new f8(((Long) obj).longValue());
                                }
                                return new d8(((Integer) obj).intValue());
                            }
                            return new b8(((Float) obj).floatValue());
                        }
                        return new a8(((Double) obj).doubleValue());
                    }
                    return new z7(((Character) obj).charValue());
                }
                return new y7(((Byte) obj).byteValue());
            }
            return new w7(((Boolean) obj).booleanValue());
        }
        return (c8) invokeL.objValue;
    }
}
