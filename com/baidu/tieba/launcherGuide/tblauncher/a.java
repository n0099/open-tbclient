package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity cjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.cjt = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cK(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.cjt.cjj;
            if (baseViewPager != null) {
                baseViewPager2 = this.cjt.cjj;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.cjt.cjf;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.cjt.GY();
            }
            CompatibleUtile.setAnim(this.cjt.getPageContext().getPageActivity(), 0, n.a.left);
            this.cjt.closeActivity();
        }
    }
}
