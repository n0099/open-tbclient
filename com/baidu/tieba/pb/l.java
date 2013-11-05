package com.baidu.tieba.pb;

import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f2140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f2140a = kVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BaseViewPager baseViewPager;
        if (eVar != null) {
            baseViewPager = this.f2140a.f2139a.z;
            ImagePbImageView imagePbImageView = (ImagePbImageView) baseViewPager.findViewWithTag(str);
            if (imagePbImageView != null) {
                imagePbImageView.invalidate();
                imagePbImageView.a();
            }
        }
    }
}
