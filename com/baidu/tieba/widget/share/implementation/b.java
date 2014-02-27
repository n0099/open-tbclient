package com.baidu.tieba.widget.share.implementation;

import com.baidu.tieba.widget.share.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements c {
    final /* synthetic */ a a;
    private final /* synthetic */ f b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, f fVar, int i) {
        this.a = aVar;
        this.b = fVar;
        this.c = i;
    }

    @Override // com.baidu.tieba.widget.share.implementation.c
    public final void a() {
        this.a.a(this.b, this.c, false);
    }
}
