package com.baidu.tieba.signall;

import java.util.Comparator;
/* loaded from: classes.dex */
class d implements Comparator<e> {
    final /* synthetic */ c cIC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cIC = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(e eVar, e eVar2) {
        return eVar2.arj() - eVar.arj();
    }
}
