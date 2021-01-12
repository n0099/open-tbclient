package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.personPolymeric.c.q;
import com.squareup.wire.Wire;
import tbclient.GetRecommendGodList.GetRecommendGodListResIdl;
/* loaded from: classes7.dex */
public class RecommendGodHttpResponseMessage extends HttpResponsedMessage {
    public q recommendGodData;

    public RecommendGodHttpResponseMessage() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetRecommendGodListResIdl getRecommendGodListResIdl = (GetRecommendGodListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRecommendGodListResIdl.class);
        if (getRecommendGodListResIdl != null) {
            if (getRecommendGodListResIdl.error != null) {
                if (getRecommendGodListResIdl.error.errorno != null) {
                    setError(getRecommendGodListResIdl.error.errorno.intValue());
                }
                setErrorString(getRecommendGodListResIdl.error.usermsg);
            }
            this.recommendGodData = new q();
            this.recommendGodData.a(getRecommendGodListResIdl.data);
        }
    }
}
