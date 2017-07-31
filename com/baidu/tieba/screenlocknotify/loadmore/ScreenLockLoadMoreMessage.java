package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.n;
import tbclient.GetMoreMsg.DataReq;
import tbclient.GetMoreMsg.GetMoreMsgReqIdl;
/* loaded from: classes2.dex */
public class ScreenLockLoadMoreMessage extends NetMessage {
    public ScreenLockLoadMoreMessage() {
        super(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            n.bindCommonParamsToProtobufData(builder, true);
        }
        GetMoreMsgReqIdl.Builder builder2 = new GetMoreMsgReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
