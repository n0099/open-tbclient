package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes9.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lnp = BdUniqueId.gen();
    public String cardId;
    public boolean lmk = false;
    public boolean lml = true;
    private d lmq;
    private List<o> lmx;

    public n(VipSpecialList vipSpecialList) {
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.lmq = new d();
            this.lmq.Es(1);
            this.lmq.setCategoryName(vipSpecialList.class_name);
            this.lmq.NZ(vipSpecialList.class_url_name);
            this.lmq.Oa(vipSpecialList.class_url);
            this.lmx = new ArrayList();
            for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
                this.lmx.add(new o(vipSpecialItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lnp;
    }
}
