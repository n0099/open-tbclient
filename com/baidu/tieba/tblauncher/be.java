package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ao aoVar) {
        this.dfH = aoVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        this.dfH.gH(false);
        this.dfH.z(0.0f);
    }
}
