package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(bq bqVar) {
        this.a = bqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        if (this.a.j != null) {
            this.a.j.n();
            this.a.y();
            this.a.aR = false;
        }
        view2 = this.a.aL;
        if (view2 != null) {
            view3 = this.a.aL;
            view3.setVisibility(8);
            view4 = this.a.aK;
            view4.setVisibility(8);
            this.a.aR = false;
        }
    }
}
