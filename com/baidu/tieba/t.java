package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.view.a {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.a.i;
            if (baseViewPager != null) {
                baseViewPager2 = this.a.i;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.a.e;
            if (!str.equals("from_about_page")) {
                this.a.a();
            }
            CompatibleUtile.setAnim(this.a, 0, R.anim.left);
            this.a.closeActivity();
        }
    }
}
