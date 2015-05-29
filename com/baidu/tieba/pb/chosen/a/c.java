package com.baidu.tieba.pb.chosen.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b bJo;
    private final /* synthetic */ String bJp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.bJo = bVar;
        this.bJp = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.bJo.bJm;
        if (gVar != null) {
            gVar2 = this.bJo.bJm;
            gVar2.ig(this.bJp);
        }
    }
}
