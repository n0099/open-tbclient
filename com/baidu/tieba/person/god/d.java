package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
class d implements NoNetworkView.a {
    final /* synthetic */ GodThreadListActivity eiG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GodThreadListActivity godThreadListActivity) {
        this.eiG = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aD(boolean z) {
        i iVar;
        h hVar;
        List list;
        List list2;
        h hVar2;
        h hVar3;
        i iVar2;
        i iVar3;
        h hVar4;
        h hVar5;
        iVar = this.eiG.eiC;
        if (iVar != null) {
            hVar = this.eiG.eiB;
            if (hVar != null) {
                list = this.eiG.eiD;
                if (list != null) {
                    list2 = this.eiG.eiD;
                    if (list2.isEmpty()) {
                        if (z) {
                            iVar2 = this.eiG.eiC;
                            if (!iVar2.DK()) {
                                iVar3 = this.eiG.eiC;
                                if (iVar3.hasMore()) {
                                    hVar4 = this.eiG.eiB;
                                    hVar4.jB();
                                    hVar5 = this.eiG.eiB;
                                    hVar5.aLw();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        String string = TbadkCoreApplication.m9getInst().getString(u.j.neterror);
                        hVar2 = this.eiG.eiB;
                        hVar2.nK(string);
                        hVar3 = this.eiG.eiB;
                        hVar3.aLw();
                    }
                }
            }
        }
    }
}
