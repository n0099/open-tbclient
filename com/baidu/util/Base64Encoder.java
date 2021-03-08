package com.baidu.util;
/* loaded from: classes5.dex */
public class Base64Encoder {
    public static final native byte[] nativeB64Decode(byte[] bArr, int i);

    private static final native byte[] nativeB64Encode(byte[] bArr, int i);

    public static final native int nativeB64GetVersion();

    static {
        try {
            System.loadLibrary("base64encoder_v2_0");
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }

    public static final byte[] B64Encode(byte[] bArr) {
        try {
            return nativeB64Encode(bArr, 0);
        } catch (Error e) {
            return bArr;
        } catch (Exception e2) {
            return bArr;
        }
    }

    public static final byte[] B64Decode(byte[] bArr) {
        try {
            return nativeB64Decode(bArr, 0);
        } catch (Error e) {
            return bArr;
        } catch (Exception e2) {
            return bArr;
        }
    }

    public static final int B64GetVersion() {
        try {
            return nativeB64GetVersion();
        } catch (Error e) {
            return 0;
        } catch (Exception e2) {
            return 0;
        }
    }

    public static final byte[] b64Encode(byte[] bArr) {
        try {
            return nativeB64Encode(bArr, 0);
        } catch (Error e) {
            return bArr;
        } catch (Exception e2) {
            return bArr;
        }
    }

    public static final byte[] b64Encode(byte[] bArr, int i) {
        try {
            return nativeB64Encode(bArr, i);
        } catch (Error e) {
            return bArr;
        } catch (Exception e2) {
            return bArr;
        }
    }

    public static final byte[] b64Decode(byte[] bArr) {
        try {
            return nativeB64Decode(bArr, 0);
        } catch (Error e) {
            return bArr;
        } catch (Exception e2) {
            return bArr;
        }
    }

    public static final byte[] b64Decode(byte[] bArr, int i) {
        try {
            return nativeB64Decode(bArr, i);
        } catch (Error e) {
            return bArr;
        } catch (Exception e2) {
            return bArr;
        }
    }

    public static final int b64GetVersion() {
        try {
            return nativeB64GetVersion();
        } catch (Error e) {
            return 0;
        } catch (Exception e2) {
            return 0;
        }
    }
}
