package com.baidu.tieba.person.god;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
class d implements NoNetworkView.a {
    final /* synthetic */ GodThreadListActivity esK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GodThreadListActivity godThreadListActivity) {
        this.esK = godThreadListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aG(boolean z) {
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
        iVar = this.esK.esG;
        if (iVar != null) {
            hVar = this.esK.esF;
            if (hVar != null) {
                list = this.esK.esH;
                if (list != null) {
                    list2 = this.esK.esH;
                    if (list2.isEmpty()) {
                        if (z) {
                            iVar2 = this.esK.esG;
                            if (!iVar2.DJ()) {
                                iVar3 = this.esK.esG;
                                if (iVar3.hasMore()) {
                                    hVar4 = this.esK.esF;
                                    hVar4.jA();
                                    hVar5 = this.esK.esF;
                                    hVar5.aNZ();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        String string = TbadkCoreApplication.m10getInst().getString(u.j.neterror);
                        hVar2 = this.esK.esF;
                        hVar2.ox(string);
                        hVar3 = this.esK.esF;
                        hVar3.aNZ();
                    }
                }
            }
        }
    }
}
