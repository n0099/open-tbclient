package com.baidu.tieba.pb.chosen.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ b bJp;
    private final /* synthetic */ String bJr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, String str) {
        this.bJp = bVar;
        this.bJr = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.bJp.bJn;
        if (gVar != null) {
            gVar2 = this.bJp.bJn;
            gVar2.ih(this.bJr);
        }
    }
}
