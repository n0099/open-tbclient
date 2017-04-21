package com.baidu.tieba.person.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.f;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId eCl = BdUniqueId.gen();
    private String eBI;
    private String eBJ;
    private List<f.a> eBK;
    private List<com.baidu.tieba.personCenter.c.c> eCm;
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

    public String aRn() {
        return this.eBI;
    }

    public void nW(String str) {
        this.eBI = str;
    }

    public String aRo() {
        return this.eBJ;
    }

    public void nX(String str) {
        this.eBJ = str;
    }

    public List<f.a> aRp() {
        return this.eBK;
    }

    public void cf(List<f.a> list) {
        if (this.eBK == null) {
            this.eBK = new ArrayList();
        } else {
            this.eBK.clear();
        }
        if (this.eCm == null) {
            this.eCm = new ArrayList();
        } else {
            this.eCm.clear();
        }
        cg(list);
    }

    private void cg(List<f.a> list) {
        if (list != null) {
            for (f.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title)) {
                    if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_record))) {
                        com.baidu.tieba.personCenter.c.c cVar = new com.baidu.tieba.personCenter.c.c();
                        cVar.iconId = w.g.icon_mine_buy;
                        cVar.title = TbadkCoreApplication.m9getInst().getString(w.l.consumption_records);
                        cVar.eDk = new com.baidu.tieba.personCenter.d.a();
                        cVar.eDk.bJo = 13;
                        cVar.eDk.bJp = new Bundle();
                        cVar.eDk.bJp.putString("type_center_consume_url", aVar.eBJ);
                        this.eCm.add(cVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.get_tdou))) {
                        this.eBK.add(aVar);
                    }
                }
            }
        }
    }

    public com.baidu.tieba.personCenter.c.c nY(String str) {
        for (com.baidu.tieba.personCenter.c.c cVar : this.eCm) {
            if (cVar != null && str != null && str.equals(cVar.title)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eCl;
    }
}
