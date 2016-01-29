package com.baidu.tieba.recommendfrs.indicator;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.recommendfrs.d {
    final /* synthetic */ a dFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dFk = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.d
    public void g(long j, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (i >= 0) {
            arrayList = this.dFk.dFf;
            if (arrayList != null) {
                arrayList2 = this.dFk.dFf;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.dFk.dFf;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.recommendfrs.data.h hVar = (com.baidu.tieba.recommendfrs.data.h) it.next();
                        if (hVar != null && hVar.aFr() != null && j == hVar.aFr().tag_code.longValue()) {
                            hVar.nz(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
