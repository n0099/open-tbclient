package com.baidu.tieba.pb.chosen.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b bJp;
    private final /* synthetic */ String bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.bJp = bVar;
        this.bJq = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.bJp.bJn;
        if (gVar != null) {
            gVar2 = this.bJp.bJn;
            gVar2.ig(this.bJq);
        }
    }
}
