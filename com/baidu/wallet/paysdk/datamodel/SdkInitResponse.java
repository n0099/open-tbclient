package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
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
    public static final String DEFAULT_JS_HOOK_URL = "https://co.baifubao.com/content/umoney/jspatch/hook-js.f25a0cf.zip";
    public static final String SID_JS_HOOK_URL = "js_hook_url";
    public static final String SID_OFFLINE_CACHE_CONFIG = "offline_cache_config";

    /* renamed from: a  reason: collision with root package name */
    public static final String f25564a = "langbridge_speed_up";

    /* renamed from: b  reason: collision with root package name */
    public static final String f25565b = "pass_auth_url";

    /* renamed from: c  reason: collision with root package name */
    public static final String f25566c = "key_paycode_url";

    /* renamed from: d  reason: collision with root package name */
    public static final String f25567d = "key_balance_home_url";

    /* renamed from: e  reason: collision with root package name */
    public static final String f25568e = "key_cookies_sync_domain_list";

    /* renamed from: f  reason: collision with root package name */
    public static final String f25569f = "white_screen_config";

    /* renamed from: g  reason: collision with root package name */
    public static final String f25570g = "key_loading_duration_interval";

    /* renamed from: h  reason: collision with root package name */
    public static final String f25571h = "key_transaction_records_url";
    public static volatile boolean i = true;
    public JSONObject loginUrl;
    public String fp = "";
    public String kefuPhoneNum = "";
    public String enableJsNameVerify = "";
    public String jsipc = "";
    public String publicKeyPins = "";
    public String langbridgeSpeedUp = "";
    public String langbridgeCheckProtocol = "";
    public String passAuthUrl = "";
    public String whiteScreenConfig = "";
    public String takePicWaitTime = "";
    public String offlineCacheConfig = "";
    public String interval_millis = "";
    public String JSHookURL = "";
    public String LangbridgeSettings = "";
    public String certWhiteList = "";
    public String domainSwitch = "";
    public String domainConfig = "";
    public String paymentCodeUrl = "";
    public String balanceHomeUrl = "";
    public String transactionRecordsUrl = "";
    public String cookiesSyncDomainList = "";
    public String needShowLoadingInterval = "";
    public String sdk_permission_dialog = "";
    public String langbridge_permission_dialog = "";
    public String permission_dialog_info = "";
    public String permission_dialog_contacts = "";
    public String permission_dialog_location = "";
    public String permission_dialog_camera = "";
    public String permission_dialog_audio = "";
    public String permission_dialog_storage = "";
    public String loadingDurationInterval = "";

    /* loaded from: classes5.dex */
    public static class OfflineCacheConfig implements NoProguard {
        public boolean useOfflineCache = true;
        public boolean usePreSetCookie;
        public boolean usePreload;

        public boolean isUseOfflineCache() {
            return this.useOfflineCache;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final SdkInitResponse f25576a = new SdkInitResponse();
    }

    private Map<String, EnumSet<Permission>> a(@NonNull String str) throws JSONException {
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

    public static SdkInitResponse getInstance() {
        return a.f25576a;
    }

    public static boolean isEnableJsNameVerify() {
        if (TextUtils.isEmpty(a.f25576a.enableJsNameVerify)) {
            return false;
        }
        return "1".equals(a.f25576a.enableJsNameVerify);
    }

    public static boolean isLangBridgeCheckUrlProtocol() {
        if (TextUtils.isEmpty(a.f25576a.langbridgeCheckProtocol)) {
            return true;
        }
        return "1".equals(a.f25576a.langbridgeCheckProtocol);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public String getBalanceHomeUrl(Context context) {
        if (TextUtils.isEmpty(this.balanceHomeUrl)) {
            this.balanceHomeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f25567d, "");
        }
        return this.balanceHomeUrl;
    }

    public String getCookiesSyncDomainList(Context context) {
        if (TextUtils.isEmpty(this.cookiesSyncDomainList)) {
            this.cookiesSyncDomainList = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f25568e, "");
        }
        return this.cookiesSyncDomainList;
    }

    public String getJsHookURl(Context context) {
        if (!TextUtils.isEmpty(a.f25576a.JSHookURL)) {
            return a.f25576a.JSHookURL;
        }
        LogUtil.d("WebViewCacheManager", "cache jsHookUrl = " + ((String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, DEFAULT_JS_HOOK_URL)));
        return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, DEFAULT_JS_HOOK_URL);
    }

    public String getLoadingDurationInterval(Context context) {
        if (TextUtils.isEmpty(this.loadingDurationInterval) && context != null) {
            this.loadingDurationInterval = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f25570g, "");
        }
        return this.loadingDurationInterval;
    }

    public String getLoginUrl(String str) {
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

    public String getOfflineCacheConfig(Context context) {
        return a.f25576a.offlineCacheConfig;
    }

    public String getPassAuthUrl(Context context) {
        String str = DomainConfig.getInstance().getCOHost() + "/content/resource/pass_normal/index.html";
        if (!TextUtils.isEmpty(a.f25576a.passAuthUrl)) {
            return a.f25576a.passAuthUrl;
        }
        String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f25565b, "");
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public String getPayCodeUrl(Context context) {
        if (TextUtils.isEmpty(this.paymentCodeUrl)) {
            this.paymentCodeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f25566c, "");
        }
        return this.paymentCodeUrl;
    }

    public int getTakePicWaitTime() {
        if (TextUtils.isEmpty(a.f25576a.takePicWaitTime)) {
            return 2000;
        }
        return Integer.valueOf(a.f25576a.takePicWaitTime).intValue();
    }

    public String getTransactionRecordsUrl(Context context) {
        if (TextUtils.isEmpty(this.transactionRecordsUrl)) {
            this.transactionRecordsUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f25571h, "");
        }
        return this.transactionRecordsUrl;
    }

    public String getWhiteScreenConfig(Context context) {
        if (!TextUtils.isEmpty(a.f25576a.whiteScreenConfig)) {
            return a.f25576a.whiteScreenConfig;
        }
        return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f25569f, "");
    }

    public boolean isLangbridgeSpeedUpEnable(Context context) {
        if (!TextUtils.isEmpty(a.f25576a.langbridgeSpeedUp)) {
            return "1".equals(a.f25576a.langbridgeSpeedUp);
        }
        String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f25564a, "");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "1".equals(str);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        if (!TextUtils.isEmpty(this.offlineCacheConfig)) {
            a.f25576a.offlineCacheConfig = this.offlineCacheConfig;
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
            a.f25576a.LangbridgeSettings = this.LangbridgeSettings;
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_updateSettings").data("config", this.LangbridgeSettings), new RouterCallback() { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.1
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                }
            });
        }
        if (!TextUtils.isEmpty(this.JSHookURL)) {
            a.f25576a.JSHookURL = this.JSHookURL;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, this.JSHookURL);
            LogUtil.d("WebViewCacheManager", "init config JSHookURL = " + this.JSHookURL);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_getToImapctJsFiles").data("configs", new String[]{"config.json"}).data("keys", new String[]{"common", "multi-webview"}), new RouterCallback() { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.2
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                }
            });
        }
        if (i) {
            i = false;
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
                a.f25576a.langbridgeSpeedUp = this.langbridgeSpeedUp;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f25564a, this.langbridgeSpeedUp);
            }
            if (!TextUtils.isEmpty(this.passAuthUrl)) {
                a.f25576a.passAuthUrl = this.passAuthUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f25565b, this.passAuthUrl);
            }
            a.f25576a.paymentCodeUrl = this.paymentCodeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f25566c, this.paymentCodeUrl);
            a.f25576a.transactionRecordsUrl = this.transactionRecordsUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f25571h, this.transactionRecordsUrl);
            a.f25576a.balanceHomeUrl = this.balanceHomeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f25567d, this.balanceHomeUrl);
            if (!TextUtils.isEmpty(this.whiteScreenConfig)) {
                a.f25576a.whiteScreenConfig = this.whiteScreenConfig;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f25569f, this.whiteScreenConfig);
            }
            a.f25576a.fp = this.fp;
            a.f25576a.kefuPhoneNum = this.kefuPhoneNum;
            a.f25576a.enableJsNameVerify = this.enableJsNameVerify;
            a.f25576a.loginUrl = this.loginUrl;
            a.f25576a.certWhiteList = this.certWhiteList;
            a.f25576a.jsipc = this.jsipc;
            a.f25576a.publicKeyPins = this.publicKeyPins;
            a.f25576a.langbridgeSpeedUp = this.langbridgeSpeedUp;
            a.f25576a.langbridgeCheckProtocol = this.langbridgeCheckProtocol;
            a.f25576a.passAuthUrl = this.passAuthUrl;
            a.f25576a.domainSwitch = this.domainSwitch;
            a.f25576a.domainConfig = this.domainConfig;
            a.f25576a.paymentCodeUrl = this.paymentCodeUrl;
            a.f25576a.balanceHomeUrl = this.balanceHomeUrl;
            a.f25576a.transactionRecordsUrl = this.transactionRecordsUrl;
            a.f25576a.takePicWaitTime = this.takePicWaitTime;
            a.f25576a.cookiesSyncDomainList = this.cookiesSyncDomainList;
            a.f25576a.sdk_permission_dialog = this.sdk_permission_dialog;
            a.f25576a.langbridge_permission_dialog = this.langbridge_permission_dialog;
            a.f25576a.permission_dialog_info = this.permission_dialog_info;
            a.f25576a.permission_dialog_contacts = this.permission_dialog_contacts;
            a.f25576a.permission_dialog_location = this.permission_dialog_location;
            a.f25576a.permission_dialog_camera = this.permission_dialog_camera;
            a.f25576a.permission_dialog_audio = this.permission_dialog_audio;
            a.f25576a.permission_dialog_storage = this.permission_dialog_storage;
            if (!TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f25568e, this.cookiesSyncDomainList);
            }
            a.f25576a.needShowLoadingInterval = this.needShowLoadingInterval;
            a.f25576a.loadingDurationInterval = this.loadingDurationInterval;
            if (!TextUtils.isEmpty(this.loadingDurationInterval)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f25570g, this.loadingDurationInterval);
            }
            try {
                Domains.getInstance().setDomainsPermissionConfig(a(this.jsipc));
            } catch (JSONException e3) {
                LogUtil.logd(e3.getMessage());
            }
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_setJsNameVerfiy").data("enableJsNameVerify", this.enableJsNameVerify), new RouterCallback() { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.3
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                }
            });
        }
    }

    public String toString() {
        return "sdk-init:\n\tfp:" + this.fp + "\n\tkefuPhoneNum:" + this.kefuPhoneNum + "\n\tenableJsNameVerify:" + this.enableJsNameVerify + "\n\tjsipc:" + this.jsipc + "\n\tpublicKeyPins:" + this.publicKeyPins + "\n\tcertWhiteList:" + this.certWhiteList + "\n\tloginUrl:" + this.loginUrl + "\n\tlangbridgeSpeedUp:" + this.langbridgeSpeedUp + "\n\tlangbridgeCheckProtocol:" + this.langbridgeCheckProtocol + "\n\tpassAuthUrl:" + this.passAuthUrl + "\n\tdomainSwitch:" + this.domainSwitch + "\n\tdomainConfig:" + this.domainConfig + "\n\twhiteScreenConfig:" + this.whiteScreenConfig + "\n\tpaymentCodeUrl:" + this.paymentCodeUrl + "\n\tbalanceHomeUrl:" + this.balanceHomeUrl + "\n\ttransactionRecordsUrl:" + this.transactionRecordsUrl + "\n\tofflineCacheConfig:" + this.offlineCacheConfig + "\n\tLangbridgeSettings:" + this.LangbridgeSettings + "\n\tcookiesSyncDomainList:" + this.cookiesSyncDomainList + "\n\tneedShowLoadingInterval:" + this.needShowLoadingInterval + "\n\tloadingDurationInterval:" + this.loadingDurationInterval;
    }

    public void updateOfflineCacheConfig(Context context, String str) {
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_offlineCacheConfig").data("config", str), new RouterCallback() { // from class: com.baidu.wallet.paysdk.datamodel.SdkInitResponse.4
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    private EnumSet<Permission> a(int i2) {
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
}
