package com.baidu.tieba.nearby;

import android.location.Location;
import android.view.View;
import com.baidu.tieba.view.LbsView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LbsView lbsView;
        View view2;
        boolean k;
        lbsView = this.a.b;
        if (view == lbsView) {
            k = this.a.k();
            if (k) {
                this.a.l();
                return;
            }
            return;
        }
        view2 = this.a.s;
        if (view == view2) {
            this.a.l();
            this.a.a((Location) null);
            return;
        }
        this.a.l();
        this.a.a(view);
    }
}
