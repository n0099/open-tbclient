package com.baidu.tieba.person;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {
    final /* synthetic */ BdCenterListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BdCenterListView bdCenterListView) {
        this.a = bdCenterListView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView;
        ImageView imageView2;
        this.a.u = null;
        imageView = this.a.j;
        imageView.setImageDrawable(null);
        imageView2 = this.a.j;
        imageView2.setVisibility(8);
        this.a.t = false;
    }
}
