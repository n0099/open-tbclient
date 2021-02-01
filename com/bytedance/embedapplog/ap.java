package com.bytedance.embedapplog;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f5783a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = bArr[i4 + i] & 255;
            int i6 = i3 + 1;
            cArr[i3] = f5783a[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = f5783a[i5 & 15];
        }
        return new String(cArr, 0, i2 * 2);
    }

    public static String b(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length == 0) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                messageDigest.update(bArr);
                return a(messageDigest.digest());
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
