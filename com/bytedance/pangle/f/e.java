package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
/* loaded from: classes9.dex */
public final class e {
    public static boolean a(String str, String str2) {
        o a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Signature[] signatureArr = null;
        try {
            if (com.bytedance.pangle.util.h.a()) {
                a = d.a(str);
            } else {
                a = a.a(str);
            }
            if (a != null) {
                signatureArr = a.b;
            }
            byte[] decode = Base64.decode(Zeus.getPlugin(str2).mSignature, 0);
            if (decode != null && decode.length != 0) {
                int i = 0;
                for (Signature signature : signatureArr) {
                    i += signature.toByteArray().length;
                }
                byte[] bArr = new byte[i];
                int i2 = 0;
                for (Signature signature2 : signatureArr) {
                    System.arraycopy(signature2.toByteArray(), 0, bArr, i2, signature2.toByteArray().length);
                    i2 += signature2.toByteArray().length;
                }
                boolean a2 = o.a(bArr, decode);
                if (!a2) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
                }
                return a2;
            }
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
            return false;
        } catch (q unused) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            return false;
        }
    }
}
