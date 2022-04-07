package com.bytedance.sdk.openadsdk.api.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
/* loaded from: classes4.dex */
public final class c {
    public PublicKey a;

    public c() {
        try {
            this.a = a(new String(Base64.decode("TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUF5ZXRudE1CRzJuU1JRb1lpT1NLegpCdkZ5cmdwQ1dlT1lnRVZxbG5rNWhLMGlydnNKdVhrZ2paVnFDc0VBRFVQQ0w5K2NlZng1NHoyRGw5dmpEemlwCjVYSGluRUdnZkR1ZzBkcmZyOHRKTElySHlnQlY5M2FTWFg5endBVGlnRnY0dzNrN1RuMStxS01CdUxhbkptSFMKQUttRGMrRCtZSmpYSGF0dWY3YlVhbXlEdDBOZ2pYM0F5d1JUSkErcldPR3RjMHRTWDdaNmlKd3o2bXdzTmZQYQpka3NwVEpmcjVja2dRdVlvWDQybGxteGhRTCtLK2F3NHE1SDgxZTFZUjN4TGhQaVdBTFNXVWlhYk5OQ3dyTGQvCk5uRVNaa0gzQVJqazVtYnhzU1lKcU8yUTRTL2lmNXl3WXYycG51ZW50d2ZQa3p3b0NkcFA3VVZ0MHhNNFgvZEcKYXdJREFRQUI=", 0)));
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public boolean a(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, empty sign: ");
            return false;
        } else if (file != null && file.exists()) {
            if (this.a == null) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, no key ");
                return false;
            }
            try {
                return a(str, new FileInputStream(file));
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, sign: " + str + ", error:" + e);
                return false;
            }
        } else {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, no file");
            return false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private boolean a(String str, InputStream inputStream) throws Exception {
        if (this.a == null) {
            return false;
        }
        byte[] decode = Base64.decode(str, 0);
        try {
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(this.a);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                signature.update(bArr, 0, read);
            }
            return signature.verify(decode);
        } catch (Throwable th) {
            try {
                throw new Exception("Verify sign failed", th);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Exception e) {
            throw new Exception("Init public key failed", e);
        }
    }
}
