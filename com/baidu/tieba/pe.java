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
/* loaded from: classes5.dex */
public class pe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final dd a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new yc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new nd((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new wc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new md((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new fd((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new jd((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new hd((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new kd((Set) obj);
                                            }
                                            if (!tc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new id((OrmObject) obj);
                                        }
                                        return new ld(((Short) obj).shortValue());
                                    }
                                    return new gd(((Long) obj).longValue());
                                }
                                return new ed(((Integer) obj).intValue());
                            }
                            return new cd(((Float) obj).floatValue());
                        }
                        return new bd(((Double) obj).doubleValue());
                    }
                    return new ad(((Character) obj).charValue());
                }
                return new zc(((Byte) obj).byteValue());
            }
            return new xc(((Boolean) obj).booleanValue());
        }
        return (dd) invokeL.objValue;
    }
}
