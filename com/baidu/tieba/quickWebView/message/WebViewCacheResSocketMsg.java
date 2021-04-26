package com.baidu.tieba.quickWebView.message;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.a.j0.q2.e.a;
import java.util.HashMap;
import java.util.Map;
import tbclient.GetWebviewCacheInfo.GetWebviewCacheInfoResIdl;
import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes3.dex */
public class WebViewCacheResSocketMsg extends TbSocketReponsedMessage {
    public Map<String, a> mModuleInfos;

    public WebViewCacheResSocketMsg() {
        super(309485);
    }

    public Map<String, a> getModuleInfos() {
        return this.mModuleInfos;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetWebviewCacheInfoResIdl getWebviewCacheInfoResIdl = (GetWebviewCacheInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetWebviewCacheInfoResIdl.class);
        setError(getWebviewCacheInfoResIdl.error.errorno.intValue());
        setErrorString(getWebviewCacheInfoResIdl.error.usermsg);
        if (this.mModuleInfos == null) {
            this.mModuleInfos = new HashMap();
        }
        if (getError() != 0 || ListUtils.isEmpty(getWebviewCacheInfoResIdl.data.offpack_list)) {
            return;
        }
        this.mModuleInfos.clear();
        for (Offpack offpack : getWebviewCacheInfoResIdl.data.offpack_list) {
            if (offpack != null && !TextUtils.isEmpty(offpack.mod_name)) {
                a aVar = new a();
                aVar.e(offpack);
                this.mModuleInfos.put(offpack.mod_name, aVar);
            }
        }
    }
}
