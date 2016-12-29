package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity diy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.diy = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cY(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.diy.dil;
            if (baseViewPager != null) {
                baseViewPager2 = this.diy.dil;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.diy.ckd;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.diy.Mg();
            }
            CompatibleUtile.setAnim(this.diy.getPageContext().getPageActivity(), 0, r.a.left);
            this.diy.closeActivity();
        }
    }
}
