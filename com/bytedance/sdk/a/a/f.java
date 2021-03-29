package com.bytedance.sdk.a.a;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.c.c.a.a.b;
import d.c.c.a.a.c;
import d.c.c.a.a.s;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f27161a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final f f27162b = a(new byte[0]);

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f27163c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f27164d;

    /* renamed from: e  reason: collision with root package name */
    public transient String f27165e;

    public f(byte[] bArr) {
        this.f27163c = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String b() {
        return b.a(this.f27163c);
    }

    public f c() {
        return c("SHA-1");
    }

    public f d() {
        return c("SHA-256");
    }

    public String e() {
        byte[] bArr = this.f27163c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f27161a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int g2 = fVar.g();
            byte[] bArr = this.f27163c;
            if (g2 == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public f f() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f27163c;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
            i++;
        }
    }

    public int g() {
        return this.f27163c.length;
    }

    public byte[] h() {
        return (byte[]) this.f27163c.clone();
    }

    public int hashCode() {
        int i = this.f27164d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f27163c);
        this.f27164d = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f27163c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 == -1) {
            if (this.f27163c.length <= 64) {
                return "[hex=" + e() + "]";
            }
            return "[size=" + this.f27163c.length + " hex=" + a(0, 64).e() + "…]";
        }
        String replace = a2.substring(0, a3).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a3 < a2.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f27163c.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }

    public static f b(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
                }
                return a(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    private f c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f27163c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static f a(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(s.f65168a));
            fVar.f27165e = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String a() {
        String str = this.f27165e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f27163c, s.f65168a);
        this.f27165e = str2;
        return str2;
    }

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c2);
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public f a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f27163c;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f27163c.length + SmallTailInfo.EMOTION_SUFFIX);
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(this.f27163c, i, bArr2, 0, i3);
                return new f(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(f fVar) {
        int g2 = g();
        int g3 = fVar.g();
        int min = Math.min(g2, g3);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = fVar.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (g2 == g3) {
            return 0;
        }
        return g2 < g3 ? -1 : 1;
    }

    public byte a(int i) {
        return this.f27163c[i];
    }

    public void a(c cVar) {
        byte[] bArr = this.f27163c;
        cVar.y(bArr, 0, bArr.length);
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        return fVar.a(i2, this.f27163c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f27163c;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && s.e(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(f fVar) {
        return a(0, fVar, 0, fVar.g());
    }

    public static int a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
