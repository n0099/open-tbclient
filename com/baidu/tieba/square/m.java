package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ i a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar, View view) {
        this.a = iVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag = this.b.findViewWithTag(str);
        if ((findViewWithTag instanceof ImageView) && bVar != null) {
            ImageView imageView = (ImageView) findViewWithTag;
            imageView.setImageBitmap(bVar.h());
            imageView.invalidate();
        }
    }
}
