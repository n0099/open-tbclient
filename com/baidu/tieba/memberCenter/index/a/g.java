package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes9.dex */
public class g implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmS = BdUniqueId.gen();
    public String cardId;
    private d lmE;
    private List<h> lmL;
    public boolean lmy = false;
    public boolean lmz = true;

    public g(VipDailyList vipDailyList) {
        this.cardId = "";
        if (vipDailyList != null && vipDailyList.item != null && vipDailyList.item.size() > 0) {
            this.cardId = vipDailyList.card_id;
            this.lmE = new d();
            this.lmE.Es(1);
            this.lmE.setCategoryName(vipDailyList.class_name);
            this.lmE.Oa(vipDailyList.class_url_name);
            this.lmE.Ob(vipDailyList.class_url);
            this.lmL = new ArrayList();
            for (VipThemeItem vipThemeItem : vipDailyList.item) {
                this.lmL.add(new h(vipThemeItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmS;
    }
}
