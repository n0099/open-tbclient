package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes8.dex */
public class g implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId loZ = BdUniqueId.gen();
    public String cardId;
    public boolean loF = false;
    public boolean loG = true;
    private d loL;
    private List<h> loS;

    public g(VipDailyList vipDailyList) {
        this.cardId = "";
        if (vipDailyList != null && vipDailyList.item != null && vipDailyList.item.size() > 0) {
            this.cardId = vipDailyList.card_id;
            this.loL = new d();
            this.loL.Ev(1);
            this.loL.setCategoryName(vipDailyList.class_name);
            this.loL.Og(vipDailyList.class_url_name);
            this.loL.Oh(vipDailyList.class_url);
            this.loS = new ArrayList();
            for (VipThemeItem vipThemeItem : vipDailyList.item) {
                this.loS.add(new h(vipThemeItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return loZ;
    }
}
