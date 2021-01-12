package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.SetCard.DataReq;
import tbclient.SetCard.SetCardReqIdl;
/* loaded from: classes8.dex */
public class SetPersonalCardRequest extends NetMessage {
    private long cardId;
    private int type;

    public SetPersonalCardRequest() {
        super(1003095, CmdConfigSocket.CMD_SET_PERSONAL_CARD);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Long.valueOf(this.cardId);
        builder.type = Integer.valueOf(this.type);
        if (z) {
            t.b(builder, true);
        }
        SetCardReqIdl.Builder builder2 = new SetCardReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getCardId() {
        return this.cardId;
    }

    public void setCardId(long j) {
        this.cardId = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
