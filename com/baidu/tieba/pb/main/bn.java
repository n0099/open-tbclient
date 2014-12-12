package com.baidu.tieba.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class bn implements Comparator<Integer> {
    final /* synthetic */ bi bzJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bi biVar) {
        this.bzJ = biVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
