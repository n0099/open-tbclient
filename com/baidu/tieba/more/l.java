package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class l implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ k bug;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bug = kVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tbadk.core.l.mc().ad(switchState == BdSwitchView.SwitchState.ON);
        this.bug.UL();
    }
}
