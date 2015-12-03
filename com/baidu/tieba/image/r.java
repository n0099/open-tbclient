package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class r implements View.OnLongClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        if (this.this$0.cgm == null || this.this$0.cgm.getCurrentImageData() != null) {
            String[] strArr = {this.this$0.getPageContext().getString(n.i.save)};
            ImageViewerActivity imageViewerActivity = this.this$0;
            bVar = this.this$0.cgB;
            imageViewerActivity.createListMenu(strArr, bVar);
            this.this$0.showListMenu();
        }
        return true;
    }
}
