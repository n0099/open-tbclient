package com.baidu.tieba.recommendfrs.indicator;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.recommendfrs.d {
    final /* synthetic */ a eas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eas = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.d
    public void v(long j, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (i >= 0) {
            arrayList = this.eas.eao;
            if (arrayList != null) {
                arrayList2 = this.eas.eao;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.eas.eao;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.recommendfrs.data.l lVar = (com.baidu.tieba.recommendfrs.data.l) it.next();
                        if (lVar != null && lVar.aMq() != null && j == lVar.aMq().tag_code.longValue()) {
                            lVar.ks(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
