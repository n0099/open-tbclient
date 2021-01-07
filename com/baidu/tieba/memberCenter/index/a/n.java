package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes9.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ljR = BdUniqueId.gen();
    public String cardId;
    public boolean liN = false;
    public boolean liO = true;
    private d liT;
    private List<o> lja;

    public n(VipSpecialList vipSpecialList) {
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.liT = new d();
            this.liT.FG(1);
            this.liT.setCategoryName(vipSpecialList.class_name);
            this.liT.Os(vipSpecialList.class_url_name);
            this.liT.Ot(vipSpecialList.class_url);
            this.lja = new ArrayList();
            for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
                this.lja.add(new o(vipSpecialItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ljR;
    }
}
