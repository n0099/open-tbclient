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
    public static final BdUniqueId eZn = BdUniqueId.gen();
    private List<g.a> eYT;
    private List<com.baidu.tieba.personCenter.c.d> eZo;
    public String eZp;

    public void cz(List<g.a> list) {
        if (this.eYT == null) {
            this.eYT = new ArrayList();
        } else {
            this.eYT.clear();
        }
        if (this.eZo == null) {
            this.eZo = new ArrayList();
        } else {
            this.eZo.clear();
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
                        dVar.fan = new com.baidu.tieba.personCenter.d.a();
                        dVar.fan.ceI = 13;
                        dVar.fan.ceJ = new Bundle();
                        dVar.fan.ceJ.putString("type_center_consume_url", aVar.eYS);
                        this.eZp = aVar.eYS;
                        this.eZo.add(dVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.l.get_tdou))) {
                        this.eYT.add(aVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eZn;
    }
}
