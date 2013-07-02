package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.view.a {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void b_(int i) {
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.a.f;
            if (baseViewPager != null) {
                baseViewPager2 = this.a.f;
                baseViewPager2.setOnScrollOutListener(null);
            }
            this.a.a();
            CompatibleUtile.setAnim(this.a, 0, R.anim.left);
        }
    }
}
