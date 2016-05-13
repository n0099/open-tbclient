package com.baidu.tieba.person.god;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.person.god.h;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
class f implements h.a {
    final /* synthetic */ GodThreadListActivity dzZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GodThreadListActivity godThreadListActivity) {
        this.dzZ = godThreadListActivity;
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
        List<v> list4;
        List list5;
        hVar = this.dzZ.dzV;
        if (hVar != null) {
            gVar = this.dzZ.dzU;
            if (gVar != null) {
                list2 = this.dzZ.dzW;
                if (list2 != null) {
                    gVar2 = this.dzZ.dzU;
                    gVar2.Np();
                    gVar3 = this.dzZ.dzU;
                    gVar3.aCA();
                    gVar4 = this.dzZ.dzU;
                    gVar4.hideNoDataView();
                    aVar = this.dzZ.dzT;
                    if (aVar != null) {
                        metaData = this.dzZ.dzX;
                        List<com.baidu.tieba.card.a.c> a = b.a(list, metaData, true);
                        if (y.r(a) > 0) {
                            if (i == 0) {
                                list5 = this.dzZ.dzW;
                                list5.clear();
                            }
                            list3 = this.dzZ.dzW;
                            list3.addAll(a);
                            aVar2 = this.dzZ.dzT;
                            list4 = this.dzZ.dzW;
                            aVar2.bO(list4);
                            return;
                        }
                        String string = TbadkCoreApplication.m11getInst().getString(t.j.no_data_text);
                        gVar5 = this.dzZ.dzU;
                        gVar5.mj(string);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void fz(String str) {
        h hVar;
        g gVar;
        g gVar2;
        List list;
        g gVar3;
        g gVar4;
        hVar = this.dzZ.dzV;
        if (hVar != null) {
            gVar = this.dzZ.dzU;
            if (gVar != null) {
                gVar2 = this.dzZ.dzU;
                gVar2.Np();
                list = this.dzZ.dzW;
                if (list.isEmpty()) {
                    gVar3 = this.dzZ.dzU;
                    gVar3.aCB();
                    gVar4 = this.dzZ.dzU;
                    gVar4.mj(str);
                }
            }
        }
    }
}
