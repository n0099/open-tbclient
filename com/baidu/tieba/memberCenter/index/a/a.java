package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBannerItem;
import tbclient.GetVipInfo.VipBannerList;
/* loaded from: classes9.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmn = BdUniqueId.gen();
    public String cardId;
    public boolean lmk = false;
    private List<b> lmo;

    public a(VipBannerList vipBannerList) {
        this.cardId = "";
        if (vipBannerList != null && vipBannerList.item != null) {
            this.cardId = vipBannerList.card_id;
            this.lmo = new ArrayList();
            for (VipBannerItem vipBannerItem : vipBannerList.item) {
                this.lmo.add(new b(vipBannerItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmn;
    }
}
