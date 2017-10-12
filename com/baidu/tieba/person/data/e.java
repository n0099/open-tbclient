package com.baidu.tieba.person.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.person.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eZB = BdUniqueId.gen();
    private List<com.baidu.tieba.personCenter.c.d> eZC;
    public String eZD;
    private List<g.a> eZh;

    public void cz(List<g.a> list) {
        if (this.eZh == null) {
            this.eZh = new ArrayList();
        } else {
            this.eZh.clear();
        }
        if (this.eZC == null) {
            this.eZC = new ArrayList();
        } else {
            this.eZC.clear();
        }
        cA(list);
    }

    private void cA(List<g.a> list) {
        if (list != null) {
            for (g.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title)) {
                    if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.person_wallet_record))) {
                        com.baidu.tieba.personCenter.c.d dVar = new com.baidu.tieba.personCenter.c.d();
                        dVar.iconId = d.g.icon_mine_buy;
                        dVar.title = TbadkCoreApplication.getInst().getString(d.l.consumption_records);
                        dVar.faB = new com.baidu.tieba.personCenter.d.a();
                        dVar.faB.ceU = 13;
                        dVar.faB.ceV = new Bundle();
                        dVar.faB.ceV.putString("type_center_consume_url", aVar.eZg);
                        this.eZD = aVar.eZg;
                        this.eZC.add(dVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.get_tdou))) {
                        this.eZh.add(aVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eZB;
    }
}
