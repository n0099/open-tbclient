package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ am cVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.cVq = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SlidingMenu slidingMenu;
        if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR) {
            slidingMenu = this.cVq.bbU;
            slidingMenu.toggle(true);
        }
    }
}
