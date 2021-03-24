package com.baidu.tieba.wallet.pay;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetOrder.DataRes;
import tbclient.GetOrder.GetOrderResIdl;
/* loaded from: classes5.dex */
public class ResponsedGetOrderHttpMessage extends HttpResponsedMessage {
    public DataRes mData;

    public ResponsedGetOrderHttpMessage(int i) {
        super(i);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
