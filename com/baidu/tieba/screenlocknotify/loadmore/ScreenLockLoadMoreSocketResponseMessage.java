package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.GetMoreMsg.GetMoreMsgResIdl;
/* loaded from: classes8.dex */
public class ScreenLockLoadMoreSocketResponseMessage extends SocketResponsedMessage {
    private a loadMoreData;

    public ScreenLockLoadMoreSocketResponseMessage() {
        super(CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE);
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
