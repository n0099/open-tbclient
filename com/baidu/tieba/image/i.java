package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class i implements View.OnLongClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.core.dialog.h hVar;
        String[] strArr = {this.this$0.getPageContext().getString(y.save)};
        ImageViewerActivity imageViewerActivity = this.this$0;
        hVar = this.this$0.buJ;
        imageViewerActivity.createListMenu(strArr, hVar);
        this.this$0.showListMenu();
        return false;
    }
}
