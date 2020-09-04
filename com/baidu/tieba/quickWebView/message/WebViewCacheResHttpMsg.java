package com.baidu.tieba.quickWebView.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoResIdl;
/* loaded from: classes.dex */
public class WebViewCacheResHttpMsg extends TbHttpResponsedMessage {
    private String mCacheDownUrl;
    private String mMd5;
    private String mVersion;

    public WebViewCacheResHttpMsg() {
        super(1003365);
    }

    public String getCacheDownloadUrl() {
        return this.mCacheDownUrl;
    }

    public String getCacheMd5() {
        return this.mMd5;
    }

    public String getCacheVersion() {
        return this.mVersion;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetWebviewCacheInfoResIdl getWebviewCacheInfoResIdl = (GetWebviewCacheInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetWebviewCacheInfoResIdl.class);
        setError(getWebviewCacheInfoResIdl.error.errorno.intValue());
        setErrorString(getWebviewCacheInfoResIdl.error.usermsg);
        if (getError() == 0) {
            this.mCacheDownUrl = getWebviewCacheInfoResIdl.data.src;
            this.mMd5 = getWebviewCacheInfoResIdl.data.md5;
            this.mVersion = getWebviewCacheInfoResIdl.data.webview_version;
        }
    }
}
