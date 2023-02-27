package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.net.http.Headers;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.sdk.Log;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import okhttp3.CertificatePinner;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes7.dex */
public class BdNetEngine extends HandlerThread implements INoProGuard {
    public static final int ALT_DNS_NAME = 2;
    public static final int ALT_IPA_NAME = 7;
    public static final String CER_FILE_NAME = "server_test.crt";
    public static final String CRONET_ENGINE_BRIDGE = "org.chromium.net.CronetEngineBridge";
    public static final boolean DEBUG = false;
    public static final int DEFAULT_PROXY_PORT = 80;
    public static final int EXCUTE_TASK_ERROR = 3;
    public static final int EXCUTE_TASK_REDIRECT = 2;
    public static final int EXCUTE_TASK_SUCCESS = 1;
    public static final String HTTPS_SERVER_HOST = "cq01-mic-shahe-1.epc.baidu.com";
    public static final String LOG_TAG = "BdNetEngine";
    public static final int MESSAGE_EXCUTE_TASK = 1;
    public static final int MESSAGE_STOP_ENGINE = 2;
    public static boolean mFirstWait;
    public static int sNid;
    public static boolean sUsingChromiumNet;
    public HttpURLConnection mConnection;
    public boolean mIsCmwap;
    public volatile boolean mIsRecycle;
    public volatile boolean mIsRunning;
    public volatile boolean mIsWorking;
    public b mListener;
    public final Object mLock;
    public BdNetTask mNetTask;
    public Handler mPrivateHandler;
    public int mProxyPort;
    public String mProxyUrl;
    public static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static Object mSelfLock = new Object();
    public static long mWaitTime = 10000;

    /* loaded from: classes7.dex */
    public static final class a {
        public final String a;
        public final int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public char[] g;

        public a(X500Principal x500Principal) {
            String name = x500Principal.getName("RFC2253");
            this.a = name;
            this.b = name.length();
        }

