package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class m implements BdSwitchView.a {
    final /* synthetic */ l dKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.dKz = lVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tbadk.core.l.rn().af(switchState == BdSwitchView.SwitchState.ON);
        this.dKz.aHc();
    }
}
