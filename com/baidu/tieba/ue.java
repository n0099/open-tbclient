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

    public static final id a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new dd((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new sd((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new bd(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new rd((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new kd((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new od((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new md((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new pd((Set) obj);
                                            }
                                            if (!yc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new nd((OrmObject) obj);
                                        }
                                        return new qd(((Short) obj).shortValue());
                                    }
                                    return new ld(((Long) obj).longValue());
                                }
                                return new jd(((Integer) obj).intValue());
                            }
                            return new hd(((Float) obj).floatValue());
                        }
                        return new gd(((Double) obj).doubleValue());
                    }
                    return new fd(((Character) obj).charValue());
                }
                return new ed(((Byte) obj).byteValue());
            }
            return new cd(((Boolean) obj).booleanValue());
        }
        return (id) invokeL.objValue;
    }
}
