package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import tbclient.GiftInfo;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eFJ = BdUniqueId.gen();
    public long eFK;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eFJ;
    }

    public void a(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.picUrl = giftInfo.icon;
            this.eFK = giftInfo.num.intValue();
        }
    }
}
