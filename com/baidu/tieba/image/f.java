package com.baidu.tieba.image;

import android.view.View;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        com.baidu.tbadk.core.dialog.e listMenu;
        listMenu = this.this$0.getListMenu();
        if (eVar == listMenu) {
            switch (i) {
                case 0:
                    this.this$0.Rr();
                    break;
            }
            eVar.dismiss();
        }
    }
}
