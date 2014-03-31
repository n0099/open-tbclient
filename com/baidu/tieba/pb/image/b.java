package com.baidu.tieba.pb.image;

import com.baidu.tbadk.core.view.BaseViewPager;
/* loaded from: classes.dex */
final class b implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        ImagePbActivity imagePbActivity;
        BaseViewPager baseViewPager;
        if (bVar != null && !z) {
            imagePbActivity = this.a.a;
            baseViewPager = imagePbActivity.y;
            ImagePbImageView imagePbImageView = (ImagePbImageView) baseViewPager.findViewWithTag(str);
            if (imagePbImageView != null) {
                imagePbImageView.invalidate();
                imagePbImageView.a();
            }
        }
    }
}
