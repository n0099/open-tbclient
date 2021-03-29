package com.baidu.tieba.lego.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.Lego.DataRes;
import tbclient.Lego.LegoResIdl;
/* loaded from: classes3.dex */
public class LegoSocketResponse extends SocketResponsedMessage {
    public DataRes resultData;

    public LegoSocketResponse() {
        super(309312);
    }

    public DataRes getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        LegoResIdl legoResIdl = (LegoResIdl) new Wire(new Class[0]).parseFrom(bArr, LegoResIdl.class);
        if (legoResIdl == null) {
            return;
        }
        Error error = legoResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(legoResIdl.error.usermsg);
        }
        this.resultData = legoResIdl.data;
    }
}
