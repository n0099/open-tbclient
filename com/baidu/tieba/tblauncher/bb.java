package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ao aoVar) {
        this.dfH = aoVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        ao aoVar = this.dfH;
        slidingMenu = this.dfH.bcE;
        aoVar.z(1.0f - slidingMenu.getPercentOpen());
    }
}
