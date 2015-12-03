package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.diB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.diB.diw;
        bVar.c(1, 0L, 0L);
        this.diB.TI();
        this.diB.a(this.diB.getView(), false, this.diB.getResources().getDimensionPixelSize(n.d.ds360));
    }
}
