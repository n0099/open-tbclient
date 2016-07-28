package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dmX = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cH(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dmX.dmJ;
            if (baseViewPager != null) {
                baseViewPager2 = this.dmX.dmJ;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dmX.cnQ;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dmX.Jb();
            }
            CompatibleUtile.setAnim(this.dmX.getPageContext().getPageActivity(), 0, u.a.left);
            this.dmX.closeActivity();
        }
    }
}
