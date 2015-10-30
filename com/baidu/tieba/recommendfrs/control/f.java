package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a cIB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cIB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.cIB.cIw;
        bVar.c(0, "头条", 0);
        this.cIB.apP();
        this.cIB.a(this.cIB.getView(), false, this.cIB.getResources().getDimensionPixelSize(i.d.ds360));
    }
}
