package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.dfH = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SlidingMenu slidingMenu;
        if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR) {
            slidingMenu = this.dfH.bcE;
            slidingMenu.toggle(true);
        }
    }
}
