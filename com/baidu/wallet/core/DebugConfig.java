package com.baidu.wallet.core;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.domain.c;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes5.dex */
public final class DebugConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static String A = null;
    public static String B = null;
    public static DebugConfig C = null;
    public static String DEFAULT_ENVIRONMENT = "ONLINE";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    public static final String F = "https://www.baifubao.com";
    public static String LBS_HOST = null;
    public static final String PASS_COMPLETE_VERIFY = "pass_complete_verify";
    public static final String SERVER_COMPLETE_VERIFY = "http://wappass.baidu.com/v2/?bindingret";
    public static final String SERVICE = "service";
    public static final String VOICE_API_HOST_DFT = "https://wallet.baidu.com";
    public static final String VOICE_SERVICE_URL_DFT = "https://wallet.baidu.com";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24813a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f24814b = "wallet_config.properties";

    /* renamed from: c  reason: collision with root package name */
    public static final String f24815c = "wallet_https_host";

    /* renamed from: d  reason: collision with root package name */
    public static final String f24816d = "wallet_passport_host";

    /* renamed from: e  reason: collision with root package name */
    public static final String f24817e = "environment";

    /* renamed from: f  reason: collision with root package name */
    public static final String f24818f = "wallet_plugin_host";

    /* renamed from: g  reason: collision with root package name */
    public static final String f24819g = "wallet_nfc_host";

    /* renamed from: h  reason: collision with root package name */
    public static final String f24820h = "wallet_web_cache_host";

    /* renamed from: i  reason: collision with root package name */
    public static final String f24821i = "voiceprint_service";
    public static final String j = "voiceprint_host";
    public static final String k = "wallet_stat_host";
    public static final String l = "wallet_stat_strategy_host";
    public static final String m = "wallet_sensor_stat_host";
    public static final String n = "wallet_coupon_host";
    public static final String o = "wallet_comet_push_host";
    public static String p = "https://www.baifubao.com";
    public static String q = "http://www.baifubao.com";
    public static String r = "http://wappass.baidu.com/passport";
    public static String s = "https://chong.baidu.com";
    public static String t = "https://wallet.baidu.com";
    public static String u = "https://wallet.baidu.com";
    public static String v = "https://wallet.baidu.com";
    public static String w = "https://www.baifubao.com";
    public static String x = "https://www.baifubao.com";
    public static String y = "https://www.baifubao.com";
    public static String z = "https://datasink.dxmpay.com";
    public transient /* synthetic */ FieldHolder $fh;
    public File D;
    public Properties E;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(524126318, "Lcom/baidu/wallet/core/DebugConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(524126318, "Lcom/baidu/wallet/core/DebugConfig;");
                return;
            }
        }
        A = DomainConfig.getInstance().getCometHost();
        LBS_HOST = DomainConfig.getInstance().getZhiFuHost();
        B = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
        C = null;
    }

    public DebugConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = null;
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            File externalFilesDir = context.getExternalFilesDir("");
            if (externalFilesDir != null && !externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            this.D = new File(externalFilesDir, f24814b);
        } else {
            this.D = new File(String.valueOf(Environment.getExternalStorageDirectory()), f24814b);
        }
        this.E = b();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            c.a().a(a("life_host"));
            c.a().d(a("app_host"));
            c.a().f(a(c.n));
            c.a().h(a(c.p));
            c.a().k(a("comet_host"));
            c.a().c(a(c.k));
            c.a().g(a(c.o));
            c.a().e(a("nfc_host"));
            c.a().b(a("my_host"));
            c.a().i(a(c.q));
            c.a().j(a(c.r));
            c.a().l(a("wallet_web_cache_host"));
            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA);
            String a2 = a(k);
            w = a2;
            if (TextUtils.isEmpty(a2)) {
                w = "https://www.baifubao.com";
            }
            String a3 = a(l);
            x = a3;
            if (TextUtils.isEmpty(a3)) {
                x = "https://www.baifubao.com";
            }
            String a4 = a(m);
            z = a4;
            if (TextUtils.isEmpty(a4)) {
                z = "https://datasink.dxmpay.com";
            }
        }
    }

    private Properties b() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Properties properties = new Properties();
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(this.D);
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused2) {
            }
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (Exception unused3) {
                fileInputStream2 = fileInputStream;
                LogUtil.d("DebugConfig", "the wallet_config.properties is not exist!!");
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return properties;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
            return properties;
        }
        return (Properties) invokeV.objValue;
    }

    public static synchronized DebugConfig getInstance(Context context) {
        InterceptResult invokeL;
        DebugConfig debugConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (DebugConfig.class) {
                if (C == null) {
                    C = new DebugConfig(context);
                }
                debugConfig = C;
            }
            return debugConfig;
        }
        return (DebugConfig) invokeL.objValue;
    }

    public void changeOnline() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f24813a = false;
            p = "https://www.baifubao.com";
            r = "https://wappass.baidu.com/passport/";
            s = "https://chong.baidu.com";
            LBS_HOST = DomainConfig.getInstance().getZhiFuHost();
            t = "https://wallet.baidu.com";
            DEFAULT_ENVIRONMENT = "ONLINE";
            A = DomainConfig.getInstance().getCometHost();
            u = "https://wallet.baidu.com";
            v = "https://wallet.baidu.com";
            w = "https://www.baifubao.com";
            x = "https://www.baifubao.com";
            y = "https://www.baifubao.com";
        }
    }

    public void changeQA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f24813a = true;
            DEFAULT_ENVIRONMENT = "QA";
            readConfigHost(true);
        }
    }

    public String getCometPushHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? A : (String) invokeV.objValue;
    }

    public String getCouponHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? t : (String) invokeV.objValue;
    }

    public String getEnvironment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (f24813a) {
                return a(f24817e);
            }
            return DEFAULT_ENVIRONMENT;
        }
        return (String) invokeV.objValue;
    }

    public String getFixedWalletHttpsHostForH5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "https://www.baifubao.com" : (String) invokeV.objValue;
    }

    public String getProperty(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (!f24813a) {
                LogUtil.logd("没有打开DEBUG开关 返回默认值=" + str2);
                return str2;
            }
            String a2 = a(str);
            if (TextUtils.isEmpty(a2)) {
                LogUtil.logd("配置文件没有配置 返回默认值=" + str2);
                return str2;
            }
            LogUtil.logd("返回配置文件的值 value=" + a2);
            return a2;
        }
        return (String) invokeLL.objValue;
    }

    public String getSenorStatisticsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? z : (String) invokeV.objValue;
    }

    public String getStatStrategyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (isOnline()) {
                return DomainConfig.getInstance().getLifeHost();
            }
            return x;
        }
        return (String) invokeV.objValue;
    }

    public String getStatisticsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (isOnline()) {
                return DomainConfig.getInstance().getAppHost();
            }
            return w;
        }
        return (String) invokeV.objValue;
    }

    public String getVoiceprintHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? v : (String) invokeV.objValue;
    }

    public String getVoiceprintServiceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? u : (String) invokeV.objValue;
    }

    public String getWalletHttpsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? p : (String) invokeV.objValue;
    }

    public String getWalletNfcHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? s : (String) invokeV.objValue;
    }

    public String getWalletPassportHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? r : (String) invokeV.objValue;
    }

    public String getWalletPluginHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? B : (String) invokeV.objValue;
    }

    public String getWebCacheHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? y : (String) invokeV.objValue;
    }

    public boolean isOnline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "ONLINE".equals(getEnvironment()) : invokeV.booleanValue;
    }

    public void readConfigHost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            f24813a = z2;
            if (z2) {
                a();
            } else {
                p = "https://www.baifubao.com";
                r = "https://wappass.baidu.com/passport/";
                B = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
                s = "https://chong.baidu.com";
                t = "https://wallet.baidu.com";
                A = DomainConfig.getInstance().getCometHost();
                u = "https://wallet.baidu.com";
                v = "https://wallet.baidu.com";
                w = "https://www.baifubao.com";
                x = "https://www.baifubao.com";
                y = "https://www.baifubao.com";
                z = "https://datasink.dxmpay.com";
            }
            RestDebugConfig.getInstance().setQAEnv(z2);
        }
    }

    public void setCometPushHttps(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            A = str;
        }
    }

    public void setWalletHttpsHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            p = str;
        }
    }

    public static synchronized DebugConfig getInstance() {
        InterceptResult invokeV;
        DebugConfig debugConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            synchronized (DebugConfig.class) {
                if (C == null) {
                    C = new DebugConfig(null);
                }
                debugConfig = C;
            }
            return debugConfig;
        }
        return (DebugConfig) invokeV.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            Properties b2 = b();
            this.E = b2;
            return b2.getProperty(str);
        }
        return (String) invokeL.objValue;
    }
}
