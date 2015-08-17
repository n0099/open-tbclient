package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.csI = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.csI.csD;
        bVar.c(0, "头条", 0);
        this.csI.ajr();
        this.csI.a(this.csI.getView(), false, this.csI.getResources().getDimensionPixelSize(i.d.ds360));
    }
}
