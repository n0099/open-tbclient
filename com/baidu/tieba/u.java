package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(GuideActivity guideActivity) {
        this.f2460a = guideActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.f2460a.h;
            if (baseViewPager != null) {
                baseViewPager2 = this.f2460a.h;
                baseViewPager2.setOnScrollOutListener(null);
            }
            this.f2460a.a();
            CompatibleUtile.setAnim(this.f2460a, 0, R.anim.left);
        }
    }
}
