package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes9.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmI = BdUniqueId.gen();
    public String cardId;
    private List<j> lmJ;
    private List<j> lmK;
    public boolean lmk = false;
    public boolean lml = true;
    private d lmq;

    public i(VipThemeList vipThemeList) {
        this.cardId = "";
        if (vipThemeList != null) {
            this.cardId = vipThemeList.card_id;
            this.lmq = new d();
            this.lmq.Es(2);
            this.lmq.setCategoryName(vipThemeList.class_name);
            this.lmq.NZ(vipThemeList.class_url_name);
            this.lmq.Oa(vipThemeList.class_url);
            if (vipThemeList.item != null) {
                this.lmJ = new ArrayList();
                for (VipThemeItem vipThemeItem : vipThemeList.item) {
                    this.lmJ.add(new j(vipThemeItem));
                }
            }
            if (vipThemeList.item_card != null) {
                this.lmK = new ArrayList();
                for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                    this.lmK.add(new j(vipThemeItem2));
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmI;
    }
}
