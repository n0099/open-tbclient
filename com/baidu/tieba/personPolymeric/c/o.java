package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes11.dex */
public class o extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kba = BdUniqueId.gen();
    public long giftNum;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kba;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.giftNum = giftInfo.num.intValue();
        }
    }
}
