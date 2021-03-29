package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.QueryCollectUpdateNum.DataRes;
import tbclient.QueryCollectUpdateNum.QueryCollectUpdateNumResIdl;
/* loaded from: classes3.dex */
public class ResponseQueryCollectUpdateNumMessage extends SocketResponsedMessage {
    public int mCollectUpdateNum;

    public ResponseQueryCollectUpdateNumMessage() {
        super(303005);
        this.mCollectUpdateNum = 0;
    }

    public int getCollectUpdateNum() {
        return this.mCollectUpdateNum;
    }

    public void setCollectUpdateNum(int i) {
        this.mCollectUpdateNum = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        QueryCollectUpdateNumResIdl queryCollectUpdateNumResIdl = (QueryCollectUpdateNumResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryCollectUpdateNumResIdl.class);
        setError(queryCollectUpdateNumResIdl.error.errorno.intValue());
        setErrorString(queryCollectUpdateNumResIdl.error.usermsg);
        if (getError() == 0 && (dataRes = queryCollectUpdateNumResIdl.data) != null) {
            setCollectUpdateNum(dataRes.collect_update_num.intValue());
        }
    }
}
