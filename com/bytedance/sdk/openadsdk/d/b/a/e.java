package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.o;
import com.bytedance.sdk.openadsdk.d.q;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public final class e extends com.bytedance.sdk.openadsdk.d.d.a {

    /* renamed from: b  reason: collision with root package name */
    private static final Reader f7176b = new Reader() { // from class: com.bytedance.sdk.openadsdk.d.b.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object c = new Object();
    private Object[] d;
    private int e;
    private String[] f;
    private int[] g;

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public void a() throws IOException {
        a(com.bytedance.sdk.openadsdk.d.d.b.BEGIN_ARRAY);
        a(((com.bytedance.sdk.openadsdk.d.i) t()).iterator());
        this.g[this.e - 1] = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public void b() throws IOException {
        a(com.bytedance.sdk.openadsdk.d.d.b.END_ARRAY);
        u();
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public void c() throws IOException {
        a(com.bytedance.sdk.openadsdk.d.d.b.BEGIN_OBJECT);
        a(((o) t()).n().iterator());
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public void d() throws IOException {
        a(com.bytedance.sdk.openadsdk.d.d.b.END_OBJECT);
        u();
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public boolean e() throws IOException {
        com.bytedance.sdk.openadsdk.d.d.b f = f();
        return (f == com.bytedance.sdk.openadsdk.d.d.b.END_OBJECT || f == com.bytedance.sdk.openadsdk.d.d.b.END_ARRAY) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public com.bytedance.sdk.openadsdk.d.d.b f() throws IOException {
        if (this.e == 0) {
            return com.bytedance.sdk.openadsdk.d.d.b.END_DOCUMENT;
        }
        Object t = t();
        if (t instanceof Iterator) {
            boolean z = this.d[this.e - 2] instanceof o;
            Iterator it = (Iterator) t;
            if (!it.hasNext()) {
                return z ? com.bytedance.sdk.openadsdk.d.d.b.END_OBJECT : com.bytedance.sdk.openadsdk.d.d.b.END_ARRAY;
            } else if (z) {
                return com.bytedance.sdk.openadsdk.d.d.b.NAME;
            } else {
                a(it.next());
                return f();
            }
        } else if (t instanceof o) {
            return com.bytedance.sdk.openadsdk.d.d.b.BEGIN_OBJECT;
        } else {
            if (t instanceof com.bytedance.sdk.openadsdk.d.i) {
                return com.bytedance.sdk.openadsdk.d.d.b.BEGIN_ARRAY;
            }
            if (t instanceof q) {
                q qVar = (q) t;
                if (qVar.p()) {
                    return com.bytedance.sdk.openadsdk.d.d.b.STRING;
                }
                if (qVar.n()) {
                    return com.bytedance.sdk.openadsdk.d.d.b.BOOLEAN;
                }
                if (qVar.o()) {
                    return com.bytedance.sdk.openadsdk.d.d.b.NUMBER;
                }
                throw new AssertionError();
            } else if (t instanceof com.bytedance.sdk.openadsdk.d.n) {
                return com.bytedance.sdk.openadsdk.d.d.b.NULL;
            } else {
                if (t == c) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object t() {
        return this.d[this.e - 1];
    }

    private Object u() {
        Object[] objArr = this.d;
        int i = this.e - 1;
        this.e = i;
        Object obj = objArr[i];
        this.d[this.e] = null;
        return obj;
    }

    private void a(com.bytedance.sdk.openadsdk.d.d.b bVar) throws IOException {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f() + v());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public String g() throws IOException {
        a(com.bytedance.sdk.openadsdk.d.d.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        String str = (String) entry.getKey();
        this.f[this.e - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public String h() throws IOException {
        com.bytedance.sdk.openadsdk.d.d.b f = f();
        if (f != com.bytedance.sdk.openadsdk.d.d.b.STRING && f != com.bytedance.sdk.openadsdk.d.d.b.NUMBER) {
            throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.d.d.b.STRING + " but was " + f + v());
        }
        String b2 = ((q) u()).b();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return b2;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public boolean i() throws IOException {
        a(com.bytedance.sdk.openadsdk.d.d.b.BOOLEAN);
        boolean f = ((q) u()).f();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return f;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public void j() throws IOException {
        a(com.bytedance.sdk.openadsdk.d.d.b.NULL);
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public double k() throws IOException {
        com.bytedance.sdk.openadsdk.d.d.b f = f();
        if (f != com.bytedance.sdk.openadsdk.d.d.b.NUMBER && f != com.bytedance.sdk.openadsdk.d.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.d.d.b.NUMBER + " but was " + f + v());
        }
        double c2 = ((q) t()).c();
        if (!q() && (Double.isNaN(c2) || Double.isInfinite(c2))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c2);
        }
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return c2;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public long l() throws IOException {
        com.bytedance.sdk.openadsdk.d.d.b f = f();
        if (f != com.bytedance.sdk.openadsdk.d.d.b.NUMBER && f != com.bytedance.sdk.openadsdk.d.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.d.d.b.NUMBER + " but was " + f + v());
        }
        long d = ((q) t()).d();
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return d;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public int m() throws IOException {
        com.bytedance.sdk.openadsdk.d.d.b f = f();
        if (f != com.bytedance.sdk.openadsdk.d.d.b.NUMBER && f != com.bytedance.sdk.openadsdk.d.d.b.STRING) {
            throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.d.d.b.NUMBER + " but was " + f + v());
        }
        int e = ((q) t()).e();
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return e;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d = new Object[]{c};
        this.e = 1;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public void n() throws IOException {
        if (f() == com.bytedance.sdk.openadsdk.d.d.b.NAME) {
            g();
            this.f[this.e - 2] = "null";
        } else {
            u();
            if (this.e > 0) {
                this.f[this.e - 1] = "null";
            }
        }
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void o() throws IOException {
        a(com.bytedance.sdk.openadsdk.d.d.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        a(entry.getValue());
        a(new q((String) entry.getKey()));
    }

    private void a(Object obj) {
        if (this.e == this.d.length) {
            int i = this.e * 2;
            this.d = Arrays.copyOf(this.d, i);
            this.g = Arrays.copyOf(this.g, i);
            this.f = (String[]) Arrays.copyOf(this.f, i);
        }
        Object[] objArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        objArr[i2] = obj;
    }

    @Override // com.bytedance.sdk.openadsdk.d.d.a
    public String p() {
        StringBuilder append = new StringBuilder().append('$');
        int i = 0;
        while (i < this.e) {
            if (this.d[i] instanceof com.bytedance.sdk.openadsdk.d.i) {
                i++;
                if (this.d[i] instanceof Iterator) {
                    append.append('[').append(this.g[i]).append(']');
                }
            } else if (this.d[i] instanceof o) {
                i++;
                if (this.d[i] instanceof Iterator) {
                    append.append('.');
                    if (this.f[i] != null) {
                        append.append(this.f[i]);
                    }
                }
            }
            i++;
        }
        return append.toString();
    }

    private String v() {
        return " at path " + p();
    }
}
