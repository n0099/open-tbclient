package com.baidu.tieba.pb.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class dk implements Comparator<Integer> {
    final /* synthetic */ dc exj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dc dcVar) {
        this.exj = dcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
