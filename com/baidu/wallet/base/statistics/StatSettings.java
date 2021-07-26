package com.baidu.wallet.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.statistics.Config;
import com.baidu.apollon.statistics.StatisticsSettings;
import com.baidu.bankdetection.BuildConfig;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.UAFilterUtil;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class StatSettings extends StatisticsSettings {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BDUSS = "bs";
    public static final String BDUSS_KEY = "bk";
    public static final String CUID = "cu2";
    public static final String CUID_SEC = "cu";
    public static final String GET_STRATETY_URL = "/callback";
    public static final String LOCATION = "lc";
    public static final String LOG_SEND_URL = "/chanpin_stat";
    public static final String OPERATOR = "op";
    public static final String SSID = "sd";
    public static final String UA = "ua";
    public static final String UNIONID = "union_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f24281a;

    /* renamed from: b  reason: collision with root package name */
    public String f24282b;

    /* renamed from: c  reason: collision with root package name */
    public String f24283c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24284d;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static StatSettings f24286a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1582602095, "Lcom/baidu/wallet/base/statistics/StatSettings$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1582602095, "Lcom/baidu/wallet/base/statistics/StatSettings$a;");
                    return;
                }
            }
            f24286a = new StatSettings();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, context) == null) && this.f24284d == null && context != null) {
            this.f24284d = context.getApplicationContext();
        }
    }

    public static StatSettings getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            a.f24286a.a(context);
            return a.f24286a;
        }
        return (StatSettings) invokeL.objValue;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getCommonHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.wallet.base.statistics.a a2 = com.baidu.wallet.base.statistics.a.a();
                jSONObject.putOpt("ua", a2.c(this.f24284d));
                jSONObject.putOpt("cu", a2.a(this.f24284d));
                jSONObject.put("cu2", a2.b(this.f24284d));
                jSONObject.putOpt("op", a2.d(this.f24284d));
                jSONObject.putOpt("bs", a2.e(this.f24284d));
                jSONObject.putOpt("bk", a2.f(this.f24284d));
                jSONObject.putOpt("sd", a2.h(this.f24284d));
                jSONObject.putOpt(UNIONID, a2.b());
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getCrashDataHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.m, SafePay.getInstance().encryptProxy(WalletLoginHelper.getInstance().getPassUid()));
                jSONObject.put(Config.n, SafePay.getInstance().getpwProxy());
                return jSONObject.toString();
            } catch (Throwable th) {
                LogUtil.d("wallet_stastics", th.toString());
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getPackagesConcerned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f24282b == null) {
                this.f24282b = "com.baidu.wallet.pay,com.baidu.wallet.balance," + BuildConfig.APPLICATION_ID + ",com.baidu.wallet.fastpay,com.baidu.wallet.home,com.baidu.wallet.paysdk,com.baidu.wallet.personal,com.baidu.wallet.scancode,com.baidu.wallet.transfer,com.baidu.wallet,com.baidu.android.pay,com.baidu.android.lbspay";
            }
            return this.f24282b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return a(this.f24284d, 0, DebugConfig.getInstance(this.f24284d).getStatStrategyHost() + GET_STRATETY_URL);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getUploadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DebugConfig.getInstance().getStatisticsHost() + LOG_SEND_URL;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public boolean isEnableCrashHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public boolean isForbidToUploadNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public boolean isReleaseVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f24281a : invokeV.booleanValue;
    }

    public void setReleaseVesionFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f24281a = z;
        }
    }

    public StatSettings() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24281a = true;
        this.f24282b = null;
    }

    private String a(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, this, context, i2, str)) == null) {
            RestTemplate restTemplate = new RestTemplate(context, UAFilterUtil.getInstance().getTrueUA(context), "stastics bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("cmd", "2201"));
            arrayList.add(new RestNameValuePair("callback", "productReportStrategy"));
            String c2 = com.baidu.wallet.base.statistics.a.a().c(context);
            if (!TextUtils.isEmpty(c2)) {
                arrayList.add(new RestNameValuePair("ua", c2));
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new RestHttpRequestInterceptor(this) { // from class: com.baidu.wallet.base.statistics.StatSettings.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ StatSettings f24285a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24285a = this;
                }

                @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
                public void intercept(Context context2, d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, dVar) == null) {
                        dVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    }
                }
            });
            restTemplate.setRequestInterceptor(arrayList2);
            restTemplate.setMessageConverter(new b());
            String str3 = null;
            try {
                if (i2 == 0) {
                    str2 = (String) restTemplate.a(str, arrayList, "utf-8", String.class);
                } else {
                    str2 = (String) restTemplate.c(str, arrayList, "utf-8", String.class);
                }
                str3 = str2;
                return str3;
            } catch (RestRuntimeException e2) {
                e2.printStackTrace();
                return str3;
            }
        }
        return (String) invokeLIL.objValue;
    }
}
