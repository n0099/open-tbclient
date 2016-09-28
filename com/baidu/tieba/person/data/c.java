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
    public static final BdUniqueId eEi = BdUniqueId.gen();
    private String eDC;
    private String eDD;
    private List<g.a> eDE;
    private List<com.baidu.tieba.personCenter.c.c> eEj;
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

    public String aSE() {
        return this.eDC;
    }

    public void pD(String str) {
        this.eDC = str;
    }

    public String aSF() {
        return this.eDD;
    }

    public void pE(String str) {
        this.eDD = str;
    }

    public List<g.a> aSG() {
        return this.eDE;
    }

    public void cz(List<g.a> list) {
        if (this.eDE == null) {
            this.eDE = new ArrayList();
        } else {
            this.eDE.clear();
        }
        if (this.eEj == null) {
            this.eEj = new ArrayList();
        } else {
            this.eEj.clear();
        }
        cA(list);
    }

    private void cA(List<g.a> list) {
        if (list != null) {
            boolean z = EcommSwitchStatic.GK() && TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
            for (g.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title) && (z || !aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.ecomm_my_shop)))) {
                    if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_record))) {
                        com.baidu.tieba.personCenter.c.c cVar = new com.baidu.tieba.personCenter.c.c();
                        cVar.iconId = r.f.icon_mine_buy;
                        cVar.eFF = r.j.person_center_buy_record;
                        cVar.eFE = new com.baidu.tieba.personCenter.d.a();
                        cVar.eFE.bJq = 12;
                        cVar.eFE.bJr = new Bundle();
                        cVar.eFE.bJr.putString("type_center_consume_url", aVar.eDD);
                        this.eEj.add(cVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_center_my_order))) {
                        com.baidu.tieba.personCenter.c.c cVar2 = new com.baidu.tieba.personCenter.c.c();
                        cVar2.iconId = r.f.icon_mine_order;
                        cVar2.eFF = r.j.person_center_my_order;
                        cVar2.eFE = new com.baidu.tieba.personCenter.d.a();
                        cVar2.eFE.bJq = 13;
                        cVar2.eFE.bJr = new Bundle();
                        cVar2.eFE.bJr.putString("type_center_order_url", aVar.eDD);
                        cVar2.eFE.bJr.putString("person_center_item_txt", aVar.tip);
                        this.eEj.add(cVar2);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.ecomm_my_shop))) {
                        com.baidu.tieba.personCenter.c.c cVar3 = new com.baidu.tieba.personCenter.c.c();
                        cVar3.iconId = r.f.icon_mine_shop;
                        cVar3.eFF = r.j.ecomm_my_shop;
                        cVar3.eFE = new com.baidu.tieba.personCenter.d.a();
                        cVar3.eFE.bJr = new Bundle();
                        cVar3.eFE.bJq = 14;
                        cVar3.eFE.bJr.putString("type_center_myshop_url", aVar.eDD);
                        cVar3.eFE.bJr.putString("person_center_item_txt", aVar.tip);
                        this.eEj.add(cVar3);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_getTbeans))) {
                        this.eDE.add(aVar);
                    }
                }
            }
        }
    }

    public com.baidu.tieba.personCenter.c.c oT(int i) {
        for (com.baidu.tieba.personCenter.c.c cVar : this.eEj) {
            if (cVar != null && i == cVar.eFF) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eEi;
    }
}
