package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ an ccc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(an anVar) {
        this.ccc = anVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        an anVar = this.ccc;
        slidingMenu = this.ccc.aED;
        anVar.z(1.0f - slidingMenu.getPercentOpen());
    }
}
