package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
class e implements BdListView.e {
    final /* synthetic */ GodThreadListActivity dzZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GodThreadListActivity godThreadListActivity) {
        this.dzZ = godThreadListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        h hVar;
        g gVar;
        List list;
        h hVar2;
        List list2;
        h hVar3;
        List list3;
        g gVar2;
        g gVar3;
        h hVar4;
        long j;
        g gVar4;
        hVar = this.dzZ.dzV;
        if (hVar != null) {
            gVar = this.dzZ.dzU;
            if (gVar != null) {
                list = this.dzZ.dzW;
                if (list != null) {
                    hVar2 = this.dzZ.dzV;
                    if (!hVar2.isLoading()) {
                        list2 = this.dzZ.dzW;
                        if (!list2.isEmpty()) {
                            hVar3 = this.dzZ.dzV;
                            if (hVar3.hasMore()) {
                                hVar4 = this.dzZ.dzV;
                                j = this.dzZ.mUserId;
                                hVar4.bG(j);
                                gVar4 = this.dzZ.dzU;
                                gVar4.OJ();
                                return;
                            }
                            list3 = this.dzZ.dzW;
                            if (!list3.isEmpty()) {
                                gVar2 = this.dzZ.dzU;
                                gVar2.aCx();
                                return;
                            }
                            String string = TbadkCoreApplication.m11getInst().getString(t.j.no_data_text);
                            gVar3 = this.dzZ.dzU;
                            gVar3.mj(string);
                        }
                    }
                }
            }
        }
    }
}
