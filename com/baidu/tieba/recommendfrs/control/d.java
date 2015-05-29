package com.baidu.tieba.recommendfrs.control;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a cbM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cbM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.cbM.cbG;
        bVar.B(0, "头条");
        this.cbM.ahr();
    }
}
