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
    public static final BdUniqueId ezV = BdUniqueId.gen();
    private List<com.baidu.tieba.personCenter.c.c> ezW;
    private String ezs;
    private String ezt;
    private List<f.a> ezu;
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

    public String aQm() {
        return this.ezs;
    }

    public void nV(String str) {
        this.ezs = str;
    }

    public String aQn() {
        return this.ezt;
    }

    public void nW(String str) {
        this.ezt = str;
    }

    public List<f.a> aQo() {
        return this.ezu;
    }

    public void ce(List<f.a> list) {
        if (this.ezu == null) {
            this.ezu = new ArrayList();
        } else {
            this.ezu.clear();
        }
        if (this.ezW == null) {
            this.ezW = new ArrayList();
        } else {
            this.ezW.clear();
        }
        cf(list);
    }

    private void cf(List<f.a> list) {
        if (list != null) {
            for (f.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title)) {
                    if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_record))) {
                        com.baidu.tieba.personCenter.c.c cVar = new com.baidu.tieba.personCenter.c.c();
                        cVar.iconId = w.g.icon_mine_buy;
                        cVar.title = TbadkCoreApplication.m9getInst().getString(w.l.consumption_records);
                        cVar.eAU = new com.baidu.tieba.personCenter.d.a();
                        cVar.eAU.bGX = 13;
                        cVar.eAU.bGY = new Bundle();
                        cVar.eAU.bGY.putString("type_center_consume_url", aVar.ezt);
                        this.ezW.add(cVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(w.l.get_tdou))) {
                        this.ezu.add(aVar);
                    }
                }
            }
        }
    }

    public com.baidu.tieba.personCenter.c.c nX(String str) {
        for (com.baidu.tieba.personCenter.c.c cVar : this.ezW) {
            if (cVar != null && str != null && str.equals(cVar.title)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ezV;
    }
}
