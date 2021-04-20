package com.baidu.wallet.core.utils;

import android.content.Context;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.core.ActLifecycleCbs;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class PollOfflineCacheSwitch implements ActLifecycleCbs.a {
    public static int INTERVAL_TIME = 120000;
    public static final String TAG = "WebViewCacheManager";

    /* renamed from: a  reason: collision with root package name */
    public SdkInitResponse.OfflineCacheConfig f23993a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final PollOfflineCacheSwitch f23996a = new PollOfflineCacheSwitch();
    }

    public static final PollOfflineCacheSwitch getInstance() {
        return a.f23996a;
    }

    @Override // com.baidu.wallet.core.ActLifecycleCbs.a
    public boolean onInvoke(Context context, ActLifecycleCbs.FROM from) {
        final boolean[] zArr = new boolean[1];
        StringBuilder sb = new StringBuilder();
        sb.append("pollinit-触发请求init接口，from = ");
        sb.append(from);
        sb.append("; 离线缓存开关");
        SdkInitResponse.OfflineCacheConfig offlineCacheConfig = this.f23993a;
        sb.append(offlineCacheConfig != null ? Boolean.valueOf(offlineCacheConfig.isUseOfflineCache()) : "空");
        LogUtil.d("WebViewCacheManager", sb.toString());
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbridge_openPoll"), new RouterCallback() { // from class: com.baidu.wallet.core.utils.PollOfflineCacheSwitch.1
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i != 0 || hashMap == null) {
                    return;
                }
                zArr[0] = ((Boolean) hashMap.get("openPoll")).booleanValue();
            }
        });
        if (from == ActLifecycleCbs.FROM.RESUME) {
            LogUtil.d("WebViewCacheManager", "pollinit-触发请求init接口，来自resume直接发起接口请求");
            BdWalletUtils.getInitForPoll(context);
            return true;
        }
        SdkInitResponse.OfflineCacheConfig offlineCacheConfig2 = this.f23993a;
        if ((offlineCacheConfig2 == null || !offlineCacheConfig2.isUseOfflineCache()) && !zArr[0]) {
            return false;
        }
        LogUtil.d("WebViewCacheManager", "pollinit-触发请求init接口，来自非resume，判断config非空且离线缓存开关打开 || 多webview打开=" + zArr[0]);
        BdWalletUtils.getInitForPoll(context);
        return true;
    }

    public void registerListener() {
        ActLifecycleCbs.a().a(this, INTERVAL_TIME);
    }

    public void updateCacheConfig(SdkInitResponse.OfflineCacheConfig offlineCacheConfig) {
        StringBuilder sb = new StringBuilder();
        sb.append("pollinit-更新缓存配置:");
        sb.append(offlineCacheConfig != null ? Boolean.valueOf(offlineCacheConfig.isUseOfflineCache()) : "配置为空");
        LogUtil.d("WebViewCacheManager", sb.toString());
        this.f23993a = offlineCacheConfig;
    }

    public void updateIntervalTime(String str) {
        INTERVAL_TIME = Integer.valueOf(str).intValue();
        LogUtil.d("WebViewCacheManager", "pollinit-更新间隔时间:" + str);
        ActLifecycleCbs.a().a(this, Long.valueOf(str).longValue());
    }
}
