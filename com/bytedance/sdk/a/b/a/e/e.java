package com.bytedance.sdk.a.b.a.e;

import java.io.IOException;
/* loaded from: classes6.dex */
public final class e {
    static final com.bytedance.sdk.a.a.f psd = com.bytedance.sdk.a.a.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] b = new String[64];
    static final String[] c = new String[256];

    static {
        int[] iArr;
        for (int i = 0; i < c.length; i++) {
            c[i] = com.bytedance.sdk.a.b.a.c.a("%8s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        b[0] = "";
        b[1] = "END_STREAM";
        int[] iArr2 = {1};
        b[8] = "PADDED";
        for (int i2 : iArr2) {
            b[i2 | 8] = b[i2] + "|PADDED";
        }
        b[4] = "END_HEADERS";
        b[32] = "PRIORITY";
        b[36] = "END_HEADERS|PRIORITY";
        for (int i3 : new int[]{4, 32, 36}) {
            for (int i4 : iArr2) {
                b[i4 | i3] = b[i4] + '|' + b[i3];
                b[i4 | i3 | 8] = b[i4] + '|' + b[i3] + "|PADDED";
            }
        }
        for (int i5 = 0; i5 < b.length; i5++) {
            if (b[i5] == null) {
                b[i5] = c[i5];
            }
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException h(String str, Object... objArr) {
        throw new IllegalArgumentException(com.bytedance.sdk.a.b.a.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException j(String str, Object... objArr) throws IOException {
        throw new IOException(com.bytedance.sdk.a.b.a.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String a2 = b2 < d.length ? d[b2] : com.bytedance.sdk.a.b.a.c.a("0x%02x", Byte.valueOf(b2));
        String c2 = c(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = c2;
        return com.bytedance.sdk.a.b.a.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String c(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        switch (b2) {
            case 2:
            case 3:
            case 7:
            case 8:
                return c[b3];
            case 4:
            case 6:
                return b3 == 1 ? "ACK" : c[b3];
            case 5:
            default:
                String str = b3 < b.length ? b[b3] : c[b3];
                if (b2 == 5 && (b3 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b2 == 0 && (b3 & 32) != 0) {
                    return str.replace("PRIORITY", "COMPRESSED");
                }
                return str;
        }
    }
}
