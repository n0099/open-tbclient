package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.k0.i2.e.q;
import tbclient.Error;
import tbclient.GetRecommendGodList.GetRecommendGodListResIdl;
/* loaded from: classes5.dex */
public class RecommendGodSocketResponseMessage extends SocketResponsedMessage {
    public q recommendGodData;

    public RecommendGodSocketResponseMessage() {
        super(309684);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
