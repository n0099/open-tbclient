package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.net.http.Headers;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import okhttp3.CertificatePinner;
/* loaded from: classes9.dex */
public class BdNetEngine extends HandlerThread implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final Pattern VERIFY_AS_IP_ADDRESS;
    public static boolean mFirstWait;
    public static Object mSelfLock;
    public static long mWaitTime;
    public static int sNid;
    public static boolean sUsingChromiumNet;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f63917a;

        /* renamed from: b  reason: collision with root package name */
        public final int f63918b;

        /* renamed from: c  reason: collision with root package name */
        public int f63919c;

        /* renamed from: d  reason: collision with root package name */
        public int f63920d;

        /* renamed from: e  reason: collision with root package name */
        public int f63921e;

        /* renamed from: f  reason: collision with root package name */
        public int f63922f;

        /* renamed from: g  reason: collision with root package name */
        public char[] f63923g;

        public a(X500Principal x500Principal) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x500Principal};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            String name = x500Principal.getName("RFC2253");
            this.f63917a = name;
            this.f63918b = name.length();
        }

        private int a(int i2) throws Exception {
            InterceptResult invokeI;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
                int i5 = i2 + 1;
                if (i5 >= this.f63918b) {
                    throw new IllegalStateException("Malformed DN: " + this.f63917a);
                }
                char c2 = this.f63923g[i2];
                if (c2 >= '0' && c2 <= '9') {
                    i3 = c2 - '0';
                } else if (c2 >= 'a' && c2 <= 'f') {
                    i3 = c2 - 'W';
                } else if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f63917a);
                } else {
                    i3 = c2 - '7';
                }
                char c3 = this.f63923g[i5];
                if (c3 >= '0' && c3 <= '9') {
                    i4 = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i4 = c3 - 'W';
                } else if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f63917a);
                } else {
                    i4 = c3 - '7';
                }
                return (i3 << 4) + i4;
            }
            return invokeI.intValue;
        }

        private char e() throws Exception {
            InterceptResult invokeV;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                int a2 = a(this.f63919c);
                this.f63919c++;
                if (a2 < 128) {
                    return (char) a2;
                }
                if (a2 < 192 || a2 > 247) {
                    return '?';
                }
                if (a2 <= 223) {
                    i3 = a2 & 31;
                    i2 = 1;
                } else if (a2 <= 239) {
                    i2 = 2;
                    i3 = a2 & 15;
                } else {
                    i2 = 3;
                    i3 = a2 & 7;
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    int i5 = this.f63919c + 1;
                    this.f63919c = i5;
                    if (i5 == this.f63918b || this.f63923g[i5] != '\\') {
                        return '?';
                    }
                    int i6 = i5 + 1;
                    this.f63919c = i6;
                    int a3 = a(i6);
                    this.f63919c++;
                    if ((a3 & 192) != 128) {
                        return '?';
                    }
                    i3 = (i3 << 6) + (a3 & 63);
                }
                return (char) i3;
            }
            return invokeV.charValue;
        }

        public final String a() throws Exception {
            int i2;
            char[] cArr;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                while (true) {
                    int i3 = this.f63919c;
                    if (i3 >= this.f63918b || this.f63923g[i3] != ' ') {
                        break;
                    }
                    this.f63919c = i3 + 1;
                }
                int i4 = this.f63919c;
                if (i4 == this.f63918b) {
                    return null;
                }
                this.f63920d = i4;
                do {
                    this.f63919c = i4 + 1;
                    i4 = this.f63919c;
                    if (i4 >= this.f63918b) {
                        break;
                    }
                    cArr = this.f63923g;
                    if (cArr[i4] == '=') {
                        break;
                    }
                } while (cArr[i4] != ' ');
                int i5 = this.f63919c;
                if (i5 >= this.f63918b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f63917a);
                }
                this.f63921e = i5;
                if (this.f63923g[i5] == ' ') {
                    while (true) {
                        int i6 = this.f63919c;
                        if (i6 >= this.f63918b) {
                            break;
                        }
                        char[] cArr2 = this.f63923g;
                        if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                            break;
                        }
                        this.f63919c = i6 + 1;
                    }
                    char[] cArr3 = this.f63923g;
                    int i7 = this.f63919c;
                    if (cArr3[i7] != '=' || i7 == this.f63918b) {
                        throw new IllegalStateException("Unexpected end of DN: " + this.f63917a);
                    }
                }
                do {
                    i2 = this.f63919c + 1;
                    this.f63919c = i2;
                    if (i2 >= this.f63918b) {
                        break;
                    }
                } while (this.f63923g[i2] == ' ');
                int i8 = this.f63921e;
                int i9 = this.f63920d;
                if (i8 - i9 > 4) {
                    char[] cArr4 = this.f63923g;
                    if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                        char[] cArr5 = this.f63923g;
                        int i10 = this.f63920d;
                        if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                            char[] cArr6 = this.f63923g;
                            int i11 = this.f63920d;
                            if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                                this.f63920d += 4;
                            }
                        }
                    }
                }
                char[] cArr7 = this.f63923g;
                int i12 = this.f63920d;
                return new String(cArr7, i12, this.f63921e - i12);
            }
            return (String) invokeV.objValue;
        }

        public final String b() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f63919c;
                if (i2 + 4 >= this.f63918b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f63917a);
                }
                this.f63920d = i2;
                while (true) {
                    this.f63919c = i2 + 1;
                    int i3 = this.f63919c;
                    if (i3 == this.f63918b) {
                        break;
                    }
                    char[] cArr = this.f63923g;
                    if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                        break;
                    } else if (cArr[i3] == ' ') {
                        this.f63921e = i3;
                        do {
                            this.f63919c = i3 + 1;
                            i3 = this.f63919c;
                            if (i3 >= this.f63918b) {
                                break;
                            }
                        } while (this.f63923g[i3] == ' ');
                    } else {
                        if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                            cArr[i3] = (char) (cArr[i3] + ' ');
                        }
                        i2 = this.f63919c;
                    }
                }
                this.f63921e = this.f63919c;
                int i4 = this.f63921e;
                int i5 = this.f63920d;
                int i6 = i4 - i5;
                if (i6 < 5 || (i6 & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f63917a);
                }
                int i7 = i6 / 2;
                byte[] bArr = new byte[i7];
                int i8 = i5 + 1;
                for (int i9 = 0; i9 < i7; i9++) {
                    bArr[i9] = (byte) a(i8);
                    i8 += 2;
                }
                return new String(this.f63923g, this.f63920d, i6);
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a7, code lost:
            return new java.lang.String(r1, r2, r8.f63922f - r2);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String c() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f63919c;
                this.f63920d = i2;
                this.f63921e = i2;
                while (true) {
                    int i3 = this.f63919c;
                    if (i3 < this.f63918b) {
                        char[] cArr = this.f63923g;
                        char c2 = cArr[i3];
                        if (c2 == ' ') {
                            int i4 = this.f63921e;
                            this.f63922f = i4;
                            this.f63919c = i3 + 1;
                            this.f63921e = i4 + 1;
                            cArr[i4] = ' ';
                            while (true) {
                                int i5 = this.f63919c;
                                if (i5 >= this.f63918b) {
                                    break;
                                }
                                char[] cArr2 = this.f63923g;
                                if (cArr2[i5] != ' ') {
                                    break;
                                }
                                int i6 = this.f63921e;
                                this.f63921e = i6 + 1;
                                cArr2[i6] = ' ';
                                this.f63919c = i5 + 1;
                            }
                            int i7 = this.f63919c;
                            if (i7 == this.f63918b) {
                                break;
                            }
                            char[] cArr3 = this.f63923g;
                            if (cArr3[i7] == ',' || cArr3[i7] == '+' || cArr3[i7] == ';') {
                                break;
                            }
                        } else if (c2 == ';') {
                            break;
                        } else {
                            if (c2 == '\\') {
                                int i8 = this.f63921e;
                                this.f63921e = i8 + 1;
                                cArr[i8] = d();
                                i3 = this.f63919c;
                            } else if (c2 == '+' || c2 == ',') {
                                break;
                            } else {
                                int i9 = this.f63921e;
                                this.f63921e = i9 + 1;
                                cArr[i9] = cArr[i3];
                            }
                            this.f63919c = i3 + 1;
                        }
                    } else {
                        char[] cArr4 = this.f63923g;
                        int i10 = this.f63920d;
                        return new String(cArr4, i10, this.f63921e - i10);
                    }
                }
                char[] cArr5 = this.f63923g;
                int i11 = this.f63920d;
                return new String(cArr5, i11, this.f63921e - i11);
            }
            return (String) invokeV.objValue;
        }

        public final char d() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i2 = this.f63919c + 1;
                this.f63919c = i2;
                if (i2 == this.f63918b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f63917a);
                }
                char c2 = this.f63923g[i2];
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
                return this.f63923g[this.f63919c];
            }
            return invokeV.charValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        BdNetTask onNetDownloadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask, boolean z);

        void onNetDownloadError(BdNetEngine bdNetEngine, BdNetTask bdNetTask, BdNet.NetError netError, int i2);

        void onNetDownloadStart(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        void onNetReceiveData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, byte[] bArr, int i2);

        void onNetReceiveHeaders(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        boolean onNetRedirect(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i2);

        void onNetResponseCode(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i2);

        void onNetStateChanged(BdNetEngine bdNetEngine, BdNetTask bdNetTask, BdNet.NetState netState, int i2);

        void onNetUploadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask);

        void onNetUploadData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i2, int i3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-150408273, "Lcom/baidu/webkit/net/BdNetEngine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-150408273, "Lcom/baidu/webkit/net/BdNetEngine;");
                return;
            }
        }
        VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        mSelfLock = new Object();
        mWaitTime = 10000L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdNetEngine() {
        super(LOG_TAG + nidPP());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
    }

    private void addHeaders(BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, bdNetTask) == null) {
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
    }

    public static HttpURLConnection defaultOpenConnection(URL url, SSLContext sSLContext, BdNetTask bdNetTask) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, url, sSLContext, bdNetTask)) == null) {
            bdNetTask.setIsUseCorenet(false);
            boolean equals = url.getProtocol().equals("https");
            URLConnection openConnection = url.openConnection();
            if (equals) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.webkit.net.BdNetEngine.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // javax.net.ssl.HostnameVerifier
                    public final boolean verify(String str, SSLSession sSLSession) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) {
                            try {
                                if (!TextUtils.isEmpty(str) && str.equals("180.76.76.112") && str.equals("240c:4006::6666")) {
                                    str = "httpsdns.baidu.com";
                                }
                                X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
                                return BdNetEngine.verifyAsIpAddress(str) ? BdNetEngine.verifyIpAddress(str, x509Certificate) : BdNetEngine.verifyHostName(str, x509Certificate);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                            }
                        }
                        return invokeLL.booleanValue;
                    }
                });
                return httpsURLConnection;
            }
            return (HttpURLConnection) openConnection;
        }
        return (HttpURLConnection) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean download(BdNetTask bdNetTask) {
        InterceptResult invokeL;
        InputStream inputStream;
        GZIPInputStream gZIPInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65548, this, bdNetTask)) != null) {
            return invokeL.booleanValue;
        }
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, bdNetTask)) == null) {
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
                        } catch (AssertionError unused2) {
                            if (this.mListener != null) {
                                this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_UNKNOWN, 0);
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
                        } catch (Exception unused3) {
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
                    } catch (SocketTimeoutException unused4) {
                        if (this.mListener != null) {
                            this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_CONNECT_TIMEOUT, 0);
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
                } catch (MalformedURLException unused6) {
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_MALFORMEDURL, 0);
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
                } catch (IOException unused7) {
                    if (this.mListener != null) {
                        this.mListener.onNetDownloadError(this, bdNetTask, BdNet.NetError.ERROR_IO, 0);
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
        return invokeL.intValue;
    }

    public static List<String> getSubjectAltNames(X509Certificate x509Certificate, int i2) {
        InterceptResult invokeLI;
        Integer num;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, x509Certificate, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                if (subjectAlternativeNames == null) {
                    return Collections.emptyList();
                }
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i2 && (str = (String) list.get(1)) != null) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            } catch (CertificateParsingException unused) {
                return Collections.emptyList();
            }
        }
        return (List) invokeLI.objValue;
    }

    public static int nidPP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            int i2 = sNid;
            sNid = i2 + 1;
            return i2;
        }
        return invokeV.intValue;
    }

    public static HttpURLConnection openConnection(URL url, SSLContext sSLContext, BdNetTask bdNetTask) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, url, sSLContext, bdNetTask)) == null) {
            if (!WebSettingsGlobalBlink.getCronetEnable()) {
                Log.w(LOG_TAG, "openConnection use system ".concat(String.valueOf(url)));
                return defaultOpenConnection(url, sSLContext, bdNetTask);
            }
            Log.w(LOG_TAG, "openConnection1 ".concat(String.valueOf(url)));
            HttpURLConnection openCornetConnection = openCornetConnection(url);
            return openCornetConnection != null ? openCornetConnection : defaultOpenConnection(url, sSLContext, bdNetTask);
        }
        return (HttpURLConnection) invokeLLL.objValue;
    }

    public static HttpURLConnection openConnection(URL url, SSLContext sSLContext, Proxy proxy) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, url, sSLContext, proxy)) == null) {
            if (!url.getProtocol().equals("https") || sSLContext == null) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection(proxy);
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.webkit.net.BdNetEngine.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) {
                        try {
                            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
                            return BdNetEngine.verifyAsIpAddress(str) ? BdNetEngine.verifyIpAddress(str, x509Certificate) : BdNetEngine.verifyHostName(str, x509Certificate);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                        }
                    }
                    return invokeLL.booleanValue;
                }
            });
            return httpsURLConnection;
        }
        return (HttpURLConnection) invokeLLL.objValue;
    }

    public static HttpURLConnection openCornetConnection(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, url)) == null) {
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
                } catch (Exception e2) {
                    e2.printStackTrace();
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
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else {
                Log.w(LOG_TAG, "[cronet] openConnection not init ".concat(String.valueOf(url)));
            }
            return null;
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    private boolean redirect(BdNetTask bdNetTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, bdNetTask)) == null) {
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
        return invokeL.booleanValue;
    }

    private void setHttpResponseHeader(HttpURLConnection httpURLConnection, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65556, this, httpURLConnection, bdNetTask) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            String headerField = httpURLConnection.getHeaderField(i2);
            if (headerField == null) {
                return;
            }
            bdNetTask.addResHeaders(httpURLConnection.getHeaderFieldKey(i2), headerField);
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopDownloadInner() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
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
                if (a2.f63934b != null && !a2.f63934b.isEmpty()) {
                    a2.f63934b.remove(this);
                }
            }
        }
    }

    private boolean upload(BdNetTask bdNetTask) {
        InterceptResult invokeL;
        byte[] content;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, bdNetTask)) == null) {
            boolean z = false;
            DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    try {
                        content = bdNetTask.getContent();
                        dataOutputStream = new DataOutputStream(this.mConnection.getOutputStream());
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
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
        return invokeL.booleanValue;
    }

    public static boolean verifyAsIpAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) ? VERIFY_AS_IP_ADDRESS.matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean verifyHostName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, str, str2)) == null) {
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
                    int i2 = indexOf + 1;
                    int length = lowerCase.length() - i2;
                    int length2 = str.length() - length;
                    return (str.indexOf(46, indexOf) >= length2 || str.endsWith(".clients.google.com")) && str.regionMatches(length2, lowerCase, i2, length);
                }
                return false;
            }
            return str.equals(lowerCase);
        }
        return invokeLL.booleanValue;
    }

    public static boolean verifyHostName(String str, X509Certificate x509Certificate) throws Exception {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, x509Certificate)) == null) {
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
                aVar.f63919c = 0;
                aVar.f63920d = 0;
                aVar.f63921e = 0;
                aVar.f63922f = 0;
                aVar.f63923g = aVar.f63917a.toCharArray();
                String a2 = aVar.a();
                String str4 = null;
                if (a2 != null) {
                    do {
                        int i2 = aVar.f63919c;
                        if (i2 != aVar.f63918b) {
                            char c2 = aVar.f63923g[i2];
                            if (c2 != '\"') {
                                str2 = c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : aVar.c() : aVar.b();
                            } else {
                                int i3 = i2 + 1;
                                aVar.f63919c = i3;
                                aVar.f63920d = i3;
                                while (true) {
                                    aVar.f63921e = i3;
                                    int i4 = aVar.f63919c;
                                    if (i4 == aVar.f63918b) {
                                        throw new IllegalStateException("Unexpected end of DN: " + aVar.f63917a);
                                    }
                                    char[] cArr = aVar.f63923g;
                                    if (cArr[i4] == '\"') {
                                        do {
                                            aVar.f63919c = i4 + 1;
                                            i4 = aVar.f63919c;
                                            if (i4 >= aVar.f63918b) {
                                                break;
                                            }
                                        } while (aVar.f63923g[i4] == ' ');
                                        char[] cArr2 = aVar.f63923g;
                                        int i5 = aVar.f63920d;
                                        str2 = new String(cArr2, i5, aVar.f63921e - i5);
                                    } else {
                                        if (cArr[i4] == '\\') {
                                            cArr[aVar.f63921e] = aVar.d();
                                        } else {
                                            cArr[aVar.f63921e] = cArr[i4];
                                        }
                                        aVar.f63919c++;
                                        i3 = aVar.f63921e + 1;
                                    }
                                }
                            }
                            if (AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(a2)) {
                                str4 = str2;
                            } else {
                                int i6 = aVar.f63919c;
                                if (i6 < aVar.f63918b) {
                                    if (aVar.f63923g[i6] != '+') {
                                        throw new IllegalStateException("Malformed DN: " + aVar.f63917a);
                                    }
                                    aVar.f63919c = i6 + 1;
                                    a2 = aVar.a();
                                }
                            }
                        }
                    } while (a2 != null);
                    throw new IllegalStateException("Malformed DN: " + aVar.f63917a);
                }
                if (str4 != null) {
                    return verifyHostName(lowerCase, str4);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, str, x509Certificate)) == null) {
            for (String str2 : getSubjectAltNames(x509Certificate, 7)) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void allocate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mIsRecycle = false;
        }
    }

    public BdNetTask getNetTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mNetTask : (BdNetTask) invokeV.objValue;
    }

    public boolean isRecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsRecycle : invokeV.booleanValue;
    }

    public boolean isWorking() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsWorking : invokeV.booleanValue;
    }

    @Override // android.os.HandlerThread
    @SuppressLint({"HandlerLeak"})
    public void onLooperPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.mLock) {
                if (this.mPrivateHandler == null) {
                    this.mPrivateHandler = new Handler(this, getLooper()) { // from class: com.baidu.webkit.net.BdNetEngine.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ BdNetEngine f63916a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r8};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((Looper) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f63916a = this;
                        }

                        @Override // android.os.Handler
                        public final void handleMessage(Message message) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                                int i2 = message.what;
                                if (i2 != 1) {
                                    if (i2 != 2) {
                                        return;
                                    }
                                    this.f63916a.stopDownloadInner();
                                    return;
                                }
                                this.f63916a.mIsWorking = true;
                                BdNetEngine bdNetEngine = this.f63916a;
                                bdNetEngine.mNetTask = bdNetEngine.performTask((BdNetTask) message.obj);
                                if (this.f63916a.mNetTask == null) {
                                    this.f63916a.recycle();
                                } else {
                                    this.f63916a.mPrivateHandler.obtainMessage(1, this.f63916a.mNetTask).sendToTarget();
                                }
                                this.f63916a.mIsWorking = false;
                            }
                        }
                    };
                }
                if (this.mIsWorking) {
                    this.mPrivateHandler.obtainMessage(1, this.mNetTask).sendToTarget();
                }
            }
        }
    }

    public BdNetTask performTask(BdNetTask bdNetTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdNetTask)) == null) {
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
        return (BdNetTask) invokeL.objValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mIsRecycle = true;
            this.mListener = null;
        }
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                super.run();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setCmwap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mIsCmwap = z;
        }
    }

    public void setEventListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.mListener = bVar;
        }
    }

    public void setProxyPort(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mProxyPort = i2;
        }
    }

    public void setProxyUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mProxyUrl = str;
        }
    }

    public void startDownload(BdNetTask bdNetTask) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdNetTask) == null) {
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
    }

    public void stopDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.mLock) {
                if (this.mPrivateHandler != null) {
                    this.mPrivateHandler.obtainMessage(2).sendToTarget();
                }
            }
        }
    }
}
