package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.QueryCollectUpdateNum.QueryCollectUpdateNumResIdl;
/* loaded from: classes18.dex */
public class ResponseQueryCollectUpdateNumMessage extends SocketResponsedMessage {
    private int mCollectUpdateNum;

    public ResponseQueryCollectUpdateNumMessage() {
        super(CmdConfigSocket.CMD_QUERY_COLLECT_UPDATE_NUM);
        this.mCollectUpdateNum = 0;
    }

    public void setCollectUpdateNum(int i) {
        this.mCollectUpdateNum = i;
    }

    public int getCollectUpdateNum() {
        return this.mCollectUpdateNum;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryCollectUpdateNumResIdl queryCollectUpdateNumResIdl = (QueryCollectUpdateNumResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryCollectUpdateNumResIdl.class);
        setError(queryCollectUpdateNumResIdl.error.errorno.intValue());
        setErrorString(queryCollectUpdateNumResIdl.error.usermsg);
        if (getError() == 0 && queryCollectUpdateNumResIdl.data != null) {
            setCollectUpdateNum(queryCollectUpdateNumResIdl.data.collect_update_num.intValue());
        }
    }
}
