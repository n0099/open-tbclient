package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
class e implements BdListView.e {
    final /* synthetic */ GodThreadListActivity dcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GodThreadListActivity godThreadListActivity) {
        this.dcr = godThreadListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        h hVar;
        g gVar;
        List list;
        h hVar2;
        List list2;
        h hVar3;
        List list3;
        g gVar2;
        g gVar3;
        h hVar4;
        long j;
        g gVar4;
        hVar = this.dcr.dcn;
        if (hVar != null) {
            gVar = this.dcr.dcm;
            if (gVar != null) {
                list = this.dcr.dco;
                if (list != null) {
                    hVar2 = this.dcr.dcn;
                    if (!hVar2.isLoading()) {
                        list2 = this.dcr.dco;
                        if (!list2.isEmpty()) {
                            hVar3 = this.dcr.dcn;
                            if (hVar3.hasMore()) {
                                hVar4 = this.dcr.dcn;
                                j = this.dcr.mUserId;
                                hVar4.bp(j);
                                gVar4 = this.dcr.dcm;
                                gVar4.Ob();
                                return;
                            }
                            list3 = this.dcr.dco;
                            if (!list3.isEmpty()) {
                                gVar2 = this.dcr.dcm;
                                gVar2.auA();
                                return;
                            }
                            String string = TbadkCoreApplication.m411getInst().getString(t.j.no_data_text);
                            gVar3 = this.dcr.dcm;
                            gVar3.hw(string);
                        }
                    }
                }
            }
        }
    }
}
