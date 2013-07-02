package com.baidu.zeus;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.HttpConnectionMetricsImpl;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.HttpRequestWriter;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineFormatter;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;
/* loaded from: classes.dex */
public class AndroidHttpClientConnection implements org.apache.http.HttpConnection, HttpInetConnection {
    private int maxHeaderCount;
    private int maxLineLength;
    private volatile boolean open;
    private SessionInputBuffer inbuffer = null;
    private SessionOutputBuffer outbuffer = null;
    private HttpMessageWriter requestWriter = null;
    private HttpConnectionMetricsImpl metrics = null;
    private Socket socket = null;
    private final EntitySerializer entityserializer = new EntitySerializer(new StrictContentLengthStrategy());

    public void bind(Socket socket, HttpParams httpParams) {
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        }
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        assertNotOpen();
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(httpParams));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpParams));
        int linger = HttpConnectionParams.getLinger(httpParams);
        if (linger >= 0) {
            socket.setSoLinger(linger > 0, linger);
        }
        this.socket = socket;
        int socketBufferSize = HttpConnectionParams.getSocketBufferSize(httpParams);
        this.inbuffer = new SocketInputBuffer(socket, socketBufferSize, httpParams);
        this.outbuffer = new SocketOutputBuffer(socket, socketBufferSize, httpParams);
        this.maxHeaderCount = httpParams.getIntParameter("http.connection.max-header-count", -1);
        this.maxLineLength = httpParams.getIntParameter("http.connection.max-line-length", -1);
        this.requestWriter = new HttpRequestWriter(this.outbuffer, (LineFormatter) null, httpParams);
        this.metrics = new HttpConnectionMetricsImpl(this.inbuffer.getMetrics(), this.outbuffer.getMetrics());
        this.open = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("[");
        if (isOpen()) {
            sb.append(getRemotePort());
        } else {
            sb.append("closed");
        }
        sb.append("]");
        return sb.toString();
    }

    private void assertNotOpen() {
        if (this.open) {
            throw new IllegalStateException("Connection is already open");
        }
    }

    private void assertOpen() {
        if (!this.open) {
            throw new IllegalStateException("Connection is not open");
        }
    }

    public boolean isOpen() {
        return this.open && this.socket != null && this.socket.isConnected();
    }

    public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        }
        return null;
    }

    public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        }
        return -1;
    }

    public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        }
        return -1;
    }

    public void setSocketTimeout(int i) {
        assertOpen();
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(i);
            } catch (SocketException e) {
            }
        }
    }

    public int getSocketTimeout() {
        if (this.socket != null) {
            try {
                return this.socket.getSoTimeout();
            } catch (SocketException e) {
                return -1;
            }
        }
        return -1;
    }

    public void shutdown() {
        this.open = false;
        Socket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
    }

    public void close() {
        if (this.open) {
            this.open = false;
            doFlush();
            try {
                try {
                    this.socket.shutdownOutput();
                } catch (UnsupportedOperationException e) {
                }
            } catch (IOException e2) {
            }
            try {
                this.socket.shutdownInput();
            } catch (IOException e3) {
            }
            this.socket.close();
        }
    }

    public void sendRequestHeader(HttpRequest httpRequest) {
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        assertOpen();
        this.requestWriter.write(httpRequest);
        this.metrics.incrementRequestCount();
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        if (httpEntityEnclosingRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        assertOpen();
        if (httpEntityEnclosingRequest.getEntity() != null) {
            this.entityserializer.serialize(this.outbuffer, httpEntityEnclosingRequest, httpEntityEnclosingRequest.getEntity());
        }
    }

    protected void doFlush() {
        this.outbuffer.flush();
    }

    public void flush() {
        assertOpen();
        doFlush();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        if (r2 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        r11.parseHeader(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r5 < 200) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        r10.metrics.incrementResponseCount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StatusLine parseResponseHeader(Headers headers) {
        CharArrayBuffer charArrayBuffer;
        assertOpen();
        CharArrayBuffer charArrayBuffer2 = new CharArrayBuffer(64);
        if (this.inbuffer.readLine(charArrayBuffer2) == -1) {
            throw new NoHttpResponseException("The target server failed to respond");
        }
        StatusLine parseStatusLine = BasicLineParser.DEFAULT.parseStatusLine(charArrayBuffer2, new ParserCursor(0, charArrayBuffer2.length()));
        int statusCode = parseStatusLine.getStatusCode();
        CharArrayBuffer charArrayBuffer3 = null;
        int i = 0;
        while (true) {
            if (charArrayBuffer2 == null) {
                charArrayBuffer2 = new CharArrayBuffer(64);
            } else {
                charArrayBuffer2.clear();
            }
            int readLine = this.inbuffer.readLine(charArrayBuffer2);
            if (readLine == -1 || charArrayBuffer2.length() < 1) {
                break;
            }
            NetworkStatistic.getInstance().addDownloadLength(readLine);
            char charAt = charArrayBuffer2.charAt(0);
            if ((charAt == ' ' || charAt == '\t') && charArrayBuffer3 != null) {
                int i2 = 0;
                int length = charArrayBuffer2.length();
                while (i2 < length) {
                    char charAt2 = charArrayBuffer2.charAt(i2);
                    if (charAt2 != ' ' && charAt2 != '\t') {
                        break;
                    }
                    i2++;
                }
                if (this.maxLineLength > 0 && ((charArrayBuffer3.length() + 1) + charArrayBuffer2.length()) - i2 > this.maxLineLength) {
                    throw new IOException("Maximum line length limit exceeded");
                }
                charArrayBuffer3.append(' ');
                charArrayBuffer3.append(charArrayBuffer2, i2, charArrayBuffer2.length() - i2);
                CharArrayBuffer charArrayBuffer4 = charArrayBuffer3;
                charArrayBuffer = charArrayBuffer2;
                charArrayBuffer2 = charArrayBuffer4;
            } else {
                if (charArrayBuffer3 != null) {
                    headers.parseHeader(charArrayBuffer3);
                }
                i++;
                charArrayBuffer = null;
            }
            if (this.maxHeaderCount > 0 && i >= this.maxHeaderCount) {
                throw new IOException("Maximum header count exceeded");
            }
            CharArrayBuffer charArrayBuffer5 = charArrayBuffer2;
            charArrayBuffer2 = charArrayBuffer;
            charArrayBuffer3 = charArrayBuffer5;
        }
    }

    public HttpEntity receiveResponseEntity(Headers headers) {
        assertOpen();
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long determineLength = determineLength(headers);
        if (determineLength == -2) {
            basicHttpEntity.setChunked(true);
            basicHttpEntity.setContentLength(-1L);
            basicHttpEntity.setContent(new ChunkedInputStream(this.inbuffer));
        } else if (determineLength == -1) {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(-1L);
            basicHttpEntity.setContent(new IdentityInputStream(this.inbuffer));
        } else {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(determineLength);
            basicHttpEntity.setContent(new ContentLengthInputStream(this.inbuffer, determineLength));
        }
        String contentType = headers.getContentType();
        if (contentType != null) {
            basicHttpEntity.setContentType(contentType);
        }
        String contentEncoding = headers.getContentEncoding();
        if (contentEncoding != null) {
            basicHttpEntity.setContentEncoding(contentEncoding);
        }
        return basicHttpEntity;
    }

    private long determineLength(Headers headers) {
        long transferEncoding = headers.getTransferEncoding();
        if (transferEncoding >= 0) {
            long contentLength = headers.getContentLength();
            if (contentLength <= -1) {
                return -1L;
            }
            return contentLength;
        }
        return transferEncoding;
    }

    public boolean isStale() {
        assertOpen();
        try {
            this.inbuffer.isDataAvailable(1);
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }
}
