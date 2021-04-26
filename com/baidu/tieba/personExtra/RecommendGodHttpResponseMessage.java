package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.a.j0.i2.e.q;
import tbclient.Error;
import tbclient.GetRecommendGodList.GetRecommendGodListResIdl;
/* loaded from: classes4.dex */
public class RecommendGodHttpResponseMessage extends HttpResponsedMessage {
    public q recommendGodData;

    public RecommendGodHttpResponseMessage() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetRecommendGodListResIdl getRecommendGodListResIdl = (GetRecommendGodListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRecommendGodListResIdl.class);
        if (getRecommendGodListResIdl == null) {
            return;
        }
        Error error = getRecommendGodListResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(getRecommendGodListResIdl.error.usermsg);
        }
        q qVar = new q();
        this.recommendGodData = qVar;
        qVar.b(getRecommendGodListResIdl.data);
    }
}
