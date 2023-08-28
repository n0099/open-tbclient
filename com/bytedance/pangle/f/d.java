package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.bytedance.pangle.f.c;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
@RequiresApi(api = 21)
/* loaded from: classes9.dex */
public final class d {
    public static o a(String str) {
        int[] iArr;
        RandomAccessFile randomAccessFile = null;
        Signature[] signatureArr = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                try {
                    try {
                        f.a(str, randomAccessFile2, -262969152, ApkSignatureSchemeV2Verifier.APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
                        try {
                            try {
                                try {
                                    m mVar = f.a.get(str).get(-262969152);
                                    if (mVar != null) {
                                        c.C0572c a = c.a(randomAccessFile2, mVar);
                                        Signature[] a2 = a(new Certificate[][]{a.a});
                                        if (a.b != null) {
                                            int size = a.b.a.size();
                                            Signature[] signatureArr2 = new Signature[size];
                                            iArr = new int[a.b.b.size()];
                                            for (int i = 0; i < size; i++) {
                                                signatureArr2[i] = new Signature(a.b.a.get(i).getEncoded());
                                                iArr[i] = a.b.b.get(i).intValue();
                                            }
                                            signatureArr = signatureArr2;
                                        } else {
                                            iArr = null;
                                        }
                                        o oVar = new o(a2, 3, signatureArr, iArr);
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Exception unused) {
                                        }
                                        return oVar;
                                    }
                                    throw new n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                                } catch (n unused2) {
                                    o a3 = a.a(str);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused3) {
                                    }
                                    return a3;
                                }
                            } catch (Exception e) {
                                throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e);
                            }
                        } catch (n unused4) {
                            m mVar2 = f.a.get(str).get(ApkSignatureSchemeV2Verifier.APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
                            if (mVar2 != null) {
                                o oVar2 = new o(a(b.a(randomAccessFile2, mVar2).a));
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused5) {
                                }
                                return oVar2;
                            }
                            throw new n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                        } catch (Exception e2) {
                            throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused6) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    throw new q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e3);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused7) {
            throw new q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(String.valueOf(str)));
        }
    }

    public static Signature[] a(Certificate[][] certificateArr) {
        boolean z;
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
}
