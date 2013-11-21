package com.baidu.tieba.view;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f2547a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(MultiImageView multiImageView) {
        this.f2547a = multiImageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = r1.f2547a.getCurrentImageView();
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        Button button;
        Button button2;
        k currentImageView;
        k currentImageView2;
        button = this.f2547a.f2525a;
        if (view == button) {
            currentImageView2 = this.f2547a.getCurrentImageView();
            if (currentImageView2 != null) {
                currentImageView2.m();
                return;
            }
            return;
        }
        button2 = this.f2547a.b;
        if (view == button2 && currentImageView != null) {
            currentImageView.n();
        }
    }
}
