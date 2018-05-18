package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fLI = BdUniqueId.gen();
    public long giftNum;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fLI;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.giftNum = giftInfo.num.intValue();
        }
    }
}
