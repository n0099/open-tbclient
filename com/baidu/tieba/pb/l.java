package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.d.d {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        ImagePbActivity imagePbActivity;
        BaseViewPager baseViewPager;
        if (bitmap != null) {
            imagePbActivity = this.a.a;
            baseViewPager = imagePbActivity.z;
            ImagePbImageView imagePbImageView = (ImagePbImageView) baseViewPager.findViewWithTag(str);
            if (imagePbImageView != null) {
                imagePbImageView.invalidate();
                imagePbImageView.a();
            }
        }
    }
}
