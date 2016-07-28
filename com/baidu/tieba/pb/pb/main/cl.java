package com.baidu.tieba.pb.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class cl implements Comparator<Integer> {
    final /* synthetic */ ch ecD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ch chVar) {
        this.ecD = chVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
