package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetMoreMsg.DataReq;
import tbclient.GetMoreMsg.GetMoreMsgReqIdl;
/* loaded from: classes8.dex */
public class ScreenLockLoadMoreMessage extends NetMessage {
    public ScreenLockLoadMoreMessage() {
        super(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            v.b(builder, true);
        }
        GetMoreMsgReqIdl.Builder builder2 = new GetMoreMsgReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
