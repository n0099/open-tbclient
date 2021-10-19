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
/* loaded from: classes8.dex */
public final class DebugConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static Boolean[] A = null;
    public static String B = null;
    public static String C = null;
    public static DebugConfig D = null;
    public static String DEFAULT_ENVIRONMENT = "ONLINE";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    public static final String G = "https://www.baifubao.com";
    public static String LBS_HOST = null;
    public static final String PASS_COMPLETE_VERIFY = "pass_complete_verify";
    public static final String SERVER_COMPLETE_VERIFY = "http://wappass.baidu.com/v2/?bindingret";
    public static final String SERVICE = "service";
    public static final String VOICE_API_HOST_DFT = "https://wallet.baidu.com";
    public static final String VOICE_SERVICE_URL_DFT = "https://wallet.baidu.com";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f61057a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61058b = "wallet_config.properties";

    /* renamed from: c  reason: collision with root package name */
    public static final String f61059c = "wallet_https_host";

    /* renamed from: d  reason: collision with root package name */
    public static final String f61060d = "wallet_passport_host";

    /* renamed from: e  reason: collision with root package name */
    public static final String f61061e = "environment";

    /* renamed from: f  reason: collision with root package name */
    public static final String f61062f = "wallet_plugin_host";

    /* renamed from: g  reason: collision with root package name */
    public static final String f61063g = "wallet_nfc_host";

    /* renamed from: h  reason: collision with root package name */
    public static final String f61064h = "wallet_web_cache_host";

    /* renamed from: i  reason: collision with root package name */
    public static final String f61065i = "voiceprint_service";

    /* renamed from: j  reason: collision with root package name */
    public static final String f61066j = "voiceprint_host";
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
    public File E;
    public Properties F;

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
        A = new Boolean[]{Boolean.FALSE};
        B = DomainConfig.getInstance().getCometHost(A);
        LBS_HOST = DomainConfig.getInstance().getZhiFuHost(A);
        C = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
        D = null;
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
        this.E = null;
        if (context != null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                    File externalFilesDir = context.getExternalFilesDir("");
                    if (externalFilesDir != null && !externalFilesDir.exists()) {
                        externalFilesDir.mkdirs();
                    }
                    this.E = new File(externalFilesDir, f61058b);
                    this.F = b();
                }
            } catch (Exception unused) {
                return;
            }
        }
        this.E = new File(String.valueOf(Environment.getExternalStorageDirectory()), f61058b);
        this.F = b();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            c.a().a(a("life_host"));
            c.a().d(a("app_host"));
            c.a().f(a(c.r));
            c.a().h(a(c.t));
            c.a().k(a("comet_host"));
            c.a().c(a(c.o));
            c.a().g(a(c.s));
            c.a().e(a("nfc_host"));
            c.a().b(a("my_host"));
            c.a().i(a(c.u));
            c.a().j(a(c.v));
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
                        fileInputStream = new FileInputStream(this.E);
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
                if (D == null) {
                    D = new DebugConfig(context);
                }
                debugConfig = D;
            }
            return debugConfig;
        }
        return (DebugConfig) invokeL.objValue;
    }

    public void changeOnline() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f61057a = false;
            p = "https://www.baifubao.com";
            r = "https://wappass.baidu.com/passport/";
            s = "https://chong.baidu.com";
            LBS_HOST = DomainConfig.getInstance().getZhiFuHost(A);
            t = "https://wallet.baidu.com";
            DEFAULT_ENVIRONMENT = "ONLINE";
            B = DomainConfig.getInstance().getCometHost(A);
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
            f61057a = true;
            DEFAULT_ENVIRONMENT = "QA";
            readConfigHost(true);
        }
    }

    public String getCometPushHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? B : (String) invokeV.objValue;
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
            if (f61057a) {
                return a(f61061e);
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
            if (!f61057a) {
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
                return DomainConfig.getInstance().getLifeHost(A);
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
                return DomainConfig.getInstance().getAppHost(A);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? C : (String) invokeV.objValue;
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
            f61057a = z2;
            if (z2) {
                a();
            } else {
                p = "https://www.baifubao.com";
                r = "https://wappass.baidu.com/passport/";
                C = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
                s = "https://chong.baidu.com";
                t = "https://wallet.baidu.com";
                B = DomainConfig.getInstance().getCometHost(A);
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
            B = str;
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
                if (D == null) {
                    D = new DebugConfig(null);
                }
                debugConfig = D;
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
            this.F = b2;
            return b2.getProperty(str);
        }
        return (String) invokeL.objValue;
    }
}
