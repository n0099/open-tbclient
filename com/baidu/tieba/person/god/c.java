package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
class c implements NoNetworkView.a {
    final /* synthetic */ GodThreadListActivity dzZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GodThreadListActivity godThreadListActivity) {
        this.dzZ = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
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
        hVar = this.dzZ.dzV;
        if (hVar != null) {
            gVar = this.dzZ.dzU;
            if (gVar != null) {
                list = this.dzZ.dzW;
                if (list != null) {
                    list2 = this.dzZ.dzW;
                    if (list2.isEmpty()) {
                        if (z) {
                            hVar2 = this.dzZ.dzV;
                            if (!hVar2.isLoading()) {
                                hVar3 = this.dzZ.dzV;
                                if (hVar3.hasMore()) {
                                    gVar4 = this.dzZ.dzU;
                                    gVar4.jy();
                                    gVar5 = this.dzZ.dzU;
                                    gVar5.aCy();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        String string = TbadkCoreApplication.m11getInst().getString(t.j.neterror);
                        gVar2 = this.dzZ.dzU;
                        gVar2.mj(string);
                        gVar3 = this.dzZ.dzU;
                        gVar3.aCy();
                    }
                }
            }
        }
    }
}
