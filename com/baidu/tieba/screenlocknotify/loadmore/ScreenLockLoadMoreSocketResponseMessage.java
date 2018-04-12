package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMoreMsg.GetMoreMsgResIdl;
/* loaded from: classes3.dex */
public class ScreenLockLoadMoreSocketResponseMessage extends SocketResponsedMessage {
    private a loadMoreData;

    public ScreenLockLoadMoreSocketResponseMessage() {
        super(309420);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetMoreMsgResIdl getMoreMsgResIdl = (GetMoreMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMoreMsgResIdl.class);
        if (getMoreMsgResIdl != null) {
            if (getMoreMsgResIdl.error != null) {
                setError(getMoreMsgResIdl.error.errorno.intValue());
                setErrorString(getMoreMsgResIdl.error.errmsg);
            }
            if (getMoreMsgResIdl.data != null && getMoreMsgResIdl.data != null) {
                this.loadMoreData = new a();
                this.loadMoreData.a(getMoreMsgResIdl.data);
            }
        }
    }

    public a getData() {
        return this.loadMoreData;
    }
}
