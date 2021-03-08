package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f3941a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static e c(s sVar) {
        return new n(sVar);
    }

    public static d b(r rVar) {
        return new m(rVar);
    }

    private static r a(final OutputStream outputStream, final t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new r() { // from class: com.bytedance.sdk.a.a.l.1
            @Override // com.bytedance.sdk.a.a.r
            public void a(c cVar, long j) throws IOException {
                u.a(cVar.b, 0L, j);
                while (j > 0) {
                    t.this.g();
                    o oVar = cVar.pqm;
                    int min = (int) Math.min(j, oVar.c - oVar.b);
                    outputStream.write(oVar.f3942a, oVar.b, min);
                    oVar.b += min;
                    j -= min;
                    cVar.b -= min;
                    if (oVar.b == oVar.c) {
                        cVar.pqm = oVar.eoW();
                        p.b(oVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // com.bytedance.sdk.a.a.r
            public t eoF() {
                return t.this;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static r f(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        a h = h(socket);
        return h.a(a(socket.getOutputStream(), h));
    }

    public static s p(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(final InputStream inputStream, final t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new s() { // from class: com.bytedance.sdk.a.a.l.2
            @Override // com.bytedance.sdk.a.a.s
            public long b(c cVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    t.this.g();
                    o OB = cVar.OB(1);
                    int read = inputStream.read(OB.f3942a, OB.c, (int) Math.min(j, 8192 - OB.c));
                    if (read == -1) {
                        return -1L;
                    }
                    OB.c += read;
                    cVar.b += read;
                    return read;
                } catch (AssertionError e) {
                    if (l.a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }

            @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // com.bytedance.sdk.a.a.s
            public t eoF() {
                return t.this;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static s g(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        a h = h(socket);
        return h.a(a(socket.getInputStream(), h));
    }

    private static a h(final Socket socket) {
        return new a() { // from class: com.bytedance.sdk.a.a.l.3
            @Override // com.bytedance.sdk.a.a.a
            protected IOException f(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.bytedance.sdk.a.a.a
            protected void eoD() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (l.a(e)) {
                        l.f3941a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    l.f3941a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
