package com.baidu.tieba.person.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.g;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId eCf = BdUniqueId.gen();
    private String eBA;
    private List<g.a> eBB;
    private String eBz;
    private List<com.baidu.tieba.personCenter.c.c> eCg;
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

    public String aSg() {
        return this.eBz;
    }

    public void pr(String str) {
        this.eBz = str;
    }

    public String aSh() {
        return this.eBA;
    }

    public void ps(String str) {
        this.eBA = str;
    }

    public List<g.a> aSi() {
        return this.eBB;
    }

    public void cy(List<g.a> list) {
        if (this.eBB == null) {
            this.eBB = new ArrayList();
        } else {
            this.eBB.clear();
        }
        if (this.eCg == null) {
            this.eCg = new ArrayList();
        } else {
            this.eCg.clear();
        }
        cz(list);
    }

    private void cz(List<g.a> list) {
        if (list != null) {
            boolean z = EcommSwitchStatic.GL() && TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
            for (g.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title) && (z || !aVar.title.equals(Boolean.valueOf(aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(t.j.ecomm_my_shop)))))) {
                    if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(t.j.person_wallet_record))) {
                        com.baidu.tieba.personCenter.c.c cVar = new com.baidu.tieba.personCenter.c.c();
                        cVar.iconId = t.f.icon_mine_buy;
                        cVar.ata = t.j.person_center_buy_record;
                        cVar.eDB = new com.baidu.tieba.personCenter.d.a();
                        cVar.eDB.bJp = 12;
                        cVar.eDB.bJq = new Bundle();
                        cVar.eDB.bJq.putString("type_center_consume_url", aVar.eBA);
                        this.eCg.add(cVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(t.j.person_center_my_order))) {
                        com.baidu.tieba.personCenter.c.c cVar2 = new com.baidu.tieba.personCenter.c.c();
                        cVar2.iconId = t.f.icon_mine_order;
                        cVar2.ata = t.j.person_center_my_order;
                        cVar2.eDB = new com.baidu.tieba.personCenter.d.a();
                        cVar2.eDB.bJp = 13;
                        cVar2.eDB.bJq = new Bundle();
                        cVar2.eDB.bJq.putString("type_center_order_url", aVar.eBA);
                        cVar2.eDB.bJq.putString("person_center_item_txt", aVar.tip);
                        this.eCg.add(cVar2);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(t.j.ecomm_my_shop))) {
                        com.baidu.tieba.personCenter.c.c cVar3 = new com.baidu.tieba.personCenter.c.c();
                        cVar3.iconId = t.f.icon_mine_shop;
                        cVar3.ata = t.j.ecomm_my_shop;
                        cVar3.eDB = new com.baidu.tieba.personCenter.d.a();
                        cVar3.eDB.bJq = new Bundle();
                        cVar3.eDB.bJp = 14;
                        cVar3.eDB.bJq.putString("type_center_myshop_url", aVar.eBA);
                        cVar3.eDB.bJq.putString("person_center_item_txt", aVar.tip);
                        this.eCg.add(cVar3);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(t.j.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(t.j.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(t.j.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(t.j.person_wallet_getTbeans))) {
                        this.eBB.add(aVar);
                    }
                }
            }
        }
    }

    public com.baidu.tieba.personCenter.c.c oJ(int i) {
        for (com.baidu.tieba.personCenter.c.c cVar : this.eCg) {
            if (cVar != null && i == cVar.ata) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eCf;
    }
}
