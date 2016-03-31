package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
class e implements BdListView.e {
    final /* synthetic */ GodThreadListActivity dwU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GodThreadListActivity godThreadListActivity) {
        this.dwU = godThreadListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
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
        hVar = this.dwU.dwQ;
        if (hVar != null) {
            gVar = this.dwU.dwP;
            if (gVar != null) {
                list = this.dwU.dwR;
                if (list != null) {
                    hVar2 = this.dwU.dwQ;
                    if (!hVar2.isLoading()) {
                        list2 = this.dwU.dwR;
                        if (!list2.isEmpty()) {
                            hVar3 = this.dwU.dwQ;
                            if (hVar3.hasMore()) {
                                hVar4 = this.dwU.dwQ;
                                j = this.dwU.mUserId;
                                hVar4.bG(j);
                                gVar4 = this.dwU.dwP;
                                gVar4.PQ();
                                return;
                            }
                            list3 = this.dwU.dwR;
                            if (!list3.isEmpty()) {
                                gVar2 = this.dwU.dwP;
                                gVar2.aCg();
                                return;
                            }
                            String string = TbadkCoreApplication.m411getInst().getString(t.j.no_data_text);
                            gVar3 = this.dwU.dwP;
                            gVar3.mf(string);
                        }
                    }
                }
            }
        }
    }
}
