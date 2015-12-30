package com.baidu.tieba.pb.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class bw implements Comparator<Integer> {
    final /* synthetic */ bu cGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bu buVar) {
        this.cGw = buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
