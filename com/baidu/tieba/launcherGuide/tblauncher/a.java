package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dFA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dFA = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cW(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dFA.dFn;
            if (baseViewPager != null) {
                baseViewPager2 = this.dFA.dFn;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dFA.cEN;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dFA.MN();
            }
            CompatibleUtile.setAnim(this.dFA.getPageContext().getPageActivity(), 0, r.a.left);
            this.dFA.closeActivity();
        }
    }
}
