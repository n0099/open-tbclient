package com.baidu.tieba.pb;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class em implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ eb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(eb ebVar) {
        this.a = ebVar;
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
