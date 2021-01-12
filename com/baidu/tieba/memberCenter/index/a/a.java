package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBannerItem;
import tbclient.GetVipInfo.VipBannerList;
/* loaded from: classes8.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lek = BdUniqueId.gen();
    public String cardId;
    public boolean leh = false;
    private List<b> lel;

    public a(VipBannerList vipBannerList) {
        this.cardId = "";
        if (vipBannerList != null && vipBannerList.item != null) {
            this.cardId = vipBannerList.card_id;
            this.lel = new ArrayList();
            for (VipBannerItem vipBannerItem : vipBannerList.item) {
                this.lel.add(new b(vipBannerItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lek;
    }
}
