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
/* loaded from: classes12.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Signature[] a(Certificate[][] certificateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, certificateArr)) == null) {
            Signature[] signatureArr = new Signature[certificateArr.length];
            for (int i2 = 0; i2 < certificateArr.length; i2++) {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 21 && i3 <= 28) {
                    Constructor a = com.bytedance.pangle.a.b.a.a(Signature.class, Certificate[].class);
                    if (a != null) {
                        a.setAccessible(true);
                    }
                    if (a != null && a.isAccessible()) {
                        try {
                            signatureArr[i2] = (Signature) a.newInstance(certificateArr[i2]);
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InstantiationException e3) {
                            e3.printStackTrace();
                        } catch (InvocationTargetException e4) {
                            e4.printStackTrace();
                        }
                    }
                } else {
                    signatureArr[i2] = new Signature(certificateArr[i2][0].getEncoded());
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
                    c.C1955c a = c.a(str);
                    Signature[] a2 = a(new Certificate[][]{a.a});
                    Signature[] signatureArr = null;
                    if (a.f54577b != null) {
                        int size = a.f54577b.a.size();
                        signatureArr = new Signature[size];
                        iArr = new int[a.f54577b.f54576b.size()];
                        for (int i2 = 0; i2 < size; i2++) {
                            signatureArr[i2] = new Signature(a.f54577b.a.get(i2).getEncoded());
                            iArr[i2] = a.f54577b.f54576b.get(i2).intValue();
                        }
                    } else {
                        iArr = null;
                    }
                    return new o(a2, 3, signatureArr, iArr);
                } catch (n unused) {
                    return a.a(str);
                } catch (Exception e2) {
                    throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e2);
                }
            } catch (n unused2) {
                return new o(a(b.a(str).a));
            } catch (Exception e3) {
                throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e3);
            }
        }
        return (o) invokeL.objValue;
    }
}
