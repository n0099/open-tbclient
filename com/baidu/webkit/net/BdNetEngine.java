package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.net.http.Headers;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.sdk.Log;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
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
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.security.auth.x500.X500Principal;
import org.apache.http.cookie.SM;
/* loaded from: classes9.dex */
public class BdNetEngine extends HandlerThread implements INoProGuard {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    private static final String CER_FILE_NAME = "server_test.crt";
    private static final String CRONET_ENGINE_BRIDGE = "org.chromium.net.CronetEngineBridge";
    private static final boolean DEBUG = false;
    public static final int DEFAULT_PROXY_PORT = 80;
    public static final int EXCUTE_TASK_ERROR = 3;
    public static final int EXCUTE_TASK_REDIRECT = 2;
    public static final int EXCUTE_TASK_SUCCESS = 1;
    private static final String HTTPS_SERVER_HOST = "cq01-mic-shahe-1.epc.baidu.com";
    private static final String LOG_TAG = "BdNetEngine";
    public static final int MESSAGE_EXCUTE_TASK = 1;
    public static final int MESSAGE_STOP_ENGINE = 2;
    public static final String URI_PROXY_CMWAP = "10.0.0.172";
    public static final String URI_PROXY_CTWAP = "10.0.0.200";
    private static boolean sUsingChromiumNet;
    private HttpURLConnection mConnection;
    private boolean mIsCmwap;
    private volatile boolean mIsRecycle;
    private volatile boolean mIsRunning;
    private volatile boolean mIsWorking;
    private b mListener;
    private final Object mLock;
    private BdNetTask mNetTask;
    private Handler mPrivateHandler;
    private int mProxyPort;
    private String mProxyUrl;
    private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    private static int sNid = 0;
    public static Object mSelfLock = new Object();
    private static boolean mFirstWait = false;
    private static long mWaitTime = 10000;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class a {
        final String a;
        final int b;
        int c;
        int d;
        int e;
        int f;
        char[] g;

        public a(X500Principal x500Principal) {
            this.a = x500Principal.getName("RFC2253");
            this.b = this.a.length();
        }

        private int a(int i) {
            int i2;
            int i3;
            if (i + 1 >= this.b) {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            char c = this.g[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i2 = c - '7';
            }
            char c2 = this.g[i + 1];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }

        private char e() {
            int i;
            int i2;
            int a = a(this.c);
            this.c++;
            if (a < 128) {
                return (char) a;
            }
            if (a < 192 || a > 247) {
                return '?';
            }
            if (a <= 223) {
                i = 1;
                i2 = a & 31;
            } else if (a <= 239) {
                i = 2;
                i2 = a & 15;
            } else {
                i = 3;
                i2 = a & 7;
            }
            int i3 = i2;
            for (int i4 = 0; i4 < i; i4++) {
                this.c++;
                if (this.c == this.b || this.g[this.c] != '\\') {
                    return '?';
                }
                this.c++;
                int a2 = a(this.c);
                this.c++;
                if ((a2 & DownloadConstants.STATUS_RUNNING) != 128) {
                    return '?';
                }
                i3 = (i3 << 6) + (a2 & 63);
            }
            return (char) i3;
        }

        final String a() {
            while (this.c < this.b && this.g[this.c] == ' ') {
                this.c++;
            }
            if (this.c == this.b) {
                return null;
            }
            this.d = this.c;
            this.c++;
            while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] != ' ') {
                this.c++;
            }
            if (this.c >= this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            this.e = this.c;
            if (this.g[this.c] == ' ') {
                while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] == ' ') {
                    this.c++;
                }
                if (this.g[this.c] != '=' || this.c == this.b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.a);
                }
            }
            do {
                this.c++;
                if (this.c >= this.b) {
                    break;
                }
            } while (this.g[this.c] == ' ');
            if (this.e - this.d > 4 && this.g[this.d + 3] == '.' && ((this.g[this.d] == 'O' || this.g[this.d] == 'o') && ((this.g[this.d + 1] == 'I' || this.g[this.d + 1] == 'i') && (this.g[this.d + 2] == 'D' || this.g[this.d + 2] == 'd')))) {
                this.d += 4;
            }
            return new String(this.g, this.d, this.e - this.d);
        }

        final String b() {
            int i;
            if (this.c + 4 >= this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            this.d = this.c;
            this.c++;
            while (this.c != this.b && this.g[this.c] != '+' && this.g[this.c] != ',' && this.g[this.c] != ';') {
                if (this.g[this.c] == ' ') {
                    this.e = this.c;
                    this.c++;
                    while (this.c < this.b && this.g[this.c] == ' ') {
                        this.c++;
                    }
                    i = this.e - this.d;
                    if (i >= 5 || (i & 1) == 0) {
                        throw new IllegalStateException("Unexpected end of DN: " + this.a);
                    }
                    byte[] bArr = new byte[i / 2];
                    int i2 = this.d + 1;
                    for (int i3 = 0; i3 < bArr.length; i3++) {
                        bArr[i3] = (byte) a(i2);
                        i2 += 2;
                    }
                    return new String(this.g, this.d, i);
                }
                if (this.g[this.c] >= 'A' && this.g[this.c] <= 'F') {
                    char[] cArr = this.g;
                    int i4 = this.c;
                    cArr[i4] = (char) (cArr[i4] + ' ');
                }
                this.c++;
            }
            this.e = this.c;
            i = this.e - this.d;
            if (i >= 5) {
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }

        final String c() {
            this.d = this.c;
            this.e = this.c;
            while (this.c < this.b) {
                switch (this.g[this.c]) {
                    case ' ':
                        this.f = this.e;
                        this.c++;
                        char[] cArr = this.g;
                        int i = this.e;
                        this.e = i + 1;
                        cArr[i] = ' ';
                        while (this.c < this.b && this.g[this.c] == ' ') {
                            char[] cArr2 = this.g;
                            int i2 = this.e;
                            this.e = i2 + 1;
                            cArr2[i2] = ' ';
                            this.c++;
                        }
                        if (this.c != this.b && this.g[this.c] != ',' && this.g[this.c] != '+' && this.g[this.c] != ';') {
                            break;
                        } else {
                            return new String(this.g, this.d, this.f - this.d);
                        }
                    case '+':
                    case ',':
                    case ';':
                        return new String(this.g, this.d, this.e - this.d);
                    case '\\':
                        char[] cArr3 = this.g;
                        int i3 = this.e;
                        this.e = i3 + 1;
                        cArr3[i3] = d();
                        this.c++;
                        break;
                    default:
                        char[] cArr4 = this.g;
                        int i4 = this.e;
                        this.e = i4 + 1;
                        cArr4[i4] = this.g[this.c];
                        this.c++;
                        break;
                }
            }
            return new String(this.g, this.d, this.e - this.d);
        }

        final char d() {
            this.c++;
            if (this.c == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            switch (this.g[this.c]) {
                case ' ':
                case '\"':
                case '#':
                case '%':
                case '*':
                case '+':
                case ',':
                case ';':
                case '<':
                case '=':
                case '>':
                case '\\':
                case '_':
                    return this.g[this.c];
                default:
                    return e();
            }
        }
    }

    /* loaded from: classes9.dex */
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
            stringBuffer.append(ETAG.EQUAL);
            stringBuffer.append(entry2.getValue().trim());
            stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
            this.mConnection.addRequestProperty(SM.COOKIE, stringBuffer.toString());
        }
        String refer = bdNetTask.getRefer();
        if (refer != null) {
            this.mConnection.addRequestProperty("Referer", refer);
        }
    }

    private URL convertToCmwapUrl(URL url) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("http://");
            stringBuffer.append(URI_PROXY_CMWAP);
            String file = url.getFile();
            if (!TextUtils.isEmpty(file)) {
                stringBuffer.append(file);
            }
            String ref = url.getRef();
            if (!TextUtils.isEmpty(ref)) {
                stringBuffer.append("#");
                stringBuffer.append(ref);
            }
            return new URL(stringBuffer.toString());
        } catch (Exception e) {
            if (0 == 0) {
                try {
                    return new URL("http://10.0.0.172");
                } catch (Exception e2) {
                    return url;
                }
            }
            return null;
        } catch (Throwable th) {
            if (0 == 0) {
                try {
                    new URL("http://10.0.0.172");
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    private static HttpURLConnection defaultOpenConnection(URL url, SSLContext sSLContext, BdNetTask bdNetTask) throws IOException {
        bdNetTask.setIsUseCorenet(false);
        if (url.getProtocol().equals("https")) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setHostnameVerifier(new com.baidu.webkit.net.b());
            return httpsURLConnection;
        }
        return (HttpURLConnection) url.openConnection();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0057 A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #10 {all -> 0x00b9, blocks: (B:28:0x0053, B:30:0x0057), top: B:100:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    try {
                        if (this.mIsRunning && !bdNetTask.isStop()) {
                            byte[] bArr = new byte[4096];
                            String headerField = this.mConnection.getHeaderField("Content-Encoding");
                            if (headerField != null && headerField.contains("gzip")) {
                                GZIPInputStream gZIPInputStream3 = new GZIPInputStream(inputStream);
                                while (true) {
                                    try {
                                        int read = gZIPInputStream3.read(bArr);
                                        if (read == -1 || !this.mIsRunning || bdNetTask.isStop()) {
                                            break;
                                        } else if (this.mListener != null) {
                                            this.mListener.onNetReceiveData(this, bdNetTask, bArr, read);
                                        }
                                    } catch (IOException e) {
                                        gZIPInputStream = gZIPInputStream3;
                                        gZIPInputStream2 = inputStream;
                                        try {
                                            if (this.mListener != null) {
                                            }
                                            if (gZIPInputStream != null) {
                                            }
                                            if (gZIPInputStream2 != null) {
                                            }
                                            return false;
                                        } catch (Throwable th) {
                                            inputStream = gZIPInputStream2;
                                            gZIPInputStream2 = gZIPInputStream;
                                            th = th;
                                            if (gZIPInputStream2 != null) {
                                                try {
                                                    gZIPInputStream2.close();
                                                } catch (IOException e2) {
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e3) {
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        gZIPInputStream2 = gZIPInputStream3;
                                        if (gZIPInputStream2 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        throw th;
                                    }
                                }
                                gZIPInputStream3.close();
                                gZIPInputStream2 = gZIPInputStream3;
                            } else {
                                while (true) {
                                    int read2 = inputStream.read(bArr);
                                    if (read2 != -1 && this.mIsRunning && !bdNetTask.isStop()) {
                                        if (this.mListener != null) {
                                            this.mListener.onNetReceiveData(this, bdNetTask, bArr, read2);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e4) {
                        gZIPInputStream = null;
                        gZIPInputStream2 = inputStream;
                    }
                    try {
                        inputStream.close();
                        break;
                    } catch (IOException e5) {
                        gZIPInputStream = gZIPInputStream2;
                        gZIPInputStream2 = inputStream;
                        if (this.mListener != null) {
                            this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (gZIPInputStream2 != null) {
                            try {
                                gZIPInputStream2.close();
                            } catch (IOException e7) {
                            }
                        }
                        return false;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (IOException e8) {
                }
            }
            if (inputStream != 0) {
                try {
                    inputStream.close();
                    return true;
                } catch (IOException e9) {
                    return true;
                }
            }
            return true;
        } catch (IOException e10) {
            gZIPInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, SGET, INVOKE, IF, IGET, IGET, INVOKE, IGET, SGET, INVOKE, IF, IGET, IF] complete} */
    private int excuteTask(BdNetTask bdNetTask) {
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
                                }
                                addHeaders(bdNetTask);
                                if (this.mListener != null) {
                                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_CONNECT_START, 0);
                                }
                                if (bdNetTask.getMethod() == BdNet.HttpMethod.METHOD_POST && !upload(bdNetTask)) {
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
                                    switch (responseCode) {
                                        case 200:
                                        case 206:
                                            if (this.mListener != null) {
                                                this.mListener.onNetReceiveHeaders(this, bdNetTask);
                                            }
                                            if (!download(bdNetTask)) {
                                                if (this.mConnection != null) {
                                                    this.mConnection.disconnect();
                                                }
                                                if (this.mListener != null) {
                                                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                                    return 3;
                                                }
                                                return 3;
                                            }
                                            break;
                                        case 300:
                                        case 301:
                                        case 302:
                                        case 303:
                                        case 307:
                                            if (this.mListener != null && this.mListener.onNetRedirect(this, bdNetTask, responseCode)) {
                                                if (redirect(bdNetTask)) {
                                                    if (this.mConnection != null) {
                                                        this.mConnection.disconnect();
                                                    }
                                                    if (this.mListener != null) {
                                                        this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                                    }
                                                    return 2;
                                                }
                                                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_REDIRECT, responseCode);
                                                if (this.mConnection != null) {
                                                    this.mConnection.disconnect();
                                                }
                                                if (this.mListener != null) {
                                                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                                    return 3;
                                                }
                                                return 3;
                                            }
                                            break;
                                        case 304:
                                            if (this.mListener != null) {
                                                this.mListener.onNetReceiveHeaders(this, bdNetTask);
                                                break;
                                            }
                                            break;
                                        case 404:
                                        case 500:
                                        case 502:
                                        case 503:
                                            if (this.mListener != null) {
                                                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_HTTP, responseCode);
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
                                }
                            }
                            if (this.mConnection != null) {
                                this.mConnection.disconnect();
                            }
                            if (this.mListener != null) {
                                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                            }
                            return 1;
                        } catch (SocketTimeoutException e) {
                            if (this.mListener != null) {
                                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_CONNECT_TIMEOUT, 0);
                            }
                            if (this.mConnection != null) {
                                this.mConnection.disconnect();
                            }
                            if (this.mListener != null) {
                                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                                return 3;
                            }
                            return 3;
                        }
                    } catch (Exception e2) {
                        if (this.mListener != null) {
                            this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_UNKNOWN, 0);
                        }
                        if (this.mConnection != null) {
                            this.mConnection.disconnect();
                        }
                        if (this.mListener != null) {
                            this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                            return 3;
                        }
                        return 3;
                    }
                } catch (IOException e3) {
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                    }
                    if (this.mConnection != null) {
                        this.mConnection.disconnect();
                    }
                    if (this.mListener != null) {
                        this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                        return 3;
                    }
                    return 3;
                } catch (IllegalStateException e4) {
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                    }
                    if (this.mConnection != null) {
                        this.mConnection.disconnect();
                    }
                    if (this.mListener != null) {
                        this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                        return 3;
                    }
                    return 3;
                }
            } catch (AssertionError e5) {
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_UNKNOWN, 0);
                }
                if (this.mConnection != null) {
                    this.mConnection.disconnect();
                }
                if (this.mListener != null) {
                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                    return 3;
                }
                return 3;
            } catch (MalformedURLException e6) {
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_MALFORMEDURL, 0);
                }
                if (this.mConnection != null) {
                    this.mConnection.disconnect();
                }
                if (this.mListener != null) {
                    this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
                    return 3;
                }
                return 3;
            }
        } finally {
            if (this.mConnection != null) {
                this.mConnection.disconnect();
            }
            if (this.mListener != null) {
                this.mListener.onNetStateChanged(this, bdNetTask, BdNet.NetState.STATE_DISCONNECT, 0);
            }
        }
    }

    private static List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
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
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    private static int nidPP() {
        int i = sNid;
        sNid = i + 1;
        return i;
    }

    private static HttpURLConnection openConnection(URL url, SSLContext sSLContext, BdNetTask bdNetTask) throws IOException {
        if (!WebSettingsGlobalBlink.getCronetEnable()) {
            Log.w(LOG_TAG, "openConnection use system " + url);
            return defaultOpenConnection(url, sSLContext, bdNetTask);
        }
        Log.w(LOG_TAG, "openConnection1 " + url);
        HttpURLConnection openCornetConnection = openCornetConnection(url);
        return openCornetConnection == null ? defaultOpenConnection(url, sSLContext, bdNetTask) : openCornetConnection;
    }

    private static HttpURLConnection openConnection(URL url, SSLContext sSLContext, Proxy proxy) throws IOException {
        if (!url.getProtocol().equals("https") || sSLContext == null) {
            return (HttpURLConnection) url.openConnection(proxy);
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection(proxy);
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new c());
        return httpsURLConnection;
    }

    public static HttpURLConnection openCornetConnection(URL url) {
        if (url == null) {
            return null;
        }
        synchronized (mSelfLock) {
            Log.w(LOG_TAG, "openConnection2 " + url);
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
                com.a.a.a.a.a.a.a.a(e);
            }
        }
        if (!WebSettingsGlobalBlink.getChromiunNetInit()) {
            Log.w(LOG_TAG, "[cronet] openConnection not init " + url);
            return null;
        }
        try {
            WebSettingsGlobalBlink.initCronet(WebSettingsGlobalBlink.getKernelContext());
            boolean useCronet = WebSettingsGlobalBlink.useCronet();
            Log.w(LOG_TAG, "[cronet] http_utils openConnection useChromiumNet " + useCronet);
            Log.w(LOG_TAG, "[cronet] http_utils openConnection url " + url);
            if (useCronet) {
                HttpURLConnection httpUrlConnection = WebSettingsGlobalBlink.getHttpUrlConnection(url.toString());
                if (httpUrlConnection != null) {
                    return httpUrlConnection;
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            com.a.a.a.a.a.a.a.a(e2);
            return null;
        }
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
            e a2 = e.a();
            if (a2.b != null && !a2.b.isEmpty()) {
                a2.b.remove(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean upload(BdNetTask bdNetTask) {
        DataOutputStream dataOutputStream;
        boolean z = false;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                byte[] content = bdNetTask.getContent();
                dataOutputStream = new DataOutputStream(this.mConnection.getOutputStream());
                try {
                    dataOutputStream.write(content);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (this.mIsRunning && !bdNetTask.isStop() && this.mListener != null) {
                        this.mListener.onNetUploadData(this, bdNetTask, content.length, content.length);
                        this.mListener.onNetUploadComplete(this, bdNetTask);
                    }
                    z = true;
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                    }
                } catch (IOException e2) {
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return z;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            dataOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            if (lowerCase.startsWith("*.") && str.equals(lowerCase.substring(2))) {
                return true;
            }
            if (lowerCase.startsWith("*.*.") && str.endsWith(lowerCase.substring(4))) {
                return true;
            }
            int indexOf = lowerCase.indexOf(42);
            if (indexOf <= lowerCase.indexOf(46) && str.regionMatches(0, lowerCase, 0, indexOf)) {
                int length = lowerCase.length() - (indexOf + 1);
                int length2 = str.length() - length;
                if ((str.indexOf(46, indexOf) >= length2 || str.endsWith(".clients.google.com")) && str.regionMatches(length2, lowerCase, indexOf + 1, length)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return str.equals(lowerCase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean verifyHostName(String str, X509Certificate x509Certificate) {
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
            if (a2 != null) {
                do {
                    str2 = "";
                    if (aVar.c == aVar.b) {
                        str2 = null;
                    } else {
                        switch (aVar.g[aVar.c]) {
                            case '\"':
                                aVar.c++;
                                aVar.d = aVar.c;
                                aVar.e = aVar.d;
                                while (aVar.c != aVar.b) {
                                    if (aVar.g[aVar.c] == '\"') {
                                        aVar.c++;
                                        while (aVar.c < aVar.b && aVar.g[aVar.c] == ' ') {
                                            aVar.c++;
                                        }
                                        str2 = new String(aVar.g, aVar.d, aVar.e - aVar.d);
                                        break;
                                    } else {
                                        if (aVar.g[aVar.c] == '\\') {
                                            aVar.g[aVar.e] = aVar.d();
                                        } else {
                                            aVar.g[aVar.e] = aVar.g[aVar.c];
                                        }
                                        aVar.c++;
                                        aVar.e++;
                                    }
                                }
                                throw new IllegalStateException("Unexpected end of DN: " + aVar.a);
                            case '#':
                                str2 = aVar.b();
                                break;
                            case '+':
                            case ',':
                            case ';':
                                break;
                            default:
                                str2 = aVar.c();
                                break;
                        }
                        if (!AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(a2)) {
                            if (aVar.c >= aVar.b) {
                                str2 = null;
                            } else if (aVar.g[aVar.c] != '+') {
                                throw new IllegalStateException("Malformed DN: " + aVar.a);
                            } else {
                                aVar.c++;
                                a2 = aVar.a();
                            }
                        }
                    }
                } while (a2 != null);
                throw new IllegalStateException("Malformed DN: " + aVar.a);
            }
            str2 = null;
            if (str2 != null) {
                return verifyHostName(lowerCase, str2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        for (String str2 : getSubjectAltNames(x509Certificate, 7)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void allocate() {
        this.mIsRecycle = false;
    }

    public BdNetTask getNetTask() {
        return this.mNetTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isRecycle() {
        return this.mIsRecycle;
    }

    public boolean isWorking() {
        return this.mIsWorking;
    }

    @Override // android.os.HandlerThread
    @SuppressLint({"HandlerLeak"})
    protected void onLooperPrepared() {
        synchronized (this.mLock) {
            if (this.mPrivateHandler == null) {
                this.mPrivateHandler = new d(this, getLooper());
            }
            if (this.mIsWorking) {
                this.mPrivateHandler.obtainMessage(1, this.mNetTask).sendToTarget();
            }
        }
    }

    public BdNetTask performTask(BdNetTask bdNetTask) {
        try {
            int excuteTask = excuteTask(bdNetTask);
            if (!this.mIsRunning) {
                if (this.mListener != null && excuteTask != 3) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_RUN_STOP, 0);
                }
                return null;
            } else if (excuteTask != 1 || this.mListener == null) {
                if (excuteTask != 2) {
                    if (excuteTask != 3 || this.mListener == null) {
                        return null;
                    }
                    return this.mListener.onNetDownloadComplete(this, bdNetTask, false);
                }
                return bdNetTask;
            } else {
                return this.mListener.onNetDownloadComplete(this, bdNetTask, true);
            }
        } catch (Exception e) {
            try {
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_RUN_EXCEPTION, 0);
                }
            } catch (Exception e2) {
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycle() {
        this.mIsRecycle = true;
        this.mListener = null;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            super.run();
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
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

    public void startDownload(BdNetTask bdNetTask) {
        synchronized (this.mLock) {
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
                this.mPrivateHandler.obtainMessage(1, this.mNetTask).sendToTarget();
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
