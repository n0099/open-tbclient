package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMoreMsg.GetMoreMsgResIdl;
/* loaded from: classes21.dex */
public class ScreenLockLoadMoreHttpResponseMessage extends TbHttpResponsedMessage {
    private a loadMoreData;

    public ScreenLockLoadMoreHttpResponseMessage() {
        super(1003194);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
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
