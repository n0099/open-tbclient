package com.baidu.tts;

import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.searchbox.v8engine.DiskCodeCacheManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.Tun2tornado;
import com.baidu.webkit.sdk.WebChromeClient;
import com.tencent.connect.common.Constants;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class n0 {
    public static /* synthetic */ Interceptable $ic;
    public static final n0 A;
    public static final n0 A0;
    public static final n0 B;
    public static final n0 B0;
    public static final n0 C;
    public static final n0 C0;
    public static final n0 D;
    public static final n0 D0;
    public static final n0 E;
    public static final n0 E0;
    public static final n0 F;
    public static final n0 F0;
    public static final n0 G;
    public static final n0 G0;
    public static final n0 H;
    public static final n0 H0;
    public static final n0 I;
    public static final n0 I0;
    public static final n0 J;
    public static final n0 J0;
    public static final n0 K;
    public static final n0 K0;
    public static final n0 L;
    public static final n0 L0;
    public static final n0 M;
    public static final n0 M0;
    public static final n0 N;
    public static final n0 N0;
    public static final n0 O;
    public static final n0 O0;
    public static final n0 P;
    public static final n0 P0;
    public static final n0 Q;
    public static final n0 Q0;
    public static final n0 R;
    public static final n0 R0;
    public static final n0 S;
    public static final n0 S0;

    /* renamed from: T  reason: collision with root package name */
    public static final n0 f1185T;
    public static final n0 T0;
    public static final n0 U;
    public static final n0 U0;
    public static final n0 V;
    public static final n0 V0;
    public static final n0 W;
    public static final n0 W0;
    public static final n0 X;
    public static final n0 X0;
    public static final n0 Y;
    public static final n0 Y0;
    public static final n0 Z;
    public static final n0 Z0;
    public static final n0 a0;
    public static final n0 a1;
    public static final n0 b0;
    public static final n0 b1;
    public static final n0 c0;
    public static final n0 c1;
    public static final n0 d;
    public static final n0 d0;
    public static final /* synthetic */ n0[] d1;
    public static final n0 e;
    public static final n0 e0;
    public static final n0 f;
    public static final n0 f0;
    public static final n0 g;
    public static final n0 g0;
    public static final n0 h;
    public static final n0 h0;
    public static final n0 i;
    public static final n0 i0;
    public static final n0 j;
    public static final n0 j0;
    public static final n0 k;
    public static final n0 k0;
    public static final n0 l;
    public static final n0 l0;
    public static final n0 m;
    public static final n0 m0;
    public static final n0 n;
    public static final n0 n0;
    public static final n0 o;
    public static final n0 o0;
    public static final n0 p;
    public static final n0 p0;
    public static final n0 q;
    public static final n0 q0;
    public static final n0 r;
    public static final n0 r0;
    public static final n0 s;
    public static final n0 s0;
    public static final n0 t;
    public static final n0 t0;
    public static final n0 u;
    public static final n0 u0;
    public static final n0 v;
    public static final n0 v0;
    public static final n0 w;
    public static final n0 w0;
    public static final n0 x;
    public static final n0 x0;
    public static final n0 y;
    public static final n0 y0;
    public static final n0 z;
    public static final n0 z0;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722262031, "Lcom/baidu/tts/n0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722262031, "Lcom/baidu/tts/n0;");
                return;
            }
        }
        d = new n0("STATE", 0, null, "state", null);
        e = new n0("CODE", 1, null, "code", null);
        f = new n0("DATA", 2, null, "data", null);
        g = new n0("IVERSION", 3, null, "iversion", null);
        h = new n0("URL", 4, "url", "url", null);
        i = new n0("MD5", 5, null, PackageTable.MD5, null);
        j = new n0("LENGTH", 6, null, "length", null);
        k = new n0("ABS_PATH", 7, null, "absPath", null);
        l = new n0(UserSettingForceListListener.FORCE_LIST_ITEM_ID_KEY, 8, "id", "id", null);
        m = new n0("IS_PID", 9, "is_pid", null, null);
        n = new n0("GENDER", 10, null, "gender", null);
        o = new n0("DOMAIN", 11, null, "domain", null);
        p = new n0("QUALITY", 12, null, "quality", null);
        q = new n0("DATA_COUNT", 13, null, "data_count", null);
        r = new n0("DATA_LIST", 14, null, "data_list", null);
        s = new n0("NAME", 15, null, "name", null);
        t = new n0("VERSION_MIN", 16, null, "version_min", null);
        u = new n0("VERSION_MAX", 17, null, "version_max", null);
        v = new n0("TEXT_DATA_ID", 18, null, "text_data_id", null);
        w = new n0("SPEECH_DATA_ID", 19, null, "speech_data_id", null);
        x = new n0("SPEECH_EXT_DATA_ID", 20, null, "speech_ext_data_id", null);
        y = new n0("TAC_SUBGAN_SPEAKER_ATTR", 21, null, "tac_subgan_speaker_attr", null);
        z = new n0("FUNCTION", 22, WebChromeClient.KEY_FUNCTION_NAME, "function", "");
        A = new n0("MODELSINFO", 23, "modelsinfo", "modelsinfo", "");
        B = new n0("ERROR_NUMBER", 24, "err_no", "errorNumber", "");
        C = new n0("ERROR_MESSAGE", 25, PmsConstant.Statistic.STATISTIC_ERRMSG, "errorMessage", "");
        D = new n0("MIX_MODE", 26, null, "mixMode", null);
        E = new n0("VERIFY_NETWORK_VALID", 27, "VerifyNetworkValid", "VerifyNetworkValid", null);
        F = new n0("PLAYER_POLICY", 28, "player_policy", "player_policy", null);
        G = new n0("PERCENT", 29, "pct", "percent", "");
        H = new n0("ENCODER_AUDIO_LEN", 30, "audio_len", "audio_len", "");
        I = new n0("APP_CODE", 31, "appid", "appCode", "");
        J = new n0("AUTH_SERIAL_NUMBER", 32, "authSN", "authSerialNumber", "");
        K = new n0("PACKAGE_NAME", 33, "pn", "packageName", "app_name");
        L = new n0("PLATFORM", 34, "", Constants.PARAM_PLATFORM, "");
        M = new n0("SPEED", 35, "spd", "speed", "");
        N = new n0("ONLINE_SPEED", 36, "spd", "speed", "");
        O = new n0("OFFLINE_SPEED", 37, "spd", "speed", "");
        P = new n0("INTERCEPT_SSML", 38, "inte", "intercept", "");
        Q = new n0("VOLUME", 39, "vol", "volume", "");
        R = new n0("PITCH", 40, "pit", SdkConfigOptions.LivenessConfigOption.q, "");
        S = new n0("LANGUAGE", 41, "lan", "language", "");
        f1185T = new n0("AUDIO_ENCODE", 42, "aue", "audioEncode", "");
        U = new n0("BITRATE", 43, "rate", "audioRate", "");
        V = new n0("PLAYER_VOLUME", 44, "player_volume", "player_volume", "");
        W = new n0("PLAYER_STREAM_TYPE", 45, "player_stream_type", "player_stream_type", "");
        X = new n0("PLAYER_USAGE", 46, "player_usage", "player_usage", "");
        Y = new n0("PLAYER_CONTENT_TYPE", 47, "player_content_type", "player_content_type", "");
        Z = new n0("PRODUCT_ID", 48, "pdt", "productId", "");
        a0 = new n0("ONLINE_SPEAKER", 49, "per", "onlineSpeaker", "");
        b0 = new n0("OFFLINE_RESOURCE_PATH", 50, "orp", "offlineResourcePath", "");
        c0 = new n0("OFFLINE_SPEAKER", 51, "osr", "offlineSpeaker", "");
        d0 = new n0("OFFLINE_MODEL", 52, "oml", "offlineModel", "");
        e0 = new n0("TEXT_DAT_PATH", 53, "tdp", "textDatPath", "");
        f0 = new n0("SPEECH_DAT_PATH", 54, "sdp", "speechDatPath", "");
        g0 = new n0("CONVERT_DAT_PATH", 55, "convert", "convertDatPath", "");
        h0 = new n0("SPEECH_EXT_DAT_PATH", 56, "sedp", "speechExtDatPath", "");
        i0 = new n0("TTS_LICENSE_FILE_PATH", 57, "tlfp", "ttsLicenseFilePath", "");
        j0 = new n0("CUSTOM_SYNTH", 58, "cs", "custom_synth", "");
        k0 = new n0("OPEN_XML", 59, "xml", "open_xml", "");
        l0 = new n0("TTS_VOCODER_OPTIMIZATION", 60, "tvo", "ttsVocoderOptimzation", "");
        m0 = new n0("SERIAL_NUMBER", 61, ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, "serialNumber", "");
        n0 = new n0("INDEX", 62, DiskCodeCacheManager.DISK_CODE_CACHE_INDEX_SUFFIX, "index", "");
        o0 = new n0("TEXT", 63, "tex", "text", "");
        p0 = new n0("CTP", 64, "ctp", "clientPath", "");
        q0 = new n0("CUID", 65, "cuid", "deviceId", "wise_cuid");
        r0 = new n0("VERSION", 66, "ver", "version", "sdkversion");
        s0 = new n0("NUMBER", 67, "num", "number", "");
        t0 = new n0("ENGINE", 68, "en", "engine", "");
        u0 = new n0("CONTEXT", 69, "ctx", "context", "");
        v0 = new n0("API_KEY", 70, "", "apiKey", "");
        w0 = new n0("SECRET_KEY", 71, "", "secretKey", "");
        x0 = new n0(Tun2tornado.ENV_TOKEN, 72, "tok", "token", "");
        y0 = new n0("SPEC", 73, "spec", "spec", "");
        z0 = new n0("KEY", 74, "key", "key", "");
        A0 = new n0("REQUEST_ENABLE_DNS", 75, DnsCacheHelper.DIR_NAME, DnsCacheHelper.DIR_NAME, "");
        B0 = new n0("SIGN", 76, "sign", "", "appidmd5");
        C0 = new n0("APPNAME", 77, "app", "", "app_package_name");
        D0 = new n0("SELFDEF", 78, "selfDef", "", "");
        E0 = new n0("STA", 79, "sta", "", "");
        F0 = new n0("GETLICENSE_ERRNO", 80, "errno", "", "");
        G0 = new n0("BILINGUAL_MODE", 81, "bmode", "bilingualmode", "");
        H0 = new n0("ONLINE_REQUEST_TIMEOUT", 82, null, "online_request_timeout", null);
        I0 = new n0("RESPONSE_CHANNEL", 83, "channel", "channel", "");
        J0 = new n0("RESPONSE_SAMPLE_RATE", 84, "samplerate", "samplerate", "");
        K0 = new n0("AUDIO_CTRL", 85, "audio_ctrl", "audio_ctrl", "");
        L0 = new n0("PACK_SIZE_TYPE", 86, "pack_size_type", "pack_size_type", "");
        M0 = new n0("TEXT_CTRL", 87, "text_ctrl", "text_ctrl", "");
        N0 = new n0("LIP_CTRL", 88, "lip_ctrl", "lip_ctrl", "");
        O0 = new n0("LIP_ENABLE", 89, "lip", "lip", "");
        P0 = new n0("CUID_NUM", 90, "cuid_num", "cuid_num", "");
        Q0 = new n0("STAT_PAM", 91, "stat_pam", "stat_pam", "");
        R0 = new n0("PHONE_MODEL", 92, "phone_model", "phone_model", "");
        S0 = new n0("TEXT_POS", 93, "text_pos", "text_pos", "");
        T0 = new n0("CITYID", 94, "cityid", "cityid", "");
        U0 = new n0("USERID", 95, DpStatConstants.KEY_USER_ID, DpStatConstants.KEY_USER_ID, "");
        V0 = new n0("ENABLE_UPLOAD_LOG", 96, "enable_upload_log", "enable_upload_log", "");
        W0 = new n0("UPLOAD_LOG_URL", 97, "upload_log_url", "upload_log_url", "");
        X0 = new n0("ENABLE_WM", 98, "enablewm", "enable_water_mark", "");
        Y0 = new n0("MULTIPLEX", 99, "multiplex", "multiplex", "");
        Z0 = new n0("THREAD_PRIORITY", 100, "thread_priority", "thread_priority", "");
        a1 = new n0("BIND_CORE", 101, "bind_core", "bind_core", "");
        b1 = new n0("OFFLINE_SYNTHESIZE_SLEEP_DIVISOR", 102, "offline_synthesize_sleep_divisor", "offline_synthesize_sleep_divisor", "");
        n0 n0Var = new n0("PRE_CREATE_CONNECTIONS", 103, "pre_create_connections", "pre_create_connections", "");
        c1 = n0Var;
        d1 = new n0[]{d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, f1185T, U, V, W, X, Y, Z, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0, k0, l0, m0, n0, o0, p0, q0, r0, s0, t0, u0, v0, w0, x0, y0, z0, A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0, Z0, a1, b1, n0Var};
    }

    public n0(String str, int i2, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str5 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str2;
        this.b = str3;
        this.c = str4;
    }

    public static String a(n0 n0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, n0Var)) == null) {
            return n0Var.name();
        }
        return (String) invokeL.objValue;
    }

    public static n0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (n0) Enum.valueOf(n0.class, str);
        }
        return (n0) invokeL.objValue;
    }

    public static n0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (n0[]) d1.clone();
        }
        return (n0[]) invokeV.objValue;
    }
}
