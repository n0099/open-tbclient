package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.GetCard.DataReq;
import tbclient.GetCard.GetCardReqIdl;
/* loaded from: classes5.dex */
public class PersonalCardDetailRequest extends NetMessage {
    public long cardId;

    public PersonalCardDetailRequest() {
        super(CmdConfigHttp.CMD_GET_CARD_DETAIL, 309333);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Long.valueOf(this.cardId);
        if (z) {
            w.a(builder, true);
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
