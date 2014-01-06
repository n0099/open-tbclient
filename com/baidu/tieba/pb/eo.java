package com.baidu.tieba.pb;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(ed edVar) {
        this.a = edVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            ImageView imageView = (ImageView) this.a.c.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                dVar.a(imageView);
                imageView = (ImageView) this.a.c.findViewWithTag(str);
            }
        }
    }
}
