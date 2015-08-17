package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdSwitchView.a {
    final /* synthetic */ i cvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cvU = iVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        MsgSettingItemView msgSettingItemView;
        MsgSettingItemView msgSettingItemView2;
        i.a aVar;
        i.a aVar2;
        i.a aVar3;
        i.a aVar4;
        msgSettingItemView = this.cvU.cvK;
        if (view != msgSettingItemView.getSwitchView()) {
            msgSettingItemView2 = this.cvU.cvM;
            if (view != msgSettingItemView2.getSwitchView()) {
                return;
            }
            aVar = this.cvU.cvT;
            if (aVar == null) {
                return;
            }
            aVar2 = this.cvU.cvT;
            aVar2.b(switchState);
            return;
        }
        aVar3 = this.cvU.cvT;
        if (aVar3 == null) {
            return;
        }
        aVar4 = this.cvU.cvT;
        aVar4.a(switchState);
    }
}
