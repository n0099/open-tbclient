package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.f.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
@RequiresApi(api = 21)
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Signature[] a(Certificate[][] certificateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, certificateArr)) == null) {
            Signature[] signatureArr = new Signature[certificateArr.length];
            for (int i = 0; i < certificateArr.length; i++) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 21 && i2 <= 28) {
                    Constructor a = com.bytedance.pangle.a.b.a.a(Signature.class, Certificate[].class);
                    if (a != null) {
                        a.setAccessible(true);
                    }
                    if (a != null && a.isAccessible()) {
                        try {
                            signatureArr[i] = (Signature) a.newInstance(certificateArr[i]);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e2) {
                            e2.printStackTrace();
                        } catch (InvocationTargetException e3) {
                            e3.printStackTrace();
                        }
                    }
                } else {
                    signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
                }
            }
            return signatureArr;
        }
        return (Signature[]) invokeL.objValue;
    }

    public static o a(String str) {
        InterceptResult invokeL;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                try {
                    c.C0260c a = c.a(str);
                    Signature[] a2 = a(new Certificate[][]{a.a});
                    Signature[] signatureArr = null;
                    if (a.b != null) {
                        int size = a.b.a.size();
                        signatureArr = new Signature[size];
                        iArr = new int[a.b.b.size()];
                        for (int i = 0; i < size; i++) {
                            signatureArr[i] = new Signature(a.b.a.get(i).getEncoded());
                            iArr[i] = a.b.b.get(i).intValue();
                        }
                    } else {
                        iArr = null;
                    }
                    return new o(a2, 3, signatureArr, iArr);
                } catch (n unused) {
                    return a.a(str);
                } catch (Exception e) {
                    throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e);
                }
            } catch (n unused2) {
                return new o(a(b.a(str).a));
            } catch (Exception e2) {
                throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
            }
        }
        return (o) invokeL.objValue;
    }
}
