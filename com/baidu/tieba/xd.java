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
/* loaded from: classes6.dex */
public class xd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final lc a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new gc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new vc((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new ec(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new uc((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new nc((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new rc((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new pc((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new sc((Set) obj);
                                            }
                                            if (!bc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new qc((OrmObject) obj);
                                        }
                                        return new tc(((Short) obj).shortValue());
                                    }
                                    return new oc(((Long) obj).longValue());
                                }
                                return new mc(((Integer) obj).intValue());
                            }
                            return new kc(((Float) obj).floatValue());
                        }
                        return new jc(((Double) obj).doubleValue());
                    }
                    return new ic(((Character) obj).charValue());
                }
                return new hc(((Byte) obj).byteValue());
            }
            return new fc(((Boolean) obj).booleanValue());
        }
        return (lc) invokeL.objValue;
    }
}
