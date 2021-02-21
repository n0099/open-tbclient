package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes9.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lnD = BdUniqueId.gen();
    public String cardId;
    private d lmE;
    private List<o> lmL;
    public boolean lmy = false;
    public boolean lmz = true;

    public n(VipSpecialList vipSpecialList) {
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.lmE = new d();
            this.lmE.Es(1);
            this.lmE.setCategoryName(vipSpecialList.class_name);
            this.lmE.Oa(vipSpecialList.class_url_name);
            this.lmE.Ob(vipSpecialList.class_url);
            this.lmL = new ArrayList();
            for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
                this.lmL.add(new o(vipSpecialItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lnD;
    }
}
