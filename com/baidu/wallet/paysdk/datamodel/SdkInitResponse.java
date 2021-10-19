package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.Permission;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PollInitUtils;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import java.util.HashMap;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SdkInitResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_JS_HOOK_URL = "https://co.baifubao.com/content/umoney/jspatch/hook-js.f0caeff.zip";
    public static final String SID_JS_HOOK_URL = "js_hook_url";
    public static final String SID_OFFLINE_CACHE_CONFIG = "offline_cache_config";

    /* renamed from: a  reason: collision with root package name */
    public static final String f62777a = "langbridge_speed_up";

    /* renamed from: b  reason: collision with root package name */
    public static final String f62778b = "pass_auth_url";

    /* renamed from: c  reason: collision with root package name */
    public static final String f62779c = "key_paycode_url";

    /* renamed from: d  reason: collision with root package name */
    public static final String f62780d = "key_balance_home_url";

    /* renamed from: e  reason: collision with root package name */
    public static final String f62781e = "key_cookies_sync_domain_list";

    /* renamed from: f  reason: collision with root package name */
    public static final String f62782f = "white_screen_config";

    /* renamed from: g  reason: collision with root package name */
    public static final String f62783g = "key_loading_duration_interval";

    /* renamed from: h  reason: collision with root package name */
    public static final String f62784h = "key_transaction_records_url";

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f62785i = true;
    public transient /* synthetic */ FieldHolder $fh;
    public String JSHookURL;
    public String LangbridgeSettings;
    public String appDomainConfig;
    public int attemptDelay;
    public String balanceHomeUrl;
    public String certWhiteList;
    public String cookiesSyncDomainList;
    public String domainConfig;
    public String domainSwitch;
    public String enableHE;
    public String enableJsNameVerify;
    public String enableNetStat;
    public String fp;
    public String interval_millis;
    public String jsipc;
    public String kefuPhoneNum;
    public String langbridgeCheckProtocol;
    public String langbridgeSpeedUp;
    public String langbridge_permission_dialog;
    public String loadingDurationInterval;
    public JSONObject loginUrl;
    public int multipleMaxCount;
    public String needShowLoadingInterval;
    public String offlineCacheConfig;
    public String passAuthUrl;
    public String paymentCodeUrl;
    public String permission_dialog_audio;
    public String permission_dialog_camera;
    public String permission_dialog_contacts;
    public String permission_dialog_info;
    public String permission_dialog_location;
    public String permission_dialog_storage;
    public String polling_switch;
    public String publicKeyPins;
    public double samplingRate;
    public String sdk_permission_dialog;
    public String sign;
    public String supportBarCode;
    public String supportZxingScanCode;
    public String takePicWaitTime;
    public String transactionRecordsUrl;
    public String useOkHttp;
    public String whiteScreenConfig;

    /* loaded from: classes8.dex */
    public static class OfflineCacheConfig implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean useOfflineCache;
        public boolean usePreSetCookie;
        public boolean usePreload;

        public OfflineCacheConfig() {
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
            this.useOfflineCache = true;
        }

        public boolean isUseOfflineCache() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.useOfflineCache : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SdkInitResponse f62790a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1338105784, "Lcom/baidu/wallet/paysdk/datamodel/SdkInitResponse$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1338105784, "Lcom/baidu/wallet/paysdk/datamodel/SdkInitResponse$a;");
                    return;
                }
            }
            f62790a = new SdkInitResponse();
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1862292651, "Lcom/baidu/wallet/paysdk/datamodel/SdkInitResponse;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1862292651, "Lcom/baidu/wallet/paysdk/datamodel/SdkInitResponse;");
        }
    }

    public SdkInitResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.fp = "";
        this.kefuPhoneNum = "";
        this.enableJsNameVerify = "";
        this.jsipc = "";
        this.publicKeyPins = "";
        this.langbridgeSpeedUp = "";
        this.langbridgeCheckProtocol = "";
        this.passAuthUrl = "";
        this.whiteScreenConfig = "";
        this.takePicWaitTime = "";
        this.offlineCacheConfig = "";
        this.interval_millis = "";
        this.polling_switch = "true";
        this.JSHookURL = "";
        this.LangbridgeSettings = "";
        this.supportZxingScanCode = "0";
        this.supportBarCode = "0";
        this.certWhiteList = "";
        this.domainSwitch = "";
        this.appDomainConfig = "";
        this.domainConfig = "";
        this.paymentCodeUrl = "";
        this.balanceHomeUrl = "";
        this.transactionRecordsUrl = "";
        this.cookiesSyncDomainList = "";
        this.needShowLoadingInterval = "";
        this.sdk_permission_dialog = "";
        this.langbridge_permission_dialog = "";
        this.permission_dialog_info = "";
        this.permission_dialog_contacts = "";
        this.permission_dialog_location = "";
        this.permission_dialog_camera = "";
        this.permission_dialog_audio = "";
        this.permission_dialog_storage = "";
        this.loadingDurationInterval = "";
        this.useOkHttp = "1";
        this.enableHE = "1";
        this.enableNetStat = "1";
        this.samplingRate = 0.1d;
        this.multipleMaxCount = 9;
        this.sign = "";
    }

    public static SdkInitResponse getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62790a : (SdkInitResponse) invokeV.objValue;
    }

    public static boolean isEnableJsNameVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(a.f62790a.enableJsNameVerify)) {
                return false;
            }
            return "1".equals(a.f62790a.enableJsNameVerify);
        }
        return invokeV.booleanValue;
    }

    public static boolean isLangBridgeCheckUrlProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(a.f62790a.langbridgeCheckProtocol)) {
                return true;
            }
            return "1".equals(a.f62790a.langbridgeCheckProtocol);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getBalanceHomeUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (TextUtils.isEmpty(this.balanceHomeUrl)) {
                this.balanceHomeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f62780d, "");
            }
            return this.balanceHomeUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getCookiesSyncDomainList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                this.cookiesSyncDomainList = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f62781e, "");
                LogUtil.d("Cookie", "use cache: " + this.cookiesSyncDomainList);
            } else {
                LogUtil.d("Cookie", "use online: " + this.cookiesSyncDomainList);
            }
            return this.cookiesSyncDomainList;
        }
        return (String) invokeL.objValue;
    }

    public String getJsHookURl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (!TextUtils.isEmpty(a.f62790a.JSHookURL)) {
                return a.f62790a.JSHookURL;
            }
            LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "cache jsHookUrl = " + ((String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, DEFAULT_JS_HOOK_URL)));
            return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, DEFAULT_JS_HOOK_URL);
        }
        return (String) invokeL.objValue;
    }

    public String getLoadingDurationInterval(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (TextUtils.isEmpty(this.loadingDurationInterval) && context != null) {
                this.loadingDurationInterval = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f62783g, "");
            }
            return this.loadingDurationInterval;
        }
        return (String) invokeL.objValue;
    }

    public String getLoginUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            DXMSdkSAUtils.onEvent("event_get_bindurl");
            JSONObject jSONObject = this.loginUrl;
            if (jSONObject == null) {
                return "";
            }
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public int getMultipleMaxCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String simpleName = SdkInitResponse.class.getSimpleName();
            LogUtil.d(simpleName, "multipleMaxCount = " + a.f62790a.multipleMaxCount);
            return a.f62790a.multipleMaxCount;
        }
        return invokeV.intValue;
    }

    public String getOfflineCacheConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? a.f62790a.offlineCacheConfig : (String) invokeL.objValue;
    }

    public String getPassAuthUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            String str = DomainConfig.getInstance().getCOHost(new Boolean[]{Boolean.FALSE}) + "/content/resource/pass_normal/index.html";
            if (!TextUtils.isEmpty(a.f62790a.passAuthUrl)) {
                return a.f62790a.passAuthUrl;
            }
            String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f62778b, "");
            return !TextUtils.isEmpty(str2) ? str2 : str;
        }
        return (String) invokeL.objValue;
    }

    public String getPayCodeUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            if (TextUtils.isEmpty(this.paymentCodeUrl)) {
                this.paymentCodeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f62779c, "");
            }
            return this.paymentCodeUrl;
        }
        return (String) invokeL.objValue;
    }

    public int getTakePicWaitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (TextUtils.isEmpty(a.f62790a.takePicWaitTime)) {
                return 2000;
            }
            return Integer.valueOf(a.f62790a.takePicWaitTime).intValue();
        }
        return invokeV.intValue;
    }

    public String getTransactionRecordsUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            if (TextUtils.isEmpty(this.transactionRecordsUrl)) {
                this.transactionRecordsUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f62784h, "");
            }
            return this.transactionRecordsUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getWhiteScreenConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            if (!TextUtils.isEmpty(a.f62790a.whiteScreenConfig)) {
                return a.f62790a.whiteScreenConfig;
            }
            return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f62782f, "");
        }
        return (String) invokeL.objValue;
    }

    public boolean isLangbridgeSpeedUpEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            if (!TextUtils.isEmpty(a.f62790a.langbridgeSpeedUp)) {
                return "1".equals(a.f62790a.langbridgeSpeedUp);
            }
            String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f62777a, "");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return "1".equals(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isSupportBarCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            LogUtil.d("zxing", "isSupportBarCode = " + a.f62790a.supportBarCode);
            return "1".equals(a.f62790a.supportBarCode);
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportZxingScanCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LogUtil.d("zxing", "isSupportZxingScanCode = " + a.f62790a.supportZxingScanCode);
            return "1".equals(a.f62790a.supportZxingScanCode);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, context) == null) {
            LogUtil.d("okhttp", "initResponse: " + toString());
            if (!TextUtils.isEmpty(this.offlineCacheConfig)) {
                a.f62790a.offlineCacheConfig = this.offlineCacheConfig;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, SID_OFFLINE_CACHE_CONFIG, this.offlineCacheConfig);
                updateOfflineCacheConfig(context, this.offlineCacheConfig);
            }
            RestDebugConfig.setEnableOkHttp("1".equals(this.useOkHttp));
            RestDebugConfig.setEnableHappyEyeballs("1".equals(this.enableHE));
            RestDebugConfig.setEnableNetworkStats("1".equals(this.enableNetStat));
            RestDebugConfig.updateOkHttpEventListenerFactory(this.samplingRate);
            int i2 = this.attemptDelay;
            if (i2 > 0) {
                RestDebugConfig.setOkHttpAttemptConnectionDelay(i2);
            }
            if (!TextUtils.isEmpty(this.interval_millis) && Integer.valueOf(this.interval_millis).intValue() > 0) {
                PollInitUtils.getInstance().updateIntervalTime(this.interval_millis);
            }
            if (!TextUtils.isEmpty(this.polling_switch)) {
                PollInitUtils.getInstance().updatePollingSwitch(this.polling_switch);
            }
            LogUtil.i("mwsettings", "LangbridgeSettings  " + this.LangbridgeSettings);
            if (!TextUtils.isEmpty(this.LangbridgeSettings)) {
                a.f62790a.LangbridgeSettings = this.LangbridgeSettings;
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_updateSettings").data("config", this.LangbridgeSettings), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SdkInitResponse f62786a;

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
                        this.f62786a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i3, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(this.JSHookURL)) {
                a.f62790a.JSHookURL = this.JSHookURL;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, this.JSHookURL);
                LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "init config JSHookURL = " + this.JSHookURL);
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_getToImapctJsFiles").data("configs", new String[]{"config.json"}).data(SavedStateHandle.KEYS, new String[]{"common", "multi-webview"}), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SdkInitResponse f62787a;

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
                        this.f62787a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i3, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                        }
                    }
                });
            }
            if (f62785i) {
                f62785i = false;
                if (!TextUtils.isEmpty(this.fp)) {
                    String decrypt = SafePay.getInstance().decrypt(this.fp);
                    if (!TextUtils.isEmpty(decrypt) && !decrypt.equals(BdWalletUtils.getDeviceFP(context))) {
                        BdWalletUtils.setDeviceFP(context, decrypt);
                    }
                }
                if (!TextUtils.isEmpty(this.kefuPhoneNum)) {
                    BdWalletUtils.setKefuPhoneNumToSP(context, this.kefuPhoneNum);
                }
                if (!TextUtils.isEmpty(this.langbridgeSpeedUp)) {
                    a.f62790a.langbridgeSpeedUp = this.langbridgeSpeedUp;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f62777a, this.langbridgeSpeedUp);
                }
                if (!TextUtils.isEmpty(this.passAuthUrl)) {
                    a.f62790a.passAuthUrl = this.passAuthUrl;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f62778b, this.passAuthUrl);
                }
                a.f62790a.paymentCodeUrl = this.paymentCodeUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f62779c, this.paymentCodeUrl);
                a.f62790a.transactionRecordsUrl = this.transactionRecordsUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f62784h, this.transactionRecordsUrl);
                a.f62790a.balanceHomeUrl = this.balanceHomeUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f62780d, this.balanceHomeUrl);
                if (!TextUtils.isEmpty(this.whiteScreenConfig)) {
                    a.f62790a.whiteScreenConfig = this.whiteScreenConfig;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f62782f, this.whiteScreenConfig);
                }
                a.f62790a.fp = this.fp;
                a.f62790a.kefuPhoneNum = this.kefuPhoneNum;
                a.f62790a.enableJsNameVerify = this.enableJsNameVerify;
                a.f62790a.loginUrl = this.loginUrl;
                a.f62790a.certWhiteList = this.certWhiteList;
                a.f62790a.jsipc = this.jsipc;
                a.f62790a.publicKeyPins = this.publicKeyPins;
                a.f62790a.langbridgeSpeedUp = this.langbridgeSpeedUp;
                a.f62790a.langbridgeCheckProtocol = this.langbridgeCheckProtocol;
                a.f62790a.passAuthUrl = this.passAuthUrl;
                a.f62790a.domainSwitch = this.domainSwitch;
                a.f62790a.domainConfig = this.domainConfig;
                a.f62790a.paymentCodeUrl = this.paymentCodeUrl;
                a.f62790a.balanceHomeUrl = this.balanceHomeUrl;
                a.f62790a.transactionRecordsUrl = this.transactionRecordsUrl;
                a.f62790a.takePicWaitTime = this.takePicWaitTime;
                a.f62790a.cookiesSyncDomainList = this.cookiesSyncDomainList;
                a.f62790a.sdk_permission_dialog = this.sdk_permission_dialog;
                a.f62790a.langbridge_permission_dialog = this.langbridge_permission_dialog;
                a.f62790a.permission_dialog_info = this.permission_dialog_info;
                a.f62790a.permission_dialog_contacts = this.permission_dialog_contacts;
                a.f62790a.permission_dialog_location = this.permission_dialog_location;
                a.f62790a.permission_dialog_camera = this.permission_dialog_camera;
                a.f62790a.permission_dialog_audio = this.permission_dialog_audio;
                a.f62790a.permission_dialog_storage = this.permission_dialog_storage;
                a.f62790a.supportZxingScanCode = this.supportZxingScanCode;
                a.f62790a.supportBarCode = this.supportBarCode;
                a.f62790a.multipleMaxCount = this.multipleMaxCount;
                if (!TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f62781e, this.cookiesSyncDomainList);
                }
                a.f62790a.needShowLoadingInterval = this.needShowLoadingInterval;
                a.f62790a.loadingDurationInterval = this.loadingDurationInterval;
                if (!TextUtils.isEmpty(this.loadingDurationInterval)) {
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f62783g, this.loadingDurationInterval);
                }
                try {
                    LogUtil.d("Domains", "parse the online jsipc: " + this.jsipc);
                    Domains.getInstance().setDomainsPermissionConfig(Permission.parseDomainsConfig(this.jsipc));
                } catch (JSONException e2) {
                    LogUtil.logd(e2.getMessage());
                }
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_setJsNameVerfiy").data("enableJsNameVerify", this.enableJsNameVerify), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SdkInitResponse f62788a;

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
                        this.f62788a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i3, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                        }
                    }
                });
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return ExtendedMessageFormat.START_FE + super.toString() + ", useOkHttp='" + this.useOkHttp + ExtendedMessageFormat.QUOTE + ", enableHE='" + this.enableHE + ExtendedMessageFormat.QUOTE + ", enableNetStat='" + this.enableNetStat + ExtendedMessageFormat.QUOTE + ", attemptDelay=" + this.attemptDelay + ExtendedMessageFormat.QUOTE + ", mwSettings=" + this.LangbridgeSettings + ExtendedMessageFormat.QUOTE + ", supportZxingScanCode" + this.supportZxingScanCode + ExtendedMessageFormat.QUOTE + ", supportBarCode" + this.supportBarCode + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public void updateOfflineCacheConfig(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, str) == null) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("langbrige").action("langbrige_offlineCacheConfig").data("config", str), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SdkInitResponse f62789a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62789a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                    }
                }
            });
        }
    }
}
