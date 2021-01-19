package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes8.dex */
public class g implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId leC = BdUniqueId.gen();
    public String cardId;
    public boolean leh = false;
    public boolean lei = true;
    private d leo;
    private List<h> lev;

    public g(VipDailyList vipDailyList) {
        this.cardId = "";
        if (vipDailyList != null && vipDailyList.item != null && vipDailyList.item.size() > 0) {
            this.cardId = vipDailyList.card_id;
            this.leo = new d();
            this.leo.Ea(1);
            this.leo.setCategoryName(vipDailyList.class_name);
            this.leo.Nl(vipDailyList.class_url_name);
            this.leo.Nm(vipDailyList.class_url);
            this.lev = new ArrayList();
            for (VipThemeItem vipThemeItem : vipDailyList.item) {
                this.lev.add(new h(vipThemeItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return leC;
    }
}
