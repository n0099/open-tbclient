package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes8.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lfm = BdUniqueId.gen();
    public String cardId;
    public boolean leh = false;
    public boolean lei = true;
    private d leo;
    private List<o> lev;

    public n(VipSpecialList vipSpecialList) {
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.leo = new d();
            this.leo.Ea(1);
            this.leo.setCategoryName(vipSpecialList.class_name);
            this.leo.Nk(vipSpecialList.class_url_name);
            this.leo.Nl(vipSpecialList.class_url);
            this.lev = new ArrayList();
            for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
                this.lev.add(new o(vipSpecialItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lfm;
    }
}
