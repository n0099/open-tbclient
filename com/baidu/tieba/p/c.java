package com.baidu.tieba.p;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.IHttpContext;
import com.baidu.searchbox.network.IHttpDns;
import com.baidu.searchbox.network.cookie.CookieManager;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.connect.IHttpDelegator;
import com.baidu.searchbox.network.request.HttpRequest;
import com.baidu.searchbox.network.statistics.NetworkInfoRecord;
import com.baidu.searchbox.network.statistics.NetworkStat;
/* loaded from: classes.dex */
public class c implements IHttpContext {
    @Override // com.baidu.searchbox.network.IHttpContext
    public void init(AbstractHttpManager abstractHttpManager) {
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public IHttpDns getNewHttpDns() {
        return null;
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public IHttpDns getNewCloneStatHttpDns(HttpRequest httpRequest) {
        return null;
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public void prefetchDnsResult(String str) {
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public NetworkStat<Request> getNewNetworkStat() {
        return null;
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public IHttpDelegator getCronetHttpDelegator() {
        return null;
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public CookieManager getCookieManager(boolean z, boolean z2) {
        return null;
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public boolean isPreconnectEnable() {
        return false;
    }

    @Override // com.baidu.searchbox.network.IHttpContext
    public boolean isNQEEnable() {
        return false;
    }
}
