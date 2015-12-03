package com.baidu.tieba.message;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DebugCommitMsg.DataReq;
import protobuf.DebugCommitMsg.DebugCommitMsgReqIdl;
/* loaded from: classes.dex */
public class TbDebugOnlineMessage extends TbSocketMessage {
    private boolean bSender;
    private String content;
    private String from;
    private String to;

    public TbDebugOnlineMessage(boolean z, String str, String str2, String str3) {
        super(205102);
        this.bSender = true;
        this.bSender = z;
        this.from = str;
        this.to = str2;
        this.content = str3;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.content = this.content;
            builder.sender = Boolean.valueOf(this.bSender);
            builder.to = this.to;
            builder.cuid = this.from;
            DebugCommitMsgReqIdl.Builder builder2 = new DebugCommitMsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
