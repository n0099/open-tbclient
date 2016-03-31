package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements s.a {
    final /* synthetic */ GodThreadListActivity dwU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GodThreadListActivity godThreadListActivity) {
        this.dwU = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
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
        hVar = this.dwU.dwQ;
        if (hVar != null) {
            gVar = this.dwU.dwP;
            if (gVar != null) {
                if (!com.baidu.adp.lib.util.i.jf()) {
                    gVar4 = this.dwU.dwP;
                    gVar4.Op();
                    String string = TbadkCoreApplication.m411getInst().getString(t.j.neterror);
                    gVar5 = this.dwU.dwP;
                    gVar5.mf(string);
                    gVar6 = this.dwU.dwP;
                    gVar6.aCh();
                    return;
                }
                hVar2 = this.dwU.dwQ;
                if (!hVar2.isLoading()) {
                    gVar2 = this.dwU.dwP;
                    gVar2.aCh();
                    gVar3 = this.dwU.dwP;
                    gVar3.hideNoDataView();
                    hVar3 = this.dwU.dwQ;
                    i = this.dwU.ddc;
                    j = this.dwU.mUserId;
                    hVar3.j(i, j);
                }
            }
        }
    }
}
