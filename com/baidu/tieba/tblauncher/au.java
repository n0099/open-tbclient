package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(aj ajVar) {
        this.cwn = ajVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        aj ajVar = this.cwn;
        slidingMenu = this.cwn.aQd;
        ajVar.y(1.0f - slidingMenu.getPercentOpen());
    }
}
