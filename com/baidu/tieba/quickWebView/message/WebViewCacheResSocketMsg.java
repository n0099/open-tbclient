package com.baidu.tieba.quickWebView.message;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.HashMap;
import java.util.Map;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoResIdl;
import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes.dex */
public class WebViewCacheResSocketMsg extends TbSocketReponsedMessage {
    private Map<String, a> mModuleInfos;

    public WebViewCacheResSocketMsg() {
        super(CmdConfigSocket.WEBVIEW_CACHE_INFO);
    }

    public Map<String, a> getModuleInfos() {
        return this.mModuleInfos;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetWebviewCacheInfoResIdl getWebviewCacheInfoResIdl = (GetWebviewCacheInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetWebviewCacheInfoResIdl.class);
        setError(getWebviewCacheInfoResIdl.error.errorno.intValue());
        setErrorString(getWebviewCacheInfoResIdl.error.usermsg);
        if (this.mModuleInfos == null) {
            this.mModuleInfos = new HashMap();
        }
        if (getError() == 0 && !y.isEmpty(getWebviewCacheInfoResIdl.data.offpack_list)) {
            this.mModuleInfos.clear();
            for (Offpack offpack : getWebviewCacheInfoResIdl.data.offpack_list) {
                if (offpack != null && !TextUtils.isEmpty(offpack.mod_name)) {
                    a aVar = new a();
                    aVar.a(offpack);
                    this.mModuleInfos.put(offpack.mod_name, aVar);
                }
            }
        }
    }
}
