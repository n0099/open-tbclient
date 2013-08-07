package com.baidu.tieba.pb;

import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f1534a = kVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ImagePbActivity imagePbActivity;
        BaseViewPager baseViewPager;
        if (bVar != null) {
            imagePbActivity = this.f1534a.f1533a;
            baseViewPager = imagePbActivity.z;
            ImagePbImageView imagePbImageView = (ImagePbImageView) baseViewPager.findViewWithTag(str);
            if (imagePbImageView != null) {
                imagePbImageView.invalidate();
                imagePbImageView.a();
            }
        }
    }
}
