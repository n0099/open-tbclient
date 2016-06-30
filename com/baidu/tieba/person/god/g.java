package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.person.god.i;
import com.baidu.tieba.u;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
class g implements i.a {
    final /* synthetic */ GodThreadListActivity eiG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GodThreadListActivity godThreadListActivity) {
        this.eiG = godThreadListActivity;
    }

    @Override // com.baidu.tieba.person.god.i.a
    public void c(int i, List<ThreadInfo> list) {
        i iVar;
        h hVar;
        List list2;
        h hVar2;
        h hVar3;
        h hVar4;
        a aVar;
        MetaData metaData;
        h hVar5;
        List list3;
        a aVar2;
        List<v> list4;
        List list5;
        iVar = this.eiG.eiC;
        if (iVar != null) {
            hVar = this.eiG.eiB;
            if (hVar != null) {
                list2 = this.eiG.eiD;
                if (list2 != null) {
                    hVar2 = this.eiG.eiB;
                    hVar2.SQ();
                    hVar3 = this.eiG.eiB;
                    hVar3.aLv();
                    hVar4 = this.eiG.eiB;
                    hVar4.hideNoDataView();
                    aVar = this.eiG.eiA;
                    if (aVar != null) {
                        metaData = this.eiG.eiE;
                        List<com.baidu.tieba.card.a.c> a = c.a(list, metaData, true);
                        if (y.s(a) > 0) {
                            if (i == 0) {
                                list5 = this.eiG.eiD;
                                list5.clear();
                            }
                            list3 = this.eiG.eiD;
                            list3.addAll(a);
                            aVar2 = this.eiG.eiA;
                            list4 = this.eiG.eiD;
                            aVar2.cm(list4);
                            return;
                        }
                        String string = TbadkCoreApplication.m9getInst().getString(u.j.no_data_text);
                        hVar5 = this.eiG.eiB;
                        hVar5.nK(string);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.god.i.a
    public void fF(String str) {
        i iVar;
        h hVar;
        h hVar2;
        List list;
        h hVar3;
        h hVar4;
        iVar = this.eiG.eiC;
        if (iVar != null) {
            hVar = this.eiG.eiB;
            if (hVar != null) {
                hVar2 = this.eiG.eiB;
                hVar2.SQ();
                list = this.eiG.eiD;
                if (list.isEmpty()) {
                    hVar3 = this.eiG.eiB;
                    hVar3.aLw();
                    hVar4 = this.eiG.eiB;
                    hVar4.nK(str);
                }
            }
        }
    }
}
