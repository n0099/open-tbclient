package com.baidu.tieba.pb.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class co implements Comparator<Integer> {
    final /* synthetic */ cj eqG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cj cjVar) {
        this.eqG = cjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
