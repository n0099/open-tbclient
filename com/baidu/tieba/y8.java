package com.baidu.tieba;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.squareup.wire.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x0150 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: java.io.ObjectOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.io.ObjectOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.io.ObjectOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final e8 a(Object obj) {
        InterceptResult invokeL;
        ObjectOutputStream objectOutputStream;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            ObjectOutputStream objectOutputStream2 = 0;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Boolean) {
                return new y7(((Boolean) obj).booleanValue());
            }
            if (obj instanceof Bundle) {
                return new z7((Bundle) obj);
            }
            if (obj instanceof Byte) {
                return new a8(((Byte) obj).byteValue());
            }
            if (obj instanceof Character) {
                return new b8(((Character) obj).charValue());
            }
            if (obj instanceof Double) {
                return new c8(((Double) obj).doubleValue());
            }
            if (obj instanceof Float) {
                return new d8(((Float) obj).floatValue());
            }
            if (obj instanceof Integer) {
                return new f8(((Integer) obj).intValue());
            }
            if (obj instanceof JSONArray) {
                return new g8((JSONArray) obj);
            }
            if (obj instanceof JSONObject) {
                return new h8((JSONObject) obj);
            }
            if (obj instanceof Long) {
                return new j8(((Long) obj).longValue());
            }
            if (obj instanceof Short) {
                return new p8(((Short) obj).shortValue());
            }
            if (obj instanceof String) {
                return new r8((String) obj);
            }
            if (obj instanceof SparseArray) {
                return new q8((SparseArray) obj);
            }
            if (obj instanceof List) {
                return new i8((List) obj);
            }
            if (obj instanceof Queue) {
                return new n8((Queue) obj);
            }
            if (obj instanceof Set) {
                return new o8((Set) obj);
            }
            if (obj instanceof Map) {
                return new k8((Map) obj);
            }
            if (obj instanceof Message) {
                return new m8((Message) obj);
            }
            if (obj.getClass().isArray()) {
                return new x7(obj);
            }
            if (obj instanceof CharSequence) {
                return new r8(((CharSequence) obj).toString());
            }
            if (obj instanceof Serializable) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeObject(obj);
                            objectOutputStream.flush();
                            x7 x7Var = new x7(byteArrayOutputStream.toByteArray());
                            try {
                                objectOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            return x7Var;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            l8 l8Var = new l8(obj);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            return l8Var;
                        }
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream2 = interceptable;
                        if (objectOutputStream2 != 0) {
                            try {
                                objectOutputStream2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    objectOutputStream = null;
                    e = e9;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream2 != 0) {
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } else if (obj instanceof IBinder) {
                return new l8(obj);
            } else {
                if (obj instanceof Parcelable) {
                    return new l8(obj);
                }
                return new l8(obj);
            }
        } else {
            return (e8) invokeL.objValue;
        }
    }
}
