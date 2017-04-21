package com.baidu.tieba.pb.pb.main;

import java.util.Comparator;
/* loaded from: classes.dex */
class ct implements Comparator<Integer> {
    final /* synthetic */ cn emZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cn cnVar) {
        this.emZ = cnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(Integer num, Integer num2) {
        return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
    }
}
