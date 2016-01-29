package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ a dEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.dEd = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.j jVar;
        com.baidu.tieba.recommendfrs.control.a.j jVar2;
        jVar = this.dEd.dDW;
        if (jVar != null) {
            jVar2 = this.dEd.dDW;
            jVar2.a(1, true, 0, 0, 1, 0);
            this.dEd.avv();
            this.dEd.a(this.dEd.getView(), false, this.dEd.getResources().getDimensionPixelSize(t.e.ds360));
        }
    }
}
