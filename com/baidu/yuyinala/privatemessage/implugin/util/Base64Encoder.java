package com.baidu.yuyinala.privatemessage.implugin.util;
/* loaded from: classes4.dex */
public class Base64Encoder {
    public static final native byte[] nativeB64Decode(byte[] bArr);

    private static final native byte[] nativeB64Encode(byte[] bArr);

    public static final native int nativeB64GetVersion();

    static {
        try {
            System.loadLibrary("base64encoder_v1_4");
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }

    public static final byte[] b64Encode(byte[] bArr) {
        try {
            return nativeB64Encode(bArr);
        } catch (Error e) {
            return bArr;
        } catch (Exception e2) {
            return bArr;
        }
    }
}
