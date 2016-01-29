package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.person.god.h;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
class f implements h.a {
    final /* synthetic */ GodThreadListActivity dcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GodThreadListActivity godThreadListActivity) {
        this.dcr = godThreadListActivity;
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void c(int i, List<ThreadInfo> list) {
        h hVar;
        g gVar;
        List list2;
        g gVar2;
        g gVar3;
        g gVar4;
        a aVar;
        MetaData metaData;
        g gVar5;
        List list3;
        a aVar2;
        List<u> list4;
        List list5;
        hVar = this.dcr.dcn;
        if (hVar != null) {
            gVar = this.dcr.dcm;
            if (gVar != null) {
                list2 = this.dcr.dco;
                if (list2 != null) {
                    gVar2 = this.dcr.dcm;
                    gVar2.MB();
                    gVar3 = this.dcr.dcm;
                    gVar3.auA();
                    gVar4 = this.dcr.dcm;
                    gVar4.hideNoDataView();
                    aVar = this.dcr.dcl;
                    if (aVar != null) {
                        metaData = this.dcr.dcp;
                        List<com.baidu.tieba.card.a.c> a = b.a(list, metaData, true);
                        if (x.o(a) > 0) {
                            if (i == 0) {
                                list5 = this.dcr.dco;
                                list5.clear();
                            }
                            list3 = this.dcr.dco;
                            list3.addAll(a);
                            aVar2 = this.dcr.dcl;
                            list4 = this.dcr.dco;
                            aVar2.bq(list4);
                            return;
                        }
                        String string = TbadkCoreApplication.m411getInst().getString(t.j.no_data_text);
                        gVar5 = this.dcr.dcm;
                        gVar5.hw(string);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void fu(String str) {
        h hVar;
        g gVar;
        g gVar2;
        List list;
        g gVar3;
        g gVar4;
        hVar = this.dcr.dcn;
        if (hVar != null) {
            gVar = this.dcr.dcm;
            if (gVar != null) {
                gVar2 = this.dcr.dcm;
                gVar2.MB();
                list = this.dcr.dco;
                if (list.isEmpty()) {
                    gVar3 = this.dcr.dcm;
                    gVar3.auB();
                    gVar4 = this.dcr.dcm;
                    gVar4.hw(str);
                }
            }
        }
    }
}
