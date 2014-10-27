package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ GuideActivity bOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GuideActivity guideActivity) {
        this.bOn = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public void bE(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.bOn.bOd;
            if (baseViewPager != null) {
                baseViewPager2 = this.bOn.bOd;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.bOn.bNZ;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.bOn.oq();
            }
            CompatibleUtile.setAnim(this.bOn, 0, com.baidu.tieba.p.left);
            this.bOn.closeActivity();
        }
    }
}
