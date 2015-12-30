package com.baidu.tieba.recommendfrs.indicator;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.recommendfrs.c {
    final /* synthetic */ a dpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dpx = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void e(long j, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (i >= 0) {
            arrayList = this.dpx.rN;
            if (arrayList != null) {
                arrayList2 = this.dpx.rN;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.dpx.rN;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.recommendfrs.data.f fVar = (com.baidu.tieba.recommendfrs.data.f) it.next();
                        if (fVar != null && fVar.ayn() != null && j == fVar.ayn().tag_code.longValue()) {
                            fVar.mo(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
