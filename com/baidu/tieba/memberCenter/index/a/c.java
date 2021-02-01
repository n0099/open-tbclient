package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes9.dex */
public class c implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmp = BdUniqueId.gen();
    public String cardId;
    private List<VipSpecialItem> itemList;
    public boolean lmk = false;
    public boolean lml = true;
    private d lmq;
    public int type;

    public c(VipBasicList vipBasicList) {
        this.type = 0;
        this.cardId = "";
        if (vipBasicList != null && vipBasicList.item.size() > 0) {
            this.cardId = vipBasicList.card_id;
            this.type = vipBasicList.card_type.intValue();
            this.lmq = new d();
            this.lmq.Es(5);
            this.lmq.setCategoryName(vipBasicList.class_name);
            this.lmq.NZ(vipBasicList.class_url_name);
            this.lmq.Oa(vipBasicList.class_url);
            this.itemList = new ArrayList();
            for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
                this.itemList.add(vipSpecialItem);
            }
        }
    }

    public List<VipSpecialItem> dfc() {
        return this.itemList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmp;
    }
}
