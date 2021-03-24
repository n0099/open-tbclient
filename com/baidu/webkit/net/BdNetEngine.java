package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.net.http.Headers;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.security.auth.x500.X500Principal;
import okhttp3.CertificatePinner;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f27030a;

        /* renamed from: b  reason: collision with root package name */
        public final int f27031b;

        /* renamed from: c  reason: collision with root package name */
        public int f27032c;

        /* renamed from: d  reason: collision with root package name */
        public int f27033d;

        /* renamed from: e  reason: collision with root package name */
        public int f27034e;

        /* renamed from: f  reason: collision with root package name */
        public int f27035f;

        /* renamed from: g  reason: collision with root package name */
        public char[] f27036g;

        public a(X500Principal x500Principal) {
            String name = x500Principal.getName("RFC2253");
            this.f27030a = name;
            this.f27031b = name.length();
        }

        private int a(int i) {
            int i2;
            int i3;
            int i4 = i + 1;
            if (i4 >= this.f27031b) {
                throw new IllegalStateException("Malformed DN: " + this.f27030a);
            }
            char c2 = this.f27036g[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f27030a);
            } else {
                i2 = c2 - '7';
            }
            char c3 = this.f27036g[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f27030a);
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }

        private char e() {
            int i;
            int i2;
            int a2 = a(this.f27032c);
            this.f27032c++;
            if (a2 < 128) {
                return (char) a2;
            }
            if (a2 < 192 || a2 > 247) {
                return '?';
            }
            if (a2 <= 223) {
                i2 = a2 & 31;
                i = 1;
            } else if (a2 <= 239) {
                i = 2;
                i2 = a2 & 15;
            } else {
                i = 3;
                i2 = a2 & 7;
            }
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = this.f27032c + 1;
                this.f27032c = i4;
                if (i4 == this.f27031b || this.f27036g[i4] != '\\') {
                    return '?';
                }
                int i5 = i4 + 1;
                this.f27032c = i5;
                int a3 = a(i5);
                this.f27032c++;
                if ((a3 & 192) != 128) {
                    return '?';
                }
                i2 = (i2 << 6) + (a3 & 63);
            }
            return (char) i2;
        }

        public final String a() {
            int i;
            char[] cArr;
            while (true) {
                int i2 = this.f27032c;
                if (i2 >= this.f27031b || this.f27036g[i2] != ' ') {
                    break;
                }
                this.f27032c = i2 + 1;
            }
            int i3 = this.f27032c;
            if (i3 == this.f27031b) {
                return null;
            }
            this.f27033d = i3;
            do {
                this.f27032c = i3 + 1;
                i3 = this.f27032c;
                if (i3 >= this.f27031b) {
                    break;
                }
                cArr = this.f27036g;
                if (cArr[i3] == '=') {
                    break;
                }
            } while (cArr[i3] != ' ');
            int i4 = this.f27032c;
            if (i4 >= this.f27031b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f27030a);
            }
            this.f27034e = i4;
            if (this.f27036g[i4] == ' ') {
                while (true) {
                    int i5 = this.f27032c;
                    if (i5 >= this.f27031b) {
                        break;
                    }
                    char[] cArr2 = this.f27036g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f27032c = i5 + 1;
                }
                char[] cArr3 = this.f27036g;
                int i6 = this.f27032c;
                if (cArr3[i6] != '=' || i6 == this.f27031b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f27030a);
                }
            }
            do {
                i = this.f27032c + 1;
                this.f27032c = i;
                if (i >= this.f27031b) {
                    break;
                }
            } while (this.f27036g[i] == ' ');
            int i7 = this.f27034e;
            int i8 = this.f27033d;
            if (i7 - i8 > 4) {
                char[] cArr4 = this.f27036g;
                if (cArr4[i8 + 3] == '.' && (cArr4[i8] == 'O' || cArr4[i8] == 'o')) {
                    char[] cArr5 = this.f27036g;
                    int i9 = this.f27033d;
                    if (cArr5[i9 + 1] == 'I' || cArr5[i9 + 1] == 'i') {
                        char[] cArr6 = this.f27036g;
                        int i10 = this.f27033d;
                        if (cArr6[i10 + 2] == 'D' || cArr6[i10 + 2] == 'd') {
                            this.f27033d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f27036g;
            int i11 = this.f27033d;
            return new String(cArr7, i11, this.f27034e - i11);
        }

        public final String b() {
            int i = this.f27032c;
            if (i + 4 >= this.f27031b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f27030a);
            }
            this.f27033d = i;
            while (true) {
                this.f27032c = i + 1;
                int i2 = this.f27032c;
                if (i2 == this.f27031b) {
                    break;
                }
                char[] cArr = this.f27036g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f27034e = i2;
                    do {
                        this.f27032c = i2 + 1;
                        i2 = this.f27032c;
                        if (i2 >= this.f27031b) {
                            break;
                        }
                    } while (this.f27036g[i2] == ' ');
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    i = this.f27032c;
                }
            }
            this.f27034e = this.f27032c;
            int i3 = this.f27034e;
            int i4 = this.f27033d;
            int i5 = i3 - i4;
            if (i5 < 5 || (i5 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f27030a);
            }
            int i6 = i5 / 2;
            byte[] bArr = new byte[i6];
            int i7 = i4 + 1;
            for (int i8 = 0; i8 < i6; i8++) {
                bArr[i8] = (byte) a(i7);
                i7 += 2;
            }
            return new String(this.f27036g, this.f27033d, i5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
            return new java.lang.String(r1, r2, r8.f27035f - r2);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String c() {
            int i = this.f27032c;
            this.f27033d = i;
            this.f27034e = i;
            while (true) {
                int i2 = this.f27032c;
                if (i2 < this.f27031b) {
                    char[] cArr = this.f27036g;
                    char c2 = cArr[i2];
                    if (c2 == ' ') {
                        int i3 = this.f27034e;
                        this.f27035f = i3;
                        this.f27032c = i2 + 1;
                        this.f27034e = i3 + 1;
                        cArr[i3] = ' ';
                        while (true) {
                            int i4 = this.f27032c;
                            if (i4 >= this.f27031b) {
                                break;
                            }
                            char[] cArr2 = this.f27036g;
                            if (cArr2[i4] != ' ') {
                                break;
                            }
                            int i5 = this.f27034e;
                            this.f27034e = i5 + 1;
                            cArr2[i5] = ' ';
                            this.f27032c = i4 + 1;
                        }
                        int i6 = this.f27032c;
                        if (i6 == this.f27031b) {
                            break;
                        }
                        char[] cArr3 = this.f27036g;
                        if (cArr3[i6] == ',' || cArr3[i6] == '+' || cArr3[i6] == ';') {
                            break;
                        }
                    } else if (c2 == ';') {
                        break;
                    } else {
                        if (c2 == '\\') {
                            int i7 = this.f27034e;
                            this.f27034e = i7 + 1;
                            cArr[i7] = d();
                            i2 = this.f27032c;
                        } else if (c2 == '+' || c2 == ',') {
                            break;
                        } else {
                            int i8 = this.f27034e;
                            this.f27034e = i8 + 1;
                            cArr[i8] = cArr[i2];
                        }
                        this.f27032c = i2 + 1;
                    }
                } else {
                    char[] cArr4 = this.f27036g;
                    int i9 = this.f27033d;
                    return new String(cArr4, i9, this.f27034e - i9);
                }
            }
            char[] cArr5 = this.f27036g;
            int i10 = this.f27033d;
            return new String(cArr5, i10, this.f27034e - i10);
        }

        public final char d() {
            int i = this.f27032c + 1;
            this.f27032c = i;
            if (i == this.f27031b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f27030a);
            }
            char c2 = this.f27036g[i];
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
                                return e();
                        }
                }
            }
            return this.f27036g[this.f27032c];
        }
    }

    /* loaded from: classes5.dex */
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
            stringBuffer.append(";");
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
            httpsURLConnection.setHostnameVerifier(new com.baidu.webkit.net.b());
            return httpsURLConnection;
        }
        return (HttpURLConnection) openConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                        if (!(headerField != null && headerField.contains(AsyncHttpClient.ENCODING_GZIP))) {
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
            Log.w(LOG_TAG, "openConnection use system " + url);
            return defaultOpenConnection(url, sSLContext, bdNetTask);
        }
        Log.w(LOG_TAG, "openConnection1 " + url);
        HttpURLConnection openCornetConnection = openCornetConnection(url);
        return openCornetConnection != null ? openCornetConnection : defaultOpenConnection(url, sSLContext, bdNetTask);
    }

    public static HttpURLConnection openConnection(URL url, SSLContext sSLContext, Proxy proxy) throws IOException {
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (WebSettingsGlobalBlink.getChromiunNetInit()) {
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
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else {
            Log.w(LOG_TAG, "[cronet] openConnection not init " + url);
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
            e a2 = e.a();
            if (a2.f27049b != null && !a2.f27049b.isEmpty()) {
                a2.f27049b.remove(this);
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
            aVar.f27032c = 0;
            aVar.f27033d = 0;
            aVar.f27034e = 0;
            aVar.f27035f = 0;
            aVar.f27036g = aVar.f27030a.toCharArray();
            String a2 = aVar.a();
            String str4 = null;
            if (a2 != null) {
                do {
                    int i = aVar.f27032c;
                    if (i != aVar.f27031b) {
                        char c2 = aVar.f27036g[i];
                        if (c2 != '\"') {
                            str2 = c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : aVar.c() : aVar.b();
                        } else {
                            int i2 = i + 1;
                            aVar.f27032c = i2;
                            aVar.f27033d = i2;
                            while (true) {
                                aVar.f27034e = i2;
                                int i3 = aVar.f27032c;
                                if (i3 == aVar.f27031b) {
                                    throw new IllegalStateException("Unexpected end of DN: " + aVar.f27030a);
                                }
                                char[] cArr = aVar.f27036g;
                                if (cArr[i3] == '\"') {
                                    do {
                                        aVar.f27032c = i3 + 1;
                                        i3 = aVar.f27032c;
                                        if (i3 >= aVar.f27031b) {
                                            break;
                                        }
                                    } while (aVar.f27036g[i3] == ' ');
                                    char[] cArr2 = aVar.f27036g;
                                    int i4 = aVar.f27033d;
                                    str2 = new String(cArr2, i4, aVar.f27034e - i4);
                                } else {
                                    if (cArr[i3] == '\\') {
                                        cArr[aVar.f27034e] = aVar.d();
                                    } else {
                                        cArr[aVar.f27034e] = cArr[i3];
                                    }
                                    aVar.f27032c++;
                                    i2 = aVar.f27034e + 1;
                                }
                            }
                        }
                        if (AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(a2)) {
                            str4 = str2;
                        } else {
                            int i5 = aVar.f27032c;
                            if (i5 < aVar.f27031b) {
                                if (aVar.f27036g[i5] != '+') {
                                    throw new IllegalStateException("Malformed DN: " + aVar.f27030a);
                                }
                                aVar.f27032c = i5 + 1;
                                a2 = aVar.a();
                            }
                        }
                    }
                } while (a2 != null);
                throw new IllegalStateException("Malformed DN: " + aVar.f27030a);
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
                this.mPrivateHandler = new d(this, getLooper());
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
        } catch (Exception e2) {
            e2.printStackTrace();
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
                    } catch (IllegalThreadStateException e2) {
                        this.mIsRunning = false;
                        this.mIsWorking = false;
                        this.mNetTask = null;
                        throw e2;
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
