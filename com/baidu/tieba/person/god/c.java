package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
class c implements NoNetworkView.a {
    final /* synthetic */ GodThreadListActivity dwU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GodThreadListActivity godThreadListActivity) {
        this.dwU = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
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
        hVar = this.dwU.dwQ;
        if (hVar != null) {
            gVar = this.dwU.dwP;
            if (gVar != null) {
                list = this.dwU.dwR;
                if (list != null) {
                    list2 = this.dwU.dwR;
                    if (list2.isEmpty()) {
                        if (z) {
                            hVar2 = this.dwU.dwQ;
                            if (!hVar2.isLoading()) {
                                hVar3 = this.dwU.dwQ;
                                if (hVar3.hasMore()) {
                                    gVar4 = this.dwU.dwP;
                                    gVar4.nk();
                                    gVar5 = this.dwU.dwP;
                                    gVar5.aCh();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        String string = TbadkCoreApplication.m411getInst().getString(t.j.neterror);
                        gVar2 = this.dwU.dwP;
                        gVar2.mf(string);
                        gVar3 = this.dwU.dwP;
                        gVar3.aCh();
                    }
                }
            }
        }
    }
}
