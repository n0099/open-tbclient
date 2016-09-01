package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dyF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dyF = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cV(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dyF.dyr;
            if (baseViewPager != null) {
                baseViewPager2 = this.dyF.dyr;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dyF.cyZ;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dyF.LD();
            }
            CompatibleUtile.setAnim(this.dyF.getPageContext().getPageActivity(), 0, t.a.left);
            this.dyF.closeActivity();
        }
    }
}
