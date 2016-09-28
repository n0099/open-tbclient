package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dzW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dzW = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cV(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dzW.dzJ;
            if (baseViewPager != null) {
                baseViewPager2 = this.dzW.dzJ;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dzW.czD;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dzW.Mh();
            }
            CompatibleUtile.setAnim(this.dzW.getPageContext().getPageActivity(), 0, r.a.left);
            this.dzW.closeActivity();
        }
    }
}
