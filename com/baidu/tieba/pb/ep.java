package com.baidu.tieba.pb;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ep implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(ed edVar) {
        this.a = edVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            ImageView imageView = (ImageView) this.a.c.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                bVar.a(imageView);
                imageView = (ImageView) this.a.c.findViewWithTag(str);
            }
        }
    }
}
