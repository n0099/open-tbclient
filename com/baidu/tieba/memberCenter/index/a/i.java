package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes9.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmW = BdUniqueId.gen();
    public String cardId;
    private d lmE;
    private List<j> lmX;
    private List<j> lmY;
    public boolean lmy = false;
    public boolean lmz = true;

    public i(VipThemeList vipThemeList) {
        this.cardId = "";
        if (vipThemeList != null) {
            this.cardId = vipThemeList.card_id;
            this.lmE = new d();
            this.lmE.Es(2);
            this.lmE.setCategoryName(vipThemeList.class_name);
            this.lmE.Oa(vipThemeList.class_url_name);
            this.lmE.Ob(vipThemeList.class_url);
            if (vipThemeList.item != null) {
                this.lmX = new ArrayList();
                for (VipThemeItem vipThemeItem : vipThemeList.item) {
                    this.lmX.add(new j(vipThemeItem));
                }
            }
            if (vipThemeList.item_card != null) {
                this.lmY = new ArrayList();
                for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                    this.lmY.add(new j(vipThemeItem2));
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmW;
    }
}
