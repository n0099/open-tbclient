package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dqA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dqA = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cY(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dqA.dqn;
            if (baseViewPager != null) {
                baseViewPager2 = this.dqA.dqn;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dqA.cqm;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dqA.Mb();
            }
            CompatibleUtile.setAnim(this.dqA.getPageContext().getPageActivity(), 0, w.a.left);
            this.dqA.closeActivity();
        }
    }
}
