package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity bZT;
    private final /* synthetic */ boolean bZU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bZT = personalTalkSettingActivity;
        this.bZU = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.bZT.bZQ;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.bZT.bZQ;
        wVar2.dX(!this.bZU);
        wVar3 = this.bZT.bZQ;
        wVar3.a(this.bZT);
    }
}
