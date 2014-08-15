package com.baidu.tieba.signall;

import java.util.Comparator;
/* loaded from: classes.dex */
class c implements Comparator<d> {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(d dVar, d dVar2) {
        return dVar2.g() - dVar.g();
    }
}
