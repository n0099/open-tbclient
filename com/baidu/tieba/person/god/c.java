package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
class c implements NoNetworkView.a {
    final /* synthetic */ GodThreadListActivity dcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GodThreadListActivity godThreadListActivity) {
        this.dcr = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        h hVar;
        g gVar;
        List list;
        List list2;
        g gVar2;
        g gVar3;
        h hVar2;
        h hVar3;
        g gVar4;
        g gVar5;
        hVar = this.dcr.dcn;
        if (hVar != null) {
            gVar = this.dcr.dcm;
            if (gVar != null) {
                list = this.dcr.dco;
                if (list != null) {
                    list2 = this.dcr.dco;
                    if (list2.isEmpty()) {
                        if (z) {
                            hVar2 = this.dcr.dcn;
                            if (!hVar2.isLoading()) {
                                hVar3 = this.dcr.dcn;
                                if (hVar3.hasMore()) {
                                    gVar4 = this.dcr.dcm;
                                    gVar4.ns();
                                    gVar5 = this.dcr.dcm;
                                    gVar5.auB();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        String string = TbadkCoreApplication.m411getInst().getString(t.j.neterror);
                        gVar2 = this.dcr.dcm;
                        gVar2.hw(string);
                        gVar3 = this.dcr.dcm;
                        gVar3.auB();
                    }
                }
            }
        }
    }
}
