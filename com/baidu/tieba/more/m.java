package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class m implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ l bqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bqR = lVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tbadk.core.l.js().N(switchState == BdSwitchView.SwitchState.ON);
        this.bqR.Uy();
    }
}
