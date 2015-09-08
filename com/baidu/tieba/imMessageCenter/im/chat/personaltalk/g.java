package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity bHe;
    private final /* synthetic */ boolean bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bHe = personalTalkSettingActivity;
        this.bHf = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.bHe.bHb;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.bHe.bHb;
        wVar2.dA(!this.bHf);
        wVar3 = this.bHe.bHb;
        wVar3.a(this.bHe);
    }
}
