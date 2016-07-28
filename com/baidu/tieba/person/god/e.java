package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class e implements t.b {
    final /* synthetic */ GodThreadListActivity esK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GodThreadListActivity godThreadListActivity) {
        this.esK = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aH(boolean z) {
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
        iVar = this.esK.esG;
        if (iVar != null) {
            hVar = this.esK.esF;
            if (hVar != null) {
                if (!com.baidu.adp.lib.util.i.fq()) {
                    hVar4 = this.esK.esF;
                    hVar4.Ty();
                    String string = TbadkCoreApplication.m10getInst().getString(u.j.neterror);
                    hVar5 = this.esK.esF;
                    hVar5.ox(string);
                    hVar6 = this.esK.esF;
                    hVar6.aNZ();
                    return;
                }
                iVar2 = this.esK.esG;
                if (!iVar2.DJ()) {
                    hVar2 = this.esK.esF;
                    hVar2.aNZ();
                    hVar3 = this.esK.esF;
                    hVar3.hideNoDataView();
                    iVar3 = this.esK.esG;
                    i = this.esK.dYz;
                    j = this.esK.mUserId;
                    iVar3.k(i, j);
                }
            }
        }
    }
}
