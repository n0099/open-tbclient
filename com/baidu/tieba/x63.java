package com.baidu.tieba;

import com.baidu.swan.apps.publisher.draft.DraftData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class x63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            File file = new File(b(), "publisher_draft");
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static final String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            m93 M = m93.M();
            if (M != null) {
                str = M.b;
            } else {
                str = null;
            }
            String v = ug3.v(str);
            Intrinsics.checkNotNullExpressionValue(v, "StorageUtil.getSwanAppStoreDirectory(appId)");
            return v;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final DraftData c() {
        InterceptResult invokeV;
        ObjectInputStream objectInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File file = new File(b(), "publisher_draft");
            ObjectInputStream objectInputStream2 = null;
            try {
                try {
                    if (file.exists()) {
                        objectInputStream = new ObjectInputStream(new FileInputStream(file));
                        try {
                            Object readObject = objectInputStream.readObject();
                            if (readObject != null) {
                                DraftData draftData = (DraftData) readObject;
                                if (System.currentTimeMillis() - draftData.getTimeStamp() > 432000000) {
                                    objectInputStream.close();
                                    return null;
                                }
                                objectInputStream.close();
                                return draftData;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.swan.apps.publisher.draft.DraftData");
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    objectInputStream2 = "publisher_draft";
                    if (objectInputStream2 != null) {
                        objectInputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                objectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream2 != null) {
                }
                throw th;
            }
            return null;
        }
        return (DraftData) invokeV.objValue;
    }

    public static final void d(DraftData draftData) {
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, draftData) == null) && draftData != null) {
            File file = new File(b(), "publisher_draft");
            try {
                if (file.exists()) {
                    file.delete();
                    file.createNewFile();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(draftData);
                objectOutputStream.close();
            } catch (Exception e3) {
                e = e3;
                objectOutputStream2 = objectOutputStream;
                e.printStackTrace();
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
                throw th;
            }
        }
    }
}
