package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements r.a {
    final /* synthetic */ GodThreadListActivity dcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GodThreadListActivity godThreadListActivity) {
        this.dcr = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
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
        hVar = this.dcr.dcn;
        if (hVar != null) {
            gVar = this.dcr.dcm;
            if (gVar != null) {
                if (!com.baidu.adp.lib.util.i.iZ()) {
                    gVar4 = this.dcr.dcm;
                    gVar4.MB();
                    String string = TbadkCoreApplication.m411getInst().getString(t.j.neterror);
                    gVar5 = this.dcr.dcm;
                    gVar5.hw(string);
                    gVar6 = this.dcr.dcm;
                    gVar6.auB();
                    return;
                }
                hVar2 = this.dcr.dcn;
                if (!hVar2.isLoading()) {
                    gVar2 = this.dcr.dcm;
                    gVar2.auB();
                    gVar3 = this.dcr.dcm;
                    gVar3.hideNoDataView();
                    hVar3 = this.dcr.dcn;
                    i = this.dcr.cJL;
                    j = this.dcr.mUserId;
                    hVar3.i(i, j);
                }
            }
        }
    }
}
