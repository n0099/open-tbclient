package com.bun.miitmdid.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3999a = "#PART#".getBytes();

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.encode(a(str.getBytes(), Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6ZetPcgLCvLsvDWzA3TYpRhEO\nfncquhfl9utVX+VApfrknKvYInYzmxjhdAEay+Nn6NPJKGPkCt1D7VWbf0YPiLmo\noCTIsuc7czZOu9pBJYjOrqCZhhJsJucc3+T/un8KioD2CjkXy0EhNMJSuvo+tHJg\nTbiR4QuPcIU1YBLX4wIDAQAB".getBytes(), 0)), 2));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int length = bArr.length;
        if (length <= 117) {
            return b(bArr, bArr2);
        }
        ArrayList<Byte> arrayList = new ArrayList(2048);
        byte[] bArr3 = new byte[117];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            bArr3[i3] = bArr[i4];
            i3++;
            if (i3 == 117 || i4 == length - 1) {
                i2++;
                if (i2 != 1) {
                    for (byte b : f3999a) {
                        arrayList.add(Byte.valueOf(b));
                    }
                }
                byte[] b2 = b(bArr3, bArr2);
                for (byte b3 : b2) {
                    arrayList.add(Byte.valueOf(b3));
                }
                if (i4 == length - 1) {
                    bArr3 = null;
                    i3 = 0;
                } else {
                    bArr3 = new byte[Math.min(117, (length - i4) - 1)];
                    i3 = 0;
                }
            }
        }
        byte[] bArr4 = new byte[arrayList.size()];
        for (Byte b4 : arrayList) {
            bArr4[i] = b4.byteValue();
            i++;
        }
        return bArr4;
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }
}
