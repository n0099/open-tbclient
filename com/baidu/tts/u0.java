package com.baidu.tts;

import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import org.chromium.net.NetError;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class u0 {
    public static /* synthetic */ Interceptable $ic;
    public static final u0 A;
    public static final u0 A0;
    public static final u0 B;
    public static final u0 B0;
    public static final u0 C;
    public static final u0 C0;
    public static final u0 D;
    public static final u0 D0;
    public static final u0 E;
    public static final u0 E0;
    public static final u0 F;
    public static final u0 F0;
    public static final u0 G;
    public static final u0 G0;
    public static final u0 H;
    public static final u0 H0;
    public static final u0 I;
    public static final u0 I0;
    public static final u0 J;
    public static final u0 J0;
    public static final u0 K;
    public static final u0 K0;
    public static final u0 L;
    public static final u0 L0;
    public static final u0 M;
    public static final u0 M0;
    public static final u0 N;
    public static final u0 N0;
    public static final u0 O;
    public static final u0 O0;
    public static final u0 P;
    public static final u0 P0;
    public static final u0 Q;
    public static final u0 Q0;
    public static final u0 R;
    public static final u0 R0;
    public static final u0 S;
    public static final u0 S0;

    /* renamed from: T  reason: collision with root package name */
    public static final u0 f1189T;
    public static final u0 T0;
    public static final u0 U;
    public static final u0 U0;
    public static final u0 V;
    public static final /* synthetic */ u0[] V0;
    public static final u0 W;
    public static final u0 X;
    public static final u0 Y;
    public static final u0 Z;
    public static final u0 a0;
    public static final u0 b0;
    public static final u0 c;
    public static final u0 c0;
    public static final u0 d;
    public static final u0 d0;
    public static final u0 e;
    public static final u0 e0;
    public static final u0 f;
    public static final u0 f0;
    public static final u0 g;
    public static final u0 g0;
    public static final u0 h;
    public static final u0 h0;
    public static final u0 i;
    public static final u0 i0;
    public static final u0 j;
    public static final u0 j0;
    public static final u0 k;
    public static final u0 k0;
    public static final u0 l;
    public static final u0 l0;
    public static final u0 m;
    public static final u0 m0;
    public static final u0 n;
    public static final u0 n0;
    public static final u0 o;
    public static final u0 o0;
    public static final u0 p;
    public static final u0 p0;
    public static final u0 q;
    public static final u0 q0;
    public static final u0 r;
    public static final u0 r0;
    public static final u0 s;
    public static final u0 s0;
    public static final u0 t;
    public static final u0 t0;
    public static final u0 u;
    public static final u0 u0;
    public static final u0 v;
    public static final u0 v0;
    public static final u0 w;
    public static final u0 w0;
    public static final u0 x;
    public static final u0 x0;
    public static final u0 y;
    public static final u0 y0;
    public static final u0 z;
    public static final u0 z0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722268758, "Lcom/baidu/tts/u0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722268758, "Lcom/baidu/tts/u0;");
                return;
            }
        }
        a aVar = a.b;
        c = new u0("ONLINE_ENGINE_AUTH_FAILURE", 0, aVar, -1, "online engine auth failure");
        d = new u0("ONLINE_ENGINE_HTTP_REQUEST_FAILURE", 1, aVar, -2, "request failure");
        e = new u0("ONLINE_ENGINE_CANCEL_FAILURE", 2, aVar, -3, "cancel failure");
        f = new u0("ONLINE_AUTH_INTERRUPTED_EXCEPTION", 3, aVar, -4, "InterruptedException");
        g = new u0("ONLINE_AUTH_EXECUTION_EXCEPTION", 4, aVar, -5, "ExecutionException");
        h = new u0("ONLINE_AUTH_TIMEOUT_EXCEPTION", 5, aVar, -6, "TimeoutException");
        i = new u0("ONLINE_ENGINE_REQUEST_RESULT_ERROR", 6, aVar, -7, "request result contains error message");
        j = new u0("ONLINE_TOKEN_IS_NULL", 7, aVar, -8, "access token is null, please check your apikey and secretkey or product id");
        k = new u0("ONLINE_ENGINE_UNINITIALIZED", 8, aVar, -9, "online engine is not initial");
        l = new u0("ONLINE_ENGINE_CALL_EXCEPTION", 9, aVar, -10, "online engine call synthesize exception");
        m = new u0("ONLINE_UNSUPPORTED_OPERATION", 10, aVar, -11, "this method is not supported by online mode(please use other mode)");
        n = new u0("ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR", 11, aVar, -12, "request result parse error may responsebag is null");
        o = new u0("ONLINE_ENGINE_GET_INTERRUPTED", 12, aVar, -13, "online synthesize get was interrupted");
        p = new u0("ONLINE_ENGINE_GET_EXECUTION_EXCEPTION", 13, aVar, -14, "online synthesize get exception");
        q = new u0("ONLINE_ENGINE_GET_TIMEOUT", 14, aVar, -15, "online synthesize get was timeout");
        r = new u0("ONLINE_AUTH_CANCELLATION_EXCEPTION", 15, aVar, -16, "CancellationException");
        s = new u0("ONLINE_ENGINE_SERVER_IP_IS_NULL", 16, aVar, -17, "online engine server ip is null");
        t = new u0("ONLINE_ENGINE_GET_UNKNOWN_HOST", 17, aVar, -18, "online synthesize get was unknown host");
        u = new u0("ONLINE_ENGINE_GET_READ_ERROR", 18, aVar, -19, "online synthesize get was read error");
        v = new u0("ONLINE_ENGINE_GET_CONNECT_EXCEPTION", 19, aVar, -20, "online synthesize connect exception");
        w = new u0("ONLINE_ENGINE_GET_SOCKET_EXCEPTION", 20, aVar, -21, "online synthesize get was socket is closed");
        x = new u0("ONLINE_ENGINE_GET_SSL_HANDSHAKE_EXCEPTION", 21, aVar, -22, "SSLHandshakeException");
        y = new u0("ONLINE_ENGINE_GET_WEBSOCKET_CLOSING", 22, aVar, -23, "online synthesize websocket closing");
        z = new u0("ONLINE_ENGINE_REQUEST_URI_MALFORMED", 23, aVar, -24, "online synthesize request uri malformed");
        A = new u0("ONLINE_ENGINE_NET_WRITE_ERROR", 24, aVar, -25, "online synthesize network write error");
        B = new u0("ONLINE_ENGINE_NET_CLOSE_ERROR", 25, aVar, -26, "online synthesize network close error");
        C = new u0("ONLINE_ENGINE_NET_PROXY_ERROR", 26, aVar, -27, "online synthesize network proxy error");
        D = new u0("ONLINE_ENGINE_PRT_LVTV_ERROR", 27, aVar, -28, "online synthesize protocal error");
        E = new u0("ONLINE_ENGINE_PRT_FIELD_MISS_ERROR", 28, aVar, -29, "online synthesize field miss error");
        F = new u0("ONLINE_ENGINE_PRT_DATA_MISS_ERROR", 29, aVar, -30, "online synthesize need more data error");
        G = new u0("ONLINE_ENGINE_DECODE_BUSY_ERROR", 30, aVar, -31, "online decode is busy error");
        H = new u0("ONLINE_ENGINE_SOCKET_UNKNOWN_ERROR", 31, aVar, -32, "online unknown socket error");
        I = new u0("ONLINE_ENGINE_INIT_FAILED", 32, aVar, -33, "online engine initTTS, init failure");
        J = new u0("ONLINE_ENGINE_NET_IDLE_CLOSE", 33, aVar, -34, "online synthesize network idle timeout");
        K = new u0("ONLINE_ENGINE_GET_CONNECT_BUSY", 34, aVar, -35, "online synthesize connect is busy");
        L = new u0("ONLINE_ENGINE_CONNECTION_NOT_READY", 35, aVar, -36, "online synthesize connect is not ready");
        M = new u0("ONLINE_ENGINE_TTS_EMPTY_AUDIO", 36, aVar, -37, "online synthesize receive no audio.");
        N = new u0("ONLINE_ENGINE_REQUEST_CANCEL_ERROR", 37, aVar, -38, "the request has canceled");
        O = new u0("ONLINE_ENGINE_TEMPORARY_ERROR", 38, aVar, -39, "temporary online engine failure");
        a aVar2 = a.c;
        P = new u0("OFFLINE_ENGINE_AUTH_FAILURE", 39, aVar2, -100, "offline engine auth failure,please check you offline auth params");
        Q = new u0("OFFLINE_ENGINE_CANCEL_FAILURE", 40, aVar2, -101, "offline engine cancel failure");
        R = new u0("OFFLINE_ENGINE_DOWNLOAD_LICENSE_FAILED", 41, aVar2, -102, "offline engine download license failure");
        S = new u0("OFFLINE_ENGINE_AUTH_NULL", 42, aVar2, -103, "offline engine auth authinfo is null");
        f1189T = new u0("OFFLINE_AUTH_INTERRUPTED_EXCEPTION", 43, aVar2, -105, "InterruptedException");
        U = new u0("OFFLINE_AUTH_EXECUTION_EXCEPTION", 44, aVar2, -106, "ExecutionException");
        V = new u0("OFFLINE_AUTH_TIMEOUT_EXCEPTION", 45, aVar2, -107, "TimeoutException");
        W = new u0("OFFLINE_ENGINE_INIT_FAILED", 46, aVar2, -108, "bdTTSEngineInit failed,please check you offline params");
        X = new u0("OFFLINE_ENGINE_FILE_ERROR", 47, aVar2, -109, "offline file error");
        Y = new u0("OFFLINE_ENGINE_CALL_EXCEPTION", 48, aVar2, -110, "offline engine call synthesize exception");
        Z = new u0("OFFLINE_ENGINE_SYNTHESIZE_ERROR", 49, aVar2, -111, "offline engine synthesize result not 0");
        a0 = new u0("OFFLINE_ENGINE_AUTH_EXPIRED", 50, aVar2, -112, "offline engine auth verify expired,formal expired or temp expired");
        b0 = new u0("OFFLINE_ENGINE_AUTH_PACKAGE_UNMATCH", 51, aVar2, -113, "package name is unmatch");
        c0 = new u0("OFFLINE_ENGINE_AUTH_SIGN_UNMATCH", 52, aVar2, -114, "app sign is unmatch");
        d0 = new u0("OFFLINE_ENGINE_AUTH_CUID_UNMATCH", 53, aVar2, -115, "devices cuid is unmatch");
        e0 = new u0("OFFLINE_ENGINE_AUTH_PLATFORM_ERROR", 54, aVar2, NetError.ERR_CERT_ERROR_IN_SSL_RENEGOTIATION, "platform is unmatch");
        f0 = new u0("OFFLINE_ENGINE_AUTH_LICENSE_FILE_INVALID", 55, aVar2, NetError.ERR_BAD_SSL_CLIENT_AUTH_CERT, "license file not exist or file length is 0 (download license fail)");
        g0 = new u0("OFFLINE_AUTH_CANCELLATION_EXCEPTION", 56, a.b, NetError.ERR_CONNECTION_TIMED_OUT, "CancellationException");
        h0 = new u0("OFFLINE_RESOURCES_VERSION_ERROR", 57, aVar2, NetError.ERR_HOST_RESOLVER_QUEUE_TOO_LARGE, "offline resources version error");
        i0 = new u0("OFFLINE_RESOURCES_AUTHORIZE_FAILURE", 58, aVar2, NetError.ERR_SOCKS_CONNECTION_FAILED, "offline resources authorize failed");
        j0 = new u0("OFFLINE_ENGINE_LABEL_FAILED", 59, aVar2, -121, "Offline engine does not support SSML");
        k0 = new u0("OFFLINE_RESOURCE_LOAD_FAILED", 60, aVar2, NetError.ERR_ALPN_NEGOTIATION_FAILED, "offline speaker resource wrong");
        l0 = new u0("OFFLINE_SPEAKER_LOAD_FAILED", 61, aVar2, NetError.ERR_SSL_NO_RENEGOTIATION, "offline speaker not exist");
        m0 = new u0("OFFLINE_DOWNLOAD_LICENSE_INVALID_SN", 62, aVar2, NetError.ERR_WINSOCK_UNEXPECTED_WRITTEN_BYTES, "download license failure,invalid SN");
        a aVar3 = a.a;
        n0 = new u0("MIX_ENGINE_AUTH_FAILURE", 63, aVar3, -200, "both online and offline engine auth failue");
        o0 = new u0("MIX_AUTH_INTERRUPTED_EXCEPTION", 64, aVar3, -201, "InterruptedException");
        p0 = new u0("MIX_AUTH_EXECUTION_EXCEPTION", 65, aVar3, -202, "ExecutionException");
        q0 = new u0("MIX_AUTH_TIMEOUT_EXCEPTION", 66, aVar3, -203, "TimeoutException");
        r0 = new u0("MIX_ENGINE_OFFLINE_INIT_FAILURE", 67, aVar3, -204, "mix engine initTTS, the offline init failure");
        s0 = new u0("MIX_AUTH_CANCELLATION_EXCEPTION", 68, aVar3, -205, "CancellationException");
        t0 = new u0("MIX_ENGINE_ONLINE_INIT_FAILURE", 69, aVar3, -206, "mix engine initTTS, the online init failure");
        u0 = new u0("MIX_ENGINE_BOTH_INIT_FAILURE", 70, aVar3, -207, "mix engine initTTS, all engines init failure");
        v0 = new u0("MIX_ONLINE_NOT_EQUAL_OFFLINE_SAMPLE_RATE", 71, aVar3, -208, "online sample rate not equal offline sample rate");
        a aVar4 = a.d;
        w0 = new u0("TEXT_IS_EMPTY", 72, aVar4, NetError.ERR_INVALID_URL, "text is null or empty double quotation marks");
        x0 = new u0("TEXT_IS_TOO_LONG", 73, aVar4, -301, "text length in gbk is more than 1024, the text is too long, cut it short than 1024");
        y0 = new u0("TEXT_ENCODE_IS_WRONG", 74, aVar4, -302, "text encode is not gbk, please use gbk text");
        a aVar5 = a.e;
        z0 = new u0("TTS_UNINITIAL", 75, aVar5, -400, "tts has not been initialized,invoke in a wrong state");
        A0 = new u0("TTS_MODE_ILLEGAL", 76, aVar5, -401, "tts mode unset or not the spechified value");
        B0 = new u0("TTS_QUEUE_IS_FULL", 77, aVar5, -402, "队列长度小于MAX_QUEUE_SIZE时才能加入合成队列");
        C0 = new u0("TTS_LIST_IS_TOO_LONG", 78, aVar5, -403, "list的size小于MAX_LIST_SIZE时才有效");
        D0 = new u0("TTS_ENGINE_STOP_FAILURE", 79, aVar5, -404, "引擎停止失败");
        E0 = new u0("TTS_APP_ID_IS_INVALID", 80, aVar5, -405, "app id is invalid,must be less than int(11)");
        F0 = new u0("TTS_PARAMETER_INVALID", 81, aVar5, NetError.ERR_CACHE_RACE, "arguments of the method is invalid");
        G0 = new u0("TTS_DATA_TOO_MUCH", 82, aVar5, NetError.ERR_CACHE_CHECKSUM_READ_FAILURE, "too much data in buffer, wait please.");
        H0 = new u0("APP_RESOURCE_IS_NULL", 83, a.f, ErrorCode.SERVER_ERROR, "context was released or persistent app value is null");
        I0 = new u0("PLAYER_IS_NULL", 84, a.g, -600, "player is null");
        a aVar6 = a.h;
        J0 = new u0("MODEL_PARAMS_ERROR", 85, aVar6, -1000, "params is wrong");
        K0 = new u0("MODEL_REQUEST_ERROR", 86, aVar6, -1001, "request error");
        L0 = new u0("MODEL_SERVER_ERROR", 87, aVar6, -1002, "server error");
        M0 = new u0("MODEL_DB_MODEL_INVALID", 88, aVar6, -1003, "model item in db is invalid(fileids is empty)");
        N0 = new u0("MODEL_DB_MODEL_FILE_PATHS_INVALID", 89, aVar6, -1004, "model file in db is invalid(abspath is empty)");
        O0 = new u0("MODEL_EXISTS", 90, aVar6, -1005, "this model exists(have downloaded success ever)");
        P0 = new u0("MODEL_BAGS_EMPTY", 91, aVar6, -1006, "can't get server model info,maybe modelid invalid or request failure");
        Q0 = new u0("MODEL_FILE_BAG_EMPTY", 92, aVar6, -1007, "can't get server file info,maybe fileid invalid or request failure");
        R0 = new u0("MODEL_CHECK_EXCEPTION", 93, aVar6, -1008, "CheckWork exception happened");
        S0 = new u0("MODEL_FILE_DOWNLOAD_EXCEPTION", 94, aVar6, -1009, "exception happens when file downloadwork execute");
        T0 = new u0("MODEL_INACTIVITY_NETWORK", 95, aVar6, -1010, "Inactivity Network");
        u0 u0Var = new u0("TTS_ERROR_UNKNOW", 96, a.i, -9999, DownloadStatisticConstants.UBC_VALUE_UNKNOW);
        U0 = u0Var;
        V0 = new u0[]{c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, f1189T, U, V, W, X, Y, Z, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0, k0, l0, m0, n0, o0, p0, q0, r0, s0, t0, u0, v0, w0, x0, y0, z0, A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, u0Var};
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final /* synthetic */ a[] j;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1537848441, "Lcom/baidu/tts/u0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1537848441, "Lcom/baidu/tts/u0$a;");
                    return;
                }
            }
            a aVar = new a("MIX_ERROR", 0);
            a = aVar;
            a aVar2 = new a("ONLINE_ENGINE_ERROR", 1);
            b = aVar2;
            a aVar3 = new a("OFFLINE_ENGINE_ERROR", 2);
            c = aVar3;
            a aVar4 = new a("TEXT", 3);
            d = aVar4;
            a aVar5 = new a("TTS", 4);
            e = aVar5;
            a aVar6 = new a(GrsBaseInfo.CountryCodeSource.APP, 5);
            f = aVar6;
            a aVar7 = new a("PLAYER", 6);
            g = aVar7;
            a aVar8 = new a("MODEL", 7);
            h = aVar8;
            a aVar9 = new a("UNKNOW", 8);
            i = aVar9;
            j = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) j.clone();
            }
            return (a[]) invokeV.objValue;
        }
    }

    public u0(String str, int i2, a aVar, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), aVar, Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i3;
        this.b = str2;
    }

    public static u0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (u0) Enum.valueOf(u0.class, str);
        }
        return (u0) invokeL.objValue;
    }

    public static u0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (u0[]) V0.clone();
        }
        return (u0[]) invokeV.objValue;
    }
}
