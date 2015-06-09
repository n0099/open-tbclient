package com.baidu.tieba.recommendfrs.control;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a cbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cbN = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.cbN.cbH;
        bVar.B(0, "头条");
        this.cbN.ahs();
    }
}
