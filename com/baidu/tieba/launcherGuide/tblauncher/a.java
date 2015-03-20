package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ GuideActivity bxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.bxy = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public void cj(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.bxy.bxr;
            if (baseViewPager != null) {
                baseViewPager2 = this.bxy.bxr;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.bxy.bxn;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.bxy.us();
            }
            CompatibleUtile.setAnim(this.bxy.getPageContext().getPageActivity(), 0, p.left);
            this.bxy.closeActivity();
        }
    }
}
