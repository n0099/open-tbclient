package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GuideActivity guideActivity) {
        this.f2295a = guideActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a_(int i) {
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.f2295a.f;
            if (baseViewPager != null) {
                baseViewPager2 = this.f2295a.f;
                baseViewPager2.setOnScrollOutListener(null);
            }
            this.f2295a.b();
            CompatibleUtile.setAnim(this.f2295a, 0, R.anim.left);
        }
    }
}
