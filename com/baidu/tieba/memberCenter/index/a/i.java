package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes9.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ljl = BdUniqueId.gen();
    public String cardId;
    public boolean liN = false;
    public boolean liO = true;
    private d liT;
    private List<j> ljm;
    private List<j> ljn;

    public i(VipThemeList vipThemeList) {
        this.cardId = "";
        if (vipThemeList != null) {
            this.cardId = vipThemeList.card_id;
            this.liT = new d();
            this.liT.FG(2);
            this.liT.setCategoryName(vipThemeList.class_name);
            this.liT.Os(vipThemeList.class_url_name);
            this.liT.Ot(vipThemeList.class_url);
            if (vipThemeList.item != null) {
                this.ljm = new ArrayList();
                for (VipThemeItem vipThemeItem : vipThemeList.item) {
                    this.ljm.add(new j(vipThemeItem));
                }
            }
            if (vipThemeList.item_card != null) {
                this.ljn = new ArrayList();
                for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                    this.ljn.add(new j(vipThemeItem2));
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ljl;
    }
}
