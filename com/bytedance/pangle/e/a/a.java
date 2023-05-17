package com.bytedance.pangle.e.a;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class a {
    public int a;
    public b b;
    public int[] c;
    public boolean i;
    public f k;
    public boolean j = false;
    public final c l = new c();
    public int d = 0;
    public int e = 1;
    public int f = 2;
    public int g = 3;
    public int h = 4;

    public a() {
        c();
    }

    private void c() {
        this.c = null;
        this.a = -1;
    }

    public final void a() {
        if (this.j) {
            this.j = false;
            b bVar = this.b;
            InputStream inputStream = bVar.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.k = null;
            this.b = null;
            c cVar = this.l;
            cVar.b = 0;
            cVar.c = 0;
            c();
        }
    }

    private int e(int i) {
        if (this.a == 2) {
            int i2 = i * 5;
            if (i2 < this.c.length) {
                return i2;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public final String a(int i) {
        int i2 = this.c[e(i) + 1];
        if (i2 == -1) {
            return "";
        }
        return this.k.a(i2);
    }

    public final int b(int i) {
        return this.c[e(i) + 3];
    }

    public final int c(int i) {
        return this.c[e(i) + 4];
    }

    public final String d(int i) {
        int e = e(i);
        int[] iArr = this.c;
        if (iArr[e + 3] == 3) {
            return this.k.a(iArr[e + 2]);
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x023e, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b() {
        int a;
        int a2;
        int i;
        int i2;
        int i3;
        try {
            if (this.b != null) {
                if (this.k == null) {
                    this.b.b(524291);
                    this.b.b();
                    b bVar = this.b;
                    bVar.b(1835009);
                    int a3 = bVar.a();
                    int a4 = bVar.a();
                    int a5 = bVar.a();
                    bVar.a();
                    int a6 = bVar.a();
                    int a7 = bVar.a();
                    f fVar = new f();
                    fVar.a = bVar.a(a4);
                    if (a5 != 0) {
                        bVar.a(a5);
                    }
                    if (a7 == 0) {
                        i3 = a3;
                    } else {
                        i3 = a7;
                    }
                    int i4 = i3 - a6;
                    if (i4 % 4 == 0) {
                        fVar.b = bVar.a(i4 / 4);
                        if (a7 != 0) {
                            int i5 = a3 - a7;
                            if (i5 % 4 == 0) {
                                bVar.a(i5 / 4);
                            } else {
                                throw new IOException();
                            }
                        }
                        this.k = fVar;
                        this.l.a();
                        this.j = true;
                    } else {
                        throw new IOException();
                    }
                }
                if (this.a != this.e) {
                    int i6 = this.a;
                    c();
                    while (true) {
                        int i7 = 0;
                        if (this.i) {
                            this.i = false;
                            c cVar = this.l;
                            if (cVar.b != 0) {
                                int i8 = cVar.b - 1;
                                int i9 = cVar.a[i8] * 2;
                                if ((i8 - 1) - i9 != 0) {
                                    cVar.b -= i9 + 2;
                                    cVar.c--;
                                }
                            }
                        }
                        if (i6 == this.g && this.l.c == 1) {
                            c cVar2 = this.l;
                            if (cVar2.b != 0) {
                                i7 = cVar2.a[cVar2.b - 1];
                            }
                            if (i7 == 0) {
                                this.a = this.e;
                                break;
                            }
                        }
                        if (i6 == this.d) {
                            a = 1048834;
                        } else {
                            a = this.b.a();
                        }
                        if (a == 524672) {
                            a2 = this.b.a();
                            if (a2 < 8 || a2 % 4 != 0) {
                                break;
                            }
                            this.b.a((a2 / 4) - 2);
                        } else if (a < 1048832 || a > 1048836) {
                            break;
                        } else {
                            if (a == 1048834 && i6 == -1) {
                                this.a = this.d;
                                break;
                            }
                            this.b.b();
                            this.b.a();
                            this.b.b();
                            if (a != 1048832 && a != 1048833) {
                                if (a == 1048834) {
                                    this.b.a();
                                    this.b.a();
                                    this.b.b();
                                    this.b.a();
                                    this.c = this.b.a((this.b.a() & 65535) * 5);
                                    for (int i10 = 3; i10 < this.c.length; i10 += 5) {
                                        int[] iArr = this.c;
                                        iArr[i10] = iArr[i10] >>> 24;
                                    }
                                    this.l.a();
                                    this.a = this.f;
                                } else if (a == 1048835) {
                                    this.b.a();
                                    this.b.a();
                                    this.a = this.g;
                                    this.i = true;
                                    break;
                                } else if (a == 1048836) {
                                    this.b.a();
                                    this.b.b();
                                    this.b.b();
                                    this.a = this.h;
                                    break;
                                }
                            }
                            if (a == 1048832) {
                                int a8 = this.b.a();
                                int a9 = this.b.a();
                                c cVar3 = this.l;
                                if (cVar3.c == 0) {
                                    cVar3.a();
                                }
                                cVar3.b();
                                int i11 = cVar3.b - 1;
                                int i12 = cVar3.a[i11];
                                int i13 = i12 + 1;
                                cVar3.a[(i11 - 1) - (i12 * 2)] = i13;
                                cVar3.a[i11] = a8;
                                cVar3.a[i11 + 1] = a9;
                                cVar3.a[i11 + 2] = i13;
                                cVar3.b += 2;
                            } else {
                                this.b.b();
                                this.b.b();
                                c cVar4 = this.l;
                                if (cVar4.b != 0 && (i2 = cVar4.a[(i = cVar4.b - 1)]) != 0) {
                                    int i14 = i2 - 1;
                                    int i15 = i - 2;
                                    cVar4.a[i15] = i14;
                                    cVar4.a[i15 - ((i14 * 2) + 1)] = i14;
                                    cVar4.b -= 2;
                                }
                            }
                        }
                    }
                    throw new IOException("Invalid resource ids size (" + a2 + ").");
                }
                return this.a;
            }
            throw new IOException("Parser is not opened.");
        } catch (IOException e) {
            a();
            throw e;
        }
    }
}
