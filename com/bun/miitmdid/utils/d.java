package com.bun.miitmdid.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f27149a = "#PART#".getBytes();

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.encode(a(str.getBytes(), Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6ZetPcgLCvLsvDWzA3TYpRhEO\nfncquhfl9utVX+VApfrknKvYInYzmxjhdAEay+Nn6NPJKGPkCt1D7VWbf0YPiLmo\noCTIsuc7czZOu9pBJYjOrqCZhhJsJucc3+T/un8KioD2CjkXy0EhNMJSuvo+tHJg\nTbiR4QuPcIU1YBLX4wIDAQAB".getBytes(), 0)), 2));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length <= 117) {
            return b(bArr, bArr2);
        }
        ArrayList<Byte> arrayList = new ArrayList(2048);
        byte[] bArr3 = new byte[117];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            bArr3[i3] = bArr[i2];
            i3++;
            if (i3 == 117 || i2 == length - 1) {
                i4++;
                if (i4 != 1) {
                    for (byte b2 : f27149a) {
                        arrayList.add(Byte.valueOf(b2));
                    }
                }
                for (byte b3 : b(bArr3, bArr2)) {
                    arrayList.add(Byte.valueOf(b3));
                }
                bArr3 = i2 == length + (-1) ? null : new byte[Math.min(117, (length - i2) - 1)];
                i3 = 0;
            }
            i2++;
        }
        byte[] bArr4 = new byte[arrayList.size()];
        for (Byte b4 : arrayList) {
            bArr4[i] = b4.byteValue();
            i++;
        }
        return bArr4;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }
}
