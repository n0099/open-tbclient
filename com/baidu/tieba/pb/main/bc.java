package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bc implements Runnable {
    final /* synthetic */ bb a;
    private final /* synthetic */ com.baidu.tieba.data.au b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, com.baidu.tieba.data.au auVar, View view) {
        this.a = bbVar;
        this.b = auVar;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bs bsVar;
        PbActivity pbActivity2;
        bl blVar;
        pbActivity = this.a.a;
        bsVar = pbActivity.D;
        com.baidu.tieba.data.au auVar = this.b;
        View view = this.c;
        pbActivity2 = this.a.a;
        blVar = pbActivity2.x;
        bsVar.a(false, auVar, true, null, null, view, blVar.r().l());
    }
}
