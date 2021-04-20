package com.baidu.wallet.paysdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PollOfflineCacheSwitch;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SDKInitBeanCallBack implements IBeanResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f25056a = true;

    /* renamed from: c  reason: collision with root package name */
    public static int f25057c;

    /* renamed from: b  reason: collision with root package name */
    public Context f25058b;

    public SDKInitBeanCallBack(Context context) {
        this.f25058b = context;
    }

    public static Map<String, Set<String>> a(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray(str);
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            JSONArray jSONArray2 = jSONObject.getJSONArray("pin-sha256");
            JSONArray jSONArray3 = jSONObject.getJSONArray("domains");
            hashSet.clear();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                hashSet.add(jSONArray2.getString(i2));
            }
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                hashMap.put(jSONArray3.getString(i3), hashSet);
            }
        }
        return hashMap;
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i, int i2, String str) {
        if (f25056a) {
            return;
        }
        int i3 = f25057c + 1;
        f25057c = i3;
        if (i3 >= 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", "1");
            Tracker.send("OfflineFailOverOccur", hashMap, this.f25058b);
            LogUtil.d("WebViewCacheManager", "pollinit-连续三次失败关闭离线缓存");
            PollOfflineCacheSwitch.getInstance().updateCacheConfig(null);
            SdkInitResponse.getInstance().updateOfflineCacheConfig(this.f25058b, null);
            LogUtil.d("WebViewCacheManager", "pollinit-连续三次失败关闭多webview");
            LocalRouter.getInstance(this.f25058b).route(this.f25058b, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_updateSettings").data("config", null), new RouterCallback() { // from class: com.baidu.wallet.paysdk.SDKInitBeanCallBack.1
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i4, HashMap hashMap2) {
                }
            });
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i, Object obj, String str) {
        boolean z;
        if (!f25056a) {
            f25057c = 0;
            return;
        }
        f25056a = false;
        if (obj instanceof SdkInitResponse) {
            SdkInitResponse sdkInitResponse = (SdkInitResponse) obj;
            if (!TextUtils.isEmpty(sdkInitResponse.domainConfig)) {
                try {
                    new JSONObject(sdkInitResponse.domainConfig);
                    z = true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    z = false;
                }
                if (z) {
                    if (DebugConfig.getInstance().isOnline()) {
                        DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, sdkInitResponse.domainConfig);
                        SharedPreferencesUtils.setParam(this.f25058b.getApplicationContext(), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.DOMAIN_CONFIG_KEY, sdkInitResponse.domainConfig);
                    } else {
                        DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, sdkInitResponse.domainConfig);
                        SharedPreferencesUtils.setParam(this.f25058b.getApplicationContext(), BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.DOMAIN_CONFIG_KEY, sdkInitResponse.domainConfig);
                    }
                }
            }
            if (!TextUtils.isEmpty(sdkInitResponse.domainSwitch)) {
                if (TextUtils.equals("1", sdkInitResponse.domainSwitch)) {
                    if (DebugConfig.getInstance().isOnline()) {
                        SharedPreferencesUtils.setParam(this.f25058b.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.TRUE);
                    } else {
                        SharedPreferencesUtils.setParam(this.f25058b.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.TRUE);
                    }
                    com.baidu.apollon.heartbeat.a.c().a(true);
                } else {
                    if (DebugConfig.getInstance().isOnline()) {
                        SharedPreferencesUtils.setParam(this.f25058b.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE);
                    } else {
                        SharedPreferencesUtils.setParam(this.f25058b.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE);
                    }
                    com.baidu.apollon.heartbeat.a.c().a(false);
                }
            }
            if (TextUtils.isEmpty(sdkInitResponse.publicKeyPins)) {
                return;
            }
            try {
                Map<String, Set<String>> a2 = a(sdkInitResponse.publicKeyPins);
                com.baidu.apollon.b.a.a().b();
                for (String str2 : a2.keySet()) {
                    com.baidu.apollon.b.a.a().a(str2, a2.get(str2));
                }
            } catch (JSONException unused) {
            }
        }
    }
}
