package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbImageView;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.c.d {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        ImagePbActivity imagePbActivity;
        BaseViewPager baseViewPager;
        if (bitmap == null) {
            return;
        }
        imagePbActivity = this.a.a;
        baseViewPager = imagePbActivity.x;
        ImagePbImageView imagePbImageView = (ImagePbImageView) baseViewPager.findViewWithTag(str);
        if (imagePbImageView != null) {
            imagePbImageView.invalidate();
            imagePbImageView.a();
        }
    }
}
