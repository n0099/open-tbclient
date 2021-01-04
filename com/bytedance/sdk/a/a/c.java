package com.bytedance.sdk.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public final class c implements d, e, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: b  reason: collision with root package name */
    long f6139b;
    o phQ;

    public final long b() {
        return this.f6139b;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c epS() {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: epT */
    public c eqb() {
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() {
        return this.f6139b == 0;
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j) throws EOFException {
        if (this.f6139b < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream epU() {
        return new InputStream() { // from class: com.bytedance.sdk.a.a.c.1
            @Override // java.io.InputStream
            public int read() {
                if (c.this.f6139b > 0) {
                    return c.this.epV() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.f6139b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.a(this.f6139b, j, j2);
        if (j2 != 0) {
            cVar.f6139b += j2;
            o oVar = this.phQ;
            while (j >= oVar.c - oVar.f6148b) {
                j -= oVar.c - oVar.f6148b;
                oVar = oVar.pie;
            }
            while (j2 > 0) {
                o eqh = oVar.eqh();
                eqh.f6148b = (int) (eqh.f6148b + j);
                eqh.c = Math.min(eqh.f6148b + ((int) j2), eqh.c);
                if (cVar.phQ == null) {
                    eqh.pif = eqh;
                    eqh.pie = eqh;
                    cVar.phQ = eqh;
                } else {
                    cVar.phQ.pif.a(eqh);
                }
                j2 -= eqh.c - eqh.f6148b;
                oVar = oVar.pie;
                j = 0;
            }
        }
        return this;
    }

    public final long g() {
        long j = this.f6139b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.phQ.pif;
        if (oVar.c < 8192 && oVar.e) {
            return j - (oVar.c - oVar.f6148b);
        }
        return j;
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte epV() {
        if (this.f6139b == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.phQ;
        int i = oVar.f6148b;
        int i2 = oVar.c;
        int i3 = i + 1;
        byte b2 = oVar.f6147a[i];
        this.f6139b--;
        if (i3 == i2) {
            this.phQ = oVar.eqi();
            p.b(oVar);
        } else {
            oVar.f6148b = i3;
        }
        return b2;
    }

    public final byte ie(long j) {
        u.a(this.f6139b, j, 1L);
        if (this.f6139b - j > j) {
            o oVar = this.phQ;
            while (true) {
                int i = oVar.c - oVar.f6148b;
                if (j < i) {
                    return oVar.f6147a[oVar.f6148b + ((int) j)];
                }
                j -= i;
                oVar = oVar.pie;
            }
        } else {
            long j2 = j - this.f6139b;
            o oVar2 = this.phQ.pif;
            while (true) {
                j2 += oVar2.c - oVar2.f6148b;
                if (j2 >= 0) {
                    return oVar2.f6147a[oVar2.f6148b + ((int) j2)];
                }
                oVar2 = oVar2.pif;
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public short epW() {
        if (this.f6139b < 2) {
            throw new IllegalStateException("size < 2: " + this.f6139b);
        }
        o oVar = this.phQ;
        int i = oVar.f6148b;
        int i2 = oVar.c;
        if (i2 - i < 2) {
            return (short) (((epV() & 255) << 8) | (epV() & 255));
        }
        byte[] bArr = oVar.f6147a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f6139b -= 2;
        if (i4 == i2) {
            this.phQ = oVar.eqi();
            p.b(oVar);
        } else {
            oVar.f6148b = i4;
        }
        return (short) i5;
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() {
        if (this.f6139b < 4) {
            throw new IllegalStateException("size < 4: " + this.f6139b);
        }
        o oVar = this.phQ;
        int i = oVar.f6148b;
        int i2 = oVar.c;
        if (i2 - i < 4) {
            return ((epV() & 255) << 24) | ((epV() & 255) << 16) | ((epV() & 255) << 8) | (epV() & 255);
        }
        byte[] bArr = oVar.f6147a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f6139b -= 4;
        if (i8 == i2) {
            this.phQ = oVar.eqi();
            p.b(oVar);
            return i9;
        }
        oVar.f6148b = i8;
        return i9;
    }

    @Override // com.bytedance.sdk.a.a.e
    public short epX() {
        return u.l(epW());
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() {
        return u.a(j());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
        r14.f6139b -= r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    @Override // com.bytedance.sdk.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m() {
        int i;
        if (this.f6139b != 0) {
            boolean z = false;
            int i2 = 0;
            long j = 0;
            while (true) {
                o oVar = this.phQ;
                byte[] bArr = oVar.f6147a;
                int i3 = oVar.c;
                int i4 = i2;
                for (int i5 = oVar.f6148b; i5 < i3; i5++) {
                    byte b2 = bArr[i5];
                    if (b2 >= 48 && b2 <= 57) {
                        i = b2 - 48;
                    } else if (b2 >= 97 && b2 <= 102) {
                        i = (b2 - 97) + 10;
                    } else if (b2 >= 65 && b2 <= 70) {
                        i = (b2 - 65) + 10;
                    } else if (i4 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                    } else {
                        z = true;
                        if (i5 != i3) {
                            this.phQ = oVar.eqi();
                            p.b(oVar);
                        } else {
                            oVar.f6148b = i5;
                        }
                        if (!!z || this.phQ == null) {
                            break;
                        }
                        i2 = i4;
                    }
                    if (((-1152921504606846976L) & j) != 0) {
                        throw new NumberFormatException("Number too large: " + new c().ik(j).PM(b2).o());
                    }
                    j = (j << 4) | i;
                    i4++;
                }
                if (i5 != i3) {
                }
                if (!z) {
                    break;
                }
                break;
            }
        }
        throw new IllegalStateException("size == 0");
    }

    public f epY() {
        return new f(q());
    }

    @Override // com.bytedance.sdk.a.a.e
    /* renamed from: if  reason: not valid java name */
    public f mo47if(long j) throws EOFException {
        return new f(ih(j));
    }

    public String o() {
        try {
            return a(this.f6139b, u.f6152a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j) throws EOFException {
        return a(j, u.f6152a);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String b(Charset charset) {
        try {
            return a(this.f6139b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.f6139b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        o oVar = this.phQ;
        if (oVar.f6148b + j > oVar.c) {
            return new String(ih(j), charset);
        }
        String str = new String(oVar.f6147a, oVar.f6148b, (int) j, charset);
        oVar.f6148b = (int) (oVar.f6148b + j);
        this.f6139b -= j;
        if (oVar.f6148b == oVar.c) {
            this.phQ = oVar.eqi();
            p.b(oVar);
            return str;
        }
        return str;
    }

    @Override // com.bytedance.sdk.a.a.e
    public String p() throws EOFException {
        return e(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String e(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long a2 = a((byte) 10, 0L, j2);
        if (a2 != -1) {
            return ig(a2);
        }
        if (j2 < b() && ie(j2 - 1) == 13 && ie(j2) == 10) {
            return ig(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, b()));
        throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + cVar.epY().e() + (char) 8230);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ig(long j) throws EOFException {
        if (j > 0 && ie(j - 1) == 13) {
            String d = d(j - 1);
            h(2L);
            return d;
        }
        String d2 = d(j);
        h(1L);
        return d2;
    }

    public byte[] q() {
        try {
            return ih(this.f6139b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] ih(long j) throws EOFException {
        u.a(this.f6139b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        u.a(bArr.length, i, i2);
        o oVar = this.phQ;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.c - oVar.f6148b);
        System.arraycopy(oVar.f6147a, oVar.f6148b, bArr, i, min);
        oVar.f6148b += min;
        this.f6139b -= min;
        if (oVar.f6148b == oVar.c) {
            this.phQ = oVar.eqi();
            p.b(oVar);
            return min;
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.phQ;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.c - oVar.f6148b);
        byteBuffer.put(oVar.f6147a, oVar.f6148b, min);
        oVar.f6148b += min;
        this.f6139b -= min;
        if (oVar.f6148b == oVar.c) {
            this.phQ = oVar.eqi();
            p.b(oVar);
            return min;
        }
        return min;
    }

    public final void r() {
        try {
            h(this.f6139b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j) throws EOFException {
        while (j > 0) {
            if (this.phQ == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.phQ.c - this.phQ.f6148b);
            this.f6139b -= min;
            j -= min;
            o oVar = this.phQ;
            oVar.f6148b = min + oVar.f6148b;
            if (this.phQ.f6148b == this.phQ.c) {
                o oVar2 = this.phQ;
                this.phQ = oVar2.eqi();
                p.b(oVar2);
            }
        }
    }

    public c c(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.a(this);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: YG */
    public c YH(String str) {
        return B(str, 0, str.length());
    }

    public c B(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                o PI = PI(1);
                byte[] bArr = PI.f6147a;
                int i4 = PI.c - i;
                int min = Math.min(i2, 8192 - i4);
                i3 = i + 1;
                bArr[i4 + i] = (byte) charAt;
                while (i3 < min) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i3 + i4] = (byte) charAt2;
                    i3++;
                }
                int i5 = (i3 + i4) - PI.c;
                PI.c += i5;
                this.f6139b += i5;
            } else if (charAt < 2048) {
                PM((charAt >> 6) | 192);
                PM((charAt & '?') | 128);
                i3 = i + 1;
            } else if (charAt < 55296 || charAt > 57343) {
                PM((charAt >> '\f') | 224);
                PM(((charAt >> 6) & 63) | 128);
                PM((charAt & '?') | 128);
                i3 = i + 1;
            } else {
                char charAt3 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                    PM(63);
                    i++;
                } else {
                    int i6 = ((charAt3 & 9215) | ((charAt & 10239) << 10)) + 65536;
                    PM((i6 >> 18) | 240);
                    PM(((i6 >> 12) & 63) | 128);
                    PM(((i6 >> 6) & 63) | 128);
                    PM((i6 & 63) | 128);
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return this;
    }

    public c PE(int i) {
        if (i < 128) {
            PM(i);
        } else if (i < 2048) {
            PM((i >> 6) | 192);
            PM((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                PM(63);
            } else {
                PM((i >> 12) | 224);
                PM(((i >> 6) & 63) | 128);
                PM((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            PM((i >> 18) | 240);
            PM(((i >> 12) & 63) | 128);
            PM(((i >> 6) & 63) | 128);
            PM((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(u.f6152a)) {
            return B(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return x(bytes, 0, bytes.length);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: ai */
    public c aj(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return x(bArr, 0, bArr.length);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: w */
    public c x(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        u.a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            o PI = PI(1);
            int min = Math.min(i3 - i, 8192 - PI.c);
            System.arraycopy(bArr, i, PI.f6147a, PI.c, min);
            i += min;
            PI.c = min + PI.c;
        }
        this.f6139b += i2;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            o PI = PI(1);
            int min = Math.min(i, 8192 - PI.c);
            byteBuffer.get(PI.f6147a, PI.c, min);
            i -= min;
            PI.c = min + PI.c;
        }
        this.f6139b += remaining;
        return remaining;
    }

    public long b(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = sVar.b(this, 8192L);
            if (b2 != -1) {
                j += b2;
            } else {
                return j;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: PF */
    public c PM(int i) {
        o PI = PI(1);
        byte[] bArr = PI.f6147a;
        int i2 = PI.c;
        PI.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f6139b++;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: PG */
    public c PL(int i) {
        o PI = PI(2);
        byte[] bArr = PI.f6147a;
        int i2 = PI.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        PI.c = i3 + 1;
        this.f6139b += 2;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: PH */
    public c PK(int i) {
        o PI = PI(4);
        byte[] bArr = PI.f6147a;
        int i2 = PI.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        PI.c = i5 + 1;
        this.f6139b += 4;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: ii */
    public c il(long j) {
        boolean z;
        long j2;
        int i;
        if (j == 0) {
            return PM(48);
        }
        if (j >= 0) {
            z = false;
            j2 = j;
        } else {
            j2 = -j;
            if (j2 < 0) {
                return YH("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i = j2 < TimeUtils.NANOS_PER_MS ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 < 100) {
            i = j2 < 10 ? 1 : 2;
        } else {
            i = j2 < 1000 ? 3 : 4;
        }
        if (z) {
            i++;
        }
        o PI = PI(i);
        byte[] bArr = PI.f6147a;
        int i2 = PI.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        PI.c += i;
        this.f6139b = i + this.f6139b;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: ij */
    public c ik(long j) {
        if (j == 0) {
            return PM(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o PI = PI(numberOfTrailingZeros);
        byte[] bArr = PI.f6147a;
        int i = PI.c;
        for (int i2 = (PI.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        PI.c += numberOfTrailingZeros;
        this.f6139b = numberOfTrailingZeros + this.f6139b;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o PI(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.phQ == null) {
            this.phQ = p.eqh();
            o oVar = this.phQ;
            o oVar2 = this.phQ;
            o oVar3 = this.phQ;
            oVar2.pif = oVar3;
            oVar.pie = oVar3;
            return oVar3;
        }
        o oVar4 = this.phQ.pif;
        if (oVar4.c + i > 8192 || !oVar4.e) {
            return oVar4.a(p.eqh());
        }
        return oVar4;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.a(cVar.f6139b, 0L, j);
        while (j > 0) {
            if (j < cVar.phQ.c - cVar.phQ.f6148b) {
                o oVar = this.phQ != null ? this.phQ.pif : null;
                if (oVar != null && oVar.e) {
                    if ((oVar.c + j) - (oVar.d ? 0 : oVar.f6148b) <= 8192) {
                        cVar.phQ.a(oVar, (int) j);
                        cVar.f6139b -= j;
                        this.f6139b += j;
                        return;
                    }
                }
                cVar.phQ = cVar.phQ.PN((int) j);
            }
            o oVar2 = cVar.phQ;
            long j2 = oVar2.c - oVar2.f6148b;
            cVar.phQ = oVar2.eqi();
            if (this.phQ == null) {
                this.phQ = oVar2;
                o oVar3 = this.phQ;
                o oVar4 = this.phQ;
                o oVar5 = this.phQ;
                oVar4.pif = oVar5;
                oVar3.pie = oVar5;
            } else {
                this.phQ.pif.a(oVar2).c();
            }
            cVar.f6139b -= j2;
            this.f6139b += j2;
            j -= j2;
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f6139b == 0) {
            return -1L;
        }
        if (j > this.f6139b) {
            j = this.f6139b;
        }
        cVar.a(this, j);
        return j;
    }

    @Override // com.bytedance.sdk.a.a.e
    public long e(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        o oVar;
        long j3;
        o oVar2;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f6139b), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (j2 > this.f6139b) {
            j2 = this.f6139b;
        }
        if (j == j2 || (oVar = this.phQ) == null) {
            return -1L;
        }
        if (this.f6139b - j < j) {
            j3 = this.f6139b;
            oVar2 = oVar;
            while (j3 > j) {
                oVar2 = oVar2.pif;
                j3 -= oVar2.c - oVar2.f6148b;
            }
        } else {
            j3 = 0;
            oVar2 = oVar;
            while (true) {
                long j4 = (oVar2.c - oVar2.f6148b) + j3;
                if (j4 >= j) {
                    break;
                }
                oVar2 = oVar2.pie;
                j3 = j4;
            }
        }
        long j5 = j3;
        while (j5 < j2) {
            byte[] bArr = oVar2.f6147a;
            int min = (int) Math.min(oVar2.c, (oVar2.f6148b + j2) - j5);
            for (int i = (int) ((oVar2.f6148b + j) - j5); i < min; i++) {
                if (bArr[i] == b2) {
                    return (i - oVar2.f6148b) + j5;
                }
            }
            long j6 = (oVar2.c - oVar2.f6148b) + j5;
            oVar2 = oVar2.pie;
            j5 = j6;
            j = j6;
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.g());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f6139b - j < i2 || fVar.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (ie(i3 + j) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.a.a.r
    public t epR() {
        return t.pig;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f6139b != cVar.f6139b) {
                return false;
            }
            if (this.f6139b == 0) {
                return true;
            }
            o oVar = this.phQ;
            o oVar2 = cVar.phQ;
            int i = oVar.f6148b;
            int i2 = oVar2.f6148b;
            while (j < this.f6139b) {
                long min = Math.min(oVar.c - i, oVar2.c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (oVar.f6147a[i] != oVar2.f6147a[i2]) {
                        return false;
                    }
                    i3++;
                    i2 = i5;
                    i = i4;
                }
                if (i == oVar.c) {
                    oVar = oVar.pie;
                    i = oVar.f6148b;
                }
                if (i2 == oVar2.c) {
                    oVar2 = oVar2.pie;
                    i2 = oVar2.f6148b;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        o oVar = this.phQ;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.c;
            for (int i3 = oVar.f6148b; i3 < i2; i3++) {
                i = (i * 31) + oVar.f6147a[i3];
            }
            oVar = oVar.pie;
        } while (oVar != this.phQ);
        return i;
    }

    public String toString() {
        return eqa().toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: epZ */
    public c clone() {
        c cVar = new c();
        if (this.f6139b == 0) {
            return cVar;
        }
        cVar.phQ = this.phQ.eqh();
        o oVar = cVar.phQ;
        o oVar2 = cVar.phQ;
        o oVar3 = cVar.phQ;
        oVar2.pif = oVar3;
        oVar.pie = oVar3;
        for (o oVar4 = this.phQ.pie; oVar4 != this.phQ; oVar4 = oVar4.pie) {
            cVar.phQ.pif.a(oVar4.eqh());
        }
        cVar.f6139b = this.f6139b;
        return cVar;
    }

    public final f eqa() {
        if (this.f6139b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f6139b);
        }
        return PJ((int) this.f6139b);
    }

    public final f PJ(int i) {
        return i == 0 ? f.f6141b : new q(this, i);
    }
}
