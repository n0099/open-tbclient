package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gqd = BdUniqueId.gen();
    public long gqe;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gqd;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.gqe = giftInfo.num.intValue();
        }
    }
}
