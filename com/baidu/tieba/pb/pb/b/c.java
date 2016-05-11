package com.baidu.tieba.pb.pb.b;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b dhU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dhU = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        PbActivity pbActivity;
        aVar = this.dhU.dhT;
        pbActivity = aVar.dhQ;
        pbActivity.hideProgressBar();
    }
}
