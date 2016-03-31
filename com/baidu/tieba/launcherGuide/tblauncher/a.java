package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity cEG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.cEG = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cX(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.cEG.cEs;
            if (baseViewPager != null) {
                baseViewPager2 = this.cEG.cEs;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.cEG.aEr;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.cEG.JK();
            }
            CompatibleUtile.setAnim(this.cEG.getPageContext().getPageActivity(), 0, t.a.left);
            this.cEG.closeActivity();
        }
    }
}
