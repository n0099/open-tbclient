package com.baidu.tieba.quickWebView.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoResIdl;
/* loaded from: classes2.dex */
public class WebViewCacheResSocketMsg extends TbSocketReponsedMessage {
    private String mCacheDownUrl;
    private String mMd5;
    private String mVersion;

    public WebViewCacheResSocketMsg() {
        super(CmdConfigSocket.WEBVIEW_CACHE_INFO);
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
    @Override // com.baidu.adp.framework.message.a
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
