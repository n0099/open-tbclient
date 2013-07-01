package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f949a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GuideActivity guideActivity) {
        this.f949a = guideActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void b_(int i) {
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.f949a.f;
            if (baseViewPager != null) {
                baseViewPager2 = this.f949a.f;
                baseViewPager2.setOnScrollOutListener(null);
            }
            this.f949a.a();
            CompatibleUtile.setAnim(this.f949a, 0, R.anim.left);
        }
    }
}
