package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2635a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(GuideActivity guideActivity) {
        this.f2635a = guideActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.f2635a.i;
            if (baseViewPager != null) {
                baseViewPager2 = this.f2635a.i;
                baseViewPager2.setOnScrollOutListener(null);
            }
            this.f2635a.a();
            CompatibleUtile.setAnim(this.f2635a, 0, R.anim.left);
        }
    }
}
