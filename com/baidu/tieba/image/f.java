package com.baidu.tieba.image;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Intent intent = new Intent();
        i = this.this$0.mIndex;
        intent.putExtra(ImageViewerConfig.INDEX, i);
        this.this$0.setResult(-1, intent);
        this.this$0.finish();
    }
}
