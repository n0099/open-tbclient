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
public class ve {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final cd a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new xc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new md((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new vc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new ld((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new ed((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new id((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new gd((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new jd((Set) obj);
                                            }
                                            if (!sc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new hd((OrmObject) obj);
                                        }
                                        return new kd(((Short) obj).shortValue());
                                    }
                                    return new fd(((Long) obj).longValue());
                                }
                                return new dd(((Integer) obj).intValue());
                            }
                            return new bd(((Float) obj).floatValue());
                        }
                        return new ad(((Double) obj).doubleValue());
                    }
                    return new zc(((Character) obj).charValue());
                }
                return new yc(((Byte) obj).byteValue());
            }
            return new wc(((Boolean) obj).booleanValue());
        }
        return (cd) invokeL.objValue;
    }
}
