package com.bytedance.sdk.openadsdk.api.a;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes7.dex */
public final class b {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f51809b;

    /* renamed from: c  reason: collision with root package name */
    public int f51810c;

    /* renamed from: d  reason: collision with root package name */
    public int f51811d;

    /* renamed from: e  reason: collision with root package name */
    public int f51812e;

    /* renamed from: f  reason: collision with root package name */
    public int f51813f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f51814g;

    public b(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.f51809b = name.length();
    }

    private String a() {
        while (true) {
            int i2 = this.f51810c;
            if (i2 >= this.f51809b || this.f51814g[i2] != ' ') {
                break;
            }
            this.f51810c = i2 + 1;
        }
        int i3 = this.f51810c;
        if (i3 == this.f51809b) {
            return null;
        }
        this.f51811d = i3;
        this.f51810c = i3 + 1;
        while (true) {
            int i4 = this.f51810c;
            if (i4 >= this.f51809b) {
                break;
            }
            char[] cArr = this.f51814g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f51810c = i4 + 1;
        }
        int i5 = this.f51810c;
        if (i5 < this.f51809b) {
            this.f51812e = i5;
            if (this.f51814g[i5] == ' ') {
                while (true) {
                    int i6 = this.f51810c;
                    if (i6 >= this.f51809b) {
                        break;
                    }
                    char[] cArr2 = this.f51814g;
                    if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                        break;
                    }
                    this.f51810c = i6 + 1;
                }
                char[] cArr3 = this.f51814g;
                int i7 = this.f51810c;
                if (cArr3[i7] != '=' || i7 == this.f51809b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.a);
                }
            }
            this.f51810c++;
            while (true) {
                int i8 = this.f51810c;
                if (i8 >= this.f51809b || this.f51814g[i8] != ' ') {
                    break;
                }
                this.f51810c = i8 + 1;
            }
            int i9 = this.f51812e;
            int i10 = this.f51811d;
            if (i9 - i10 > 4) {
                char[] cArr4 = this.f51814g;
                if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                    char[] cArr5 = this.f51814g;
                    int i11 = this.f51811d;
                    if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                        char[] cArr6 = this.f51814g;
                        int i12 = this.f51811d;
                        if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                            this.f51811d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f51814g;
            int i13 = this.f51811d;
            return new String(cArr7, i13, this.f51812e - i13);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private String b() {
        int i2 = this.f51810c + 1;
        this.f51810c = i2;
        this.f51811d = i2;
        this.f51812e = i2;
        while (true) {
            int i3 = this.f51810c;
            if (i3 != this.f51809b) {
                char[] cArr = this.f51814g;
                if (cArr[i3] == '\"') {
                    this.f51810c = i3 + 1;
                    while (true) {
                        int i4 = this.f51810c;
                        if (i4 >= this.f51809b || this.f51814g[i4] != ' ') {
                            break;
                        }
                        this.f51810c = i4 + 1;
                    }
                    char[] cArr2 = this.f51814g;
                    int i5 = this.f51811d;
                    return new String(cArr2, i5, this.f51812e - i5);
                }
                if (cArr[i3] == '\\') {
                    cArr[this.f51812e] = e();
                } else {
                    cArr[this.f51812e] = cArr[i3];
                }
                this.f51810c++;
                this.f51812e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
    }

    private String c() {
        int i2 = this.f51810c;
        if (i2 + 4 < this.f51809b) {
            this.f51811d = i2;
            this.f51810c = i2 + 1;
            while (true) {
                int i3 = this.f51810c;
                if (i3 == this.f51809b) {
                    break;
                }
                char[] cArr = this.f51814g;
                if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                    break;
                } else if (cArr[i3] == ' ') {
                    this.f51812e = i3;
                    this.f51810c = i3 + 1;
                    while (true) {
                        int i4 = this.f51810c;
                        if (i4 >= this.f51809b || this.f51814g[i4] != ' ') {
                            break;
                        }
                        this.f51810c = i4 + 1;
                    }
                } else {
                    if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                        cArr[i3] = (char) (cArr[i3] + WebvttCueParser.CHAR_SPACE);
                    }
                    this.f51810c++;
                }
            }
            this.f51812e = this.f51810c;
            int i5 = this.f51812e;
            int i6 = this.f51811d;
            int i7 = i5 - i6;
            if (i7 >= 5 && (i7 & 1) != 0) {
                int i8 = i7 / 2;
                byte[] bArr = new byte[i8];
                int i9 = i6 + 1;
                for (int i10 = 0; i10 < i8; i10++) {
                    bArr[i10] = (byte) a(i9);
                    i9 += 2;
                }
                return new String(this.f51814g, this.f51811d, i7);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f51813f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String d() {
        int i2 = this.f51810c;
        this.f51811d = i2;
        this.f51812e = i2;
        while (true) {
            int i3 = this.f51810c;
            if (i3 >= this.f51809b) {
                char[] cArr = this.f51814g;
                int i4 = this.f51811d;
                return new String(cArr, i4, this.f51812e - i4);
            }
            char[] cArr2 = this.f51814g;
            char c2 = cArr2[i3];
            if (c2 == ' ') {
                int i5 = this.f51812e;
                this.f51813f = i5;
                this.f51810c = i3 + 1;
                this.f51812e = i5 + 1;
                cArr2[i5] = WebvttCueParser.CHAR_SPACE;
                while (true) {
                    int i6 = this.f51810c;
                    if (i6 >= this.f51809b) {
                        break;
                    }
                    char[] cArr3 = this.f51814g;
                    if (cArr3[i6] != ' ') {
                        break;
                    }
                    int i7 = this.f51812e;
                    this.f51812e = i7 + 1;
                    cArr3[i7] = WebvttCueParser.CHAR_SPACE;
                    this.f51810c = i6 + 1;
                }
                int i8 = this.f51810c;
                if (i8 == this.f51809b) {
                    break;
                }
                char[] cArr4 = this.f51814g;
                if (cArr4[i8] == ',' || cArr4[i8] == '+' || cArr4[i8] == ';') {
                    break;
                }
            } else if (c2 == ';') {
                break;
            } else if (c2 == '\\') {
                int i9 = this.f51812e;
                this.f51812e = i9 + 1;
                cArr2[i9] = e();
                this.f51810c++;
            } else if (c2 == '+' || c2 == ',') {
                break;
            } else {
                int i10 = this.f51812e;
                this.f51812e = i10 + 1;
                cArr2[i10] = cArr2[i3];
                this.f51810c = i3 + 1;
            }
        }
        char[] cArr5 = this.f51814g;
        int i11 = this.f51811d;
        return new String(cArr5, i11, this.f51812e - i11);
    }

    private char e() {
        int i2 = this.f51810c + 1;
        this.f51810c = i2;
        if (i2 != this.f51809b) {
            char c2 = this.f51814g[i2];
            if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return f();
                        }
                }
            }
            return this.f51814g[this.f51810c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private char f() {
        int i2;
        int i3;
        int a = a(this.f51810c);
        this.f51810c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i3 = a & 31;
            i2 = 1;
        } else if (a <= 239) {
            i2 = 2;
            i3 = a & 15;
        } else {
            i2 = 3;
            i3 = a & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f51810c + 1;
            this.f51810c = i5;
            if (i5 == this.f51809b || this.f51814g[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.f51810c = i6;
            int a2 = a(i6);
            this.f51810c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (a2 & 63);
        }
        return (char) i3;
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f51809b) {
            char c2 = this.f51814g[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i3 = c2 - '7';
            }
            char c3 = this.f51814g[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    public String a(String str) {
        String b2;
        this.f51810c = 0;
        this.f51811d = 0;
        this.f51812e = 0;
        this.f51813f = 0;
        this.f51814g = this.a.toCharArray();
        String a = a();
        if (a == null) {
            return null;
        }
        do {
            int i2 = this.f51810c;
            if (i2 == this.f51809b) {
                return null;
            }
            char c2 = this.f51814g[i2];
            if (c2 == '\"') {
                b2 = b();
            } else if (c2 != '#') {
                b2 = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : d();
            } else {
                b2 = c();
            }
            if (str.equalsIgnoreCase(a)) {
                return b2;
            }
            int i3 = this.f51810c;
            if (i3 >= this.f51809b) {
                return null;
            }
            char[] cArr = this.f51814g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.f51810c++;
            a = a();
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
