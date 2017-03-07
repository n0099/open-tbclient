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
    public static final BdUniqueId eBP = BdUniqueId.gen();
    private List<com.baidu.tieba.personCenter.c.c> eBQ;
    private String eBm;
    private String eBn;
    private List<f.a> eBo;
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

    public String aQd() {
        return this.eBm;
    }

    public void nR(String str) {
        this.eBm = str;
    }

    public String aQe() {
        return this.eBn;
    }

    public void nS(String str) {
        this.eBn = str;
    }

    public List<f.a> aQf() {
        return this.eBo;
    }

    public void cf(List<f.a> list) {
        if (this.eBo == null) {
            this.eBo = new ArrayList();
        } else {
            this.eBo.clear();
        }
        if (this.eBQ == null) {
            this.eBQ = new ArrayList();
        } else {
            this.eBQ.clear();
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
                        cVar.eCX = new com.baidu.tieba.personCenter.d.a();
                        cVar.eCX.bHe = 13;
                        cVar.eCX.bHf = new Bundle();
                        cVar.eCX.bHf.putString("type_center_consume_url", aVar.eBn);
                        this.eBQ.add(cVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.get_tdou))) {
                        this.eBo.add(aVar);
                    }
                }
            }
        }
    }

    public com.baidu.tieba.personCenter.c.c nT(String str) {
        for (com.baidu.tieba.personCenter.c.c cVar : this.eBQ) {
            if (cVar != null && str != null && str.equals(cVar.title)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eBP;
    }
}
