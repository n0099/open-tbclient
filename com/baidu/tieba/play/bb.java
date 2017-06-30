package com.baidu.tieba.play;

import com.baidu.tieba.play.ba;
import java.util.Comparator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Comparator<Map.Entry<String, ba.a>> {
    final /* synthetic */ ba fmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.fmv = baVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: b */
    public int compare(Map.Entry<String, ba.a> entry, Map.Entry<String, ba.a> entry2) {
        return (int) (entry.getValue().lastUpdateTime - entry2.getValue().lastUpdateTime);
    }
}
