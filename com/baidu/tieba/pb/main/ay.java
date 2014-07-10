package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class ay implements Runnable {
    final /* synthetic */ ax a;
    private final /* synthetic */ com.baidu.tieba.data.at b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, com.baidu.tieba.data.at atVar, View view) {
        this.a = axVar;
        this.b = atVar;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bt btVar;
        PbActivity pbActivity2;
        bm bmVar;
        pbActivity = this.a.a;
        btVar = pbActivity.D;
        com.baidu.tieba.data.at atVar = this.b;
        View view = this.c;
        pbActivity2 = this.a.a;
        bmVar = pbActivity2.x;
        btVar.a(false, atVar, true, null, null, view, bmVar.r().k());
    }
}
