package com.baidu.tieba.recommendfrs.indicator;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.recommendfrs.b {
    final /* synthetic */ a diT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.diT = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void d(long j, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (i >= 0) {
            arrayList = this.diT.list;
            if (arrayList != null) {
                arrayList2 = this.diT.list;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.diT.list;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.recommendfrs.data.a aVar = (com.baidu.tieba.recommendfrs.data.a) it.next();
                        if (aVar != null && aVar.awh() != null && j == aVar.awh().tag_code.longValue()) {
                            aVar.lN(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
