package com.baidu.tieba.pb;

import com.baidu.tieba.view.ImagePbImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f2274a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f2274a = kVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        ImagePbImageView imagePbImageView;
        if (eVar != null && (imagePbImageView = (ImagePbImageView) this.f2274a.f2273a.y.findViewWithTag(str)) != null) {
            imagePbImageView.invalidate();
            imagePbImageView.a();
        }
    }
}
