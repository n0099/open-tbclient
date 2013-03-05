package com.baidu.zeus;

import cn.jingling.lib.file.Shared;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.RequestContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Request {
    private static final String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
    private static final String CONTENT_LENGTH_HEADER = "content-length";
    private static final String HOST_HEADER = "Host";
    private static RequestContent requestContentProcessor = new RequestContent();
    private int mBodyLength;
    private InputStream mBodyProvider;
    private Connection mConnection;
    EventHandler mEventHandler;
    HttpHost mHost;
    BasicHttpRequest mHttpRequest;
    String mPath;
    HttpHost mProxyHost;
    volatile boolean mCancelled = false;
    int mFailCount = 0;
    private int mReceivedBytes = 0;
    private final Object mClientResource = new Object();
    private boolean mLoadingPaused = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request(String str, HttpHost httpHost, HttpHost httpHost2, String str2, InputStream inputStream, int i, EventHandler eventHandler, Map map) {
        this.mEventHandler = eventHandler;
        this.mHost = httpHost;
        this.mProxyHost = httpHost2;
        this.mPath = str2;
        this.mBodyProvider = inputStream;
        this.mBodyLength = i;
        if (inputStream == null && !"POST".equalsIgnoreCase(str)) {
            this.mHttpRequest = new BasicHttpRequest(str, getUri());
        } else {
            this.mHttpRequest = new BasicHttpEntityEnclosingRequest(str, getUri());
            if (inputStream != null) {
                setBodyProvider(inputStream, i);
            }
        }
        addHeader(HOST_HEADER, getHostPort());
        addHeader(ACCEPT_ENCODING_HEADER, "gzip");
        addHeaders(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setLoadingPaused(boolean z) {
        this.mLoadingPaused = z;
        if (!this.mLoadingPaused) {
            notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnection(Connection connection) {
        this.mConnection = connection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventHandler getEventHandler() {
        return this.mEventHandler;
    }

    void addHeader(String str, String str2) {
        if (str == null) {
            HttpLog.e("Null http header name");
            throw new NullPointerException("Null http header name");
        } else if (str2 == null || str2.length() == 0) {
            String str3 = "Null or empty value for header \"" + str + "\"";
            HttpLog.e(str3);
            throw new RuntimeException(str3);
        } else {
            this.mHttpRequest.addHeader(str, str2);
        }
    }

    void addHeaders(Map map) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendRequest(AndroidHttpClientConnection androidHttpClientConnection) {
        if (!this.mCancelled) {
            requestContentProcessor.process(this.mHttpRequest, this.mConnection.getHttpContext());
            androidHttpClientConnection.sendRequestHeader(this.mHttpRequest);
            if (this.mHttpRequest instanceof HttpEntityEnclosingRequest) {
                androidHttpClientConnection.sendRequestEntity((HttpEntityEnclosingRequest) this.mHttpRequest);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [347=5, 349=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void readResponse(AndroidHttpClientConnection androidHttpClientConnection) {
        StatusLine parseResponseHeader;
        int statusCode;
        InputStream inputStream;
        byte[] bArr;
        int i;
        IOException e;
        int i2;
        if (this.mCancelled) {
            return;
        }
        androidHttpClientConnection.flush();
        Headers headers = new Headers();
        do {
            parseResponseHeader = androidHttpClientConnection.parseResponseHeader(headers);
            statusCode = parseResponseHeader.getStatusCode();
        } while (statusCode < 200);
        ProtocolVersion protocolVersion = parseResponseHeader.getProtocolVersion();
        this.mEventHandler.status(protocolVersion.getMajor(), protocolVersion.getMinor(), statusCode, parseResponseHeader.getReasonPhrase());
        this.mEventHandler.headers(headers);
        HttpEntity receiveResponseEntity = canResponseHaveBody(this.mHttpRequest, statusCode) ? androidHttpClientConnection.receiveResponseEntity(headers) : null;
        boolean equalsIgnoreCase = "bytes".equalsIgnoreCase(headers.getAcceptRanges());
        if (receiveResponseEntity != null) {
            InputStream content = receiveResponseEntity.getContent();
            InputStream contentEncoding = receiveResponseEntity.getContentEncoding();
            InputStream inputStream2 = null;
            byte[] bArr2 = null;
            int i3 = 0;
            try {
                try {
                    try {
                        if (contentEncoding != null) {
                            try {
                                if (contentEncoding.getValue().equals("gzip")) {
                                    inputStream = new GZIPInputStream(content);
                                    bArr = this.mConnection.getBuf();
                                    int length = bArr.length / 2;
                                    i = 0;
                                    i2 = 0;
                                    while (i2 != -1) {
                                        try {
                                            synchronized (this) {
                                                while (this.mLoadingPaused) {
                                                    try {
                                                        wait();
                                                    } catch (InterruptedException e2) {
                                                        HttpLog.e("Interrupted exception whilst network thread paused at WebCore's request. " + e2.getMessage());
                                                    }
                                                }
                                            }
                                            int read = inputStream.read(bArr, i, bArr.length - i);
                                            if (read != -1) {
                                                i3 = i + read;
                                                if (equalsIgnoreCase) {
                                                    this.mReceivedBytes += read;
                                                }
                                            } else {
                                                i3 = i;
                                            }
                                            if (read == -1 || i3 >= length) {
                                                this.mEventHandler.data(bArr, i3);
                                                i = 0;
                                                i2 = read;
                                            } else {
                                                i = i3;
                                                i2 = read;
                                            }
                                        } catch (EOFException e3) {
                                            i3 = i;
                                            bArr2 = bArr;
                                            inputStream2 = inputStream;
                                            if (i3 > 0) {
                                                try {
                                                    this.mEventHandler.data(bArr2, i3);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    contentEncoding = inputStream2;
                                                    if (contentEncoding != null) {
                                                        try {
                                                            contentEncoding.close();
                                                        } catch (NullPointerException e4) {
                                                            return;
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (NullPointerException e5) {
                                                    return;
                                                }
                                            }
                                            this.mConnection.setCanPersist(receiveResponseEntity, parseResponseHeader.getProtocolVersion(), headers.getConnectionType());
                                            this.mEventHandler.endData();
                                            complete();
                                        } catch (IOException e6) {
                                            e = e6;
                                            if (statusCode != 200 || statusCode == 206) {
                                                if (equalsIgnoreCase && i > 0) {
                                                    this.mEventHandler.data(bArr, i);
                                                }
                                                throw e;
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (NullPointerException e7) {
                                                    return;
                                                }
                                            }
                                            this.mConnection.setCanPersist(receiveResponseEntity, parseResponseHeader.getProtocolVersion(), headers.getConnectionType());
                                            this.mEventHandler.endData();
                                            complete();
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (NullPointerException e8) {
                                            return;
                                        }
                                    }
                                }
                            } catch (EOFException e9) {
                                if (i3 > 0) {
                                }
                                if (inputStream2 != null) {
                                }
                                this.mConnection.setCanPersist(receiveResponseEntity, parseResponseHeader.getProtocolVersion(), headers.getConnectionType());
                                this.mEventHandler.endData();
                                complete();
                            } catch (IOException e10) {
                                inputStream = null;
                                bArr = null;
                                i = 0;
                                e = e10;
                                if (statusCode != 200) {
                                }
                                if (equalsIgnoreCase) {
                                    this.mEventHandler.data(bArr, i);
                                }
                                throw e;
                            } catch (Throwable th2) {
                                th = th2;
                                contentEncoding = null;
                                if (contentEncoding != null) {
                                }
                                throw th;
                            }
                        }
                        int length2 = bArr.length / 2;
                        i = 0;
                        i2 = 0;
                        while (i2 != -1) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (EOFException e11) {
                        bArr2 = bArr;
                        inputStream2 = inputStream;
                    } catch (IOException e12) {
                        i = i3;
                        e = e12;
                    }
                    bArr = this.mConnection.getBuf();
                } catch (EOFException e13) {
                    inputStream2 = inputStream;
                } catch (IOException e14) {
                    bArr = null;
                    i = 0;
                    e = e14;
                }
                inputStream = content;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        this.mConnection.setCanPersist(receiveResponseEntity, parseResponseHeader.getProtocolVersion(), headers.getConnectionType());
        this.mEventHandler.endData();
        complete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void cancel() {
        this.mLoadingPaused = false;
        notify();
        this.mCancelled = true;
        if (this.mConnection != null) {
            this.mConnection.cancel();
        }
    }

    String getHostPort() {
        String schemeName = this.mHost.getSchemeName();
        int port = this.mHost.getPort();
        return ((port == 80 || !schemeName.equals("http")) && (port == 443 || !schemeName.equals("https"))) ? this.mHost.getHostName() : this.mHost.toHostString();
    }

    String getUri() {
        return (this.mProxyHost == null || this.mHost.getSchemeName().equals("https")) ? this.mPath : this.mHost.getSchemeName() + "://" + getHostPort() + this.mPath;
    }

    public String toString() {
        return this.mPath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.mHttpRequest.removeHeaders("content-length");
        if (this.mBodyProvider != null) {
            try {
                this.mBodyProvider.reset();
            } catch (IOException e) {
            }
            setBodyProvider(this.mBodyProvider, this.mBodyLength);
        }
        if (this.mReceivedBytes > 0) {
            this.mFailCount = 0;
            HttpLog.v("*** Request.reset() to range:" + this.mReceivedBytes);
            this.mHttpRequest.setHeader("Range", "bytes=" + this.mReceivedBytes + "-");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void waitUntilComplete() {
        synchronized (this.mClientResource) {
            try {
                this.mClientResource.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void complete() {
        synchronized (this.mClientResource) {
            this.mClientResource.notifyAll();
        }
    }

    private static boolean canResponseHaveBody(HttpRequest httpRequest, int i) {
        return ("HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod()) || i < 200 || i == 204 || i == 304) ? false : true;
    }

    private void setBodyProvider(InputStream inputStream, int i) {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("bodyProvider must support mark()");
        }
        inputStream.mark(Shared.INFINITY);
        this.mHttpRequest.setEntity(new InputStreamEntity(inputStream, i));
    }

    public void handleSslErrorResponse(boolean z) {
        HttpsConnection httpsConnection = (HttpsConnection) this.mConnection;
        if (httpsConnection != null) {
            httpsConnection.restartConnection(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void error(int i, int i2) {
        this.mEventHandler.error(i, this.mConnection.mContext.getText(i2).toString());
    }
}
