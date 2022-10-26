package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.os.Build;
import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.bytedance.pangle.f.c;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static o a(String str) {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            RandomAccessFile randomAccessFile2 = null;
            Signature[] signatureArr = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(str, "r");
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    try {
                        f.a(str, randomAccessFile, -262969152, ApkSignatureSchemeV2Verifier.APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
                        try {
                            try {
                                m mVar = (m) ((SparseArray) f.a.get(str)).get(-262969152);
                                if (mVar != null) {
                                    c.C0495c a = c.a(randomAccessFile, mVar);
                                    Signature[] a2 = a(new Certificate[][]{a.a});
                                    if (a.b != null) {
                                        int size = a.b.a.size();
                                        Signature[] signatureArr2 = new Signature[size];
                                        iArr = new int[a.b.b.size()];
                                        for (int i = 0; i < size; i++) {
                                            signatureArr2[i] = new Signature(((X509Certificate) a.b.a.get(i)).getEncoded());
                                            iArr[i] = ((Integer) a.b.b.get(i)).intValue();
                                        }
                                        signatureArr = signatureArr2;
                                    } else {
                                        iArr = null;
                                    }
                                    o oVar = new o(a2, 3, signatureArr, iArr);
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused) {
                                    }
                                    return oVar;
                                }
                                throw new n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                            } catch (n unused2) {
                                o a3 = a.a(str);
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused3) {
                                }
                                return a3;
                            } catch (Exception e) {
                                throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e);
                            }
                        } catch (n unused4) {
                            m mVar2 = (m) ((SparseArray) f.a.get(str)).get(ApkSignatureSchemeV2Verifier.APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
                            if (mVar2 != null) {
                                o oVar2 = new o(a(b.a(randomAccessFile, mVar2).a));
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused5) {
                                }
                                return oVar2;
                            }
                            throw new n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                        } catch (Exception e2) {
                            throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
                        }
                    } catch (Exception e3) {
                        throw new q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e3);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Exception unused6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused7) {
                throw new q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(String.valueOf(str)));
            }
        }
        return (o) invokeL.objValue;
    }

    public static Signature[] a(Certificate[][] certificateArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, certificateArr)) == null) {
            Signature[] signatureArr = new Signature[certificateArr.length];
            for (int i = 0; i < certificateArr.length; i++) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 21 && i2 <= 28) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
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
}
