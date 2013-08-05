package com.baidu.zeus;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public final class PlumCore {
    private static String LOGTAG = "PlumCore";

    public static native void NativeOnCreate();

    public static native void PlEncoder(byte[] bArr, boolean z);

    public static native int PlGetWhiteBuffLen(int i, PackageInfo packageInfo);

    public static native void PlIdeaBase64Encoder(byte[] bArr);

    public static native int PlIdeaBase64GetBufferNeed(int i);

    public static native byte[] PlMartine(String str);

    public static native byte[] PlMartine2(byte[] bArr);

    public static native void PlRsaEncoder(byte[] bArr);

    public static native int PlRsaGetBufferNeed(int i);

    public static native int PlSetBuff(byte[] bArr, PackageInfo packageInfo);

    public static native int PlSetBuffV2(byte[] bArr, Context context);

    public static native int PlSetWhiteBuff(byte[] bArr, PackageInfo packageInfo);

    public static native int decryptWenKuNew(String str, int i);

    public static String ZeusMartine(String str) {
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            int PlIdeaBase64GetBufferNeed = PlIdeaBase64GetBufferNeed(length);
            byteArrayOutputStream.write(length & Util.MASK_8BIT);
            byteArrayOutputStream.write((length >> 8) & Util.MASK_8BIT);
            byteArrayOutputStream.write((length >> 16) & Util.MASK_8BIT);
            byteArrayOutputStream.write((length >> 24) & Util.MASK_8BIT);
            for (int i = 1; i <= 16; i++) {
                byteArrayOutputStream.write(0);
            }
            byteArrayOutputStream.write(bytes);
            int i2 = (PlIdeaBase64GetBufferNeed - length) - 20;
            for (int i3 = 0; i3 < i2; i3++) {
                byteArrayOutputStream.write(0);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            PlIdeaBase64Encoder(byteArray);
            return new String(byteArray, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (UnsatisfiedLinkError e2) {
            Log.e("LOGTAG", "callLibrary's method error.", e2);
            return null;
        }
    }

    public static String ZeusMartine2(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] PlMartine2 = PlMartine2(str.getBytes());
            if (PlMartine2 != null) {
                return new String(PlMartine2, "UTF-8");
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void encodeTest() {
        String ZeusMartine = ZeusMartine("lihuanhuan");
        Log.e(LOGTAG, "encode:" + ZeusMartine);
        ZeusMartine.toString().getBytes();
        String ZeusMartine2 = ZeusMartine2(ZeusMartine);
        Log.e(LOGTAG, "decode:" + ZeusMartine2);
        if (ZeusMartine2.equals("lihuanhuan")) {
            Log.e(LOGTAG, "yes");
        }
    }
}
