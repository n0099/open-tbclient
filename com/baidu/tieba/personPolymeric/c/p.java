package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgY = BdUniqueId.gen();
    public long fgZ;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgY;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.fgZ = giftInfo.num.intValue();
        }
    }
}
