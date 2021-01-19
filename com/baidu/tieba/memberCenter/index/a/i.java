package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes8.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId leG = BdUniqueId.gen();
    public String cardId;
    private List<j> leH;
    private List<j> leI;
    public boolean leh = false;
    public boolean lei = true;
    private d leo;

    public i(VipThemeList vipThemeList) {
        this.cardId = "";
        if (vipThemeList != null) {
            this.cardId = vipThemeList.card_id;
            this.leo = new d();
            this.leo.Ea(2);
            this.leo.setCategoryName(vipThemeList.class_name);
            this.leo.Nl(vipThemeList.class_url_name);
            this.leo.Nm(vipThemeList.class_url);
            if (vipThemeList.item != null) {
                this.leH = new ArrayList();
                for (VipThemeItem vipThemeItem : vipThemeList.item) {
                    this.leH.add(new j(vipThemeItem));
                }
            }
            if (vipThemeList.item_card != null) {
                this.leI = new ArrayList();
                for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                    this.leI.add(new j(vipThemeItem2));
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return leG;
    }
}
