package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBannerItem;
import tbclient.GetVipInfo.VipBannerList;
/* loaded from: classes9.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId liQ = BdUniqueId.gen();
    public String cardId;
    public boolean liN = false;
    private List<b> liR;

    public a(VipBannerList vipBannerList) {
        this.cardId = "";
        if (vipBannerList != null && vipBannerList.item != null) {
            this.cardId = vipBannerList.card_id;
            this.liR = new ArrayList();
            for (VipBannerItem vipBannerItem : vipBannerList.item) {
                this.liR.add(new b(vipBannerItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return liQ;
    }
}
