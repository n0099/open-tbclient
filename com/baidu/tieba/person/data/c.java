package com.baidu.tieba.person.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.g;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId eKH = BdUniqueId.gen();
    private List<com.baidu.tieba.personCenter.c.c> eKI;
    private String eKb;
    private String eKc;
    private List<g.a> eKd;
    private String icon;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String aUL() {
        return this.eKb;
    }

    public void pQ(String str) {
        this.eKb = str;
    }

    public String aUM() {
        return this.eKc;
    }

    public void pR(String str) {
        this.eKc = str;
    }

    public List<g.a> aUN() {
        return this.eKd;
    }

    public void cB(List<g.a> list) {
        if (this.eKd == null) {
            this.eKd = new ArrayList();
        } else {
            this.eKd.clear();
        }
        if (this.eKI == null) {
            this.eKI = new ArrayList();
        } else {
            this.eKI.clear();
        }
        cC(list);
    }

    private void cC(List<g.a> list) {
        if (list != null) {
            boolean z = EcommSwitchStatic.GN() && TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
            for (g.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title) && (z || !aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.ecomm_my_shop)))) {
                    if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_record))) {
                        com.baidu.tieba.personCenter.c.c cVar = new com.baidu.tieba.personCenter.c.c();
                        cVar.iconId = r.f.icon_mine_buy;
                        cVar.eMe = r.j.person_center_buy_record;
                        cVar.eMd = new com.baidu.tieba.personCenter.d.a();
                        cVar.eMd.bMj = 12;
                        cVar.eMd.bMk = new Bundle();
                        cVar.eMd.bMk.putString("type_center_consume_url", aVar.eKc);
                        this.eKI.add(cVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_center_my_order))) {
                        com.baidu.tieba.personCenter.c.c cVar2 = new com.baidu.tieba.personCenter.c.c();
                        cVar2.iconId = r.f.icon_mine_order;
                        cVar2.eMe = r.j.person_center_my_order;
                        cVar2.eMd = new com.baidu.tieba.personCenter.d.a();
                        cVar2.eMd.bMj = 13;
                        cVar2.eMd.bMk = new Bundle();
                        cVar2.eMd.bMk.putString("type_center_order_url", aVar.eKc);
                        cVar2.eMd.bMk.putString("person_center_item_txt", aVar.tip);
                        this.eKI.add(cVar2);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.ecomm_my_shop))) {
                        com.baidu.tieba.personCenter.c.c cVar3 = new com.baidu.tieba.personCenter.c.c();
                        cVar3.iconId = r.f.icon_mine_shop;
                        cVar3.eMe = r.j.ecomm_my_shop;
                        cVar3.eMd = new com.baidu.tieba.personCenter.d.a();
                        cVar3.eMd.bMk = new Bundle();
                        cVar3.eMd.bMj = 14;
                        cVar3.eMd.bMk.putString("type_center_myshop_url", aVar.eKc);
                        cVar3.eMd.bMk.putString("person_center_item_txt", aVar.tip);
                        this.eKI.add(cVar3);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_getTbeans))) {
                        this.eKd.add(aVar);
                    }
                }
            }
        }
    }

    public com.baidu.tieba.personCenter.c.c pg(int i) {
        for (com.baidu.tieba.personCenter.c.c cVar : this.eKI) {
            if (cVar != null && i == cVar.eMe) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eKH;
    }
}
