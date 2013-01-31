package com.baidu.tieba.nearby;

import android.location.Location;
import android.view.View;
import android.widget.ImageView;
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
        ImageView imageView;
        boolean m;
        lbsView = this.a.c;
        if (view != lbsView) {
            imageView = this.a.t;
            if (view == imageView) {
                this.a.n();
                this.a.a((Location) null);
                return;
            }
            this.a.n();
            this.a.a(view);
            return;
        }
        m = this.a.m();
        if (m) {
            this.a.n();
        }
    }
}
