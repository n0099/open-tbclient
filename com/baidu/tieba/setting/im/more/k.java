package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ i cep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cep = iVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        MsgSettingItemView msgSettingItemView;
        MsgSettingItemView msgSettingItemView2;
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        msgSettingItemView = this.cep.ceg;
        if (view != msgSettingItemView.getSwitchView()) {
            msgSettingItemView2 = this.cep.cei;
            if (view != msgSettingItemView2.getSwitchView()) {
                return;
            }
            lVar = this.cep.cdS;
            if (lVar == null) {
                return;
            }
            lVar2 = this.cep.cdS;
            lVar2.b(switchState);
            return;
        }
        lVar3 = this.cep.cdS;
        if (lVar3 == null) {
            return;
        }
        lVar4 = this.cep.cdS;
        lVar4.a(switchState);
    }
}
