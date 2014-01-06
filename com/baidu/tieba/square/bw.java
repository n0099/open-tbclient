package com.baidu.tieba.square;

import android.widget.ImageView;
/* loaded from: classes.dex */
class bw implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ImageView a;
    final /* synthetic */ bv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar, ImageView imageView) {
        this.b = bvVar;
        this.a = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            this.a.invalidate();
        }
    }
}
