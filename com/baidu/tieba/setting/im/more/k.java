package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements BdSwitchView.a {
    final /* synthetic */ i cLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cLQ = iVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        MsgSettingItemView msgSettingItemView;
        MsgSettingItemView msgSettingItemView2;
        i.a aVar;
        i.a aVar2;
        i.a aVar3;
        i.a aVar4;
        msgSettingItemView = this.cLQ.cLG;
        if (view != msgSettingItemView.getSwitchView()) {
            msgSettingItemView2 = this.cLQ.cLI;
            if (view != msgSettingItemView2.getSwitchView()) {
                return;
            }
            aVar = this.cLQ.cLP;
            if (aVar == null) {
                return;
            }
            aVar2 = this.cLQ.cLP;
            aVar2.b(switchState);
            return;
        }
        aVar3 = this.cLQ.cLP;
        if (aVar3 == null) {
            return;
        }
        aVar4 = this.cLQ.cLP;
        aVar4.a(switchState);
    }
}
