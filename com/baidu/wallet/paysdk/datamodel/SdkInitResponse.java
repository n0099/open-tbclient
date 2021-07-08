package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.Permission;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PollOfflineCacheSwitch;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SdkInitResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_JS_HOOK_URL = "https://co.baifubao.com/content/umoney/jspatch/hook-js.f25a0cf.zip";
    public static final String SID_JS_HOOK_URL = "js_hook_url";
    public static final String SID_OFFLINE_CACHE_CONFIG = "offline_cache_config";

    /* renamed from: a  reason: collision with root package name */
    public static final String f26040a = "langbridge_speed_up";

    /* renamed from: b  reason: collision with root package name */
    public static final String f26041b = "pass_auth_url";

    /* renamed from: c  reason: collision with root package name */
    public static final String f26042c = "key_paycode_url";

    /* renamed from: d  reason: collision with root package name */
    public static final String f26043d = "key_balance_home_url";

    /* renamed from: e  reason: collision with root package name */
    public static final String f26044e = "key_cookies_sync_domain_list";

    /* renamed from: f  reason: collision with root package name */
    public static final String f26045f = "white_screen_config";

    /* renamed from: g  reason: collision with root package name */
    public static final String f26046g = "key_loading_duration_interval";

    /* renamed from: h  reason: collision with root package name */
    public static final String f26047h = "key_transaction_records_url";

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f26048i = true;
    public transient /* synthetic */ FieldHolder $fh;
    public String JSHookURL;
    public String LangbridgeSettings;
    public String balanceHomeUrl;
    public String certWhiteList;
    public String cookiesSyncDomainList;
    public String domainConfig;
    public String domainSwitch;
    public String enableJsNameVerify;
    public String fp;
    public String interval_millis;
    public String jsipc;
    public String kefuPhoneNum;
    public String langbridgeCheckProtocol;
    public String langbridgeSpeedUp;
    public String langbridge_permission_dialog;
    public String loadingDurationInterval;
    public JSONObject loginUrl;
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
    public String publicKeyPins;
    public String sdk_permission_dialog;
    public String takePicWaitTime;
    public String transactionRecordsUrl;
    public String whiteScreenConfig;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SdkInitResponse f26053a;
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
            f26053a = new SdkInitResponse();
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
        this.JSHookURL = "";
        this.LangbridgeSettings = "";
        this.certWhiteList = "";
        this.domainSwitch = "";
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
    }

    private Map<String, EnumSet<Permission>> a(@NonNull String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    hashMap.put(next, a(jSONObject.optInt(next)));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static SdkInitResponse getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.f26053a : (SdkInitResponse) invokeV.objValue;
    }

    public static boolean isEnableJsNameVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (TextUtils.isEmpty(a.f26053a.enableJsNameVerify)) {
                return false;
            }
            return "1".equals(a.f26053a.enableJsNameVerify);
        }
        return invokeV.booleanValue;
    }

    public static boolean isLangBridgeCheckUrlProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (TextUtils.isEmpty(a.f26053a.langbridgeCheckProtocol)) {
                return true;
            }
            return "1".equals(a.f26053a.langbridgeCheckProtocol);
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
                this.balanceHomeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f26043d, "");
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
                this.cookiesSyncDomainList = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f26044e, "");
            }
            return this.cookiesSyncDomainList;
        }
        return (String) invokeL.objValue;
    }

    public String getJsHookURl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (!TextUtils.isEmpty(a.f26053a.JSHookURL)) {
                return a.f26053a.JSHookURL;
            }
            LogUtil.d("WebViewCacheManager", "cache jsHookUrl = " + ((String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, DEFAULT_JS_HOOK_URL)));
            return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, DEFAULT_JS_HOOK_URL);
        }
        return (String) invokeL.objValue;
    }

    public String getLoadingDurationInterval(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (TextUtils.isEmpty(this.loadingDurationInterval) && context != null) {
                this.loadingDurationInterval = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f26046g, "");
            }
            return this.loadingDurationInterval;
        }
        return (String) invokeL.objValue;
    }

    public String getLoginUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_GET_BINDURL);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_GET_BINDURL);
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

    public String getOfflineCacheConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? a.f26053a.offlineCacheConfig : (String) invokeL.objValue;
    }

    public String getPassAuthUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            String str = DomainConfig.getInstance().getCOHost() + "/content/resource/pass_normal/index.html";
            if (!TextUtils.isEmpty(a.f26053a.passAuthUrl)) {
                return a.f26053a.passAuthUrl;
            }
            String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f26041b, "");
            return !TextUtils.isEmpty(str2) ? str2 : str;
        }
        return (String) invokeL.objValue;
    }

    public String getPayCodeUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            if (TextUtils.isEmpty(this.paymentCodeUrl)) {
                this.paymentCodeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f26042c, "");
            }
            return this.paymentCodeUrl;
        }
        return (String) invokeL.objValue;
    }

    public int getTakePicWaitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (TextUtils.isEmpty(a.f26053a.takePicWaitTime)) {
                return 2000;
            }
            return Integer.valueOf(a.f26053a.takePicWaitTime).intValue();
        }
        return invokeV.intValue;
    }

    public String getTransactionRecordsUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            if (TextUtils.isEmpty(this.transactionRecordsUrl)) {
                this.transactionRecordsUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f26047h, "");
            }
            return this.transactionRecordsUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getWhiteScreenConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            if (!TextUtils.isEmpty(a.f26053a.whiteScreenConfig)) {
                return a.f26053a.whiteScreenConfig;
            }
            return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f26045f, "");
        }
        return (String) invokeL.objValue;
    }

    public boolean isLangbridgeSpeedUpEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            if (!TextUtils.isEmpty(a.f26053a.langbridgeSpeedUp)) {
                return "1".equals(a.f26053a.langbridgeSpeedUp);
            }
            String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f26040a, "");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return "1".equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            if (!TextUtils.isEmpty(this.offlineCacheConfig)) {
                a.f26053a.offlineCacheConfig = this.offlineCacheConfig;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, SID_OFFLINE_CACHE_CONFIG, this.offlineCacheConfig);
                try {
                    PollOfflineCacheSwitch.getInstance().updateCacheConfig((OfflineCacheConfig) JsonUtils.fromJson(this.offlineCacheConfig, OfflineCacheConfig.class));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                updateOfflineCacheConfig(context, this.offlineCacheConfig);
            }
            if (!TextUtils.isEmpty(this.interval_millis) && Integer.valueOf(this.interval_millis).intValue() > 0) {
                PollOfflineCacheSwitch.getInstance().updateIntervalTime(this.interval_millis);
            }
            if (!TextUtils.isEmpty(this.LangbridgeSettings)) {
                a.f26053a.LangbridgeSettings = this.LangbridgeSettings;
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_updateSettings").data("config", this.LangbridgeSettings), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SdkInitResponse f26049a;

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
                        this.f26049a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(this.JSHookURL)) {
                a.f26053a.JSHookURL = this.JSHookURL;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, this.JSHookURL);
                LogUtil.d("WebViewCacheManager", "init config JSHookURL = " + this.JSHookURL);
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_getToImapctJsFiles").data("configs", new String[]{"config.json"}).data(SavedStateHandle.KEYS, new String[]{"common", "multi-webview"}), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SdkInitResponse f26050a;

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
                        this.f26050a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        }
                    }
                });
            }
            if (f26048i) {
                f26048i = false;
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
                    a.f26053a.langbridgeSpeedUp = this.langbridgeSpeedUp;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f26040a, this.langbridgeSpeedUp);
                }
                if (!TextUtils.isEmpty(this.passAuthUrl)) {
                    a.f26053a.passAuthUrl = this.passAuthUrl;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f26041b, this.passAuthUrl);
                }
                a.f26053a.paymentCodeUrl = this.paymentCodeUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f26042c, this.paymentCodeUrl);
                a.f26053a.transactionRecordsUrl = this.transactionRecordsUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f26047h, this.transactionRecordsUrl);
                a.f26053a.balanceHomeUrl = this.balanceHomeUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f26043d, this.balanceHomeUrl);
                if (!TextUtils.isEmpty(this.whiteScreenConfig)) {
                    a.f26053a.whiteScreenConfig = this.whiteScreenConfig;
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f26045f, this.whiteScreenConfig);
                }
                a.f26053a.fp = this.fp;
                a.f26053a.kefuPhoneNum = this.kefuPhoneNum;
                a.f26053a.enableJsNameVerify = this.enableJsNameVerify;
                a.f26053a.loginUrl = this.loginUrl;
                a.f26053a.certWhiteList = this.certWhiteList;
                a.f26053a.jsipc = this.jsipc;
                a.f26053a.publicKeyPins = this.publicKeyPins;
                a.f26053a.langbridgeSpeedUp = this.langbridgeSpeedUp;
                a.f26053a.langbridgeCheckProtocol = this.langbridgeCheckProtocol;
                a.f26053a.passAuthUrl = this.passAuthUrl;
                a.f26053a.domainSwitch = this.domainSwitch;
                a.f26053a.domainConfig = this.domainConfig;
                a.f26053a.paymentCodeUrl = this.paymentCodeUrl;
                a.f26053a.balanceHomeUrl = this.balanceHomeUrl;
                a.f26053a.transactionRecordsUrl = this.transactionRecordsUrl;
                a.f26053a.takePicWaitTime = this.takePicWaitTime;
                a.f26053a.cookiesSyncDomainList = this.cookiesSyncDomainList;
                a.f26053a.sdk_permission_dialog = this.sdk_permission_dialog;
                a.f26053a.langbridge_permission_dialog = this.langbridge_permission_dialog;
                a.f26053a.permission_dialog_info = this.permission_dialog_info;
                a.f26053a.permission_dialog_contacts = this.permission_dialog_contacts;
                a.f26053a.permission_dialog_location = this.permission_dialog_location;
                a.f26053a.permission_dialog_camera = this.permission_dialog_camera;
                a.f26053a.permission_dialog_audio = this.permission_dialog_audio;
                a.f26053a.permission_dialog_storage = this.permission_dialog_storage;
                if (!TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f26044e, this.cookiesSyncDomainList);
                }
                a.f26053a.needShowLoadingInterval = this.needShowLoadingInterval;
                a.f26053a.loadingDurationInterval = this.loadingDurationInterval;
                if (!TextUtils.isEmpty(this.loadingDurationInterval)) {
                    SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f26046g, this.loadingDurationInterval);
                }
                try {
                    Domains.getInstance().setDomainsPermissionConfig(a(this.jsipc));
                } catch (JSONException e3) {
                    LogUtil.logd(e3.getMessage());
                }
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_setJsNameVerfiy").data("enableJsNameVerify", this.enableJsNameVerify), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SdkInitResponse f26051a;

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
                        this.f26051a = this;
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "sdk-init:\n\tfp:" + this.fp + "\n\tkefuPhoneNum:" + this.kefuPhoneNum + "\n\tenableJsNameVerify:" + this.enableJsNameVerify + "\n\tjsipc:" + this.jsipc + "\n\tpublicKeyPins:" + this.publicKeyPins + "\n\tcertWhiteList:" + this.certWhiteList + "\n\tloginUrl:" + this.loginUrl + "\n\tlangbridgeSpeedUp:" + this.langbridgeSpeedUp + "\n\tlangbridgeCheckProtocol:" + this.langbridgeCheckProtocol + "\n\tpassAuthUrl:" + this.passAuthUrl + "\n\tdomainSwitch:" + this.domainSwitch + "\n\tdomainConfig:" + this.domainConfig + "\n\twhiteScreenConfig:" + this.whiteScreenConfig + "\n\tpaymentCodeUrl:" + this.paymentCodeUrl + "\n\tbalanceHomeUrl:" + this.balanceHomeUrl + "\n\ttransactionRecordsUrl:" + this.transactionRecordsUrl + "\n\tofflineCacheConfig:" + this.offlineCacheConfig + "\n\tLangbridgeSettings:" + this.LangbridgeSettings + "\n\tcookiesSyncDomainList:" + this.cookiesSyncDomainList + "\n\tneedShowLoadingInterval:" + this.needShowLoadingInterval + "\n\tloadingDurationInterval:" + this.loadingDurationInterval;
        }
        return (String) invokeV.objValue;
    }

    public void updateOfflineCacheConfig(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_offlineCacheConfig").data("config", str), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SdkInitResponse f26052a;

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
                    this.f26052a = this;
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

    private EnumSet<Permission> a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            EnumSet<Permission> of = EnumSet.of(Permission.NONE);
            if (Permission.READ_NORMAL.verify(i2)) {
                of.add(Permission.READ_NORMAL);
            }
            if (Permission.READ_PRIVATE.verify(i2)) {
                of.add(Permission.READ_PRIVATE);
            }
            if (Permission.WRITE.verify(i2)) {
                of.add(Permission.WRITE);
            }
            if (Permission.READ_DEVICE.verify(i2)) {
                of.add(Permission.READ_DEVICE);
            }
            return of;
        }
        return (EnumSet) invokeI.objValue;
    }
}
