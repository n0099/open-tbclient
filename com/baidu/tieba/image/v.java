package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NavigationBar navigationBar;
        navigationBar = this.this$0.bse;
        if (navigationBar.getVisibility() != 8) {
            this.this$0.acm();
        }
    }
}
