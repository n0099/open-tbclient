package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ ao ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ao aoVar) {
        this.ddy = aoVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        ao aoVar = this.ddy;
        slidingMenu = this.ddy.bbZ;
        aoVar.z(1.0f - slidingMenu.getPercentOpen());
    }
}
