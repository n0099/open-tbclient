package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class g implements View.OnLongClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.this$0.getPageContext().getString(i.h.save)};
        ImageViewerActivity imageViewerActivity = this.this$0;
        bVar = this.this$0.bMe;
        imageViewerActivity.createListMenu(strArr, bVar);
        this.this$0.showListMenu();
        return true;
    }
}
