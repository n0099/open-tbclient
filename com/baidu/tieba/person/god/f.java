package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
class f implements BdListView.e {
    final /* synthetic */ GodThreadListActivity eiG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GodThreadListActivity godThreadListActivity) {
        this.eiG = godThreadListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        i iVar;
        h hVar;
        List list;
        i iVar2;
        List list2;
        i iVar3;
        List list3;
        h hVar2;
        h hVar3;
        i iVar4;
        long j;
        h hVar4;
        iVar = this.eiG.eiC;
        if (iVar != null) {
            hVar = this.eiG.eiB;
            if (hVar != null) {
                list = this.eiG.eiD;
                if (list != null) {
                    iVar2 = this.eiG.eiC;
                    if (!iVar2.DK()) {
                        list2 = this.eiG.eiD;
                        if (!list2.isEmpty()) {
                            iVar3 = this.eiG.eiC;
                            if (iVar3.hasMore()) {
                                iVar4 = this.eiG.eiC;
                                j = this.eiG.mUserId;
                                iVar4.co(j);
                                hVar4 = this.eiG.eiB;
                                hVar4.Un();
                                return;
                            }
                            list3 = this.eiG.eiD;
                            if (!list3.isEmpty()) {
                                hVar2 = this.eiG.eiB;
                                hVar2.aLv();
                                return;
                            }
                            String string = TbadkCoreApplication.m9getInst().getString(u.j.no_data_text);
                            hVar3 = this.eiG.eiB;
                            hVar3.nK(string);
                        }
                    }
                }
            }
        }
    }
}
