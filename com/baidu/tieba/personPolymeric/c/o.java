package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes11.dex */
public class o extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kuc = BdUniqueId.gen();
    public long giftNum;
    public String picUrl;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kuc;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.giftNum = giftInfo.num.intValue();
        }
    }
}
