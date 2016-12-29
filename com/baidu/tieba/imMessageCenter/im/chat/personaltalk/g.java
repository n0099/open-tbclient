package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity cZX;
    private final /* synthetic */ boolean cZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.cZX = personalTalkSettingActivity;
        this.cZY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.cZX.cZU;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.cZX.cZU;
        wVar2.gw(!this.cZY);
        wVar3 = this.cZX.cZU;
        wVar3.a(this.cZX);
    }
}
