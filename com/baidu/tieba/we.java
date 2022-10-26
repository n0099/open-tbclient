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
/* loaded from: classes6.dex */
public class we {
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
    public static final ce a(Object obj) {
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
                return new wd(((Boolean) obj).booleanValue());
            }
            if (obj instanceof Bundle) {
                return new xd((Bundle) obj);
            }
            if (obj instanceof Byte) {
                return new yd(((Byte) obj).byteValue());
            }
            if (obj instanceof Character) {
                return new zd(((Character) obj).charValue());
            }
            if (obj instanceof Double) {
                return new ae(((Double) obj).doubleValue());
            }
            if (obj instanceof Float) {
                return new be(((Float) obj).floatValue());
            }
            if (obj instanceof Integer) {
                return new de(((Integer) obj).intValue());
            }
            if (obj instanceof JSONArray) {
                return new ee((JSONArray) obj);
            }
            if (obj instanceof JSONObject) {
                return new fe((JSONObject) obj);
            }
            if (obj instanceof Long) {
                return new he(((Long) obj).longValue());
            }
            if (obj instanceof Short) {
                return new ne(((Short) obj).shortValue());
            }
            if (obj instanceof String) {
                return new pe((String) obj);
            }
            if (obj instanceof SparseArray) {
                return new oe((SparseArray) obj);
            }
            if (obj instanceof List) {
                return new ge((List) obj);
            }
            if (obj instanceof Queue) {
                return new le((Queue) obj);
            }
            if (obj instanceof Set) {
                return new me((Set) obj);
            }
            if (obj instanceof Map) {
                return new ie((Map) obj);
            }
            if (obj instanceof Message) {
                return new ke((Message) obj);
            }
            if (obj.getClass().isArray()) {
                return new vd(obj);
            }
            if (obj instanceof CharSequence) {
                return new pe(((CharSequence) obj).toString());
            }
            if (obj instanceof Serializable) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeObject(obj);
                            objectOutputStream.flush();
                            vd vdVar = new vd(byteArrayOutputStream.toByteArray());
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
                            return vdVar;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            je jeVar = new je(obj);
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
                            return jeVar;
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
                return new je(obj);
            } else {
                if (obj instanceof Parcelable) {
                    return new je(obj);
                }
                return new je(obj);
            }
        } else {
            return (ce) invokeL.objValue;
        }
    }
}
