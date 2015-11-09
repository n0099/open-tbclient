package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a cJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cJX = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.cJX.cJS;
        bVar.c(0, "头条", 0);
        this.cJX.aqv();
        this.cJX.a(this.cJX.getView(), false, this.cJX.getResources().getDimensionPixelSize(i.d.ds360));
    }
}
