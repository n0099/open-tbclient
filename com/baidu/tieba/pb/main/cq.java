package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cq implements View.OnClickListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        View view3;
        View view4;
        if (this.a.j != null) {
            this.a.j.l();
            this.a.y();
            this.a.aP = false;
        }
        view2 = this.a.aJ;
        if (view2 != null) {
            view3 = this.a.aJ;
            view3.setVisibility(8);
            view4 = this.a.aI;
            view4.setVisibility(8);
            this.a.aP = false;
        }
    }
}
