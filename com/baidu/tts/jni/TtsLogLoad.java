package com.baidu.tts.jni;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.b1;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.e0;
import com.baidu.tts.f0;
import com.baidu.tts.l2;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class TtsLogLoad {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_APP_NAME = "appname";
    public static final String KEY_CUID = "uid";
    public static final String KEY_DATA_COLLECT_VERSION = "data-collect-version";
    public static final String KEY_LOG_ID = "log-id";
    public static final String KEY_OS = "os";
    public static final String KEY_REAL = "real";
    public static final String KEY_SDK_VERSION = "sdk-version";
    public static final int RESULT_FAILED = 3;
    public static final int RESULT_SUCCESS = 2;
    public static final String TAG = "TtsLogLoad";
    public transient /* synthetic */ FieldHolder $fh;
    public int index;
    public String mPid;
    public String mTtsLogUrl;
    public String url;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static native String bdTTSGetLogLibVersion();

    public static native int bdTTSSetNativeLogLevel(int i);

    public native int initLocalTtsWpData(String str, String str2, int i, boolean z, boolean z2, boolean z3, long[] jArr);

    public native int setLogHeadSring(String str, int i, long j);

    public native int writeLocalFile(String str, int i, int i2, long j);

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final TtsLogLoad a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(65360530, "Lcom/baidu/tts/jni/TtsLogLoad$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(65360530, "Lcom/baidu/tts/jni/TtsLogLoad$b;");
                    return;
                }
            }
            a = new TtsLogLoad(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1153003312, "Lcom/baidu/tts/jni/TtsLogLoad;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1153003312, "Lcom/baidu/tts/jni/TtsLogLoad;");
                return;
            }
        }
        try {
            System.loadLibrary("bd_tts_log");
            LoggerProxy.d(TAG, "bd_tts_log load succeed");
        } catch (Throwable th) {
            LoggerProxy.e(TAG, "so file bd_tts_log load fail" + th.toString());
        }
    }

    public TtsLogLoad() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTtsLogUrl = "https://upl.baidu.com/slp/upload_monitor?log_sn=";
        this.index = 0;
    }

    public static TtsLogLoad getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return b.a;
        }
        return (TtsLogLoad) invokeV.objValue;
    }

    public /* synthetic */ TtsLogLoad(a aVar) {
        this();
    }

    private Map<String, String> buildHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            String str2 = "";
            HashMap hashMap = new HashMap();
            try {
                Context b2 = b1.d().b();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                int i = this.index;
                this.index = i + 1;
                sb.append(i);
                hashMap.put("log-id", sb.toString());
                hashMap.put(KEY_REAL, URLEncoder.encode("1", StandardCharsets.UTF_8.name()));
                hashMap.put("uid", URLEncoder.encode(b1.d().c(), StandardCharsets.UTF_8.name()));
                Pattern pattern = l2.a;
                try {
                    PackageManager packageManager = b2.getPackageManager();
                    str2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(l2.a(b2), 0));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                hashMap.put("appname", URLEncoder.encode(str2, StandardCharsets.UTF_8.name()));
                hashMap.put(KEY_SDK_VERSION, URLEncoder.encode("6.0.5.5f65dca", StandardCharsets.UTF_8.name()));
                hashMap.put(KEY_DATA_COLLECT_VERSION, URLEncoder.encode(str + ".1.0.3", StandardCharsets.UTF_8.name()));
                hashMap.put(KEY_OS, URLEncoder.encode("Android", StandardCharsets.UTF_8.name()));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    private int httpRequest(String str, Map<String, String> map, byte[] bArr, boolean z, f0.b bVar) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{str, map, bArr, Boolean.valueOf(z), bVar})) == null) {
            int i = (bArr[1] & 255) | ((bArr[2] << 8) & 65280) | ((bArr[3] << 24) >>> 8) | (bArr[4] << 24);
            LoggerProxy.d(TAG, "httpRequest = " + ((int) bArr[0]) + " , dataLen = " + i + " , url = " + str);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            try {
                Response execute = builder.connectTimeout(3L, timeUnit).readTimeout(4L, timeUnit).writeTimeout(4L, TimeUnit.MILLISECONDS).build().newCall(new Request.Builder().url(str).headers(Headers.of(map)).post(RequestBody.create(MediaType.parse("application/octet-stream"), bArr)).build()).execute();
                int code = execute.code();
                if (execute.body() != null) {
                    str2 = execute.body().string();
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    try {
                        boolean optBoolean = new JSONObject(str2).optBoolean("upload_permission");
                        if (bVar != null) {
                            try {
                                ((e0) bVar).a(optBoolean);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        LoggerProxy.d(TAG, "onResponse: " + str2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (code == 200) {
                    LoggerProxy.d(TAG, "Number of data uploaded to the file:" + i);
                    return 2;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            LoggerProxy.d(TAG, "上传文件失败了");
            return 3;
        }
        return invokeCommon.intValue;
    }

    public int dataCallBack(int i, byte[] bArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            try {
                Map<String, String> buildHeader = buildHeader(this.mPid);
                String uuid = UUID.randomUUID().toString();
                this.url = this.mTtsLogUrl + uuid;
                LoggerProxy.d(TAG, "上传文件到: " + this.url);
                return httpRequest(this.url, buildHeader, bArr, true, null);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    public int dataCollectStat(byte[] bArr, f0.b bVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bVar, str)) == null) {
            try {
                Map<String, String> buildHeader = buildHeader(str);
                String str2 = this.mTtsLogUrl + UUID.randomUUID().toString();
                this.url = str2;
                return httpRequest(str2, buildHeader, bArr, true, bVar);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeLLL.intValue;
    }

    public void init(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mTtsLogUrl = str;
            }
            this.mPid = str2;
        }
    }
}
