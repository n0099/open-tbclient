package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NavigationBar navigationBar;
        NavigationBar navigationBar2;
        LinearLayout linearLayout;
        NavigationBar navigationBar3;
        LinearLayout linearLayout2;
        navigationBar = this.this$0.mNavigationBar;
        if (navigationBar.getVisibility() == 0) {
            navigationBar3 = this.this$0.mNavigationBar;
            navigationBar3.setVisibility(8);
            linearLayout2 = this.this$0.Px;
            linearLayout2.setVisibility(8);
            return;
        }
        navigationBar2 = this.this$0.mNavigationBar;
        navigationBar2.setVisibility(0);
        linearLayout = this.this$0.Px;
        linearLayout.setVisibility(0);
    }
}
