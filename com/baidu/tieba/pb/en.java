package com.baidu.tieba.pb;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class en implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(ed edVar) {
        this.a = edVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            ImageView imageView = (ImageView) this.a.c.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                eVar.a(imageView);
                imageView = (ImageView) this.a.c.findViewWithTag(str);
            }
        }
    }
}
