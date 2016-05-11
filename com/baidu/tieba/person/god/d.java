package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements t.b {
    final /* synthetic */ GodThreadListActivity dzZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GodThreadListActivity godThreadListActivity) {
        this.dzZ = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        h hVar;
        g gVar;
        h hVar2;
        g gVar2;
        g gVar3;
        h hVar3;
        int i;
        long j;
        g gVar4;
        g gVar5;
        g gVar6;
        hVar = this.dzZ.dzV;
        if (hVar != null) {
            gVar = this.dzZ.dzU;
            if (gVar != null) {
                if (!com.baidu.adp.lib.util.i.fq()) {
                    gVar4 = this.dzZ.dzU;
                    gVar4.Nn();
                    String string = TbadkCoreApplication.m11getInst().getString(t.j.neterror);
                    gVar5 = this.dzZ.dzU;
                    gVar5.mj(string);
                    gVar6 = this.dzZ.dzU;
                    gVar6.aCy();
                    return;
                }
                hVar2 = this.dzZ.dzV;
                if (!hVar2.isLoading()) {
                    gVar2 = this.dzZ.dzU;
                    gVar2.aCy();
                    gVar3 = this.dzZ.dzU;
                    gVar3.hideNoDataView();
                    hVar3 = this.dzZ.dzV;
                    i = this.dzZ.dfw;
                    j = this.dzZ.mUserId;
                    hVar3.j(i, j);
                }
            }
        }
    }
}
