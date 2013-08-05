package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f1433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(GuideActivity guideActivity) {
        this.f1433a = guideActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void b_(int i) {
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.f1433a.f;
            if (baseViewPager != null) {
                baseViewPager2 = this.f1433a.f;
                baseViewPager2.setOnScrollOutListener(null);
            }
            this.f1433a.a();
            CompatibleUtile.setAnim(this.f1433a, 0, R.anim.left);
        }
    }
}
