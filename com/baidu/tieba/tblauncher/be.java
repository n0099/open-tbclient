package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ ao ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ao aoVar) {
        this.ddy = aoVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        this.ddy.gB(false);
        this.ddy.z(0.0f);
    }
}
