package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.recommendfrs.control.a.m;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ a dVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.dVV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        mVar = this.dVV.dVN;
        if (mVar != null) {
            mVar2 = this.dVV.dVN;
            mVar2.a(1, true, 0, 0, 1, 0);
            this.dVV.XY();
            this.dVV.a(this.dVV.getView(), false, this.dVV.getResources().getDimensionPixelSize(t.e.ds360));
        }
    }
}
