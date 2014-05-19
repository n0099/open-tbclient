package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class av implements Runnable {
    final /* synthetic */ au a;
    private final /* synthetic */ com.baidu.tieba.data.ao b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, com.baidu.tieba.data.ao aoVar, View view) {
        this.a = auVar;
        this.b = aoVar;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bj bjVar;
        PbActivity pbActivity2;
        bc bcVar;
        pbActivity = this.a.a;
        bjVar = pbActivity.E;
        com.baidu.tieba.data.ao aoVar = this.b;
        View view = this.c;
        pbActivity2 = this.a.a;
        bcVar = pbActivity2.y;
        bjVar.a(false, aoVar, true, null, null, view, bcVar.p().l());
    }
}
