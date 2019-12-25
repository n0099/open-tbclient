package com.baidu.tieba.quickWebView.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetWebviewCacheInfo.DataReq;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoReqIdl;
/* loaded from: classes.dex */
public class WebViewCacheReqMsg extends NetMessage {
    private String mWebViewVersion;

    public WebViewCacheReqMsg(String str) {
        super(1003365, CmdConfigSocket.WEBVIEW_CACHE_INFO);
        this.mWebViewVersion = str;
    }

    public String getVersionNum() {
        return this.mWebViewVersion;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.webview_version = this.mWebViewVersion;
        if (z) {
            t.a(builder, true);
        }
        GetWebviewCacheInfoReqIdl.Builder builder2 = new GetWebviewCacheInfoReqIdl.Builder();
        builder2.data = builder.build(true);
        return builder2.build(true);
    }
}
