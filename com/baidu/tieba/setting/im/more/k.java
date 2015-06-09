package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ i ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.ceq = iVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        MsgSettingItemView msgSettingItemView;
        MsgSettingItemView msgSettingItemView2;
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        msgSettingItemView = this.ceq.ceh;
        if (view != msgSettingItemView.getSwitchView()) {
            msgSettingItemView2 = this.ceq.cej;
            if (view != msgSettingItemView2.getSwitchView()) {
                return;
            }
            lVar = this.ceq.cdT;
            if (lVar == null) {
                return;
            }
            lVar2 = this.ceq.cdT;
            lVar2.b(switchState);
            return;
        }
        lVar3 = this.ceq.cdT;
        if (lVar3 == null) {
            return;
        }
        lVar4 = this.ceq.cdT;
        lVar4.a(switchState);
    }
}
