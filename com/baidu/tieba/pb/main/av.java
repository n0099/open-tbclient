package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class av implements Runnable {
    final /* synthetic */ au a;
    private final /* synthetic */ com.baidu.tieba.data.ap b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, com.baidu.tieba.data.ap apVar, View view) {
        this.a = auVar;
        this.b = apVar;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bq bqVar;
        PbActivity pbActivity2;
        bj bjVar;
        pbActivity = this.a.a;
        bqVar = pbActivity.D;
        com.baidu.tieba.data.ap apVar = this.b;
        View view = this.c;
        pbActivity2 = this.a.a;
        bjVar = pbActivity2.x;
        bqVar.a(false, apVar, true, null, null, view, bjVar.q().l());
    }
}
