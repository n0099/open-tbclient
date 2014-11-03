package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ GuideActivity bOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GuideActivity guideActivity) {
        this.bOC = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public void bE(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.bOC.bOs;
            if (baseViewPager != null) {
                baseViewPager2 = this.bOC.bOs;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.bOC.bOo;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.bOC.oq();
            }
            CompatibleUtile.setAnim(this.bOC, 0, com.baidu.tieba.p.left);
            this.bOC.closeActivity();
        }
    }
}
