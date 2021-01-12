package com.bytedance.sdk.openadsdk.d.d;

import com.baidu.android.imsdk.internal.Constants;
import com.bytedance.sdk.openadsdk.d.b.a.e;
import com.bytedance.sdk.openadsdk.d.b.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final Reader f6983b;
    private long i;
    private int j;
    private String k;
    private int m;
    private String[] n;
    private int[] o;
    private boolean c = false;
    private final char[] d = new char[1024];
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;

    /* renamed from: a  reason: collision with root package name */
    int f6982a = 0;
    private int[] l = new int[32];

    public a(Reader reader) {
        this.m = 0;
        int[] iArr = this.l;
        int i = this.m;
        this.m = i + 1;
        iArr[i] = 6;
        this.n = new String[32];
        this.o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f6983b = reader;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final boolean q() {
        return this.c;
    }

    public void a() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 3) {
            a(1);
            this.o[this.m - 1] = 0;
            this.f6982a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + s());
    }

    public void b() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 4) {
            this.m--;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f6982a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + s());
    }

    public void c() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 1) {
            a(3);
            this.f6982a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + s());
    }

    public void d() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 2) {
            this.m--;
            this.n[this.m] = null;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f6982a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + s());
    }

    public boolean e() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public b f() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        switch (i) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    int r() throws IOException {
        int i = this.l[this.m - 1];
        if (i == 1) {
            this.l[this.m - 1] = 2;
        } else if (i == 2) {
            switch (b(true)) {
                case 44:
                    break;
                case 59:
                    w();
                    break;
                case 93:
                    this.f6982a = 4;
                    return 4;
                default:
                    throw b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.l[this.m - 1] = 4;
            if (i == 5) {
                switch (b(true)) {
                    case 44:
                        break;
                    case 59:
                        w();
                        break;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.f6982a = 2;
                        return 2;
                    default:
                        throw b("Unterminated object");
                }
            }
            int b2 = b(true);
            switch (b2) {
                case 34:
                    this.f6982a = 13;
                    return 13;
                case 39:
                    w();
                    this.f6982a = 12;
                    return 12;
                case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                    if (i != 5) {
                        this.f6982a = 2;
                        return 2;
                    }
                    throw b("Expected name");
                default:
                    w();
                    this.e--;
                    if (a((char) b2)) {
                        this.f6982a = 14;
                        return 14;
                    }
                    throw b("Expected name");
            }
        } else if (i == 4) {
            this.l[this.m - 1] = 5;
            switch (b(true)) {
                case 58:
                    break;
                case 59:
                case 60:
                default:
                    throw b("Expected ':'");
                case 61:
                    w();
                    if ((this.e < this.f || b(1)) && this.d[this.e] == '>') {
                        this.e++;
                        break;
                    }
                    break;
            }
        } else if (i == 6) {
            if (this.c) {
                z();
            }
            this.l[this.m - 1] = 7;
        } else if (i == 7) {
            if (b(false) == -1) {
                this.f6982a = 17;
                return 17;
            }
            w();
            this.e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (b(true)) {
            case 34:
                this.f6982a = 9;
                return 9;
            case 39:
                w();
                this.f6982a = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.f6982a = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f6982a = 4;
                    return 4;
                }
                break;
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                this.f6982a = 1;
                return 1;
            default:
                this.e--;
                int o = o();
                if (o == 0) {
                    int t = t();
                    if (t == 0) {
                        if (!a(this.d[this.e])) {
                            throw b("Expected value");
                        }
                        w();
                        this.f6982a = 10;
                        return 10;
                    }
                    return t;
                }
                return o;
        }
        if (i == 1 || i == 2) {
            w();
            this.e--;
            this.f6982a = 7;
            return 7;
        }
        throw b("Unexpected value");
    }

    private int o() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.d[this.e];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.e + i2 >= this.f && !b(i2 + 1)) {
                return 0;
            }
            char c2 = this.d[this.e + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.e + length < this.f || b(length + 1)) && a(this.d[this.e + length])) {
            return 0;
        }
        this.e += length;
        this.f6982a = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r3 != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r4 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r6 != Long.MIN_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
        if (r5 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r6 != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r5 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r5 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
        r14.i = r6;
        r14.e += r10;
        r14.f6982a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
        if (a(r2) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cd, code lost:
        r6 = -r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00d1, code lost:
        if (r3 == 2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00d4, code lost:
        if (r3 == 4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00d7, code lost:
        if (r3 != 7) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d9, code lost:
        r14.j = r10;
        r14.f6982a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e1, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int t() throws IOException {
        char c;
        char[] cArr = this.d;
        int i = this.e;
        int i2 = this.f;
        long j = 0;
        boolean z = false;
        boolean z2 = true;
        char c2 = 0;
        int i3 = 0;
        while (true) {
            if (i + i3 == i2) {
                if (i3 == cArr.length) {
                    return 0;
                }
                if (b(i3 + 1)) {
                    i = this.e;
                    i2 = this.f;
                }
            }
            char c3 = cArr[i + i3];
            switch (c3) {
                case '+':
                    if (c2 == 5) {
                        c = 6;
                        break;
                    } else {
                        return 0;
                    }
                case '-':
                    if (c2 == 0) {
                        c = 1;
                        z = true;
                        break;
                    } else if (c2 == 5) {
                        c = 6;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (c2 == 2) {
                        c = 3;
                        break;
                    } else {
                        return 0;
                    }
                case 'E':
                case 'e':
                    if (c2 == 2 || c2 == 4) {
                        c = 5;
                        break;
                    } else {
                        return 0;
                    }
                default:
                    if (c3 >= '0' && c3 <= '9') {
                        if (c2 == 1 || c2 == 0) {
                            j = -(c3 - '0');
                            c = 2;
                            break;
                        } else if (c2 == 2) {
                            if (j == 0) {
                                return 0;
                            }
                            long j2 = (10 * j) - (c3 - '0');
                            z2 &= j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                            c = c2;
                            j = j2;
                            break;
                        } else if (c2 == 3) {
                            c = 4;
                            break;
                        } else if (c2 != 5 && c2 != 6) {
                            c = c2;
                            break;
                        } else {
                            c = 7;
                            break;
                        }
                    }
                    break;
            }
            i3++;
            c2 = c;
        }
    }

    private boolean a(char c) throws IOException {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
            case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                break;
            default:
                return true;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                w();
                break;
        }
        return false;
    }

    public String g() throws IOException {
        String b2;
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 14) {
            b2 = u();
        } else if (i == 12) {
            b2 = b('\'');
        } else if (i == 13) {
            b2 = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + s());
        }
        this.f6982a = 0;
        this.n[this.m - 1] = b2;
        return b2;
    }

    public String h() throws IOException {
        String str;
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 10) {
            str = u();
        } else if (i == 8) {
            str = b('\'');
        } else if (i == 9) {
            str = b('\"');
        } else if (i == 11) {
            str = this.k;
            this.k = null;
        } else if (i == 15) {
            str = Long.toString(this.i);
        } else if (i == 16) {
            str = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + s());
        }
        this.f6982a = 0;
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 5) {
            this.f6982a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f6982a = 0;
            int[] iArr2 = this.o;
            int i3 = this.m - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + s());
        }
    }

    public void j() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 7) {
            this.f6982a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + s());
    }

    public double k() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 15) {
            this.f6982a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i == 8 || i == 9) {
            this.k = b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.k = u();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + s());
        }
        this.f6982a = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (!this.c && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + s());
        }
        this.k = null;
        this.f6982a = 0;
        int[] iArr2 = this.o;
        int i3 = this.m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long l() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 15) {
            this.f6982a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.k = u();
            } else {
                this.k = b(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.f6982a = 0;
                int[] iArr2 = this.o;
                int i3 = this.m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + s());
        }
        this.f6982a = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.k + s());
        }
        this.k = null;
        this.f6982a = 0;
        int[] iArr3 = this.o;
        int i4 = this.m - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String b(char c) throws IOException {
        int i;
        char[] cArr = this.d;
        StringBuilder sb = null;
        do {
            int i2 = this.e;
            int i3 = this.f;
            int i4 = i2;
            int i5 = i2;
            while (i5 < i3) {
                int i6 = i5 + 1;
                char c2 = cArr[i5];
                if (c2 == c) {
                    this.e = i6;
                    int i7 = (i6 - i4) - 1;
                    if (sb == null) {
                        return new String(cArr, i4, i7);
                    }
                    sb.append(cArr, i4, i7);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.e = i6;
                    int i8 = (i6 - i4) - 1;
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                    }
                    sb.append(cArr, i4, i8);
                    sb.append(y());
                    int i9 = this.e;
                    i = this.f;
                    i4 = i9;
                    i6 = i9;
                } else {
                    if (c2 == '\n') {
                        this.g++;
                        this.h = i6;
                    }
                    i = i3;
                }
                i3 = i;
                i5 = i6;
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i5 - i4) * 2, 16));
            }
            sb.append(cArr, i4, i5 - i4);
            this.e = i5;
        } while (b(1));
        throw b("Unterminated string");
    }

    private String u() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.e + i < this.f) {
                switch (this.d[this.e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        w();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.d.length) {
                if (b(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i, 16));
                }
                sb.append(this.d, this.e, i);
                this.e = i + this.e;
                if (b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        String str = sb == null ? new String(this.d, this.e, i) : sb.append(this.d, this.e, i).toString();
        this.e = i + this.e;
        return str;
    }

    private void c(char c) throws IOException {
        char[] cArr = this.d;
        do {
            int i = this.e;
            int i2 = this.f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.e = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.e = i4;
                    y();
                    i4 = this.e;
                    i2 = this.f;
                } else if (c2 == '\n') {
                    this.g++;
                    this.h = i4;
                }
                i3 = i4;
            }
            this.e = i3;
        } while (b(1));
        throw b("Unterminated string");
    }

    private void v() throws IOException {
        do {
            int i = 0;
            while (this.e + i < this.f) {
                switch (this.d[this.e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        this.e = i + this.e;
                        return;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        w();
                        this.e = i + this.e;
                        return;
                    default:
                        i++;
                }
            }
            this.e = i + this.e;
        } while (b(1));
    }

    public int m() throws IOException {
        int i = this.f6982a;
        if (i == 0) {
            i = r();
        }
        if (i == 15) {
            int i2 = (int) this.i;
            if (this.i != i2) {
                throw new NumberFormatException("Expected an int but was " + this.i + s());
            }
            this.f6982a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.k = u();
            } else {
                this.k = b(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.f6982a = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + s());
        }
        this.f6982a = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.k + s());
        }
        this.k = null;
        this.f6982a = 0;
        int[] iArr3 = this.o;
        int i6 = this.m - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6982a = 0;
        this.l[0] = 8;
        this.m = 1;
        this.f6983b.close();
    }

    public void n() throws IOException {
        int i = 0;
        do {
            int i2 = this.f6982a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 3) {
                a(1);
                i++;
            } else if (i2 == 1) {
                a(3);
                i++;
            } else if (i2 == 4) {
                this.m--;
                i--;
            } else if (i2 == 2) {
                this.m--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                v();
            } else if (i2 == 8 || i2 == 12) {
                c('\'');
            } else if (i2 == 9 || i2 == 13) {
                c('\"');
            } else if (i2 == 16) {
                this.e += this.j;
            }
            this.f6982a = 0;
        } while (i != 0);
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
        this.n[this.m - 1] = "null";
    }

    private void a(int i) {
        if (this.m == this.l.length) {
            int i2 = this.m * 2;
            this.l = Arrays.copyOf(this.l, i2);
            this.o = Arrays.copyOf(this.o, i2);
            this.n = (String[]) Arrays.copyOf(this.n, i2);
        }
        int[] iArr = this.l;
        int i3 = this.m;
        this.m = i3 + 1;
        iArr[i3] = i;
    }

    private boolean b(int i) throws IOException {
        char[] cArr = this.d;
        this.h -= this.e;
        if (this.f != this.e) {
            this.f -= this.e;
            System.arraycopy(cArr, this.e, cArr, 0, this.f);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            int read = this.f6983b.read(cArr, this.f, cArr.length - this.f);
            if (read == -1) {
                return false;
            }
            this.f = read + this.f;
            if (this.g == 0 && this.h == 0 && this.f > 0 && cArr[0] == 65279) {
                this.e++;
                this.h++;
                i++;
            }
        } while (this.f < i);
        return true;
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.d;
        int i = this.e;
        int i2 = this.f;
        while (true) {
            if (i == i2) {
                this.e = i;
                if (b(1)) {
                    i = this.e;
                    i2 = this.f;
                } else if (z) {
                    throw new EOFException("End of input" + s());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.g++;
                this.h = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.e = i3;
                if (i3 == i2) {
                    this.e--;
                    boolean b2 = b(2);
                    this.e++;
                    if (!b2) {
                        return c;
                    }
                }
                w();
                switch (cArr[this.e]) {
                    case '*':
                        this.e++;
                        if (!a("*/")) {
                            throw b("Unterminated comment");
                        }
                        i = this.e + 2;
                        i2 = this.f;
                        continue;
                    case '/':
                        this.e++;
                        x();
                        i = this.e;
                        i2 = this.f;
                        continue;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.e = i3;
                w();
                x();
                i = this.e;
                i2 = this.f;
            } else {
                this.e = i3;
                return c;
            }
        }
    }

    private void w() throws IOException {
        if (!this.c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() throws IOException {
        char c;
        do {
            if (this.e < this.f || b(1)) {
                char[] cArr = this.d;
                int i = this.e;
                this.e = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.g++;
                    this.h = this.e;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean a(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.e + length > this.f && !b(length)) {
                return false;
            }
            if (this.d[this.e] == '\n') {
                this.g++;
                this.h = this.e + 1;
            } else {
                for (i = 0; i < length; i = i + 1) {
                    i = this.d[this.e + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.e++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + s();
    }

    String s() {
        return " at line " + (this.g + 1) + " column " + ((this.e - this.h) + 1) + " path " + p();
    }

    public String p() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.m;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.l[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.o[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.n[i2] != null) {
                        append.append(this.n[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return append.toString();
    }

    private char y() throws IOException {
        int i;
        if (this.e == this.f && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.g++;
                this.h = this.e;
                return c;
            case '\"':
            case '\'':
            case '/':
            case '\\':
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.e + 4 > this.f && !b(4)) {
                    throw b("Unterminated escape sequence");
                }
                char c2 = 0;
                int i3 = this.e;
                int i4 = i3 + 4;
                while (i3 < i4) {
                    char c3 = this.d[i3];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.d, this.e, 4));
                    }
                    c2 = (char) (c4 + i);
                    i3++;
                }
                this.e += 4;
                return c2;
            default:
                throw b("Invalid escape sequence");
        }
    }

    private IOException b(String str) throws IOException {
        throw new d(str + s());
    }

    private void z() throws IOException {
        b(true);
        this.e--;
        int i = this.e;
        if (i + 5 <= this.f || b(5)) {
            char[] cArr = this.d;
            if (cArr[i] == ')' && cArr[i + 1] == ']' && cArr[i + 2] == '}' && cArr[i + 3] == '\'' && cArr[i + 4] == '\n') {
                this.e += 5;
            }
        }
    }

    static {
        f.f6958a = new f() { // from class: com.bytedance.sdk.openadsdk.d.d.a.1
            @Override // com.bytedance.sdk.openadsdk.d.b.f
            public void a(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).o();
                    return;
                }
                int i = aVar.f6982a;
                if (i == 0) {
                    i = aVar.r();
                }
                if (i == 13) {
                    aVar.f6982a = 9;
                } else if (i == 12) {
                    aVar.f6982a = 8;
                } else if (i == 14) {
                    aVar.f6982a = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.s());
                }
            }
        };
    }
}
