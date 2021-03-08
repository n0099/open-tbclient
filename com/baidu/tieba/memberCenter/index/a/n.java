package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes8.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lpJ = BdUniqueId.gen();
    public String cardId;
    public boolean loF = false;
    public boolean loG = true;
    private d loL;
    private List<o> loS;

    public n(VipSpecialList vipSpecialList) {
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.loL = new d();
            this.loL.Ev(1);
            this.loL.setCategoryName(vipSpecialList.class_name);
            this.loL.Og(vipSpecialList.class_url_name);
            this.loL.Oh(vipSpecialList.class_url);
            this.loS = new ArrayList();
            for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
                this.loS.add(new o(vipSpecialItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lpJ;
    }
}
