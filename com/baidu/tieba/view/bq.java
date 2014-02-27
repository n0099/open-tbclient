package com.baidu.tieba.view;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bq implements View.OnClickListener {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = r1.a.getCurrentImageView();
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        Button button;
        Button button2;
        w currentImageView;
        w currentImageView2;
        button = this.a.a;
        if (view != button) {
            button2 = this.a.b;
            if (view == button2 && currentImageView != null) {
                currentImageView.m();
                return;
            }
            return;
        }
        currentImageView2 = this.a.getCurrentImageView();
        if (currentImageView2 != null) {
            currentImageView2.l();
        }
    }
}
