package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity bSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.bSz = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cC(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.bSz.bSp;
            if (baseViewPager != null) {
                baseViewPager2 = this.bSz.bSp;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.bSz.bSl;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.bSz.FY();
            }
            CompatibleUtile.setAnim(this.bSz.getPageContext().getPageActivity(), 0, i.a.left);
            this.bSz.closeActivity();
        }
    }
}
