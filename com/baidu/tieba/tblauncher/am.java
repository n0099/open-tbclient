package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.cwn = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SlidingMenu slidingMenu;
        if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR) {
            slidingMenu = this.cwn.aQd;
            slidingMenu.toggle(true);
        }
    }
}
