package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.personPolymeric.c.q;
import com.squareup.wire.Wire;
import tbclient.GetRecommendGodList.GetRecommendGodListResIdl;
/* loaded from: classes7.dex */
public class RecommendGodSocketResponseMessage extends SocketResponsedMessage {
    public q recommendGodData;

    public RecommendGodSocketResponseMessage() {
        super(309684);
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
