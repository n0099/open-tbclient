package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity bKP;
    private final /* synthetic */ boolean bKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bKP = personalTalkSettingActivity;
        this.bKQ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.bKP.bKM;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.bKP.bKM;
        wVar2.dC(!this.bKQ);
        wVar3 = this.bKP.bKM;
        wVar3.a(this.bKP);
    }
}
