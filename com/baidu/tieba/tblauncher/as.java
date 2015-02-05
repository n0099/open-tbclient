package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class as implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ ai cdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ai aiVar) {
        this.cdv = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        this.cdv.eJ(false);
        this.cdv.y(0.0f);
    }
}
