package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes8.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lpd = BdUniqueId.gen();
    public String cardId;
    public boolean loF = false;
    public boolean loG = true;
    private d loL;
    private List<j> lpe;
    private List<j> lpf;

    public i(VipThemeList vipThemeList) {
        this.cardId = "";
        if (vipThemeList != null) {
            this.cardId = vipThemeList.card_id;
            this.loL = new d();
            this.loL.Ev(2);
            this.loL.setCategoryName(vipThemeList.class_name);
            this.loL.Og(vipThemeList.class_url_name);
            this.loL.Oh(vipThemeList.class_url);
            if (vipThemeList.item != null) {
                this.lpe = new ArrayList();
                for (VipThemeItem vipThemeItem : vipThemeList.item) {
                    this.lpe.add(new j(vipThemeItem));
                }
            }
            if (vipThemeList.item_card != null) {
                this.lpf = new ArrayList();
                for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                    this.lpf.add(new j(vipThemeItem2));
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lpd;
    }
}
