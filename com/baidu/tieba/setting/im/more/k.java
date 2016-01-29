package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdSwitchView.a {
    final /* synthetic */ i dIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.dIO = iVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        MsgSettingItemView msgSettingItemView;
        MsgSettingItemView msgSettingItemView2;
        i.a aVar;
        i.a aVar2;
        i.a aVar3;
        i.a aVar4;
        msgSettingItemView = this.dIO.dIE;
        if (view != msgSettingItemView.getSwitchView()) {
            msgSettingItemView2 = this.dIO.dIG;
            if (view != msgSettingItemView2.getSwitchView()) {
                return;
            }
            aVar = this.dIO.dIN;
            if (aVar == null) {
                return;
            }
            aVar2 = this.dIO.dIN;
            aVar2.b(switchState);
            return;
        }
        aVar3 = this.dIO.dIN;
        if (aVar3 == null) {
            return;
        }
        aVar4 = this.dIO.dIN;
        aVar4.a(switchState);
    }
}
