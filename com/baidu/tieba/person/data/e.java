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
    public static final BdUniqueId fqY = BdUniqueId.gen();
    private List<g.a> fqE;
    private List<com.baidu.tieba.personCenter.data.d> fqZ;
    public String fra;

    public void cO(List<g.a> list) {
        if (this.fqE == null) {
            this.fqE = new ArrayList();
        } else {
            this.fqE.clear();
        }
        if (this.fqZ == null) {
            this.fqZ = new ArrayList();
        } else {
            this.fqZ.clear();
        }
        cP(list);
    }

    private void cP(List<g.a> list) {
        if (list != null) {
            for (g.a aVar : list) {
                if (aVar != null && !StringUtils.isNull(aVar.title)) {
                    if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_record))) {
                        com.baidu.tieba.personCenter.data.d dVar = new com.baidu.tieba.personCenter.data.d();
                        dVar.iconId = d.f.icon_mine_buy;
                        dVar.title = TbadkCoreApplication.getInst().getString(d.j.consumption_records);
                        dVar.frZ = new com.baidu.tieba.personCenter.c.a();
                        dVar.frZ.cuZ = 13;
                        dVar.frZ.cva = new Bundle();
                        dVar.frZ.cva.putString("type_center_consume_url", aVar.fqD);
                        this.fra = aVar.fqD;
                        this.fqZ.add(dVar);
                    } else if (aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_money)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_bankCard)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.person_wallet_card_coupons)) || aVar.title.equals(TbadkCoreApplication.getInst().getResources().getString(d.j.get_tdou))) {
                        this.fqE.add(aVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fqY;
    }
}
