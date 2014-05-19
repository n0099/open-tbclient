package com.baidu.tieba.pb.image;

import com.baidu.tbadk.core.view.BaseViewPager;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImagePbActivity imagePbActivity;
        BaseViewPager baseViewPager;
        if (aVar != null && !z) {
            imagePbActivity = this.a.a;
            baseViewPager = imagePbActivity.x;
            ImagePbImageView imagePbImageView = (ImagePbImageView) baseViewPager.findViewWithTag(str);
            if (imagePbImageView != null) {
                imagePbImageView.invalidate();
                imagePbImageView.a();
            }
        }
    }
}
