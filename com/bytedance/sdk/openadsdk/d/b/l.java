package com.bytedance.sdk.openadsdk.d.b;

import com.bytedance.sdk.openadsdk.d.b.a.n;
import com.bytedance.sdk.openadsdk.d.p;
import com.bytedance.sdk.openadsdk.d.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes6.dex */
public final class l {
    public static com.bytedance.sdk.openadsdk.d.l a(com.bytedance.sdk.openadsdk.d.d.a aVar) throws p {
        boolean z = true;
        try {
            aVar.f();
            z = false;
            return n.X.b(aVar);
        } catch (com.bytedance.sdk.openadsdk.d.d.d e) {
            throw new t(e);
        } catch (EOFException e2) {
            if (z) {
                return com.bytedance.sdk.openadsdk.d.n.f7000a;
            }
            throw new t(e2);
        } catch (IOException e3) {
            throw new com.bytedance.sdk.openadsdk.d.m(e3);
        } catch (NumberFormatException e4) {
            throw new t(e4);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.d.l lVar, com.bytedance.sdk.openadsdk.d.d.c cVar) throws IOException {
        n.X.a(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes6.dex */
    private static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f6971a;

        /* renamed from: b  reason: collision with root package name */
        private final C1018a f6972b = new C1018a();

        a(Appendable appendable) {
            this.f6971a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.f6972b.f6973a = cArr;
            this.f6971a.append(this.f6972b, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f6971a.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* renamed from: com.bytedance.sdk.openadsdk.d.b.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static class C1018a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f6973a;

            C1018a() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f6973a.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f6973a[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f6973a, i, i2 - i);
            }
        }
    }
}
