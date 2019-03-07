package com.baidu.tieba.quickWebView.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.s;
import tbclient.GetWebviewCacheInfo.DataReq;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoReqIdl;
/* loaded from: classes.dex */
public class WebViewCacheReqMsg extends NetMessage {
    private String mWebViewVersion;

    public WebViewCacheReqMsg(String str) {
        super(CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
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
            s.bindCommonParamsToProtobufData(builder, true);
        }
        GetWebviewCacheInfoReqIdl.Builder builder2 = new GetWebviewCacheInfoReqIdl.Builder();
        builder2.data = builder.build(true);
        return builder2.build(true);
    }
}
