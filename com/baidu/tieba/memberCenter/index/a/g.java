package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes9.dex */
public class g implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmE = BdUniqueId.gen();
    public String cardId;
    public boolean lmk = false;
    public boolean lml = true;
    private d lmq;
    private List<h> lmx;

    public g(VipDailyList vipDailyList) {
        this.cardId = "";
        if (vipDailyList != null && vipDailyList.item != null && vipDailyList.item.size() > 0) {
            this.cardId = vipDailyList.card_id;
            this.lmq = new d();
            this.lmq.Es(1);
            this.lmq.setCategoryName(vipDailyList.class_name);
            this.lmq.NZ(vipDailyList.class_url_name);
            this.lmq.Oa(vipDailyList.class_url);
            this.lmx = new ArrayList();
            for (VipThemeItem vipThemeItem : vipDailyList.item) {
                this.lmx.add(new h(vipThemeItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmE;
    }
}
