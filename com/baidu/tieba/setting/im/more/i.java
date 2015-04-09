package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ g bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bZS = gVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        j jVar;
        j jVar2;
        jVar = this.bZS.bZB;
        if (jVar == null) {
            return;
        }
        jVar2 = this.bZS.bZB;
        jVar2.a(switchState);
    }
}
