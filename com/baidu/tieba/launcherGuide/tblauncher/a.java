package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ GuideActivity bxO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.bxO = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public void cj(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.bxO.bxH;
            if (baseViewPager != null) {
                baseViewPager2 = this.bxO.bxH;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.bxO.bxD;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.bxO.us();
            }
            CompatibleUtile.setAnim(this.bxO.getPageContext().getPageActivity(), 0, p.left);
            this.bxO.closeActivity();
        }
    }
}
