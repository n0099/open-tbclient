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
public class n9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final b8 a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new w7((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new l8((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new u7(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new k8((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new d8((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new h8((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new f8((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new i8((Set) obj);
                                            }
                                            if (!r7.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new g8((OrmObject) obj);
                                        }
                                        return new j8(((Short) obj).shortValue());
                                    }
                                    return new e8(((Long) obj).longValue());
                                }
                                return new c8(((Integer) obj).intValue());
                            }
                            return new a8(((Float) obj).floatValue());
                        }
                        return new z7(((Double) obj).doubleValue());
                    }
                    return new y7(((Character) obj).charValue());
                }
                return new x7(((Byte) obj).byteValue());
            }
            return new v7(((Boolean) obj).booleanValue());
        }
        return (b8) invokeL.objValue;
    }
}
