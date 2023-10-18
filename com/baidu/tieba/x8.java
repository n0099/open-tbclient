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
/* loaded from: classes8.dex */
public class x8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final l7 a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new g7((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new v7((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new e7(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new u7((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new n7((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new r7((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new p7((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new s7((Set) obj);
                                            }
                                            if (!b7.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new q7((OrmObject) obj);
                                        }
                                        return new t7(((Short) obj).shortValue());
                                    }
                                    return new o7(((Long) obj).longValue());
                                }
                                return new m7(((Integer) obj).intValue());
                            }
                            return new k7(((Float) obj).floatValue());
                        }
                        return new j7(((Double) obj).doubleValue());
                    }
                    return new i7(((Character) obj).charValue());
                }
                return new h7(((Byte) obj).byteValue());
            }
            return new f7(((Boolean) obj).booleanValue());
        }
        return (l7) invokeL.objValue;
    }
}
