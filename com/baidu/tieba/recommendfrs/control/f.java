package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a cIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cIc = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.cIc.cHX;
        bVar.c(0, "头条", 0);
        this.cIc.apN();
        this.cIc.a(this.cIc.getView(), false, this.cIc.getResources().getDimensionPixelSize(i.d.ds360));
    }
}
