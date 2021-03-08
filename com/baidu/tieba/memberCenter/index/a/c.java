package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes8.dex */
public class c implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId loK = BdUniqueId.gen();
    public String cardId;
    private List<VipSpecialItem> itemList;
    public boolean loF = false;
    public boolean loG = true;
    private d loL;
    public int type;

    public c(VipBasicList vipBasicList) {
        this.type = 0;
        this.cardId = "";
        if (vipBasicList != null && vipBasicList.item.size() > 0) {
            this.cardId = vipBasicList.card_id;
            this.type = vipBasicList.card_type.intValue();
            this.loL = new d();
            this.loL.Ev(5);
            this.loL.setCategoryName(vipBasicList.class_name);
            this.loL.Og(vipBasicList.class_url_name);
            this.loL.Oh(vipBasicList.class_url);
            this.itemList = new ArrayList();
            for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
                this.itemList.add(vipSpecialItem);
            }
        }
    }

    public List<VipSpecialItem> dfs() {
        return this.itemList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return loK;
    }
}
