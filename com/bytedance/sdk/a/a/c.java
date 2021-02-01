package com.bytedance.sdk.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public final class c implements d, e, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: b  reason: collision with root package name */
    long f5842b;
    o pnC;

    public final long b() {
        return this.f5842b;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c eor() {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: eos */
    public c eoA() {
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() {
        return this.f5842b == 0;
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j) throws EOFException {
        if (this.f5842b < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream eot() {
        return new InputStream() { // from class: com.bytedance.sdk.a.a.c.1
            @Override // java.io.InputStream
            public int read() {
                if (c.this.f5842b > 0) {
                    return c.this.eou() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.f5842b, 2147483647L);
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
        u.a(this.f5842b, j, j2);
        if (j2 != 0) {
            cVar.f5842b += j2;
            o oVar = this.pnC;
            while (j >= oVar.c - oVar.f5851b) {
                j -= oVar.c - oVar.f5851b;
                oVar = oVar.pnO;
            }
            while (j2 > 0) {
                o eoG = oVar.eoG();
                eoG.f5851b = (int) (eoG.f5851b + j);
                eoG.c = Math.min(eoG.f5851b + ((int) j2), eoG.c);
                if (cVar.pnC == null) {
                    eoG.pnP = eoG;
                    eoG.pnO = eoG;
                    cVar.pnC = eoG;
                } else {
                    cVar.pnC.pnP.a(eoG);
                }
                j2 -= eoG.c - eoG.f5851b;
                oVar = oVar.pnO;
                j = 0;
            }
        }
        return this;
    }

    public final long g() {
        long j = this.f5842b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.pnC.pnP;
        if (oVar.c < 8192 && oVar.e) {
            return j - (oVar.c - oVar.f5851b);
        }
        return j;
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte eou() {
        if (this.f5842b == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.pnC;
        int i = oVar.f5851b;
        int i2 = oVar.c;
        int i3 = i + 1;
        byte b2 = oVar.f5850a[i];
        this.f5842b--;
        if (i3 == i2) {
            this.pnC = oVar.eoH();
            p.b(oVar);
        } else {
            oVar.f5851b = i3;
        }
        return b2;
    }

    public final byte ih(long j) {
        u.a(this.f5842b, j, 1L);
        if (this.f5842b - j > j) {
            o oVar = this.pnC;
            while (true) {
                int i = oVar.c - oVar.f5851b;
                if (j < i) {
                    return oVar.f5850a[oVar.f5851b + ((int) j)];
                }
                j -= i;
                oVar = oVar.pnO;
            }
        } else {
            long j2 = j - this.f5842b;
            o oVar2 = this.pnC.pnP;
            while (true) {
                j2 += oVar2.c - oVar2.f5851b;
                if (j2 >= 0) {
                    return oVar2.f5850a[oVar2.f5851b + ((int) j2)];
                }
                oVar2 = oVar2.pnP;
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public short eov() {
        if (this.f5842b < 2) {
            throw new IllegalStateException("size < 2: " + this.f5842b);
        }
        o oVar = this.pnC;
        int i = oVar.f5851b;
        int i2 = oVar.c;
        if (i2 - i < 2) {
            return (short) (((eou() & 255) << 8) | (eou() & 255));
        }
        byte[] bArr = oVar.f5850a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f5842b -= 2;
        if (i4 == i2) {
            this.pnC = oVar.eoH();
            p.b(oVar);
        } else {
            oVar.f5851b = i4;
        }
        return (short) i5;
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() {
        if (this.f5842b < 4) {
            throw new IllegalStateException("size < 4: " + this.f5842b);
        }
        o oVar = this.pnC;
        int i = oVar.f5851b;
        int i2 = oVar.c;
        if (i2 - i < 4) {
            return ((eou() & 255) << 24) | ((eou() & 255) << 16) | ((eou() & 255) << 8) | (eou() & 255);
        }
        byte[] bArr = oVar.f5850a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f5842b -= 4;
        if (i8 == i2) {
            this.pnC = oVar.eoH();
            p.b(oVar);
            return i9;
        }
        oVar.f5851b = i8;
        return i9;
    }

    @Override // com.bytedance.sdk.a.a.e
    public short eow() {
        return u.l(eov());
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() {
        return u.a(j());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
        r14.f5842b -= r1;
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
        if (this.f5842b != 0) {
            boolean z = false;
            int i2 = 0;
            long j = 0;
            while (true) {
                o oVar = this.pnC;
                byte[] bArr = oVar.f5850a;
                int i3 = oVar.c;
                int i4 = i2;
                for (int i5 = oVar.f5851b; i5 < i3; i5++) {
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
                            this.pnC = oVar.eoH();
                            p.b(oVar);
                        } else {
                            oVar.f5851b = i5;
                        }
                        if (!!z || this.pnC == null) {
                            break;
                        }
                        i2 = i4;
                    }
                    if (((-1152921504606846976L) & j) != 0) {
                        throw new NumberFormatException("Number too large: " + new c().in(j).OA(b2).o());
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

    public f eox() {
        return new f(q());
    }

    @Override // com.bytedance.sdk.a.a.e
    public f ii(long j) throws EOFException {
        return new f(ik(j));
    }

    public String o() {
        try {
            return a(this.f5842b, u.f5855a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j) throws EOFException {
        return a(j, u.f5855a);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String b(Charset charset) {
        try {
            return a(this.f5842b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.f5842b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        o oVar = this.pnC;
        if (oVar.f5851b + j > oVar.c) {
            return new String(ik(j), charset);
        }
        String str = new String(oVar.f5850a, oVar.f5851b, (int) j, charset);
        oVar.f5851b = (int) (oVar.f5851b + j);
        this.f5842b -= j;
        if (oVar.f5851b == oVar.c) {
            this.pnC = oVar.eoH();
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
            return ij(a2);
        }
        if (j2 < b() && ih(j2 - 1) == 13 && ih(j2) == 10) {
            return ij(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, b()));
        throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + cVar.eox().e() + (char) 8230);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ij(long j) throws EOFException {
        if (j > 0 && ih(j - 1) == 13) {
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
            return ik(this.f5842b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] ik(long j) throws EOFException {
        u.a(this.f5842b, 0L, j);
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
        o oVar = this.pnC;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.c - oVar.f5851b);
        System.arraycopy(oVar.f5850a, oVar.f5851b, bArr, i, min);
        oVar.f5851b += min;
        this.f5842b -= min;
        if (oVar.f5851b == oVar.c) {
            this.pnC = oVar.eoH();
            p.b(oVar);
            return min;
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.pnC;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.c - oVar.f5851b);
        byteBuffer.put(oVar.f5850a, oVar.f5851b, min);
        oVar.f5851b += min;
        this.f5842b -= min;
        if (oVar.f5851b == oVar.c) {
            this.pnC = oVar.eoH();
            p.b(oVar);
            return min;
        }
        return min;
    }

    public final void r() {
        try {
            h(this.f5842b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j) throws EOFException {
        while (j > 0) {
            if (this.pnC == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.pnC.c - this.pnC.f5851b);
            this.f5842b -= min;
            j -= min;
            o oVar = this.pnC;
            oVar.f5851b = min + oVar.f5851b;
            if (this.pnC.f5851b == this.pnC.c) {
                o oVar2 = this.pnC;
                this.pnC = oVar2.eoH();
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
    /* renamed from: Yz */
    public c YA(String str) {
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
                o Ow = Ow(1);
                byte[] bArr = Ow.f5850a;
                int i4 = Ow.c - i;
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
                int i5 = (i3 + i4) - Ow.c;
                Ow.c += i5;
                this.f5842b += i5;
            } else if (charAt < 2048) {
                OA((charAt >> 6) | 192);
                OA((charAt & '?') | 128);
                i3 = i + 1;
            } else if (charAt < 55296 || charAt > 57343) {
                OA((charAt >> '\f') | 224);
                OA(((charAt >> 6) & 63) | 128);
                OA((charAt & '?') | 128);
                i3 = i + 1;
            } else {
                char charAt3 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                    OA(63);
                    i++;
                } else {
                    int i6 = ((charAt3 & 9215) | ((charAt & 10239) << 10)) + 65536;
                    OA((i6 >> 18) | 240);
                    OA(((i6 >> 12) & 63) | 128);
                    OA(((i6 >> 6) & 63) | 128);
                    OA((i6 & 63) | 128);
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return this;
    }

    public c Os(int i) {
        if (i < 128) {
            OA(i);
        } else if (i < 2048) {
            OA((i >> 6) | 192);
            OA((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                OA(63);
            } else {
                OA((i >> 12) | 224);
                OA(((i >> 6) & 63) | 128);
                OA((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            OA((i >> 18) | 240);
            OA(((i >> 12) & 63) | 128);
            OA(((i >> 6) & 63) | 128);
            OA((i & 63) | 128);
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
        if (charset.equals(u.f5855a)) {
            return B(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return w(bytes, 0, bytes.length);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: ag */
    public c ah(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return w(bArr, 0, bArr.length);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: v */
    public c w(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        u.a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            o Ow = Ow(1);
            int min = Math.min(i3 - i, 8192 - Ow.c);
            System.arraycopy(bArr, i, Ow.f5850a, Ow.c, min);
            i += min;
            Ow.c = min + Ow.c;
        }
        this.f5842b += i2;
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
            o Ow = Ow(1);
            int min = Math.min(i, 8192 - Ow.c);
            byteBuffer.get(Ow.f5850a, Ow.c, min);
            i -= min;
            Ow.c = min + Ow.c;
        }
        this.f5842b += remaining;
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
    /* renamed from: Ot */
    public c OA(int i) {
        o Ow = Ow(1);
        byte[] bArr = Ow.f5850a;
        int i2 = Ow.c;
        Ow.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f5842b++;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: Ou */
    public c Oz(int i) {
        o Ow = Ow(2);
        byte[] bArr = Ow.f5850a;
        int i2 = Ow.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        Ow.c = i3 + 1;
        this.f5842b += 2;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: Ov */
    public c Oy(int i) {
        o Ow = Ow(4);
        byte[] bArr = Ow.f5850a;
        int i2 = Ow.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        Ow.c = i5 + 1;
        this.f5842b += 4;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: il */
    public c io(long j) {
        boolean z;
        long j2;
        int i;
        if (j == 0) {
            return OA(48);
        }
        if (j >= 0) {
            z = false;
            j2 = j;
        } else {
            j2 = -j;
            if (j2 < 0) {
                return YA("-9223372036854775808");
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
        o Ow = Ow(i);
        byte[] bArr = Ow.f5850a;
        int i2 = Ow.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        Ow.c += i;
        this.f5842b = i + this.f5842b;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: im */
    public c in(long j) {
        if (j == 0) {
            return OA(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o Ow = Ow(numberOfTrailingZeros);
        byte[] bArr = Ow.f5850a;
        int i = Ow.c;
        for (int i2 = (Ow.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        Ow.c += numberOfTrailingZeros;
        this.f5842b = numberOfTrailingZeros + this.f5842b;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o Ow(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.pnC == null) {
            this.pnC = p.eoG();
            o oVar = this.pnC;
            o oVar2 = this.pnC;
            o oVar3 = this.pnC;
            oVar2.pnP = oVar3;
            oVar.pnO = oVar3;
            return oVar3;
        }
        o oVar4 = this.pnC.pnP;
        if (oVar4.c + i > 8192 || !oVar4.e) {
            return oVar4.a(p.eoG());
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
        u.a(cVar.f5842b, 0L, j);
        while (j > 0) {
            if (j < cVar.pnC.c - cVar.pnC.f5851b) {
                o oVar = this.pnC != null ? this.pnC.pnP : null;
                if (oVar != null && oVar.e) {
                    if ((oVar.c + j) - (oVar.d ? 0 : oVar.f5851b) <= 8192) {
                        cVar.pnC.a(oVar, (int) j);
                        cVar.f5842b -= j;
                        this.f5842b += j;
                        return;
                    }
                }
                cVar.pnC = cVar.pnC.OB((int) j);
            }
            o oVar2 = cVar.pnC;
            long j2 = oVar2.c - oVar2.f5851b;
            cVar.pnC = oVar2.eoH();
            if (this.pnC == null) {
                this.pnC = oVar2;
                o oVar3 = this.pnC;
                o oVar4 = this.pnC;
                o oVar5 = this.pnC;
                oVar4.pnP = oVar5;
                oVar3.pnO = oVar5;
            } else {
                this.pnC.pnP.a(oVar2).c();
            }
            cVar.f5842b -= j2;
            this.f5842b += j2;
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
        if (this.f5842b == 0) {
            return -1L;
        }
        if (j > this.f5842b) {
            j = this.f5842b;
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
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f5842b), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (j2 > this.f5842b) {
            j2 = this.f5842b;
        }
        if (j == j2 || (oVar = this.pnC) == null) {
            return -1L;
        }
        if (this.f5842b - j < j) {
            j3 = this.f5842b;
            oVar2 = oVar;
            while (j3 > j) {
                oVar2 = oVar2.pnP;
                j3 -= oVar2.c - oVar2.f5851b;
            }
        } else {
            j3 = 0;
            oVar2 = oVar;
            while (true) {
                long j4 = (oVar2.c - oVar2.f5851b) + j3;
                if (j4 >= j) {
                    break;
                }
                oVar2 = oVar2.pnO;
                j3 = j4;
            }
        }
        long j5 = j3;
        while (j5 < j2) {
            byte[] bArr = oVar2.f5850a;
            int min = (int) Math.min(oVar2.c, (oVar2.f5851b + j2) - j5);
            for (int i = (int) ((oVar2.f5851b + j) - j5); i < min; i++) {
                if (bArr[i] == b2) {
                    return (i - oVar2.f5851b) + j5;
                }
            }
            long j6 = (oVar2.c - oVar2.f5851b) + j5;
            oVar2 = oVar2.pnO;
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
        if (j < 0 || i < 0 || i2 < 0 || this.f5842b - j < i2 || fVar.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (ih(i3 + j) != fVar.a(i + i3)) {
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
    public t eoq() {
        return t.pnQ;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f5842b != cVar.f5842b) {
                return false;
            }
            if (this.f5842b == 0) {
                return true;
            }
            o oVar = this.pnC;
            o oVar2 = cVar.pnC;
            int i = oVar.f5851b;
            int i2 = oVar2.f5851b;
            while (j < this.f5842b) {
                long min = Math.min(oVar.c - i, oVar2.c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (oVar.f5850a[i] != oVar2.f5850a[i2]) {
                        return false;
                    }
                    i3++;
                    i2 = i5;
                    i = i4;
                }
                if (i == oVar.c) {
                    oVar = oVar.pnO;
                    i = oVar.f5851b;
                }
                if (i2 == oVar2.c) {
                    oVar2 = oVar2.pnO;
                    i2 = oVar2.f5851b;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        o oVar = this.pnC;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.c;
            for (int i3 = oVar.f5851b; i3 < i2; i3++) {
                i = (i * 31) + oVar.f5850a[i3];
            }
            oVar = oVar.pnO;
        } while (oVar != this.pnC);
        return i;
    }

    public String toString() {
        return eoz().toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eoy */
    public c clone() {
        c cVar = new c();
        if (this.f5842b == 0) {
            return cVar;
        }
        cVar.pnC = this.pnC.eoG();
        o oVar = cVar.pnC;
        o oVar2 = cVar.pnC;
        o oVar3 = cVar.pnC;
        oVar2.pnP = oVar3;
        oVar.pnO = oVar3;
        for (o oVar4 = this.pnC.pnO; oVar4 != this.pnC; oVar4 = oVar4.pnO) {
            cVar.pnC.pnP.a(oVar4.eoG());
        }
        cVar.f5842b = this.f5842b;
        return cVar;
    }

    public final f eoz() {
        if (this.f5842b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f5842b);
        }
        return Ox((int) this.f5842b);
    }

    public final f Ox(int i) {
        return i == 0 ? f.f5844b : new q(this, i);
    }
}
