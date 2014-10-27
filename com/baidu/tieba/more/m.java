package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class m implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ l bqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bqD = lVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tbadk.core.k.js().N(switchState == BdSwitchView.SwitchState.ON);
        this.bqD.Uv();
    }
}
