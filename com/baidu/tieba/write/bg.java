package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NavigationBar navigationBar;
        NavigationBar navigationBar2;
        LinearLayout linearLayout;
        NavigationBar navigationBar3;
        LinearLayout linearLayout2;
        navigationBar = this.a.p;
        if (navigationBar.getVisibility() == 0) {
            navigationBar3 = this.a.p;
            navigationBar3.setVisibility(8);
            linearLayout2 = this.a.m;
            linearLayout2.setVisibility(8);
            return;
        }
        navigationBar2 = this.a.p;
        navigationBar2.setVisibility(0);
        linearLayout = this.a.m;
        linearLayout.setVisibility(0);
    }
}
