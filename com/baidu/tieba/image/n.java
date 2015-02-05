package com.baidu.tieba.image;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NavigationBar navigationBar;
        int i;
        navigationBar = this.this$0.aJk;
        if (navigationBar.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.this$0.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.this$0.setResult(-1, intent);
            this.this$0.finish();
        }
    }
}
