package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ View a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar, View view) {
        this.b = iVar;
        this.a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        View findViewWithTag = this.a.findViewWithTag(str);
        if ((findViewWithTag instanceof ImageView) && dVar != null) {
            ImageView imageView = (ImageView) findViewWithTag;
            imageView.setImageBitmap(dVar.h());
            imageView.invalidate();
        }
    }
}
