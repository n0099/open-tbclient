package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpN = BdUniqueId.gen();
    public long gpO;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gpN;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.gpO = giftInfo.num.intValue();
        }
    }
}
