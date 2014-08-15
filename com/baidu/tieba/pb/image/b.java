package com.baidu.tieba.pb.image;

import com.baidu.tbadk.core.view.BaseViewPager;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        ImagePbActivity imagePbActivity;
        BaseViewPager baseViewPager;
        if (aVar != null && i != 1) {
            imagePbActivity = this.a.a;
            baseViewPager = imagePbActivity.w;
            ImagePbImageView imagePbImageView = (ImagePbImageView) baseViewPager.findViewWithTag(str);
            if (imagePbImageView != null) {
                imagePbImageView.invalidate();
                imagePbImageView.a();
            }
        }
    }
}
