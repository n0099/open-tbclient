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
/* loaded from: classes9.dex */
public class zd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final nc a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new ic((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new xc((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new gc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new wc((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new pc((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new tc((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new rc((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new uc((Set) obj);
                                            }
                                            if (!dc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new sc((OrmObject) obj);
                                        }
                                        return new vc(((Short) obj).shortValue());
                                    }
                                    return new qc(((Long) obj).longValue());
                                }
                                return new oc(((Integer) obj).intValue());
                            }
                            return new mc(((Float) obj).floatValue());
                        }
                        return new lc(((Double) obj).doubleValue());
                    }
                    return new kc(((Character) obj).charValue());
                }
                return new jc(((Byte) obj).byteValue());
            }
            return new hc(((Boolean) obj).booleanValue());
        }
        return (nc) invokeL.objValue;
    }
}
