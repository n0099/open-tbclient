package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.person.god.h;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
class f implements h.a {
    final /* synthetic */ GodThreadListActivity dwU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GodThreadListActivity godThreadListActivity) {
        this.dwU = godThreadListActivity;
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void d(int i, List<ThreadInfo> list) {
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
        hVar = this.dwU.dwQ;
        if (hVar != null) {
            gVar = this.dwU.dwP;
            if (gVar != null) {
                list2 = this.dwU.dwR;
                if (list2 != null) {
                    gVar2 = this.dwU.dwP;
                    gVar2.Op();
                    gVar3 = this.dwU.dwP;
                    gVar3.aCg();
                    gVar4 = this.dwU.dwP;
                    gVar4.hideNoDataView();
                    aVar = this.dwU.dwO;
                    if (aVar != null) {
                        metaData = this.dwU.dwS;
                        List<com.baidu.tieba.card.a.c> a = b.a(list, metaData, true);
                        if (y.p(a) > 0) {
                            if (i == 0) {
                                list5 = this.dwU.dwR;
                                list5.clear();
                            }
                            list3 = this.dwU.dwR;
                            list3.addAll(a);
                            aVar2 = this.dwU.dwO;
                            list4 = this.dwU.dwR;
                            aVar2.bM(list4);
                            return;
                        }
                        String string = TbadkCoreApplication.m411getInst().getString(t.j.no_data_text);
                        gVar5 = this.dwU.dwP;
                        gVar5.mf(string);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void fC(String str) {
        h hVar;
        g gVar;
        g gVar2;
        List list;
        g gVar3;
        g gVar4;
        hVar = this.dwU.dwQ;
        if (hVar != null) {
            gVar = this.dwU.dwP;
            if (gVar != null) {
                gVar2 = this.dwU.dwP;
                gVar2.Op();
                list = this.dwU.dwR;
                if (list.isEmpty()) {
                    gVar3 = this.dwU.dwP;
                    gVar3.aCh();
                    gVar4 = this.dwU.dwP;
                    gVar4.mf(str);
                }
            }
        }
    }
}
