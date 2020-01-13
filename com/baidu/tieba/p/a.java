package com.baidu.tieba.p;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.IHttpContext;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import okhttp3.Interceptor;
import okhttp3.Request;
/* loaded from: classes.dex */
public class a implements IHttpContext {
    public static boolean DEBUG;
    private static final String TAG;
    private static int jWo;
    private Context mContext = AppRuntime.getAppContext();

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest) {
        return false;
    }

    static {
        boolean isDebug = AppConfig.isDebug();
        DEBUG = isDebug;
        DEBUG = isDebug;
        TAG = a.class.getSimpleName();
        jWo = 0;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void init() {
        if (DEBUG) {
            Log.i(TAG, "baidunetwork HttpContext init!");
        }
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public Interceptor getNewNetworkInterceptor() {
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IHttpDns getNewHttpDns() {
        if (DEBUG) {
            Log.i(TAG, "baidunetwork HttpContext getNewHttpDns!");
            return null;
        }
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IHttpDns getNewCloneHttpDns(HttpRequest httpRequest) {
        if (DEBUG) {
            Log.i(TAG, "baidunetwork HttpContext getNewCloneHttpDns httpRequest:" + httpRequest);
            return null;
        }
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void prefetchDnsResult(String str) {
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
        if (DEBUG) {
            Log.i(TAG, "baidu_networksetNetworkInfoRecord networkInfoRecord:" + networkInfoRecord);
        }
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public NetworkStat<Request> getNewNetworkStat() {
        return null;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public CookieManager getCookieManager(boolean z, boolean z2) {
        return null;
    }
}
