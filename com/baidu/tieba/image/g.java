package com.baidu.tieba.image;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class g implements View.OnLongClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        String[] strArr = {this.this$0.getString(y.save)};
        ImageViewerActivity imageViewerActivity = this.this$0;
        onClickListener = this.this$0.aNs;
        imageViewerActivity.createListMenu(strArr, onClickListener);
        this.this$0.showListMenu();
        return false;
    }
}
