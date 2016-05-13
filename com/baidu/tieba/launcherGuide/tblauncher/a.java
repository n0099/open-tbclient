package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity cEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.cEy = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cF(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.cEy.cEk;
            if (baseViewPager != null) {
                baseViewPager2 = this.cEy.cEk;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.cEy.aAB;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.cEy.Id();
            }
            CompatibleUtile.setAnim(this.cEy.getPageContext().getPageActivity(), 0, t.a.left);
            this.cEy.closeActivity();
        }
    }
}
