package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class o implements c.b {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        listMenu = this.this$0.getListMenu();
        if (cVar == listMenu) {
            switch (i) {
                case 0:
                    this.this$0.acm();
                    break;
            }
            cVar.dismiss();
        }
    }
}
