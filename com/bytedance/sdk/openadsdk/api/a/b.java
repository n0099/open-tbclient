package com.bytedance.sdk.openadsdk.api.a;

import javax.security.auth.x500.X500Principal;
/* loaded from: classes3.dex */
public final class b {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f53390b;

    /* renamed from: c  reason: collision with root package name */
    public int f53391c;

    /* renamed from: d  reason: collision with root package name */
    public int f53392d;

    /* renamed from: e  reason: collision with root package name */
    public int f53393e;

    /* renamed from: f  reason: collision with root package name */
    public int f53394f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f53395g;

    public b(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.f53390b = name.length();
    }

    private String a() {
        while (true) {
            int i2 = this.f53391c;
            if (i2 >= this.f53390b || this.f53395g[i2] != ' ') {
                break;
            }
            this.f53391c = i2 + 1;
        }
        int i3 = this.f53391c;
        if (i3 == this.f53390b) {
            return null;
        }
        this.f53392d = i3;
        this.f53391c = i3 + 1;
        while (true) {
            int i4 = this.f53391c;
            if (i4 >= this.f53390b) {
                break;
            }
            char[] cArr = this.f53395g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f53391c = i4 + 1;
        }
        int i5 = this.f53391c;
        if (i5 < this.f53390b) {
            this.f53393e = i5;
            if (this.f53395g[i5] == ' ') {
                while (true) {
                    int i6 = this.f53391c;
                    if (i6 >= this.f53390b) {
                        break;
                    }
                    char[] cArr2 = this.f53395g;
                    if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                        break;
                    }
                    this.f53391c = i6 + 1;
                }
                char[] cArr3 = this.f53395g;
                int i7 = this.f53391c;
                if (cArr3[i7] != '=' || i7 == this.f53390b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.a);
                }
            }
            this.f53391c++;
            while (true) {
                int i8 = this.f53391c;
                if (i8 >= this.f53390b || this.f53395g[i8] != ' ') {
                    break;
                }
                this.f53391c = i8 + 1;
            }
            int i9 = this.f53393e;
            int i10 = this.f53392d;
            if (i9 - i10 > 4) {
                char[] cArr4 = this.f53395g;
                if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                    char[] cArr5 = this.f53395g;
                    int i11 = this.f53392d;
                    if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                        char[] cArr6 = this.f53395g;
                        int i12 = this.f53392d;
                        if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                            this.f53392d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f53395g;
            int i13 = this.f53392d;
            return new String(cArr7, i13, this.f53393e - i13);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private String b() {
        int i2 = this.f53391c + 1;
        this.f53391c = i2;
        this.f53392d = i2;
        this.f53393e = i2;
        while (true) {
            int i3 = this.f53391c;
            if (i3 != this.f53390b) {
                char[] cArr = this.f53395g;
                if (cArr[i3] == '\"') {
                    this.f53391c = i3 + 1;
                    while (true) {
                        int i4 = this.f53391c;
                        if (i4 >= this.f53390b || this.f53395g[i4] != ' ') {
                            break;
                        }
                        this.f53391c = i4 + 1;
                    }
                    char[] cArr2 = this.f53395g;
                    int i5 = this.f53392d;
                    return new String(cArr2, i5, this.f53393e - i5);
                }
                if (cArr[i3] == '\\') {
                    cArr[this.f53393e] = e();
                } else {
                    cArr[this.f53393e] = cArr[i3];
                }
                this.f53391c++;
                this.f53393e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
    }

    private String c() {
        int i2 = this.f53391c;
        if (i2 + 4 < this.f53390b) {
            this.f53392d = i2;
            this.f53391c = i2 + 1;
            while (true) {
                int i3 = this.f53391c;
                if (i3 == this.f53390b) {
                    break;
                }
                char[] cArr = this.f53395g;
                if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                    break;
                } else if (cArr[i3] == ' ') {
                    this.f53393e = i3;
                    this.f53391c = i3 + 1;
                    while (true) {
                        int i4 = this.f53391c;
                        if (i4 >= this.f53390b || this.f53395g[i4] != ' ') {
                            break;
                        }
                        this.f53391c = i4 + 1;
                    }
                } else {
                    if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                        cArr[i3] = (char) (cArr[i3] + ' ');
                    }
                    this.f53391c++;
                }
            }
            this.f53393e = this.f53391c;
            int i5 = this.f53393e;
            int i6 = this.f53392d;
            int i7 = i5 - i6;
            if (i7 >= 5 && (i7 & 1) != 0) {
                int i8 = i7 / 2;
                byte[] bArr = new byte[i8];
                int i9 = i6 + 1;
                for (int i10 = 0; i10 < i8; i10++) {
                    bArr[i10] = (byte) a(i9);
                    i9 += 2;
                }
                return new String(this.f53395g, this.f53392d, i7);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f53394f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String d() {
        int i2 = this.f53391c;
        this.f53392d = i2;
        this.f53393e = i2;
        while (true) {
            int i3 = this.f53391c;
            if (i3 >= this.f53390b) {
                char[] cArr = this.f53395g;
                int i4 = this.f53392d;
                return new String(cArr, i4, this.f53393e - i4);
            }
            char[] cArr2 = this.f53395g;
            char c2 = cArr2[i3];
            if (c2 == ' ') {
                int i5 = this.f53393e;
                this.f53394f = i5;
                this.f53391c = i3 + 1;
                this.f53393e = i5 + 1;
                cArr2[i5] = ' ';
                while (true) {
                    int i6 = this.f53391c;
                    if (i6 >= this.f53390b) {
                        break;
                    }
                    char[] cArr3 = this.f53395g;
                    if (cArr3[i6] != ' ') {
                        break;
                    }
                    int i7 = this.f53393e;
                    this.f53393e = i7 + 1;
                    cArr3[i7] = ' ';
                    this.f53391c = i6 + 1;
                }
                int i8 = this.f53391c;
                if (i8 == this.f53390b) {
                    break;
                }
                char[] cArr4 = this.f53395g;
                if (cArr4[i8] == ',' || cArr4[i8] == '+' || cArr4[i8] == ';') {
                    break;
                }
            } else if (c2 == ';') {
                break;
            } else if (c2 == '\\') {
                int i9 = this.f53393e;
                this.f53393e = i9 + 1;
                cArr2[i9] = e();
                this.f53391c++;
            } else if (c2 == '+' || c2 == ',') {
                break;
            } else {
                int i10 = this.f53393e;
                this.f53393e = i10 + 1;
                cArr2[i10] = cArr2[i3];
                this.f53391c = i3 + 1;
            }
        }
        char[] cArr5 = this.f53395g;
        int i11 = this.f53392d;
        return new String(cArr5, i11, this.f53393e - i11);
    }

    private char e() {
        int i2 = this.f53391c + 1;
        this.f53391c = i2;
        if (i2 != this.f53390b) {
            char c2 = this.f53395g[i2];
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
            return this.f53395g[this.f53391c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private char f() {
        int i2;
        int i3;
        int a = a(this.f53391c);
        this.f53391c++;
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
            int i5 = this.f53391c + 1;
            this.f53391c = i5;
            if (i5 == this.f53390b || this.f53395g[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.f53391c = i6;
            int a2 = a(i6);
            this.f53391c++;
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
        if (i5 < this.f53390b) {
            char c2 = this.f53395g[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i3 = c2 - '7';
            }
            char c3 = this.f53395g[i5];
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
        this.f53391c = 0;
        this.f53392d = 0;
        this.f53393e = 0;
        this.f53394f = 0;
        this.f53395g = this.a.toCharArray();
        String a = a();
        if (a == null) {
            return null;
        }
        do {
            int i2 = this.f53391c;
            if (i2 == this.f53390b) {
                return null;
            }
            char c2 = this.f53395g[i2];
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
            int i3 = this.f53391c;
            if (i3 >= this.f53390b) {
                return null;
            }
            char[] cArr = this.f53395g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.f53391c++;
            a = a();
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
