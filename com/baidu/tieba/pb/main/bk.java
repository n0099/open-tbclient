package com.baidu.tieba.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class bk implements Comparator<Integer> {
    final /* synthetic */ bh bvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bh bhVar) {
        this.bvU = bhVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
