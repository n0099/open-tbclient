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
public class je {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final xc a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new sc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new hd((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new qc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new gd((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new zc((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new dd((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new bd((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new ed((Set) obj);
                                            }
                                            if (!nc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new cd((OrmObject) obj);
                                        }
                                        return new fd(((Short) obj).shortValue());
                                    }
                                    return new ad(((Long) obj).longValue());
                                }
                                return new yc(((Integer) obj).intValue());
                            }
                            return new wc(((Float) obj).floatValue());
                        }
                        return new vc(((Double) obj).doubleValue());
                    }
                    return new uc(((Character) obj).charValue());
                }
                return new tc(((Byte) obj).byteValue());
            }
            return new rc(((Boolean) obj).booleanValue());
        }
        return (xc) invokeL.objValue;
    }
}
