package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tieba.card.a.z;
import java.util.Comparator;
/* loaded from: classes.dex */
class b implements Comparator<z> {
    final /* synthetic */ a dWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dWb = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(z zVar, z zVar2) {
        if (zVar == null || zVar2 == null) {
            return 0;
        }
        if (zVar.getPosition() > zVar2.getPosition()) {
            return 1;
        }
        return zVar.getPosition() < zVar2.getPosition() ? -1 : 0;
    }
}
