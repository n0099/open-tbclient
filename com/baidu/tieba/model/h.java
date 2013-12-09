package com.baidu.tieba.model;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f2035a = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        com.baidu.tieba.im.db.t.a().a(this.f2035a.f2034a, true);
        return null;
    }
}
