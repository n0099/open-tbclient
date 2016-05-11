package com.baidu.tieba.recommendfrs.control.a;

import java.util.Comparator;
/* loaded from: classes.dex */
class b implements Comparator<com.baidu.tieba.card.a.r> {
    final /* synthetic */ a dZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dZl = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.tieba.card.a.r rVar, com.baidu.tieba.card.a.r rVar2) {
        if (rVar == null || rVar2 == null) {
            return 0;
        }
        if (rVar.getPosition() > rVar2.getPosition()) {
            return 1;
        }
        return rVar.getPosition() < rVar2.getPosition() ? -1 : 0;
    }
}
