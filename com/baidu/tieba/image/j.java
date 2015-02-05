package com.baidu.tieba.image;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class j implements View.OnLongClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        String[] strArr = {this.this$0.getPageContext().getString(z.save)};
        ImageViewerActivity imageViewerActivity = this.this$0;
        onClickListener = this.this$0.brX;
        imageViewerActivity.createListMenu(strArr, onClickListener);
        this.this$0.showListMenu();
        return false;
    }
}
