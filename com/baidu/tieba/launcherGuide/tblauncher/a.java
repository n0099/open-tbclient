package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dsb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dsb = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cV(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dsb.drO;
            if (baseViewPager != null) {
                baseViewPager2 = this.dsb.drO;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dsb.crN;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dsb.LA();
            }
            CompatibleUtile.setAnim(this.dsb.getPageContext().getPageActivity(), 0, w.a.left);
            this.dsb.closeActivity();
        }
    }
}
