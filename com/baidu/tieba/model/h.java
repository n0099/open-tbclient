package com.baidu.tieba.model;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f1939a = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        com.baidu.tieba.im.db.n.a().a(this.f1939a.f1938a, true);
        return null;
    }
}
