package com.baidu.tieba.signall;

import java.util.Comparator;
/* loaded from: classes.dex */
class d implements Comparator<e> {
    final /* synthetic */ c chQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.chQ = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(e eVar, e eVar2) {
        return eVar2.akz() - eVar.akz();
    }
}
