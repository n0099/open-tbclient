package com.baidu.tieba.recommendfrs.indicator;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.recommendfrs.d {
    final /* synthetic */ a dXj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dXj = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.d
    public void u(long j, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (i >= 0) {
            arrayList = this.dXj.dXf;
            if (arrayList != null) {
                arrayList2 = this.dXj.dXf;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.dXj.dXf;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.recommendfrs.data.l lVar = (com.baidu.tieba.recommendfrs.data.l) it.next();
                        if (lVar != null && lVar.aMf() != null && j == lVar.aMf().tag_code.longValue()) {
                            lVar.kL(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
