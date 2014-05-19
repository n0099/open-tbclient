package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public void a(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.a.j;
            if (baseViewPager != null) {
                baseViewPager2 = this.a.j;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.a.f;
            if (!str.equals("from_about_page")) {
                this.a.e();
            }
            CompatibleUtile.setAnim(this.a, 0, com.baidu.tieba.l.left);
            this.a.closeActivity();
        }
    }
}
