package com.baidu.tieba.xiuba;

import com.baidu.adp.lib.g.c;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import java.util.Arrays;
import protobuf.SendXiubaSysMsg.DataReq;
import protobuf.SendXiubaSysMsg.SendXiubaSysMsgReqIdl;
/* loaded from: classes.dex */
public class RequestSendXiubaMessage extends TbSocketMessage {
    private XiubaMsg xiubaMsg;

    public RequestSendXiubaMessage() {
        super(107202);
    }

    public XiubaMsg getXiubaMsg() {
        return this.xiubaMsg;
    }

    public void setXiubaMsg(XiubaMsg xiubaMsg) {
        this.xiubaMsg = xiubaMsg;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        if (this.xiubaMsg != null) {
            builder.listeners = Integer.valueOf(c.toInt(this.xiubaMsg.getListeners(), 0));
            builder.likers = Integer.valueOf(c.toInt(this.xiubaMsg.getLikers(), 0));
            builder.intro = this.xiubaMsg.getIntro();
            builder.userName = this.xiubaMsg.getUserName();
            builder.groupName = this.xiubaMsg.getGroupName();
            builder.content = this.xiubaMsg.getContent();
            builder.userId = Integer.valueOf(c.toInt(this.xiubaMsg.getUserId(), 0));
            builder.openId = Arrays.asList(this.xiubaMsg.getOpenId());
        }
        SendXiubaSysMsgReqIdl.Builder builder2 = new SendXiubaSysMsgReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
