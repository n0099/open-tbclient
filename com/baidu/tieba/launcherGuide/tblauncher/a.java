package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity bTf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.bTf = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cC(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.bTf.bSV;
            if (baseViewPager != null) {
                baseViewPager2 = this.bTf.bSV;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.bTf.bSR;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.bTf.FR();
            }
            CompatibleUtile.setAnim(this.bTf.getPageContext().getPageActivity(), 0, i.a.left);
            this.bTf.closeActivity();
        }
    }
}
