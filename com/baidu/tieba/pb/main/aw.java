package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
final class aw implements Runnable {
    final /* synthetic */ av a;
    private final /* synthetic */ com.baidu.tieba.data.am b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar, com.baidu.tieba.data.am amVar, View view) {
        this.a = avVar;
        this.b = amVar;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PbActivity pbActivity;
        bm bmVar;
        PbActivity pbActivity2;
        bf bfVar;
        pbActivity = this.a.a;
        bmVar = pbActivity.D;
        com.baidu.tieba.data.am amVar = this.b;
        View view = this.c;
        pbActivity2 = this.a.a;
        bfVar = pbActivity2.x;
        bmVar.a(false, amVar, null, null, view, bfVar.p().l());
    }
}
