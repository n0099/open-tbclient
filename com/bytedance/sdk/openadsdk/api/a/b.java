package com.bytedance.sdk.openadsdk.api.a;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes6.dex */
public final class b {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38222b;

    /* renamed from: c  reason: collision with root package name */
    public int f38223c;

    /* renamed from: d  reason: collision with root package name */
    public int f38224d;

    /* renamed from: e  reason: collision with root package name */
    public int f38225e;

    /* renamed from: f  reason: collision with root package name */
    public int f38226f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f38227g;

    public b(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.f38222b = name.length();
    }

    private String a() {
        while (true) {
            int i = this.f38223c;
            if (i >= this.f38222b || this.f38227g[i] != ' ') {
                break;
            }
            this.f38223c = i + 1;
        }
        int i2 = this.f38223c;
        if (i2 == this.f38222b) {
            return null;
        }
        this.f38224d = i2;
        this.f38223c = i2 + 1;
        while (true) {
            int i3 = this.f38223c;
            if (i3 >= this.f38222b) {
                break;
            }
            char[] cArr = this.f38227g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f38223c = i3 + 1;
        }
        int i4 = this.f38223c;
        if (i4 < this.f38222b) {
            this.f38225e = i4;
            if (this.f38227g[i4] == ' ') {
                while (true) {
                    int i5 = this.f38223c;
                    if (i5 >= this.f38222b) {
                        break;
                    }
                    char[] cArr2 = this.f38227g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f38223c = i5 + 1;
                }
                char[] cArr3 = this.f38227g;
                int i6 = this.f38223c;
                if (cArr3[i6] != '=' || i6 == this.f38222b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.a);
                }
            }
            this.f38223c++;
            while (true) {
                int i7 = this.f38223c;
                if (i7 >= this.f38222b || this.f38227g[i7] != ' ') {
                    break;
                }
                this.f38223c = i7 + 1;
            }
            int i8 = this.f38225e;
            int i9 = this.f38224d;
            if (i8 - i9 > 4) {
                char[] cArr4 = this.f38227g;
                if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                    char[] cArr5 = this.f38227g;
                    int i10 = this.f38224d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f38227g;
                        int i11 = this.f38224d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f38224d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f38227g;
            int i12 = this.f38224d;
            return new String(cArr7, i12, this.f38225e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private String b() {
        int i = this.f38223c + 1;
        this.f38223c = i;
        this.f38224d = i;
        this.f38225e = i;
        while (true) {
            int i2 = this.f38223c;
            if (i2 != this.f38222b) {
                char[] cArr = this.f38227g;
                if (cArr[i2] == '\"') {
                    this.f38223c = i2 + 1;
                    while (true) {
                        int i3 = this.f38223c;
                        if (i3 >= this.f38222b || this.f38227g[i3] != ' ') {
                            break;
                        }
                        this.f38223c = i3 + 1;
                    }
                    char[] cArr2 = this.f38227g;
                    int i4 = this.f38224d;
                    return new String(cArr2, i4, this.f38225e - i4);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f38225e] = e();
                } else {
                    cArr[this.f38225e] = cArr[i2];
                }
                this.f38223c++;
                this.f38225e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
    }

    private String c() {
        int i = this.f38223c;
        if (i + 4 < this.f38222b) {
            this.f38224d = i;
            this.f38223c = i + 1;
            while (true) {
                int i2 = this.f38223c;
                if (i2 == this.f38222b) {
                    break;
                }
                char[] cArr = this.f38227g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f38225e = i2;
                    this.f38223c = i2 + 1;
                    while (true) {
                        int i3 = this.f38223c;
                        if (i3 >= this.f38222b || this.f38227g[i3] != ' ') {
                            break;
                        }
                        this.f38223c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + WebvttCueParser.CHAR_SPACE);
                    }
                    this.f38223c++;
                }
            }
            this.f38225e = this.f38223c;
            int i4 = this.f38225e;
            int i5 = this.f38224d;
            int i6 = i4 - i5;
            if (i6 >= 5 && (i6 & 1) != 0) {
                int i7 = i6 / 2;
                byte[] bArr = new byte[i7];
                int i8 = i5 + 1;
                for (int i9 = 0; i9 < i7; i9++) {
                    bArr[i9] = (byte) a(i8);
                    i8 += 2;
                }
                return new String(this.f38227g, this.f38224d, i6);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f38226f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String d() {
        int i = this.f38223c;
        this.f38224d = i;
        this.f38225e = i;
        while (true) {
            int i2 = this.f38223c;
            if (i2 >= this.f38222b) {
                char[] cArr = this.f38227g;
                int i3 = this.f38224d;
                return new String(cArr, i3, this.f38225e - i3);
            }
            char[] cArr2 = this.f38227g;
            char c2 = cArr2[i2];
            if (c2 == ' ') {
                int i4 = this.f38225e;
                this.f38226f = i4;
                this.f38223c = i2 + 1;
                this.f38225e = i4 + 1;
                cArr2[i4] = WebvttCueParser.CHAR_SPACE;
                while (true) {
                    int i5 = this.f38223c;
                    if (i5 >= this.f38222b) {
                        break;
                    }
                    char[] cArr3 = this.f38227g;
                    if (cArr3[i5] != ' ') {
                        break;
                    }
                    int i6 = this.f38225e;
                    this.f38225e = i6 + 1;
                    cArr3[i6] = WebvttCueParser.CHAR_SPACE;
                    this.f38223c = i5 + 1;
                }
                int i7 = this.f38223c;
                if (i7 == this.f38222b) {
                    break;
                }
                char[] cArr4 = this.f38227g;
                if (cArr4[i7] == ',' || cArr4[i7] == '+' || cArr4[i7] == ';') {
                    break;
                }
            } else if (c2 == ';') {
                break;
            } else if (c2 == '\\') {
                int i8 = this.f38225e;
                this.f38225e = i8 + 1;
                cArr2[i8] = e();
                this.f38223c++;
            } else if (c2 == '+' || c2 == ',') {
                break;
            } else {
                int i9 = this.f38225e;
                this.f38225e = i9 + 1;
                cArr2[i9] = cArr2[i2];
                this.f38223c = i2 + 1;
            }
        }
        char[] cArr5 = this.f38227g;
        int i10 = this.f38224d;
        return new String(cArr5, i10, this.f38225e - i10);
    }

    private char e() {
        int i = this.f38223c + 1;
        this.f38223c = i;
        if (i != this.f38222b) {
            char c2 = this.f38227g[i];
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
            return this.f38227g[this.f38223c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private char f() {
        int i;
        int i2;
        int a = a(this.f38223c);
        this.f38223c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i2 = a & 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.f38223c + 1;
            this.f38223c = i4;
            if (i4 == this.f38222b || this.f38227g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f38223c = i5;
            int a2 = a(i5);
            this.f38223c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f38222b) {
            char c2 = this.f38227g[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i2 = c2 - '7';
            }
            char c3 = this.f38227g[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    public String a(String str) {
        String b2;
        this.f38223c = 0;
        this.f38224d = 0;
        this.f38225e = 0;
        this.f38226f = 0;
        this.f38227g = this.a.toCharArray();
        String a = a();
        if (a == null) {
            return null;
        }
        do {
            int i = this.f38223c;
            if (i == this.f38222b) {
                return null;
            }
            char c2 = this.f38227g[i];
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
            int i2 = this.f38223c;
            if (i2 >= this.f38222b) {
                return null;
            }
            char[] cArr = this.f38227g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.f38223c++;
            a = a();
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
