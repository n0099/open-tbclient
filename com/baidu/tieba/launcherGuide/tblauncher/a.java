package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity djY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.djY = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cH(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.djY.djK;
            if (baseViewPager != null) {
                baseViewPager2 = this.djY.djK;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.djY.clB;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.djY.Jc();
            }
            CompatibleUtile.setAnim(this.djY.getPageContext().getPageActivity(), 0, u.a.left);
            this.djY.closeActivity();
        }
    }
}
