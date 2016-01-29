package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tieba.card.a.w;
import java.util.Comparator;
/* loaded from: classes.dex */
class b implements Comparator<w> {
    final /* synthetic */ a dEj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dEj = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(w wVar, w wVar2) {
        if (wVar == null || wVar2 == null) {
            return 0;
        }
        if (wVar.getPosition() > wVar2.getPosition()) {
            return 1;
        }
        return wVar.getPosition() < wVar2.getPosition() ? -1 : 0;
    }
}
