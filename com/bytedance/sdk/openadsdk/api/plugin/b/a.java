package com.bytedance.sdk.openadsdk.api.plugin.b;

import android.util.Base64;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class a {
    public static String a(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(IMAudioTransRequest.CHARSET)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
