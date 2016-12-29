package com.baidu.tieba.person.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.f;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId eow = BdUniqueId.gen();
    private String enS;
    private String enT;
    private List<f.a> enU;
    private List<com.baidu.tieba.personCenter.c.c> eox;
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

    public String aOA() {
        return this.enS;
    }

    public void or(String str) {
        this.enS = str;
    }

    public String aOB() {
        return this.enT;
    }

    public void os(String str) {
        this.enT = str;
    }

    public List<f.a> aOC() {
        return this.enU;
    }

    public void ct(List<f.a> list) {
        if (this.enU == null) {
            this.enU = new ArrayList();
        } else {
            this.enU.clear();
        }
        if (this.eox == null) {
            this.eox = new ArrayList();
        } else {
            this.eox.clear();
        }
        cu(list);
    }

    private void cu(List<f.a> list) {
        if (list != null) {
            for (f.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title)) {
                    if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_record))) {
                        com.baidu.tieba.personCenter.c.c cVar = new com.baidu.tieba.personCenter.c.c();
                        cVar.iconId = r.f.icon_mine_buy;
                        cVar.title = TbadkCoreApplication.m9getInst().getString(r.j.person_center_buy_record);
                        cVar.epB = new com.baidu.tieba.personCenter.d.a();
                        cVar.epB.bsn = 13;
                        cVar.epB.bso = new Bundle();
                        cVar.epB.bso.putString("type_center_consume_url", aVar.enT);
                        this.eox.add(cVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.j.person_wallet_getTbeans))) {
                        this.enU.add(aVar);
                    }
                }
            }
        }
    }

    public com.baidu.tieba.personCenter.c.c ot(String str) {
        for (com.baidu.tieba.personCenter.c.c cVar : this.eox) {
            if (cVar != null && str != null && str.equals(cVar.title)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eow;
    }
}
