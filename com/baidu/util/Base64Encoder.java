package com.baidu.util;
/* loaded from: classes5.dex */
public class Base64Encoder {
    static {
        try {
            System.loadLibrary("base64encoder_v2_0");
        } catch (Error | Exception unused) {
        }
    }

    public static final byte[] B64Decode(byte[] bArr) {
        try {
            return nativeB64Decode(bArr, 0);
        } catch (Error | Exception unused) {
            return bArr;
        }
    }

    public static final byte[] B64Encode(byte[] bArr) {
        try {
            return nativeB64Encode(bArr, 0);
        } catch (Error | Exception unused) {
            return bArr;
        }
    }

    public static final int B64GetVersion() {
        try {
            return nativeB64GetVersion();
        } catch (Error | Exception unused) {
            return 0;
        }
    }

    public static final byte[] b64Decode(byte[] bArr) {
        try {
            return nativeB64Decode(bArr, 0);
        } catch (Error | Exception unused) {
            return bArr;
        }
    }

    public static final byte[] b64Encode(byte[] bArr) {
        try {
            return nativeB64Encode(bArr, 0);
        } catch (Error | Exception unused) {
            return bArr;
        }
    }

    public static final int b64GetVersion() {
        try {
            return nativeB64GetVersion();
        } catch (Error | Exception unused) {
            return 0;
        }
    }

    public static final native byte[] nativeB64Decode(byte[] bArr, int i2);

    public static final native byte[] nativeB64Encode(byte[] bArr, int i2);

    public static final native int nativeB64GetVersion();

    public static final byte[] b64Decode(byte[] bArr, int i2) {
        try {
            return nativeB64Decode(bArr, i2);
        } catch (Error | Exception unused) {
            return bArr;
        }
    }

    public static final byte[] b64Encode(byte[] bArr, int i2) {
        try {
            return nativeB64Encode(bArr, i2);
        } catch (Error | Exception unused) {
            return bArr;
        }
    }
}
