package com.baidu.tieba.pb.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class cd implements Comparator<Integer> {
    final /* synthetic */ cb cOa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb cbVar) {
        this.cOa = cbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
