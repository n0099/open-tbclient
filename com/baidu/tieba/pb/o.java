package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbImageView;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.c.d {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.tieba.c.d
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
