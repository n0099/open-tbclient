package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetCard.DataReq;
import tbclient.GetCard.GetCardReqIdl;
/* loaded from: classes8.dex */
public class PersonalCardDetailRequest extends NetMessage {
    private long cardId;

    public PersonalCardDetailRequest() {
        super(1003094, CmdConfigSocket.CMD_GET_CARD_DETAIL);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Long.valueOf(this.cardId);
        if (z) {
            v.b(builder, true);
        }
        GetCardReqIdl.Builder builder2 = new GetCardReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getCardId() {
        return this.cardId;
    }

    public void setCardId(long j) {
        this.cardId = j;
    }
}
