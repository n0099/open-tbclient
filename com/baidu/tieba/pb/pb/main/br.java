package com.baidu.tieba.pb.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class br implements Comparator<Integer> {
    final /* synthetic */ bp ckk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar) {
        this.ckk = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
