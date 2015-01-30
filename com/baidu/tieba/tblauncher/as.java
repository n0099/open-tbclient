package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class as implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ ai cdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ai aiVar) {
        this.cdw = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        this.cdw.eJ(false);
        this.cdw.y(0.0f);
    }
}
