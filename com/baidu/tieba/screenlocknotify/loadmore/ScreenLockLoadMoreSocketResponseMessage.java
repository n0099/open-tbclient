package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.k0.u2.e.a;
import tbclient.Error;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.GetMoreMsgResIdl;
/* loaded from: classes5.dex */
public class ScreenLockLoadMoreSocketResponseMessage extends SocketResponsedMessage {
    public a loadMoreData;

    public ScreenLockLoadMoreSocketResponseMessage() {
        super(309420);
    }

    public a getData() {
        return this.loadMoreData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetMoreMsgResIdl getMoreMsgResIdl = (GetMoreMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMoreMsgResIdl.class);
        if (getMoreMsgResIdl == null) {
            return;
        }
        Error error = getMoreMsgResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getMoreMsgResIdl.error.errmsg);
        }
        DataRes dataRes = getMoreMsgResIdl.data;
        if (dataRes == null || dataRes == null) {
            return;
        }
        a aVar = new a();
        this.loadMoreData = aVar;
        aVar.c(getMoreMsgResIdl.data);
    }
}
