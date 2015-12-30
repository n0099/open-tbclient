package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdSwitchView.a {
    final /* synthetic */ i dsK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.dsK = iVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        MsgSettingItemView msgSettingItemView;
        MsgSettingItemView msgSettingItemView2;
        i.a aVar;
        i.a aVar2;
        i.a aVar3;
        i.a aVar4;
        msgSettingItemView = this.dsK.dsA;
        if (view != msgSettingItemView.getSwitchView()) {
            msgSettingItemView2 = this.dsK.dsC;
            if (view != msgSettingItemView2.getSwitchView()) {
                return;
            }
            aVar = this.dsK.dsJ;
            if (aVar == null) {
                return;
            }
            aVar2 = this.dsK.dsJ;
            aVar2.b(switchState);
            return;
        }
        aVar3 = this.dsK.dsJ;
        if (aVar3 == null) {
            return;
        }
        aVar4 = this.dsK.dsJ;
        aVar4.a(switchState);
    }
}
