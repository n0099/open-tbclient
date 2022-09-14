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
public class ue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final bd a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new wc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new ld((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new uc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new kd((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new dd((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new hd((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new fd((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new id((Set) obj);
                                            }
                                            if (rc.e(cls, OrmObject.class)) {
                                                return new gd((OrmObject) obj);
                                            }
                                            return null;
                                        }
                                        return new jd(((Short) obj).shortValue());
                                    }
                                    return new ed(((Long) obj).longValue());
                                }
                                return new cd(((Integer) obj).intValue());
                            }
                            return new ad(((Float) obj).floatValue());
                        }
                        return new zc(((Double) obj).doubleValue());
                    }
                    return new yc(((Character) obj).charValue());
                }
                return new xc(((Byte) obj).byteValue());
            }
            return new vc(((Boolean) obj).booleanValue());
        }
        return (bd) invokeL.objValue;
    }
}
