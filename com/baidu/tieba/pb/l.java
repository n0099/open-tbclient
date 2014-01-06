package com.baidu.tieba.pb;

import com.baidu.tieba.view.ImagePbImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        ImagePbImageView imagePbImageView;
        if (dVar != null && (imagePbImageView = (ImagePbImageView) this.a.a.y.findViewWithTag(str)) != null) {
            imagePbImageView.invalidate();
            imagePbImageView.a();
        }
    }
}
