package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetCardByCategory.DataReq;
import tbclient.GetCardByCategory.GetCardByCategoryReqIdl;
/* loaded from: classes8.dex */
public class PersonalCardCategoryRequest extends NetMessage {
    private int pn;
    private int rn;

    public PersonalCardCategoryRequest() {
        super(1003093, CmdConfigSocket.CMD_GET_CARD_BY_CATEGORY);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            v.b(builder, true);
        }
        GetCardByCategoryReqIdl.Builder builder2 = new GetCardByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }
}
