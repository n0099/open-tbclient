package com.baidu.tieba.square;

import android.widget.ImageView;
/* loaded from: classes.dex */
class bx implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ImageView a;
    final /* synthetic */ bw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar, ImageView imageView) {
        this.b = bwVar;
        this.a = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            this.a.invalidate();
        }
    }
}
