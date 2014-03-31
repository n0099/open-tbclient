package com.baidu.tieba.tbluncher;

import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
final class b implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public final void a(int i) {
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
            CompatibleUtile.setAnim(this.a, 0, com.baidu.b.a.b.left);
            this.a.closeActivity();
        }
    }
}
