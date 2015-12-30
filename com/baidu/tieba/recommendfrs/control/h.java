package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.control.a.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ a doN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.doN = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        j jVar2;
        jVar = this.doN.doH;
        if (jVar != null) {
            jVar2 = this.doN.doH;
            jVar2.a(1, true, 0, 0, 1, 0);
            this.doN.aqe();
            this.doN.a(this.doN.getView(), false, this.doN.getResources().getDimensionPixelSize(n.e.ds360));
        }
    }
}
