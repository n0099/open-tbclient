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
    long b;
    o pqm;

    public final long b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c eoG() {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: eoH */
    public c eoP() {
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() {
        return this.b == 0;
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream eoI() {
        return new InputStream() { // from class: com.bytedance.sdk.a.a.c.1
            @Override // java.io.InputStream
            public int read() {
                if (c.this.b > 0) {
                    return c.this.eoJ() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.b, 2147483647L);
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
        u.a(this.b, j, j2);
        if (j2 != 0) {
            cVar.b += j2;
            o oVar = this.pqm;
            while (j >= oVar.c - oVar.b) {
                j -= oVar.c - oVar.b;
                oVar = oVar.pqy;
            }
            while (j2 > 0) {
                o eoV = oVar.eoV();
                eoV.b = (int) (eoV.b + j);
                eoV.c = Math.min(eoV.b + ((int) j2), eoV.c);
                if (cVar.pqm == null) {
                    eoV.pqz = eoV;
                    eoV.pqy = eoV;
                    cVar.pqm = eoV;
                } else {
                    cVar.pqm.pqz.a(eoV);
                }
                j2 -= eoV.c - eoV.b;
                oVar = oVar.pqy;
                j = 0;
            }
        }
        return this;
    }

    public final long g() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.pqm.pqz;
        if (oVar.c < 8192 && oVar.e) {
            return j - (oVar.c - oVar.b);
        }
        return j;
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte eoJ() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.pqm;
        int i = oVar.b;
        int i2 = oVar.c;
        int i3 = i + 1;
        byte b = oVar.f3942a[i];
        this.b--;
        if (i3 == i2) {
            this.pqm = oVar.eoW();
            p.b(oVar);
        } else {
            oVar.b = i3;
        }
        return b;
    }

    public final byte ih(long j) {
        u.a(this.b, j, 1L);
        if (this.b - j > j) {
            o oVar = this.pqm;
            while (true) {
                int i = oVar.c - oVar.b;
                if (j < i) {
                    return oVar.f3942a[oVar.b + ((int) j)];
                }
                j -= i;
                oVar = oVar.pqy;
            }
        } else {
            long j2 = j - this.b;
            o oVar2 = this.pqm.pqz;
            while (true) {
                j2 += oVar2.c - oVar2.b;
                if (j2 >= 0) {
                    return oVar2.f3942a[oVar2.b + ((int) j2)];
                }
                oVar2 = oVar2.pqz;
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public short eoK() {
        if (this.b < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        o oVar = this.pqm;
        int i = oVar.b;
        int i2 = oVar.c;
        if (i2 - i < 2) {
            return (short) (((eoJ() & 255) << 8) | (eoJ() & 255));
        }
        byte[] bArr = oVar.f3942a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b -= 2;
        if (i4 == i2) {
            this.pqm = oVar.eoW();
            p.b(oVar);
        } else {
            oVar.b = i4;
        }
        return (short) i5;
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        o oVar = this.pqm;
        int i = oVar.b;
        int i2 = oVar.c;
        if (i2 - i < 4) {
            return ((eoJ() & 255) << 24) | ((eoJ() & 255) << 16) | ((eoJ() & 255) << 8) | (eoJ() & 255);
        }
        byte[] bArr = oVar.f3942a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.b -= 4;
        if (i8 == i2) {
            this.pqm = oVar.eoW();
            p.b(oVar);
            return i9;
        }
        oVar.b = i8;
        return i9;
    }

    @Override // com.bytedance.sdk.a.a.e
    public short eoL() {
        return u.l(eoK());
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() {
        return u.a(j());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
        r14.b -= r1;
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
        if (this.b != 0) {
            boolean z = false;
            int i2 = 0;
            long j = 0;
            while (true) {
                o oVar = this.pqm;
                byte[] bArr = oVar.f3942a;
                int i3 = oVar.c;
                int i4 = i2;
                for (int i5 = oVar.b; i5 < i3; i5++) {
                    byte b = bArr[i5];
                    if (b >= 48 && b <= 57) {
                        i = b - 48;
                    } else if (b >= 97 && b <= 102) {
                        i = (b - 97) + 10;
                    } else if (b >= 65 && b <= 70) {
                        i = (b - 65) + 10;
                    } else if (i4 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    } else {
                        z = true;
                        if (i5 != i3) {
                            this.pqm = oVar.eoW();
                            p.b(oVar);
                        } else {
                            oVar.b = i5;
                        }
                        if (!!z || this.pqm == null) {
                            break;
                        }
                        i2 = i4;
                    }
                    if (((-1152921504606846976L) & j) != 0) {
                        throw new NumberFormatException("Number too large: " + new c().in(j).OF(b).o());
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

    public f eoM() {
        return new f(q());
    }

    @Override // com.bytedance.sdk.a.a.e
    public f ii(long j) throws EOFException {
        return new f(ik(j));
    }

    public String o() {
        try {
            return a(this.b, u.f3944a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j) throws EOFException {
        return a(j, u.f3944a);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String b(Charset charset) {
        try {
            return a(this.b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        o oVar = this.pqm;
        if (oVar.b + j > oVar.c) {
            return new String(ik(j), charset);
        }
        String str = new String(oVar.f3942a, oVar.b, (int) j, charset);
        oVar.b = (int) (oVar.b + j);
        this.b -= j;
        if (oVar.b == oVar.c) {
            this.pqm = oVar.eoW();
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
        throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + cVar.eoM().e() + (char) 8230);
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
            return ik(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] ik(long j) throws EOFException {
        u.a(this.b, 0L, j);
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
        o oVar = this.pqm;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.c - oVar.b);
        System.arraycopy(oVar.f3942a, oVar.b, bArr, i, min);
        oVar.b += min;
        this.b -= min;
        if (oVar.b == oVar.c) {
            this.pqm = oVar.eoW();
            p.b(oVar);
            return min;
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.pqm;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.c - oVar.b);
        byteBuffer.put(oVar.f3942a, oVar.b, min);
        oVar.b += min;
        this.b -= min;
        if (oVar.b == oVar.c) {
            this.pqm = oVar.eoW();
            p.b(oVar);
            return min;
        }
        return min;
    }

    public final void r() {
        try {
            h(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j) throws EOFException {
        while (j > 0) {
            if (this.pqm == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.pqm.c - this.pqm.b);
            this.b -= min;
            j -= min;
            o oVar = this.pqm;
            oVar.b = min + oVar.b;
            if (this.pqm.b == this.pqm.c) {
                o oVar2 = this.pqm;
                this.pqm = oVar2.eoW();
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
    /* renamed from: YS */
    public c YT(String str) {
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
                o OB = OB(1);
                byte[] bArr = OB.f3942a;
                int i4 = OB.c - i;
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
                int i5 = (i3 + i4) - OB.c;
                OB.c += i5;
                this.b += i5;
            } else if (charAt < 2048) {
                OF((charAt >> 6) | 192);
                OF((charAt & '?') | 128);
                i3 = i + 1;
            } else if (charAt < 55296 || charAt > 57343) {
                OF((charAt >> '\f') | 224);
                OF(((charAt >> 6) & 63) | 128);
                OF((charAt & '?') | 128);
                i3 = i + 1;
            } else {
                char charAt3 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                    OF(63);
                    i++;
                } else {
                    int i6 = ((charAt3 & 9215) | ((charAt & 10239) << 10)) + 65536;
                    OF((i6 >> 18) | 240);
                    OF(((i6 >> 12) & 63) | 128);
                    OF(((i6 >> 6) & 63) | 128);
                    OF((i6 & 63) | 128);
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return this;
    }

    public c Ox(int i) {
        if (i < 128) {
            OF(i);
        } else if (i < 2048) {
            OF((i >> 6) | 192);
            OF((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                OF(63);
            } else {
                OF((i >> 12) | 224);
                OF(((i >> 6) & 63) | 128);
                OF((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            OF((i >> 18) | 240);
            OF(((i >> 12) & 63) | 128);
            OF(((i >> 6) & 63) | 128);
            OF((i & 63) | 128);
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
        if (charset.equals(u.f3944a)) {
            return B(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return w(bytes, 0, bytes.length);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: ai */
    public c aj(byte[] bArr) {
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
            o OB = OB(1);
            int min = Math.min(i3 - i, 8192 - OB.c);
            System.arraycopy(bArr, i, OB.f3942a, OB.c, min);
            i += min;
            OB.c = min + OB.c;
        }
        this.b += i2;
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
            o OB = OB(1);
            int min = Math.min(i, 8192 - OB.c);
            byteBuffer.get(OB.f3942a, OB.c, min);
            i -= min;
            OB.c = min + OB.c;
        }
        this.b += remaining;
        return remaining;
    }

    public long b(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = sVar.b(this, 8192L);
            if (b != -1) {
                j += b;
            } else {
                return j;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: Oy */
    public c OF(int i) {
        o OB = OB(1);
        byte[] bArr = OB.f3942a;
        int i2 = OB.c;
        OB.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: Oz */
    public c OE(int i) {
        o OB = OB(2);
        byte[] bArr = OB.f3942a;
        int i2 = OB.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        OB.c = i3 + 1;
        this.b += 2;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: OA */
    public c OD(int i) {
        o OB = OB(4);
        byte[] bArr = OB.f3942a;
        int i2 = OB.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        OB.c = i5 + 1;
        this.b += 4;
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
            return OF(48);
        }
        if (j >= 0) {
            z = false;
            j2 = j;
        } else {
            j2 = -j;
            if (j2 < 0) {
                return YT("-9223372036854775808");
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
        o OB = OB(i);
        byte[] bArr = OB.f3942a;
        int i2 = OB.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        OB.c += i;
        this.b = i + this.b;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: im */
    public c in(long j) {
        if (j == 0) {
            return OF(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o OB = OB(numberOfTrailingZeros);
        byte[] bArr = OB.f3942a;
        int i = OB.c;
        for (int i2 = (OB.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        OB.c += numberOfTrailingZeros;
        this.b = numberOfTrailingZeros + this.b;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o OB(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.pqm == null) {
            this.pqm = p.eoV();
            o oVar = this.pqm;
            o oVar2 = this.pqm;
            o oVar3 = this.pqm;
            oVar2.pqz = oVar3;
            oVar.pqy = oVar3;
            return oVar3;
        }
        o oVar4 = this.pqm.pqz;
        if (oVar4.c + i > 8192 || !oVar4.e) {
            return oVar4.a(p.eoV());
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
        u.a(cVar.b, 0L, j);
        while (j > 0) {
            if (j < cVar.pqm.c - cVar.pqm.b) {
                o oVar = this.pqm != null ? this.pqm.pqz : null;
                if (oVar != null && oVar.e) {
                    if ((oVar.c + j) - (oVar.d ? 0 : oVar.b) <= 8192) {
                        cVar.pqm.a(oVar, (int) j);
                        cVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                cVar.pqm = cVar.pqm.OG((int) j);
            }
            o oVar2 = cVar.pqm;
            long j2 = oVar2.c - oVar2.b;
            cVar.pqm = oVar2.eoW();
            if (this.pqm == null) {
                this.pqm = oVar2;
                o oVar3 = this.pqm;
                o oVar4 = this.pqm;
                o oVar5 = this.pqm;
                oVar4.pqz = oVar5;
                oVar3.pqy = oVar5;
            } else {
                this.pqm.pqz.a(oVar2).c();
            }
            cVar.b -= j2;
            this.b += j2;
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
        if (this.b == 0) {
            return -1L;
        }
        if (j > this.b) {
            j = this.b;
        }
        cVar.a(this, j);
        return j;
    }

    @Override // com.bytedance.sdk.a.a.e
    public long e(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j, long j2) {
        o oVar;
        long j3;
        o oVar2;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (j2 > this.b) {
            j2 = this.b;
        }
        if (j == j2 || (oVar = this.pqm) == null) {
            return -1L;
        }
        if (this.b - j < j) {
            j3 = this.b;
            oVar2 = oVar;
            while (j3 > j) {
                oVar2 = oVar2.pqz;
                j3 -= oVar2.c - oVar2.b;
            }
        } else {
            j3 = 0;
            oVar2 = oVar;
            while (true) {
                long j4 = (oVar2.c - oVar2.b) + j3;
                if (j4 >= j) {
                    break;
                }
                oVar2 = oVar2.pqy;
                j3 = j4;
            }
        }
        long j5 = j3;
        while (j5 < j2) {
            byte[] bArr = oVar2.f3942a;
            int min = (int) Math.min(oVar2.c, (oVar2.b + j2) - j5);
            for (int i = (int) ((oVar2.b + j) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - oVar2.b) + j5;
                }
            }
            long j6 = (oVar2.c - oVar2.b) + j5;
            oVar2 = oVar2.pqy;
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
        if (j < 0 || i < 0 || i2 < 0 || this.b - j < i2 || fVar.g() - i < i2) {
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
    public t eoF() {
        return t.pqA;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.b != cVar.b) {
                return false;
            }
            if (this.b == 0) {
                return true;
            }
            o oVar = this.pqm;
            o oVar2 = cVar.pqm;
            int i = oVar.b;
            int i2 = oVar2.b;
            while (j < this.b) {
                long min = Math.min(oVar.c - i, oVar2.c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (oVar.f3942a[i] != oVar2.f3942a[i2]) {
                        return false;
                    }
                    i3++;
                    i2 = i5;
                    i = i4;
                }
                if (i == oVar.c) {
                    oVar = oVar.pqy;
                    i = oVar.b;
                }
                if (i2 == oVar2.c) {
                    oVar2 = oVar2.pqy;
                    i2 = oVar2.b;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        o oVar = this.pqm;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.c;
            for (int i3 = oVar.b; i3 < i2; i3++) {
                i = (i * 31) + oVar.f3942a[i3];
            }
            oVar = oVar.pqy;
        } while (oVar != this.pqm);
        return i;
    }

    public String toString() {
        return eoO().toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eoN */
    public c clone() {
        c cVar = new c();
        if (this.b == 0) {
            return cVar;
        }
        cVar.pqm = this.pqm.eoV();
        o oVar = cVar.pqm;
        o oVar2 = cVar.pqm;
        o oVar3 = cVar.pqm;
        oVar2.pqz = oVar3;
        oVar.pqy = oVar3;
        for (o oVar4 = this.pqm.pqy; oVar4 != this.pqm; oVar4 = oVar4.pqy) {
            cVar.pqm.pqz.a(oVar4.eoV());
        }
        cVar.b = this.b;
        return cVar;
    }

    public final f eoO() {
        if (this.b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
        }
        return OC((int) this.b);
    }

    public final f OC(int i) {
        return i == 0 ? f.b : new q(this, i);
    }
}
