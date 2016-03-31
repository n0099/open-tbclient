package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class m implements BdSwitchView.a {
    final /* synthetic */ l ecT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.ecT = lVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tbadk.core.l.qE().ae(switchState == BdSwitchView.SwitchState.ON);
        this.ecT.aNM();
    }
}
