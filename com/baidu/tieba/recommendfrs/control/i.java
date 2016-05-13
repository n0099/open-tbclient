package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ a dYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.dYW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.recommendfrs.control.a.m mVar;
        com.baidu.tieba.recommendfrs.control.a.m mVar2;
        mVar = this.dYW.dYO;
        if (mVar != null) {
            mVar2 = this.dYW.dYO;
            mVar2.a(1, true, 0, 0, 1, 0);
            this.dYW.Pg();
            this.dYW.n(false, this.dYW.getResources().getDimensionPixelSize(t.e.ds520));
        }
    }
}
