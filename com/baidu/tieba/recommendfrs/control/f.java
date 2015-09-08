package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a cBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cBa = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.cBa.cAV;
        bVar.c(0, "头条", 0);
        this.cBa.anv();
        this.cBa.a(this.cBa.getView(), false, this.cBa.getResources().getDimensionPixelSize(i.d.ds360));
    }
}
