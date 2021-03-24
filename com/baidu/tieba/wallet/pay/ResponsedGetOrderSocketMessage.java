package com.baidu.tieba.wallet.pay;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetOrder.DataRes;
import tbclient.GetOrder.GetOrderResIdl;
/* loaded from: classes5.dex */
public class ResponsedGetOrderSocketMessage extends SocketResponsedMessage {
    public DataRes mData;

    public ResponsedGetOrderSocketMessage() {
        super(303043);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetOrderResIdl getOrderResIdl = (GetOrderResIdl) new Wire(new Class[0]).parseFrom(bArr, GetOrderResIdl.class);
        Error error = getOrderResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getOrderResIdl.error.errmsg);
        }
        DataRes dataRes = getOrderResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.mData = dataRes;
    }
}
