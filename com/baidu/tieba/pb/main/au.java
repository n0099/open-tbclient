package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
final class au implements Runnable {
    final /* synthetic */ at a;
    private final /* synthetic */ com.baidu.tieba.data.an b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, com.baidu.tieba.data.an anVar, View view) {
        this.a = atVar;
        this.b = anVar;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PbActivity pbActivity;
        bk bkVar;
        PbActivity pbActivity2;
        bd bdVar;
        pbActivity = this.a.a;
        bkVar = pbActivity.D;
        com.baidu.tieba.data.an anVar = this.b;
        View view = this.c;
        pbActivity2 = this.a.a;
        bdVar = pbActivity2.x;
        bkVar.a(false, anVar, null, null, view, bdVar.p().l());
    }
}
