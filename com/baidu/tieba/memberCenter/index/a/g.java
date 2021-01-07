package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes9.dex */
public class g implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ljh = BdUniqueId.gen();
    public String cardId;
    public boolean liN = false;
    public boolean liO = true;
    private d liT;
    private List<h> lja;

    public g(VipDailyList vipDailyList) {
        this.cardId = "";
        if (vipDailyList != null && vipDailyList.item != null && vipDailyList.item.size() > 0) {
            this.cardId = vipDailyList.card_id;
            this.liT = new d();
            this.liT.FG(1);
            this.liT.setCategoryName(vipDailyList.class_name);
            this.liT.Os(vipDailyList.class_url_name);
            this.liT.Ot(vipDailyList.class_url);
            this.lja = new ArrayList();
            for (VipThemeItem vipThemeItem : vipDailyList.item) {
                this.lja.add(new h(vipThemeItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ljh;
    }
}
