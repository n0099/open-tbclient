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
    final /* synthetic */ GodThreadListActivity esK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GodThreadListActivity godThreadListActivity) {
        this.esK = godThreadListActivity;
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
        iVar = this.esK.esG;
        if (iVar != null) {
            hVar = this.esK.esF;
            if (hVar != null) {
                list2 = this.esK.esH;
                if (list2 != null) {
                    hVar2 = this.esK.esF;
                    hVar2.Ty();
                    hVar3 = this.esK.esF;
                    hVar3.aNY();
                    hVar4 = this.esK.esF;
                    hVar4.hideNoDataView();
                    aVar = this.esK.esE;
                    if (aVar != null) {
                        metaData = this.esK.esI;
                        List<com.baidu.tieba.card.a.c> a = c.a(list, metaData, true);
                        if (y.s(a) > 0) {
                            if (i == 0) {
                                list5 = this.esK.esH;
                                list5.clear();
                            }
                            list3 = this.esK.esH;
                            list3.addAll(a);
                            aVar2 = this.esK.esE;
                            list4 = this.esK.esH;
                            aVar2.cz(list4);
                            return;
                        }
                        String string = TbadkCoreApplication.m10getInst().getString(u.j.no_data_text);
                        hVar5 = this.esK.esF;
                        hVar5.ox(string);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.god.i.a
    public void fD(String str) {
        i iVar;
        h hVar;
        h hVar2;
        List list;
        h hVar3;
        h hVar4;
        iVar = this.esK.esG;
        if (iVar != null) {
            hVar = this.esK.esF;
            if (hVar != null) {
                hVar2 = this.esK.esF;
                hVar2.Ty();
                list = this.esK.esH;
                if (list.isEmpty()) {
                    hVar3 = this.esK.esF;
                    hVar3.aNZ();
                    hVar4 = this.esK.esF;
                    hVar4.ox(str);
                }
            }
        }
    }
}
