package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.GetCardByCategory.DataReq;
import tbclient.GetCardByCategory.GetCardByCategoryReqIdl;
/* loaded from: classes5.dex */
public class PersonalCardCategoryRequest extends NetMessage {
    public int pn;
    public int rn;

    public PersonalCardCategoryRequest() {
        super(CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, 309331);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            w.a(builder, true);
        }
        GetCardByCategoryReqIdl.Builder builder2 = new GetCardByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getPn() {
        return this.pn;
    }

    public int getRn() {
        return this.rn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }
}
