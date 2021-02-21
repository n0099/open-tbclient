package com.baidu.tieba.yuyinala.liveroom.wheat.e;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes11.dex */
public class b {
    public static String WO(String str) {
        try {
            byte[] decode = Base64.decode(str, 9);
            if (decode != null) {
                return new String(decrypt("2011121211143000", "AFD311832EDEEAEF", decode));
            }
        } catch (Exception e) {
            Log.e("BIMUtils ", "transBDUK AES java exception");
        }
        return "";
    }

    public static byte[] decrypt(String str, String str2, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || bArr == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.e.q);
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }
}
