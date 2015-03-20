package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ g bZD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bZD = gVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        j jVar;
        j jVar2;
        jVar = this.bZD.bZm;
        if (jVar == null) {
            return;
        }
        jVar2 = this.bZD.bZm;
        jVar2.a(switchState);
    }
}
