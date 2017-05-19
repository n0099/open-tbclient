package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dmV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dmV = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cU(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dmV.dmI;
            if (baseViewPager != null) {
                baseViewPager2 = this.dmV.dmI;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dmV.cpD;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dmV.Lp();
            }
            CompatibleUtile.setAnim(this.dmV.getPageContext().getPageActivity(), 0, w.a.left);
            this.dmV.closeActivity();
        }
    }
}
