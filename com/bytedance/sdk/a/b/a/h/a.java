package com.bytedance.sdk.a.b.a.h;

import com.bytedance.sdk.a.a.j;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.g.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f6242a = {42};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f6243b = new String[0];
    private static final String[] c = {"*"};
    private static final a pkZ = new a();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final CountDownLatch f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    public static a erc() {
        return pkZ;
    }

    public String a(String str) {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] af = af(split);
        if (split.length == af.length && af[0].charAt(0) != '!') {
            return null;
        }
        if (af[0].charAt(0) == '!') {
            length = split.length - af.length;
        } else {
            length = split.length - (af.length + 1);
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        while (length < split2.length) {
            sb.append(split2[length]).append('.');
            length++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] af(String[] strArr) {
        String str;
        String str2;
        String str3 = null;
        int i = 0;
        if (!this.e.get() && this.e.compareAndSet(false, true)) {
            b();
        } else {
            try {
                this.f.await();
            } catch (InterruptedException e) {
            }
        }
        synchronized (this) {
            if (this.g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(c.pjm);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= bArr.length) {
                str = null;
                break;
            }
            str = a(this.g, bArr, i3);
            if (str != null) {
                break;
            }
            i3++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = f6242a;
                String a2 = a(this.g, bArr2, i4);
                if (a2 != null) {
                    str2 = a2;
                    break;
                }
            }
        }
        str2 = null;
        if (str2 != null) {
            while (true) {
                if (i >= bArr.length - 1) {
                    break;
                }
                String a3 = a(this.h, bArr, i);
                if (a3 != null) {
                    str3 = a3;
                    break;
                }
                i++;
            }
        }
        if (str3 != null) {
            return ("!" + str3).split("\\.");
        }
        if (str == null && str2 == null) {
            return c;
        }
        String[] split = str != null ? str.split("\\.") : f6243b;
        String[] split2 = str2 != null ? str2.split("\\.") : f6243b;
        return split.length > split2.length ? split : split2;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        int length = bArr.length;
        while (i8 < length) {
            int i9 = (i8 + length) / 2;
            while (i9 > -1 && bArr[i9] != 10) {
                i9--;
            }
            int i10 = i9 + 1;
            int i11 = 1;
            while (bArr[i10 + i11] != 10) {
                i11++;
            }
            int i12 = (i10 + i11) - i10;
            int i13 = 0;
            int i14 = 0;
            boolean z = false;
            int i15 = i;
            while (true) {
                if (z) {
                    i2 = 46;
                    z = false;
                } else {
                    i2 = bArr2[i15][i13] & 255;
                }
                i3 = i2 - (bArr[i10 + i14] & 255);
                if (i3 != 0) {
                    i4 = i14;
                    i5 = i13;
                    break;
                }
                i14++;
                i5 = i13 + 1;
                if (i14 == i12) {
                    i4 = i14;
                    break;
                }
                if (bArr2[i15].length == i5) {
                    if (i15 == bArr2.length - 1) {
                        i4 = i14;
                        break;
                    }
                    i15++;
                    i5 = -1;
                    z = true;
                }
                i13 = i5;
            }
            if (i3 < 0) {
                i7 = i10 - 1;
                i6 = i8;
            } else if (i3 > 0) {
                i6 = i11 + i10 + 1;
                i7 = length;
            } else {
                int i16 = i12 - i4;
                int length2 = bArr2[i15].length - i5;
                for (int i17 = i15 + 1; i17 < bArr2.length; i17++) {
                    length2 += bArr2[i17].length;
                }
                if (length2 < i16) {
                    i7 = i10 - 1;
                    i6 = i8;
                } else if (length2 > i16) {
                    i6 = i11 + i10 + 1;
                    i7 = length;
                } else {
                    return new String(bArr, i10, i12, c.pjm);
                }
            }
            length = i7;
            i8 = i6;
        }
        return null;
    }

    private void b() {
        boolean z;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    z = z2;
                    c();
                    break;
                } catch (InterruptedIOException e) {
                    z2 = true;
                } catch (IOException e2) {
                    e.erb().a(5, "Failed to read public suffix list", e2);
                    if (!z) {
                        return;
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    private void c() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream != null) {
            com.bytedance.sdk.a.a.e c2 = l.c(new j(l.s(resourceAsStream)));
            try {
                byte[] bArr = new byte[c2.j()];
                c2.a(bArr);
                byte[] bArr2 = new byte[c2.j()];
                c2.a(bArr2);
                synchronized (this) {
                    this.g = bArr;
                    this.h = bArr2;
                }
                this.f.countDown();
            } finally {
                c.a(c2);
            }
        }
    }
}
