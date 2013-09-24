package com.baidu.zeus;

import android.content.Context;
import android.os.SystemClock;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class Connection {
    private static final int DONE = 3;
    private static final int DRAIN = 2;
    private static final String HTTP_CONNECTION = "http.connection";
    private static final int MAX_PIPE = 3;
    private static final int MIN_PIPE = 2;
    private static final int READ = 1;
    private static final int RETRY_REQUEST_LIMIT = 2;
    private static final int SEND = 0;
    static final int SOCKET_TIMEOUT = 60000;
    private byte[] mBuf;
    Context mContext;
    HttpHost mHost;
    RequestFeeder mRequestFeeder;
    private static final String[] states = {"SEND", "READ", "DRAIN", "DONE"};
    private static int STATE_NORMAL = 0;
    private static int STATE_CANCEL_REQUESTED = 1;
    protected AndroidHttpClientConnection mHttpClientConnection = null;
    protected SslCertificate mCertificate = null;
    private int mActive = STATE_NORMAL;
    private boolean mCanPersist = false;
    private HttpContext mHttpContext = new BasicHttpContext((HttpContext) null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void closeConnection();

    abstract String getScheme();

    abstract AndroidHttpClientConnection openConnection(Request request);

    /* JADX INFO: Access modifiers changed from: protected */
    public Connection(Context context, HttpHost httpHost, RequestFeeder requestFeeder) {
        this.mContext = context;
        this.mHost = httpHost;
        this.mRequestFeeder = requestFeeder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpHost getHost() {
        return this.mHost;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Connection getConnection(Context context, HttpHost httpHost, HttpHost httpHost2, RequestFeeder requestFeeder) {
        return httpHost.getSchemeName().equals("http") ? new HttpConnection(context, httpHost, requestFeeder) : new HttpsConnection(context, httpHost, httpHost2, requestFeeder);
    }

    SslCertificate getCertificate() {
        return this.mCertificate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel() {
        this.mActive = STATE_CANCEL_REQUESTED;
        closeConnection();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processRequests(Request request) {
        HttpException httpException;
        int i;
        HttpException httpException2;
        char c;
        int i2;
        int i3;
        Request request2;
        Request request3;
        int i4 = 0;
        HttpException e = null;
        LinkedList<Request> linkedList = new LinkedList<>();
        int i5 = 2;
        int i6 = 3;
        char c2 = 0;
        Request request4 = request;
        while (c2 != 3) {
            if (this.mActive == STATE_CANCEL_REQUESTED) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                }
                this.mActive = STATE_NORMAL;
            }
            switch (c2) {
                case 0:
                    if (linkedList.size() == i6) {
                        c = 1;
                        i2 = i5;
                        i3 = i4;
                        request2 = request4;
                        int i7 = i6;
                        httpException2 = e;
                        i = i7;
                        continue;
                    } else {
                        if (request4 == null) {
                            request3 = this.mRequestFeeder.getRequest(this.mHost);
                        } else {
                            request3 = request4;
                            request4 = null;
                        }
                        if (request3 == null) {
                            c = 2;
                            i2 = i5;
                            i3 = i4;
                            request2 = request4;
                            int i8 = i6;
                            httpException2 = e;
                            i = i8;
                        } else {
                            request3.setConnection(this);
                            if (request3.mCancelled) {
                                request3.complete();
                                c = c2;
                                i2 = i5;
                                i3 = i4;
                                request2 = request4;
                                int i9 = i6;
                                httpException2 = e;
                                i = i9;
                            } else if ((this.mHttpClientConnection == null || !this.mHttpClientConnection.isOpen()) && !openHttpConnection(request3)) {
                                c = 3;
                                i2 = i5;
                                i3 = i4;
                                request2 = request4;
                                int i10 = i6;
                                httpException2 = e;
                                i = i10;
                            } else {
                                request3.mEventHandler.certificate(this.mCertificate);
                                try {
                                    request3.sendRequest(this.mHttpClientConnection);
                                } catch (IOException e3) {
                                    i4 = -7;
                                    e = e3;
                                } catch (IllegalStateException e4) {
                                    i4 = -7;
                                    e = e4;
                                } catch (HttpException e5) {
                                    i4 = -1;
                                    e = e5;
                                }
                                if (e != null) {
                                    if (httpFailure(request3, i4, e) && !request3.mCancelled) {
                                        linkedList.addLast(request3);
                                    }
                                    c = clearPipe(linkedList) ? (char) 3 : (char) 0;
                                    i = 1;
                                    httpException2 = null;
                                    i3 = i4;
                                    i2 = 1;
                                    request2 = request4;
                                } else {
                                    linkedList.addLast(request3);
                                    if (!this.mCanPersist) {
                                        c = 1;
                                        i2 = i5;
                                        i3 = i4;
                                        request2 = request4;
                                        int i11 = i6;
                                        httpException2 = e;
                                        i = i11;
                                    }
                                }
                            }
                        }
                    }
                    request4 = request2;
                    i4 = i3;
                    i5 = i2;
                    c2 = c;
                    int i12 = i;
                    e = httpException2;
                    i6 = i12;
                    break;
                case 1:
                case 2:
                    boolean z = !this.mRequestFeeder.haveRequest(this.mHost);
                    int size = linkedList.size();
                    if (c2 != 2 && size < i5 && !z && this.mCanPersist) {
                        c = 0;
                        i2 = i5;
                        i3 = i4;
                        request2 = request4;
                        int i13 = i6;
                        httpException2 = e;
                        i = i13;
                        continue;
                    } else if (size == 0) {
                        c = z ? (char) 3 : (char) 0;
                        i2 = i5;
                        i3 = i4;
                        request2 = request4;
                        int i14 = i6;
                        httpException2 = e;
                        i = i14;
                    } else {
                        Request removeFirst = linkedList.removeFirst();
                        try {
                            removeFirst.readResponse(this.mHttpClientConnection);
                        } catch (IOException e6) {
                            e = e6;
                            i4 = -7;
                        } catch (IllegalStateException e7) {
                            e = e7;
                            i4 = -7;
                        } catch (org.apache.http.ParseException e8) {
                            e = e8;
                            i4 = -7;
                        }
                        if (e != null) {
                            if (httpFailure(removeFirst, i4, e) && !removeFirst.mCancelled) {
                                removeFirst.reset();
                                linkedList.addFirst(removeFirst);
                            }
                            httpException = null;
                            this.mCanPersist = false;
                        } else {
                            httpException = e;
                        }
                        if (this.mCanPersist) {
                            i = i6;
                            httpException2 = httpException;
                            c = c2;
                            i2 = i5;
                            i3 = i4;
                            request2 = request4;
                        } else {
                            closeConnection();
                            this.mHttpContext.removeAttribute(HTTP_CONNECTION);
                            clearPipe(linkedList);
                            i2 = 1;
                            httpException2 = httpException;
                            i3 = i4;
                            c = 0;
                            request2 = request4;
                            i = 1;
                        }
                    }
                    request4 = request2;
                    i4 = i3;
                    i5 = i2;
                    c2 = c;
                    int i122 = i;
                    e = httpException2;
                    i6 = i122;
                    break;
            }
            c = c2;
            i2 = i5;
            i3 = i4;
            request2 = request4;
            int i15 = i6;
            httpException2 = e;
            i = i15;
            request4 = request2;
            i4 = i3;
            i5 = i2;
            c2 = c;
            int i1222 = i;
            e = httpException2;
            i6 = i1222;
        }
    }

    private boolean clearPipe(LinkedList<Request> linkedList) {
        boolean z;
        synchronized (this.mRequestFeeder) {
            z = true;
            while (!linkedList.isEmpty()) {
                this.mRequestFeeder.requeueRequest(linkedList.removeLast());
                z = false;
            }
            if (z) {
                z = !this.mRequestFeeder.haveRequest(this.mHost);
            }
        }
        return z;
    }

    private boolean openHttpConnection(Request request) {
        Exception e = null;
        int i = -6;
        SystemClock.uptimeMillis();
        try {
            this.mCertificate = null;
            this.mHttpClientConnection = openConnection(request);
        } catch (SSLConnectionClosedByUserException e2) {
            request.mFailCount = 2;
            return false;
        } catch (IllegalArgumentException e3) {
            e = e3;
            request.mFailCount = 2;
        } catch (UnknownHostException e4) {
            e = e4;
            i = -2;
        } catch (SSLHandshakeException e5) {
            e = e5;
            request.mFailCount = 2;
            i = -11;
        } catch (IOException e6) {
            e = e6;
        }
        if (this.mHttpClientConnection != null) {
            this.mHttpClientConnection.setSocketTimeout(SOCKET_TIMEOUT);
            this.mHttpContext.setAttribute(HTTP_CONNECTION, this.mHttpClientConnection);
            i = 0;
            if (i == 0) {
                return true;
            }
            if (request.mFailCount < 2) {
                this.mRequestFeeder.requeueRequest(request);
                request.mFailCount++;
            } else {
                httpFailure(request, i, e);
            }
            return i == 0;
        }
        request.mFailCount = 2;
        return false;
    }

    private boolean httpFailure(Request request, int i, Exception exc) {
        String th;
        boolean z = true;
        int i2 = request.mFailCount + 1;
        request.mFailCount = i2;
        if (i2 >= 2) {
            if (i < 0) {
                th = ErrorStrings.getString(i, this.mContext);
            } else {
                Throwable cause = exc.getCause();
                th = cause != null ? cause.toString() : exc.getMessage();
            }
            request.mEventHandler.error(i, th);
            request.complete();
            z = false;
        }
        closeConnection();
        this.mHttpContext.removeAttribute(HTTP_CONNECTION);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpContext getHttpContext() {
        return this.mHttpContext;
    }

    private boolean keepAlive(HttpEntity httpEntity, ProtocolVersion protocolVersion, int i, HttpContext httpContext) {
        org.apache.http.HttpConnection httpConnection = (org.apache.http.HttpConnection) httpContext.getAttribute(HTTP_CONNECTION);
        if (httpConnection == null || httpConnection.isOpen()) {
            if ((httpEntity == null || httpEntity.getContentLength() >= 0 || (httpEntity.isChunked() && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0))) && i != 1) {
                if (i == 2) {
                    return true;
                }
                return !protocolVersion.lessEquals(HttpVersion.HTTP_1_0);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanPersist(HttpEntity httpEntity, ProtocolVersion protocolVersion, int i) {
        this.mCanPersist = keepAlive(httpEntity, protocolVersion, i, this.mHttpContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanPersist(boolean z) {
        this.mCanPersist = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getCanPersist() {
        return this.mCanPersist;
    }

    public synchronized String toString() {
        return this.mHost.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getBuf() {
        if (this.mBuf == null) {
            this.mBuf = new byte[8192];
        }
        return this.mBuf;
    }
}
