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
    public static final BdUniqueId eyq = BdUniqueId.gen();
    private String exM;
    private String exN;
    private List<f.a> exO;
    private List<com.baidu.tieba.personCenter.c.c> eyr;
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

    public String aQA() {
        return this.exM;
    }

    public void oJ(String str) {
        this.exM = str;
    }

    public String aQB() {
        return this.exN;
    }

    public void oK(String str) {
        this.exN = str;
    }

    public List<f.a> aQC() {
        return this.exO;
    }

    public void cy(List<f.a> list) {
        if (this.exO == null) {
            this.exO = new ArrayList();
        } else {
            this.exO.clear();
        }
        if (this.eyr == null) {
            this.eyr = new ArrayList();
        } else {
            this.eyr.clear();
        }
        cz(list);
    }

    private void cz(List<f.a> list) {
        if (list != null) {
            for (f.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title)) {
                    if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.l.person_wallet_record))) {
                        com.baidu.tieba.personCenter.c.c cVar = new com.baidu.tieba.personCenter.c.c();
                        cVar.iconId = r.g.icon_mine_buy;
                        cVar.title = TbadkCoreApplication.m9getInst().getString(r.l.consumption_records);
                        cVar.ezy = new com.baidu.tieba.personCenter.d.a();
                        cVar.ezy.bzY = 13;
                        cVar.ezy.bzZ = new Bundle();
                        cVar.ezy.bzZ.putString("type_center_consume_url", aVar.exN);
                        this.eyr.add(cVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.l.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.l.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.l.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.m9getInst().getResources().getString(r.l.get_tdou))) {
                        this.exO.add(aVar);
                    }
                }
            }
        }
    }

    public com.baidu.tieba.personCenter.c.c oL(String str) {
        for (com.baidu.tieba.personCenter.c.c cVar : this.eyr) {
            if (cVar != null && str != null && str.equals(cVar.title)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eyq;
    }
}
