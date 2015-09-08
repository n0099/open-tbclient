package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ am cVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(am amVar) {
        this.cVq = amVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        am amVar = this.cVq;
        slidingMenu = this.cVq.bbU;
        amVar.z(1.0f - slidingMenu.getPercentOpen());
    }
}
