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
    public static final BdUniqueId fia = BdUniqueId.gen();
    private List<g.a> fhG;
    private List<com.baidu.tieba.personCenter.data.d> fib;
    public String fic;

    public void cB(List<g.a> list) {
        if (this.fhG == null) {
            this.fhG = new ArrayList();
        } else {
            this.fhG.clear();
        }
        if (this.fib == null) {
            this.fib = new ArrayList();
        } else {
            this.fib.clear();
        }
        cC(list);
    }

    private void cC(List<g.a> list) {
        if (list != null) {
            for (g.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title)) {
                    if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_record))) {
                        com.baidu.tieba.personCenter.data.d dVar = new com.baidu.tieba.personCenter.data.d();
                        dVar.iconId = d.f.icon_mine_buy;
                        dVar.title = TbadkCoreApplication.getInst().getString(d.j.consumption_records);
                        dVar.fjc = new com.baidu.tieba.personCenter.c.a();
                        dVar.fjc.cmv = 13;
                        dVar.fjc.cmw = new Bundle();
                        dVar.fjc.cmw.putString("type_center_consume_url", aVar.fhF);
                        this.fic = aVar.fhF;
                        this.fib.add(dVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.get_tdou))) {
                        this.fhG.add(aVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fia;
    }
}
