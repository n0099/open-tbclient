package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class e implements t.b {
    final /* synthetic */ GodThreadListActivity eiG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GodThreadListActivity godThreadListActivity) {
        this.eiG = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        i iVar;
        h hVar;
        i iVar2;
        h hVar2;
        h hVar3;
        i iVar3;
        int i;
        long j;
        h hVar4;
        h hVar5;
        h hVar6;
        iVar = this.eiG.eiC;
        if (iVar != null) {
            hVar = this.eiG.eiB;
            if (hVar != null) {
                if (!com.baidu.adp.lib.util.i.fr()) {
                    hVar4 = this.eiG.eiB;
                    hVar4.SQ();
                    String string = TbadkCoreApplication.m9getInst().getString(u.j.neterror);
                    hVar5 = this.eiG.eiB;
                    hVar5.nK(string);
                    hVar6 = this.eiG.eiB;
                    hVar6.aLw();
                    return;
                }
                iVar2 = this.eiG.eiC;
                if (!iVar2.DK()) {
                    hVar2 = this.eiG.eiB;
                    hVar2.aLw();
                    hVar3 = this.eiG.eiB;
                    hVar3.hideNoDataView();
                    iVar3 = this.eiG.eiC;
                    i = this.eiG.dMp;
                    j = this.eiG.mUserId;
                    iVar3.j(i, j);
                }
            }
        }
    }
}
