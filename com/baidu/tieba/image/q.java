package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class q implements View.OnLongClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        if (this.this$0.coR == null || this.this$0.coR.getCurrentImageData() != null) {
            String[] strArr = {this.this$0.getPageContext().getString(t.j.save)};
            ImageViewerActivity imageViewerActivity = this.this$0;
            bVar = this.this$0.cph;
            imageViewerActivity.createListMenu(strArr, bVar);
            this.this$0.showListMenu();
        }
        return true;
    }
}
