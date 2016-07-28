package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
class f implements BdListView.e {
    final /* synthetic */ GodThreadListActivity esK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GodThreadListActivity godThreadListActivity) {
        this.esK = godThreadListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jC() {
        i iVar;
        h hVar;
        List list;
        i iVar2;
        List list2;
        i iVar3;
        List list3;
        h hVar2;
        h hVar3;
        i iVar4;
        long j;
        h hVar4;
        iVar = this.esK.esG;
        if (iVar != null) {
            hVar = this.esK.esF;
            if (hVar != null) {
                list = this.esK.esH;
                if (list != null) {
                    iVar2 = this.esK.esG;
                    if (!iVar2.DJ()) {
                        list2 = this.esK.esH;
                        if (!list2.isEmpty()) {
                            iVar3 = this.esK.esG;
                            if (iVar3.hasMore()) {
                                iVar4 = this.esK.esG;
                                j = this.esK.mUserId;
                                iVar4.cn(j);
                                hVar4 = this.esK.esF;
                                hVar4.UV();
                                return;
                            }
                            list3 = this.esK.esH;
                            if (!list3.isEmpty()) {
                                hVar2 = this.esK.esF;
                                hVar2.aNY();
                                return;
                            }
                            String string = TbadkCoreApplication.m10getInst().getString(u.j.no_data_text);
                            hVar3 = this.esK.esF;
                            hVar3.ox(string);
                        }
                    }
                }
            }
        }
    }
}
