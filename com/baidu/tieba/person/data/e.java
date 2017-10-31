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
    public static final BdUniqueId fhE = BdUniqueId.gen();
    private List<com.baidu.tieba.personCenter.data.d> fhF;
    public String fhG;
    private List<g.a> fhk;

    public void cA(List<g.a> list) {
        if (this.fhk == null) {
            this.fhk = new ArrayList();
        } else {
            this.fhk.clear();
        }
        if (this.fhF == null) {
            this.fhF = new ArrayList();
        } else {
            this.fhF.clear();
        }
        cB(list);
    }

    private void cB(List<g.a> list) {
        if (list != null) {
            for (g.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title)) {
                    if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_record))) {
                        com.baidu.tieba.personCenter.data.d dVar = new com.baidu.tieba.personCenter.data.d();
                        dVar.iconId = d.f.icon_mine_buy;
                        dVar.title = TbadkCoreApplication.getInst().getString(d.j.consumption_records);
                        dVar.fiF = new com.baidu.tieba.personCenter.c.a();
                        dVar.fiF.cmb = 13;
                        dVar.fiF.cmc = new Bundle();
                        dVar.fiF.cmc.putString("type_center_consume_url", aVar.fhj);
                        this.fhG = aVar.fhj;
                        this.fhF.add(dVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.get_tdou))) {
                        this.fhk.add(aVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fhE;
    }
}
