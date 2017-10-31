package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpx = BdUniqueId.gen();
    public long fpy;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fpx;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.fpy = giftInfo.num.intValue();
        }
    }
}
