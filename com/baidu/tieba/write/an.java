package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NavigationBar navigationBar;
        NavigationBar navigationBar2;
        LinearLayout linearLayout;
        NavigationBar navigationBar3;
        LinearLayout linearLayout2;
        navigationBar = this.a.n;
        if (navigationBar.getVisibility() == 0) {
            navigationBar3 = this.a.n;
            navigationBar3.setVisibility(8);
            linearLayout2 = this.a.l;
            linearLayout2.setVisibility(8);
            return;
        }
        navigationBar2 = this.a.n;
        navigationBar2.setVisibility(0);
        linearLayout = this.a.l;
        linearLayout.setVisibility(0);
    }
}
