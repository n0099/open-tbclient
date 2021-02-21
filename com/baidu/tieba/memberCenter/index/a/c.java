package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes9.dex */
public class c implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmD = BdUniqueId.gen();
    public String cardId;
    private List<VipSpecialItem> itemList;
    private d lmE;
    public boolean lmy = false;
    public boolean lmz = true;
    public int type;

    public c(VipBasicList vipBasicList) {
        this.type = 0;
        this.cardId = "";
        if (vipBasicList != null && vipBasicList.item.size() > 0) {
            this.cardId = vipBasicList.card_id;
            this.type = vipBasicList.card_type.intValue();
            this.lmE = new d();
            this.lmE.Es(5);
            this.lmE.setCategoryName(vipBasicList.class_name);
            this.lmE.Oa(vipBasicList.class_url_name);
            this.lmE.Ob(vipBasicList.class_url);
            this.itemList = new ArrayList();
            for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
                this.itemList.add(vipSpecialItem);
            }
        }
    }

    public List<VipSpecialItem> dfj() {
        return this.itemList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmD;
    }
}
