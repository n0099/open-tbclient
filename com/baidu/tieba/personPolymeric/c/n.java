package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId flM = BdUniqueId.gen();
    public long flN;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return flM;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.flN = giftInfo.num.intValue();
        }
    }
}
