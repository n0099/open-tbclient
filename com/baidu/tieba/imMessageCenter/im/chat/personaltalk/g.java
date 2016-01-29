package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity ciu;
    private final /* synthetic */ boolean civ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.ciu = personalTalkSettingActivity;
        this.civ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.ciu.cir;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.ciu.cir;
        wVar2.ee(!this.civ);
        wVar3 = this.ciu.cir;
        wVar3.a(this.ciu);
    }
}
