package com.baidu.tieba.play;

import com.baidu.tieba.play.az;
import java.util.Comparator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements Comparator<Map.Entry<String, az.a>> {
    final /* synthetic */ az eTx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.eTx = azVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: b */
    public int compare(Map.Entry<String, az.a> entry, Map.Entry<String, az.a> entry2) {
        return (int) (entry.getValue().lastUpdateTime - entry2.getValue().lastUpdateTime);
    }
}
