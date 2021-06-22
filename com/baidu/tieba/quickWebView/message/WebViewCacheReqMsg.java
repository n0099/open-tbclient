package com.baidu.tieba.quickWebView.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetWebviewCacheInfo.DataReq;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoReqIdl;
/* loaded from: classes5.dex */
public class WebViewCacheReqMsg extends NetMessage {
    public String mWebViewVersion;

    public WebViewCacheReqMsg(String str) {
        super(CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
        this.mWebViewVersion = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.webview_version = this.mWebViewVersion;
        if (z) {
            w.a(builder, true);
        }
        GetWebviewCacheInfoReqIdl.Builder builder2 = new GetWebviewCacheInfoReqIdl.Builder();
        builder2.data = builder.build(true);
        return builder2.build(true);
    }

    public String getVersionNum() {
        return this.mWebViewVersion;
    }
}
