package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class m implements BdSwitchView.a {
    final /* synthetic */ l cMT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.cMT = lVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tbadk.core.m.qX().af(switchState == BdSwitchView.SwitchState.ON);
        this.cMT.arG();
    }
}
