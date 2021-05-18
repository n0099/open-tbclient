package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.SetCard.DataReq;
import tbclient.SetCard.SetCardReqIdl;
/* loaded from: classes5.dex */
public class SetPersonalCardRequest extends NetMessage {
    public long cardId;
    public int type;

    public SetPersonalCardRequest() {
        super(CmdConfigHttp.CMD_SET_PERSONAL_CARD, 309345);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Long.valueOf(this.cardId);
        builder.type = Integer.valueOf(this.type);
        if (z) {
            w.a(builder, true);
        }
        SetCardReqIdl.Builder builder2 = new SetCardReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getCardId() {
        return this.cardId;
    }

    public int getType() {
        return this.type;
    }

    public void setCardId(long j) {
        this.cardId = j;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
