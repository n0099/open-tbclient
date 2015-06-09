package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class ax implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ aj cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aj ajVar) {
        this.cwo = ajVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        this.cwo.fo(false);
        this.cwo.y(0.0f);
    }
}