        private int a(int i) throws Exception {
            int i2;
            int i3;
            int i4 = i + 1;
            if (i4 >= this.b) {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            char c = this.g[i];
            if (c >= '0' && c <= '9') {
                i2 = c - TransactionIdCreater.FILL_BYTE;
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i2 = c - '7';
            }
            char c2 = this.g[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - TransactionIdCreater.FILL_BYTE;
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }

        private char e() throws Exception {
            int i;
            int i2;
            int a = a(this.c);
            this.c++;
            if (a < 128) {
                return (char) a;
            }
            if (a < 192 || a > 247) {
                return RFC1522Codec.SEP;
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
                int i4 = this.c + 1;
                this.c = i4;
                if (i4 == this.b || this.g[i4] != '\\') {
                    return RFC1522Codec.SEP;
                }
                int i5 = i4 + 1;
                this.c = i5;
                int a2 = a(i5);
                this.c++;
                if ((a2 & 192) != 128) {
                    return RFC1522Codec.SEP;
                }
                i2 = (i2 << 6) + (a2 & 63);
            }
            return (char) i2;
        }

        public final String a() throws Exception {
            int i;
            char[] cArr;
            while (true) {
                int i2 = this.c;
                if (i2 >= this.b || this.g[i2] != ' ') {
                    break;
                }
                this.c = i2 + 1;
            }
            int i3 = this.c;
            if (i3 == this.b) {
                return null;
            }
            this.d = i3;
            do {
                this.c = i3 + 1;
                i3 = this.c;
                if (i3 >= this.b) {
                    break;
                }
                cArr = this.g;
                if (cArr[i3] == '=') {
                    break;
                }
            } while (cArr[i3] != ' ');
            int i4 = this.c;
            if (i4 >= this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            this.e = i4;
            if (this.g[i4] == ' ') {
                while (true) {
                    int i5 = this.c;
                    if (i5 >= this.b) {
                        break;
                    }
                    char[] cArr2 = this.g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.c = i5 + 1;
                }
                char[] cArr3 = this.g;
                int i6 = this.c;
                if (cArr3[i6] != '=' || i6 == this.b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.a);
                }
            }
            do {
                i = this.c + 1;
                this.c = i;
                if (i >= this.b) {
                    break;
                }
            } while (this.g[i] == ' ');
            int i7 = this.e;
            int i8 = this.d;
            if (i7 - i8 > 4) {
                char[] cArr4 = this.g;
                if (cArr4[i8 + 3] == '.' && (cArr4[i8] == 'O' || cArr4[i8] == 'o')) {
                    char[] cArr5 = this.g;
                    int i9 = this.d;
                    if (cArr5[i9 + 1] == 'I' || cArr5[i9 + 1] == 'i') {
                        char[] cArr6 = this.g;
                        int i10 = this.d;
                        if (cArr6[i10 + 2] == 'D' || cArr6[i10 + 2] == 'd') {
                            this.d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.g;
            int i11 = this.d;
            return new String(cArr7, i11, this.e - i11);
        }

        public final String b() throws Exception {
            int i = this.c;
            if (i + 4 >= this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            this.d = i;
            while (true) {
                this.c = i + 1;
                int i2 = this.c;
                if (i2 == this.b) {
                    break;
                }
                char[] cArr = this.g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.e = i2;
                    do {
                        this.c = i2 + 1;
                        i2 = this.c;
                        if (i2 >= this.b) {
                            break;
                        }
                    } while (this.g[i2] == ' ');
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + WebvttCueParser.CHAR_SPACE);
                    }
                    i = this.c;
                }
            }
            this.e = this.c;
            int i3 = this.e;
            int i4 = this.d;
            int i5 = i3 - i4;
            if (i5 < 5 || (i5 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            int i6 = i5 / 2;
            byte[] bArr = new byte[i6];
            int i7 = i4 + 1;
            for (int i8 = 0; i8 < i6; i8++) {
                bArr[i8] = (byte) a(i7);
                i7 += 2;
            }
            return new String(this.g, this.d, i5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
            return new java.lang.String(r1, r2, r8.f - r2);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String c() throws Exception {
            int i = this.c;
            this.d = i;
            this.e = i;
            while (true) {
                int i2 = this.c;
                if (i2 < this.b) {
                    char[] cArr = this.g;
                    char c = cArr[i2];
                    if (c == ' ') {
                        int i3 = this.e;
                        this.f = i3;
                        this.c = i2 + 1;
                        this.e = i3 + 1;
                        cArr[i3] = WebvttCueParser.CHAR_SPACE;
                        while (true) {
                            int i4 = this.c;
                            if (i4 >= this.b) {
                                break;
                            }
                            char[] cArr2 = this.g;
                            if (cArr2[i4] != ' ') {
                                break;
                            }
                            int i5 = this.e;
                            this.e = i5 + 1;
                            cArr2[i5] = WebvttCueParser.CHAR_SPACE;
                            this.c = i4 + 1;
                        }
                        int i6 = this.c;
                        if (i6 == this.b) {
                            break;
                        }
                        char[] cArr3 = this.g;
                        if (cArr3[i6] == ',' || cArr3[i6] == '+' || cArr3[i6] == ';') {
                            break;
                        }
                    } else if (c == ';') {
                        break;
                    } else {
                        if (c == '\\') {
                            int i7 = this.e;
                            this.e = i7 + 1;
                            cArr[i7] = d();
                            i2 = this.c;
                        } else if (c == '+' || c == ',') {
                            break;
                        } else {
                            int i8 = this.e;
                            this.e = i8 + 1;
                            cArr[i8] = cArr[i2];
                        }
                        this.c = i2 + 1;
                    }
                } else {
                    char[] cArr4 = this.g;
                    int i9 = this.d;
                    return new String(cArr4, i9, this.e - i9);
                }
            }
            char[] cArr5 = this.g;
            int i10 = this.d;
            return new String(cArr5, i10, this.e - i10);
        }

        public final char d() throws Exception {
            int i = this.c + 1;
            this.c = i;
            if (i == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            char c = this.g[i];
            if (c != ' ' && c != '%' && c != '\\' && c != '_' && c != '\"' && c != '#') {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return e();
                        }
                }
            }
            return this.g[this.c];
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        BdNetTask onNetDownloadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask, boolean z);

        void onNetDownloadError(BdNetEngine bdNetEngine, BdNetTask bdNetTask, BdNet.NetError netError, int i);

        void onNetDownloadStart(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        void onNetReceiveData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, byte[] bArr, int i);

        void onNetReceiveHeaders(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        boolean onNetRedirect(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i);

        void onNetResponseCode(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i);

        void onNetStateChanged(BdNetEngine bdNetEngine, BdNetTask bdNetTask, BdNet.NetState netState, int i);

        void onNetUploadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        void onNetUploadData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i, int i2);
    }

    public BdNetEngine() {
        super(LOG_TAG + nidPP());
        this.mLock = new Object();
    }

    private void addHeaders(BdNetTask bdNetTask) {
        for (Map.Entry<String, String> entry : bdNetTask.getHeaders().entrySet()) {
            this.mConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry2 : bdNetTask.getCookies().entrySet()) {
            stringBuffer.append(entry2.getKey().trim());
            stringBuffer.append("=");
            stringBuffer.append(entry2.getValue().trim());
            stringBuffer.append(ParamableElem.DIVIDE_PARAM);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
            this.mConnection.addRequestProperty("Cookie", stringBuffer.toString());
        }
        String refer = bdNetTask.getRefer();
        if (refer != null) {
            this.mConnection.addRequestProperty("Referer", refer);
        }
    }

    public static HttpURLConnection defaultOpenConnection(URL url, SSLContext sSLContext, BdNetTask bdNetTask) throws IOException {
        bdNetTask.setIsUseCorenet(false);
        boolean equals = url.getProtocol().equals("https");
        URLConnection openConnection = url.openConnection();
        if (equals) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.webkit.net.BdNetEngine.1
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    try {
                        if (!TextUtils.isEmpty(str) && (str.equals(DnsTransmitter.BGP_IP) || str.equals("240c:4006::6666"))) {
                            str = DnsTransmitter.IDC_HOST;
                        }
                        X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
                        return BdNetEngine.verifyAsIpAddress(str) ? BdNetEngine.verifyIpAddress(str, x509Certificate) : BdNetEngine.verifyHostName(str, x509Certificate);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                    }
                }
            });
            return httpsURLConnection;
        }
        return (HttpURLConnection) openConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean download(BdNetTask bdNetTask) {
        InputStream inputStream;
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            inputStream = this.mConnection.getInputStream();
            if (inputStream != null) {
                try {
                    if (this.mIsRunning && !bdNetTask.isStop()) {
                        byte[] bArr = new byte[4096];
                        String headerField = this.mConnection.getHeaderField("Content-Encoding");
                        if (!(headerField != null && headerField.contains("gzip"))) {
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1 || !this.mIsRunning || bdNetTask.isStop()) {
                                    break;
                                } else if (this.mListener != null) {
                                    this.mListener.onNetReceiveData(this, bdNetTask, bArr, read);
                                }
                            }
                        } else {
                            gZIPInputStream = new GZIPInputStream(inputStream);
                            while (true) {
                                try {
                                    int read2 = gZIPInputStream.read(bArr);
                                    if (read2 == -1 || !this.mIsRunning || bdNetTask.isStop()) {
                                        break;
                                    } else if (this.mListener != null) {
                                        this.mListener.onNetReceiveData(this, bdNetTask, bArr, read2);
                                    }
                                } catch (IOException unused) {
                                    gZIPInputStream2 = inputStream;
                                    try {
                                        if (this.mListener != null) {
                                            this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                                        }
                                        if (gZIPInputStream != null) {
                                            try {
                                                gZIPInputStream.close();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        if (gZIPInputStream2 != null) {
                                            try {
                                                gZIPInputStream2.close();
                                            } catch (IOException unused3) {
                                            }
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStream = gZIPInputStream2;
                                        gZIPInputStream2 = gZIPInputStream;
                                        if (gZIPInputStream2 != null) {
                                            try {
                                                gZIPInputStream2.close();
                                            } catch (IOException unused4) {
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused5) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    gZIPInputStream2 = gZIPInputStream;
                                    if (gZIPInputStream2 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    throw th;
                                }
                            }
                            gZIPInputStream.close();
                            gZIPInputStream2 = gZIPInputStream;
                        }
                    }
                    inputStream.close();
                } catch (IOException unused6) {
                    gZIPInputStream = gZIPInputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    if (gZIPInputStream2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (IOException unused7) {
                }
            }
            if (inputStream != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused8) {
                }
            }
            return true;
        } catch (IOException unused9) {
            gZIPInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, SGET, INVOKE, IF, IGET, INVOKE, SGET, INVOKE, IF, IGET, IF] complete} */
    private int excuteTask(BdNetTask bdNetTask) {
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                this.mConnection = openConnection(new URL(bdNetTask.isRedirect() ? bdNetTask.getRedirectUrl() : bdNetTask.getUrl()), bdNetTask.getSSLContext(), bdNetTask);
                                if (this.mListener != null) {
                                    this.mListener.onNetDownloadStart(this, bdNetTask);
                                }
                                this.mConnection.setConnectTimeout(bdNetTask.getConnectionTimeOut());
                                this.mConnection.setReadTimeout(bdNetTask.getReadTimeOut());
                                this.mConnection.setInstanceFollowRedirects(bdNetTask.isFollowRedirects());
                                if (this.mIsRunning && !bdNetTask.isStop()) {
                                    bdNetTask.setConnection(this.mConnection);
                                    if (bdNetTask.getMethod() == BdNet.HttpMethod.METHOD_POST) {
                                        byte[] content = bdNetTask.getContent();
                                        this.mConnection.setDoOutput(true);
                                        this.mConnection.setDoInput(true);
                                        this.mConnection.setUseCaches(false);
                                        this.mConnection.setRequestMethod("POST");
                                        this.mConnection.setRequestProperty("Content-length", String.valueOf(content.length));
                                    } else if (bdNetTask.getMethod() == BdNet.HttpMethod.METHOD_HEAD) {
                                        this.mConnection.setRequestMethod("HEAD");
                                    }
                                    addHeaders(bdNetTask);
                                    if (this.mListener != null) {
                                        this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_CONNECT_START, 0);
                                    }
                                    if (bdNetTask.getMethod() == BdNet.HttpMethod.METHOD_POST && !upload(bdNetTask)) {
                                        HttpURLConnection httpURLConnection = this.mConnection;
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        b bVar = this.mListener;
                                        if (bVar != null) {
                                            bVar.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                        }
                                        return 3;
                                    }
                                    this.mConnection.connect();
                                }
                                if (this.mIsRunning && !bdNetTask.isStop() && this.mListener != null) {
                                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_CONNECT_SETUP, 0);
                                }
                                if (this.mIsRunning && !bdNetTask.isStop()) {
                                    int responseCode = this.mConnection.getResponseCode();
                                    setHttpResponseHeader(this.mConnection, bdNetTask);
                                    if (this.mIsRunning && !bdNetTask.isStop()) {
                                        if (this.mListener != null) {
                                            this.mListener.onNetResponseCode(this, bdNetTask, responseCode);
                                        }
                                        if (responseCode == 200 || responseCode == 206) {
                                            if (this.mListener != null) {
                                                this.mListener.onNetReceiveHeaders(this, bdNetTask);
                                            }
                                            if (!download(bdNetTask)) {
                                                HttpURLConnection httpURLConnection2 = this.mConnection;
                                                if (httpURLConnection2 != null) {
                                                    httpURLConnection2.disconnect();
                                                }
                                                b bVar2 = this.mListener;
                                                if (bVar2 != null) {
                                                    bVar2.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                                }
                                                return 3;
                                            }
                                        } else {
                                            if (responseCode != 307) {
                                                if (responseCode != 404 && responseCode != 500 && responseCode != 502 && responseCode != 503) {
                                                    switch (responseCode) {
                                                        case 300:
                                                        case 301:
                                                        case 302:
                                                        case 303:
                                                            break;
                                                        case 304:
                                                            if (this.mListener != null) {
                                                                this.mListener.onNetReceiveHeaders(this, bdNetTask);
                                                                break;
                                                            }
                                                            break;
                                                        default:
                                                            if (this.mListener != null) {
                                                                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_UNKNOWN, responseCode);
                                                                break;
                                                            }
                                                            break;
                                                    }
                                                } else if (this.mListener != null) {
                                                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_HTTP, responseCode);
                                                }
                                            }
                                            if (this.mListener != null && this.mListener.onNetRedirect(this, bdNetTask, responseCode)) {
                                                if (redirect(bdNetTask)) {
                                                    HttpURLConnection httpURLConnection3 = this.mConnection;
                                                    if (httpURLConnection3 != null) {
                                                        httpURLConnection3.disconnect();
                                                    }
                                                    b bVar3 = this.mListener;
                                                    if (bVar3 != null) {
                                                        bVar3.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                                        return 2;
                                                    }
                                                    return 2;
                                                }
                                                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_REDIRECT, responseCode);
                                                HttpURLConnection httpURLConnection4 = this.mConnection;
                                                if (httpURLConnection4 != null) {
                                                    httpURLConnection4.disconnect();
                                                }
                                                b bVar4 = this.mListener;
                                                if (bVar4 != null) {
                                                    bVar4.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                                }
                                                return 3;
                                            }
                                        }
                                    }
                                }
                                HttpURLConnection httpURLConnection5 = this.mConnection;
                                if (httpURLConnection5 != null) {
                                    httpURLConnection5.disconnect();
                                }
                                b bVar5 = this.mListener;
                                if (bVar5 != null) {
                                    bVar5.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                }
                                return 1;
                            } catch (IllegalStateException unused) {
                                if (this.mListener != null) {
                                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                                }
                                HttpURLConnection httpURLConnection6 = this.mConnection;
                                if (httpURLConnection6 != null) {
                                    httpURLConnection6.disconnect();
                                }
                                b bVar6 = this.mListener;
                                if (bVar6 != null) {
                                    bVar6.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                }
                                return 3;
                            }
                        } catch (IOException unused2) {
                            if (this.mListener != null) {
                                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                            }
                            HttpURLConnection httpURLConnection7 = this.mConnection;
                            if (httpURLConnection7 != null) {
                                httpURLConnection7.disconnect();
                            }
                            b bVar7 = this.mListener;
                            if (bVar7 != null) {
                                bVar7.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                            }
                            return 3;
                        }
                    } catch (AssertionError unused3) {
                        if (this.mListener != null) {
                            this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_UNKNOWN, 0);
                        }
                        HttpURLConnection httpURLConnection8 = this.mConnection;
                        if (httpURLConnection8 != null) {
                            httpURLConnection8.disconnect();
                        }
                        b bVar8 = this.mListener;
                        if (bVar8 != null) {
                            bVar8.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                        }
                        return 3;
                    }
                } catch (MalformedURLException unused4) {
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_MALFORMEDURL, 0);
                    }
                    HttpURLConnection httpURLConnection9 = this.mConnection;
                    if (httpURLConnection9 != null) {
                        httpURLConnection9.disconnect();
                    }
                    b bVar9 = this.mListener;
                    if (bVar9 != null) {
                        bVar9.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                    }
                    return 3;
                } catch (Throwable unused5) {
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_UNKNOWN, 0);
                    }
                    HttpURLConnection httpURLConnection10 = this.mConnection;
                    if (httpURLConnection10 != null) {
                        httpURLConnection10.disconnect();
                    }
                    b bVar10 = this.mListener;
                    if (bVar10 != null) {
                        bVar10.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                    }
                    return 3;
                }
            } catch (SocketTimeoutException unused6) {
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_CONNECT_TIMEOUT, 0);
                }
                HttpURLConnection httpURLConnection11 = this.mConnection;
                if (httpURLConnection11 != null) {
                    httpURLConnection11.disconnect();
                }
                b bVar11 = this.mListener;
                if (bVar11 != null) {
                    bVar11.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                }
                return 3;
            } catch (Exception unused7) {
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_UNKNOWN, 0);
                }
                HttpURLConnection httpURLConnection12 = this.mConnection;
                if (httpURLConnection12 != null) {
                    httpURLConnection12.disconnect();
                }
                b bVar12 = this.mListener;
                if (bVar12 != null) {
                    bVar12.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                }
                return 3;
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection13 = this.mConnection;
            if (httpURLConnection13 != null) {
                httpURLConnection13.disconnect();
            }
            b bVar13 = this.mListener;
            if (bVar13 != null) {
                bVar13.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
            }
            throw th;
        }
    }

    public static List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public static int nidPP() {
        int i = sNid;
        sNid = i + 1;
        return i;
    }

    public static HttpURLConnection openConnection(URL url, SSLContext sSLContext, BdNetTask bdNetTask) throws IOException {
        if (!WebSettingsGlobalBlink.getCronetEnable()) {
            Log.w(LOG_TAG, "openConnection use system ".concat(String.valueOf(url)));
            return defaultOpenConnection(url, sSLContext, bdNetTask);
        }
        Log.w(LOG_TAG, "openConnection1 ".concat(String.valueOf(url)));
        HttpURLConnection openCornetConnection = openCornetConnection(url);
        return openCornetConnection != null ? openCornetConnection : defaultOpenConnection(url, sSLContext, bdNetTask);
    }

    public static HttpURLConnection openConnection(URL url, SSLContext sSLContext, Proxy proxy) throws IOException {
        if (!url.getProtocol().equals("https") || sSLContext == null) {
            return (HttpURLConnection) url.openConnection(proxy);
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection(proxy);
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.webkit.net.BdNetEngine.2
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                try {
                    X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
                    return BdNetEngine.verifyAsIpAddress(str) ? BdNetEngine.verifyIpAddress(str, x509Certificate) : BdNetEngine.verifyHostName(str, x509Certificate);
                } catch (Exception e) {
                    e.printStackTrace();
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
            }
        });
        return httpsURLConnection;
    }

    public static HttpURLConnection openCornetConnection(URL url) {
        if (url == null) {
            return null;
        }
        synchronized (mSelfLock) {
            Log.w(LOG_TAG, "openConnection2 ".concat(String.valueOf(url)));
            try {
                long currentTimeMillis = System.currentTimeMillis();
                while (true) {
                    if (WebSettingsGlobalBlink.getChromiunNetInit() || mFirstWait) {
                        break;
                    }
                    mSelfLock.wait(mWaitTime);
                    if (System.currentTimeMillis() - currentTimeMillis > mWaitTime - 1000) {
                        Log.w(LOG_TAG, "chromium timeout ");
                        break;
                    }
                    Log.w(LOG_TAG, "chromium init ok " + (System.currentTimeMillis() - currentTimeMillis));
                }
                mFirstWait = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (WebSettingsGlobalBlink.getChromiunNetInit()) {
            try {
                WebSettingsGlobalBlink.initCronet(WebSettingsGlobalBlink.getKernelContext());
                boolean useCronet = WebSettingsGlobalBlink.useCronet();
                Log.w(LOG_TAG, "[cronet] http_utils openConnection useChromiumNet ".concat(String.valueOf(useCronet)));
                Log.w(LOG_TAG, "[cronet] http_utils openConnection url ".concat(String.valueOf(url)));
                if (useCronet) {
                    HttpURLConnection httpUrlConnection = WebSettingsGlobalBlink.getHttpUrlConnection(url.toString());
                    if (httpUrlConnection != null) {
                        return httpUrlConnection;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            Log.w(LOG_TAG, "[cronet] openConnection not init ".concat(String.valueOf(url)));
        }
        return null;
    }

    private boolean redirect(BdNetTask bdNetTask) {
        String headerField = this.mConnection.getHeaderField("location");
        if (headerField != null) {
            String headerField2 = this.mConnection.getHeaderField(Headers.SET_COOKIE);
            if (headerField2 != null) {
                bdNetTask.addCookies(headerField2);
            }
            bdNetTask.setRedirect(true);
            bdNetTask.setRedirectUrl(headerField);
            return true;
        }
        return false;
    }

    private void setHttpResponseHeader(HttpURLConnection httpURLConnection, BdNetTask bdNetTask) {
        int i = 0;
        while (true) {
            String headerField = httpURLConnection.getHeaderField(i);
            if (headerField == null) {
                return;
            }
            bdNetTask.addResHeaders(httpURLConnection.getHeaderFieldKey(i), headerField);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopDownloadInner() {
        synchronized (this.mLock) {
            this.mIsRunning = false;
            if (this.mPrivateHandler != null) {
                this.mPrivateHandler.removeMessages(1);
                this.mPrivateHandler = null;
            }
            if (this.mNetTask != null) {
                this.mNetTask.stop();
            }
            if (this.mConnection != null) {
                this.mConnection.disconnect();
            }
            quit();
            this.mListener = null;
            com.baidu.webkit.net.a a2 = com.baidu.webkit.net.a.a();
            if (a2.b != null && !a2.b.isEmpty()) {
                a2.b.remove(this);
            }
        }
    }

    private boolean upload(BdNetTask bdNetTask) {
        byte[] content;
        DataOutputStream dataOutputStream;
        boolean z = false;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                try {
                    content = bdNetTask.getContent();
                    dataOutputStream = new DataOutputStream(this.mConnection.getOutputStream());
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.write(content);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (this.mIsRunning && !bdNetTask.isStop() && this.mListener != null) {
                this.mListener.onNetUploadData(this, bdNetTask, content.length, content.length);
                this.mListener.onNetUploadComplete(this, bdNetTask);
            }
            z = true;
            dataOutputStream.close();
        } catch (IOException unused3) {
            dataOutputStream2 = dataOutputStream;
            if (this.mListener != null) {
                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
            }
            if (dataOutputStream2 != null) {
                dataOutputStream2.close();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        return z;
    }

    public static boolean verifyAsIpAddress(String str) {
        return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
    }

    public static boolean verifyHostName(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (lowerCase.endsWith("shahe.baidu.com")) {
            lowerCase = lowerCase.replace("shahe.baidu.com", "cbs.baidu.com");
        }
        if (lowerCase.contains("*")) {
            if (lowerCase.startsWith(CertificatePinner.Pin.WILDCARD) && str.equals(lowerCase.substring(2))) {
                return true;
            }
            if (lowerCase.startsWith("*.*.") && str.endsWith(lowerCase.substring(4))) {
                return true;
            }
            int indexOf = lowerCase.indexOf(42);
            if (indexOf <= lowerCase.indexOf(46) && str.regionMatches(0, lowerCase, 0, indexOf)) {
                int i = indexOf + 1;
                int length = lowerCase.length() - i;
                int length2 = str.length() - length;
                return (str.indexOf(46, indexOf) >= length2 || str.endsWith(".clients.google.com")) && str.regionMatches(length2, lowerCase, i, length);
            }
            return false;
        }
        return str.equals(lowerCase);
    }

    public static boolean verifyHostName(String str, X509Certificate x509Certificate) throws Exception {
        String str2;
        String lowerCase = str.toLowerCase(Locale.US);
        boolean z = false;
        for (String str3 : getSubjectAltNames(x509Certificate, 2)) {
            if (verifyHostName(lowerCase, str3)) {
                return true;
            }
            z = true;
        }
        if (!z) {
            a aVar = new a(x509Certificate.getSubjectX500Principal());
            aVar.c = 0;
            aVar.d = 0;
            aVar.e = 0;
            aVar.f = 0;
            aVar.g = aVar.a.toCharArray();
            String a2 = aVar.a();
            String str4 = null;
            if (a2 != null) {
                do {
                    int i = aVar.c;
                    if (i != aVar.b) {
                        char c = aVar.g[i];
                        if (c != '\"') {
                            str2 = c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : aVar.c() : aVar.b();
                        } else {
                            int i2 = i + 1;
                            aVar.c = i2;
                            aVar.d = i2;
                            while (true) {
                                aVar.e = i2;
                                int i3 = aVar.c;
                                if (i3 == aVar.b) {
                                    throw new IllegalStateException("Unexpected end of DN: " + aVar.a);
                                }
                                char[] cArr = aVar.g;
                                if (cArr[i3] == '\"') {
                                    do {
                                        aVar.c = i3 + 1;
                                        i3 = aVar.c;
                                        if (i3 >= aVar.b) {
                                            break;
                                        }
                                    } while (aVar.g[i3] == ' ');
                                    char[] cArr2 = aVar.g;
                                    int i4 = aVar.d;
                                    str2 = new String(cArr2, i4, aVar.e - i4);
                                } else {
                                    if (cArr[i3] == '\\') {
                                        cArr[aVar.e] = aVar.d();
                                    } else {
                                        cArr[aVar.e] = cArr[i3];
                                    }
                                    aVar.c++;
                                    i2 = aVar.e + 1;
                                }
                            }
                        }
                        if ("cn".equalsIgnoreCase(a2)) {
                            str4 = str2;
                        } else {
                            int i5 = aVar.c;
                            if (i5 < aVar.b) {
                                if (aVar.g[i5] != '+') {
                                    throw new IllegalStateException("Malformed DN: " + aVar.a);
                                }
                                aVar.c = i5 + 1;
                                a2 = aVar.a();
                            }
                        }
                    }
                } while (a2 != null);
                throw new IllegalStateException("Malformed DN: " + aVar.a);
            }
            if (str4 != null) {
                return verifyHostName(lowerCase, str4);
            }
        }
        return false;
    }

    public static boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        for (String str2 : getSubjectAltNames(x509Certificate, 7)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public void allocate() {
        this.mIsRecycle = false;
    }

    public BdNetTask getNetTask() {
        return this.mNetTask;
    }

    public boolean isRecycle() {
        return this.mIsRecycle;
    }

    public boolean isWorking() {
        return this.mIsWorking;
    }

    @Override // android.os.HandlerThread
    @SuppressLint({"HandlerLeak"})
    public void onLooperPrepared() {
        synchronized (this.mLock) {
            if (this.mPrivateHandler == null) {
                this.mPrivateHandler = new Handler(getLooper()) { // from class: com.baidu.webkit.net.BdNetEngine.3
                    @Override // android.os.Handler
                    public final void handleMessage(Message message) {
                        int i = message.what;
                        if (i != 1) {
                            if (i != 2) {
                                return;
                            }
                            BdNetEngine.this.stopDownloadInner();
                            return;
                        }
                        BdNetEngine.this.mIsWorking = true;
                        BdNetEngine bdNetEngine = BdNetEngine.this;
                        bdNetEngine.mNetTask = bdNetEngine.performTask((BdNetTask) message.obj);
                        if (BdNetEngine.this.mNetTask == null) {
                            BdNetEngine.this.recycle();
                        } else {
                            BdNetEngine.this.mPrivateHandler.obtainMessage(1, BdNetEngine.this.mNetTask).sendToTarget();
                        }
                        BdNetEngine.this.mIsWorking = false;
                    }
                };
            }
            if (this.mIsWorking) {
                this.mPrivateHandler.obtainMessage(1, this.mNetTask).sendToTarget();
            }
        }
    }

    public BdNetTask performTask(BdNetTask bdNetTask) {
        try {
            try {
                int excuteTask = excuteTask(bdNetTask);
                if (!this.mIsRunning) {
                    if (this.mListener != null && excuteTask != 3) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_RUN_STOP, 0);
                    }
                    return null;
                } else if (excuteTask != 1 || this.mListener == null) {
                    if (excuteTask == 2) {
                        return bdNetTask;
                    }
                    if (excuteTask != 3 || this.mListener == null) {
                        return null;
                    }
                    return this.mListener.onNetDownloadComplete(this, bdNetTask, false);
                } else {
                    return this.mListener.onNetDownloadComplete(this, bdNetTask, true);
                }
            } catch (Exception unused) {
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_RUN_EXCEPTION, 0);
                }
                return null;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public void recycle() {
        this.mIsRecycle = true;
        this.mListener = null;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            super.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCmwap(boolean z) {
        this.mIsCmwap = z;
    }

    public void setEventListener(b bVar) {
        this.mListener = bVar;
    }

    public void setProxyPort(int i) {
        this.mProxyPort = i;
    }

    public void setProxyUrl(String str) {
        this.mProxyUrl = str;
    }

    public void startDownload(BdNetTask bdNetTask) throws Exception {
        synchronized (this.mLock) {
            try {
                if (bdNetTask == null) {
                    throw new NullPointerException();
                }
                if (!isAlive()) {
                    this.mIsRunning = true;
                    this.mIsWorking = true;
                    this.mNetTask = bdNetTask;
                    try {
                        if (getLooper() != null) {
                            onLooperPrepared();
                        } else {
                            start();
                        }
                    } catch (IllegalThreadStateException e) {
                        this.mIsRunning = false;
                        this.mIsWorking = false;
                        this.mNetTask = null;
                        throw e;
                    }
                } else if (!this.mIsRunning) {
                    throw new IllegalThreadStateException("NetEngine is stopped!");
                } else {
                    if (this.mIsWorking) {
                        throw new IllegalThreadStateException("NetEngine is working!");
                    }
                    this.mIsWorking = true;
                    this.mNetTask = bdNetTask;
                    this.mPrivateHandler.obtainMessage(1, bdNetTask).sendToTarget();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void stopDownload() {
        synchronized (this.mLock) {
            if (this.mPrivateHandler != null) {
                this.mPrivateHandler.obtainMessage(2).sendToTarget();
            }
        }
    }
}
