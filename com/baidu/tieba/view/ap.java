package com.baidu.tieba.view;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1851a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MultiImageView multiImageView) {
        this.f1851a = multiImageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = r1.f1851a.getCurrentImageView();
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        Button button;
        Button button2;
        j currentImageView;
        j currentImageView2;
        button = this.f1851a.f1835a;
        if (view != button) {
            button2 = this.f1851a.b;
            if (view == button2 && currentImageView != null) {
                currentImageView.n();
                return;
            }
            return;
        }
        currentImageView2 = this.f1851a.getCurrentImageView();
        if (currentImageView2 != null) {
            currentImageView2.m();
        }
    }
}
