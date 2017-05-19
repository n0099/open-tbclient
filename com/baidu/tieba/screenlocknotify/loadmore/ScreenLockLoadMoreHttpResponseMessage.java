package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMoreMsg.GetMoreMsgResIdl;
/* loaded from: classes2.dex */
public class ScreenLockLoadMoreHttpResponseMessage extends TbHttpResponsedMessage {
    private a loadMoreData;

    public ScreenLockLoadMoreHttpResponseMessage() {
        super(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
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
