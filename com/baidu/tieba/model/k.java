package com.baidu.tieba.model;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends SingleRunnable<Void> {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        String str;
        if (this.a.b) {
            str = com.baidu.tieba.im.db.t.b(this.a.a);
        } else {
            str = this.a.a;
        }
        com.baidu.tieba.im.db.t.a().a(str, true);
        return null;
    }
}
