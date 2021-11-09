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
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
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
/* loaded from: classes10.dex */
public class SdkInitResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_JS_HOOK_URL = "https://co.baifubao.com/content/umoney/jspatch/hook-js.f0caeff.zip";
    public static final String SID_JS_HOOK_URL = "js_hook_url";
    public static final String SID_OFFLINE_CACHE_CONFIG = "offline_cache_config";

    /* renamed from: a  reason: collision with root package name */
    public static final String f59645a = "langbridge_speed_up";

    /* renamed from: b  reason: collision with root package name */
    public static final String f59646b = "pass_auth_url";

    /* renamed from: c  reason: collision with root package name */
    public static final String f59647c = "key_paycode_url";

    /* renamed from: d  reason: collision with root package name */
    public static final String f59648d = "key_balance_home_url";

    /* renamed from: e  reason: collision with root package name */
    public static final String f59649e = "key_cookies_sync_domain_list";

    /* renamed from: f  reason: collision with root package name */
    public static final String f59650f = "white_screen_config";

    /* renamed from: g  reason: collision with root package name */
    public static final String f59651g = "key_loading_duration_interval";

    /* renamed from: h  reason: collision with root package name */
    public static final String f59652h = "key_transaction_records_url";

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f59653i = true;
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SdkInitResponse f59658a;
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
            f59658a = new SdkInitResponse();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f59658a : (SdkInitResponse) invokeV.objValue;
    }

    public static boolean isEnableJsNameVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(a.f59658a.enableJsNameVerify)) {
                return false;
            }
            return "1".equals(a.f59658a.enableJsNameVerify);
        }
        return invokeV.booleanValue;
    }

    public static boolean isLangBridgeCheckUrlProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(a.f59658a.langbridgeCheckProtocol)) {
                return true;
            }
            return "1".equals(a.f59658a.langbridgeCheckProtocol);
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
                this.balanceHomeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f59648d, "");
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
                this.cookiesSyncDomainList = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f59649e, "");
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
            if (!TextUtils.isEmpty(a.f59658a.JSHookURL)) {
                return a.f59658a.JSHookURL;
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
                this.loadingDurationInterval = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f59651g, "");
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
            LogUtil.d(simpleName, "multipleMaxCount = " + a.f59658a.multipleMaxCount);
            return a.f59658a.multipleMaxCount;
        }
        return invokeV.intValue;
    }

    public String getOfflineCacheConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? a.f59658a.offlineCacheConfig : (String) invokeL.objValue;
    }

    public String getPassAuthUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            String str = DomainConfig.getInstance().getCOHost(new Boolean[]{Boolean.FALSE}) + "/content/resource/pass_normal/index.html";
            if (!TextUtils.isEmpty(a.f59658a.passAuthUrl)) {
                return a.f59658a.passAuthUrl;
            }
            String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f59646b, "");
            return !TextUtils.isEmpty(str2) ? str2 : str;
        }
        return (String) invokeL.objValue;
    }

    public String getPayCodeUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            if (TextUtils.isEmpty(this.paymentCodeUrl)) {
                this.paymentCodeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f59647c, "");
            }
            return this.paymentCodeUrl;
        }
        return (String) invokeL.objValue;
    }

    public int getTakePicWaitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (TextUtils.isEmpty(a.f59658a.takePicWaitTime)) {
                return 2000;
            }
            return Integer.valueOf(a.f59658a.takePicWaitTime).intValue();
        }
        return invokeV.intValue;
    }

    public String getTransactionRecordsUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            if (TextUtils.isEmpty(this.transactionRecordsUrl)) {
                this.transactionRecordsUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f59652h, "");
            }
            return this.transactionRecordsUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getWhiteScreenConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            if (!TextUtils.isEmpty(a.f59658a.whiteScreenConfig)) {
                return a.f59658a.whiteScreenConfig;
            }
            return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f59650f, "");
        }
        return (String) invokeL.objValue;
    }

    public boolean isLangbridgeSpeedUpEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            if (!TextUtils.isEmpty(a.f59658a.langbridgeSpeedUp)) {
                return "1".equals(a.f59658a.langbridgeSpeedUp);
            }
            String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f59645a, "");
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
            LogUtil.d("zxing", "isSupportBarCode = " + a.f59658a.supportBarCode);
            return "1".equals(a.f59658a.supportBarCode);
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportZxingScanCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LogUtil.d("zxing", "isSupportZxingScanCode = " + a.f59658a.supportZxingScanCode);
            return "1".equals(a.f59658a.supportZxingScanCode);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, context) == null) {
            LogUtil.d("okhttp", "initResponse: " + toString());
            if (!TextUtils.isEmpty(this.offlineCacheConfig)) {
                a.f59658a.offlineCacheConfig = this.offlineCacheConfig;
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
                a.f59658a.LangbridgeSettings = this.LangbridgeSettings;
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_updateSettings").data(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, this.LangbridgeSettings), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SdkInitResponse f59654a;

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
                        this.f59654a = this;
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
                a.f59658a.JSHookURL = this.JSHookURL;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, this.JSHookURL);
                LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "init config JSHookURL = " + this.JSHookURL);
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_getToImapctJsFiles").data("configs", new String[]{ComboPraiseProvider.PRAISE_CONFIG_NAME}).data(SavedStateHandle.KEYS, new String[]{"common", "multi-webview"}), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SdkInitResponse f59655a;

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
                        this.f59655a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i3, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                        }
                    }
                });
            }
            if (f59653i) {
                f59653i = false;
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
                    a.f59658a.langbridgeSpeedUp = this.langbridgeSpeedUp;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f59645a, this.langbridgeSpeedUp);
                }
                if (!TextUtils.isEmpty(this.passAuthUrl)) {
                    a.f59658a.passAuthUrl = this.passAuthUrl;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f59646b, this.passAuthUrl);
                }
                a.f59658a.paymentCodeUrl = this.paymentCodeUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f59647c, this.paymentCodeUrl);
                a.f59658a.transactionRecordsUrl = this.transactionRecordsUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f59652h, this.transactionRecordsUrl);
                a.f59658a.balanceHomeUrl = this.balanceHomeUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f59648d, this.balanceHomeUrl);
                if (!TextUtils.isEmpty(this.whiteScreenConfig)) {
                    a.f59658a.whiteScreenConfig = this.whiteScreenConfig;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f59650f, this.whiteScreenConfig);
                }
                a.f59658a.fp = this.fp;
                a.f59658a.kefuPhoneNum = this.kefuPhoneNum;
                a.f59658a.enableJsNameVerify = this.enableJsNameVerify;
                a.f59658a.loginUrl = this.loginUrl;
                a.f59658a.certWhiteList = this.certWhiteList;
                a.f59658a.jsipc = this.jsipc;
                a.f59658a.publicKeyPins = this.publicKeyPins;
                a.f59658a.langbridgeSpeedUp = this.langbridgeSpeedUp;
                a.f59658a.langbridgeCheckProtocol = this.langbridgeCheckProtocol;
                a.f59658a.passAuthUrl = this.passAuthUrl;
                a.f59658a.domainSwitch = this.domainSwitch;
                a.f59658a.domainConfig = this.domainConfig;
                a.f59658a.paymentCodeUrl = this.paymentCodeUrl;
                a.f59658a.balanceHomeUrl = this.balanceHomeUrl;
                a.f59658a.transactionRecordsUrl = this.transactionRecordsUrl;
                a.f59658a.takePicWaitTime = this.takePicWaitTime;
                a.f59658a.cookiesSyncDomainList = this.cookiesSyncDomainList;
                a.f59658a.sdk_permission_dialog = this.sdk_permission_dialog;
                a.f59658a.langbridge_permission_dialog = this.langbridge_permission_dialog;
                a.f59658a.permission_dialog_info = this.permission_dialog_info;
                a.f59658a.permission_dialog_contacts = this.permission_dialog_contacts;
                a.f59658a.permission_dialog_location = this.permission_dialog_location;
                a.f59658a.permission_dialog_camera = this.permission_dialog_camera;
                a.f59658a.permission_dialog_audio = this.permission_dialog_audio;
                a.f59658a.permission_dialog_storage = this.permission_dialog_storage;
                a.f59658a.supportZxingScanCode = this.supportZxingScanCode;
                a.f59658a.supportBarCode = this.supportBarCode;
                a.f59658a.multipleMaxCount = this.multipleMaxCount;
                if (!TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f59649e, this.cookiesSyncDomainList);
                }
                a.f59658a.needShowLoadingInterval = this.needShowLoadingInterval;
                a.f59658a.loadingDurationInterval = this.loadingDurationInterval;
                if (!TextUtils.isEmpty(this.loadingDurationInterval)) {
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f59651g, this.loadingDurationInterval);
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
                    public final /* synthetic */ SdkInitResponse f59656a;

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
                        this.f59656a = this;
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
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("langbrige").action("langbrige_offlineCacheConfig").data(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, str), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SdkInitResponse f59657a;

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
                    this.f59657a = this;
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
