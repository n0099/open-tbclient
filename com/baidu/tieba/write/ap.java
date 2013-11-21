package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteImageActivity writeImageActivity) {
        this.f2672a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NavigationBar navigationBar;
        NavigationBar navigationBar2;
        LinearLayout linearLayout;
        NavigationBar navigationBar3;
        LinearLayout linearLayout2;
        navigationBar = this.f2672a.o;
        if (navigationBar.getVisibility() == 0) {
            navigationBar3 = this.f2672a.o;
            navigationBar3.setVisibility(8);
            linearLayout2 = this.f2672a.m;
            linearLayout2.setVisibility(8);
            return;
        }
        navigationBar2 = this.f2672a.o;
        navigationBar2.setVisibility(0);
        linearLayout = this.f2672a.m;
        linearLayout.setVisibility(0);
    }
}
