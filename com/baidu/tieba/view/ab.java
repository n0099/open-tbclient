package com.baidu.tieba.view;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = r1.a.getCurrentImageView();
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        Button button;
        Button button2;
        f currentImageView;
        f currentImageView2;
        button = this.a.a;
        if (view == button) {
            currentImageView2 = this.a.getCurrentImageView();
            if (currentImageView2 != null) {
                currentImageView2.m();
                return;
            }
            return;
        }
        button2 = this.a.b;
        if (view != button2 || currentImageView == null) {
            return;
        }
        currentImageView.n();
    }
}
