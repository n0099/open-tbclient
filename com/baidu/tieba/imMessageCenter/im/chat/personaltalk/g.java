package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity bKj;
    private final /* synthetic */ boolean bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bKj = personalTalkSettingActivity;
        this.bKk = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.bKj.bKg;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.bKj.bKg;
        wVar2.dA(!this.bKk);
        wVar3 = this.bKj.bKg;
        wVar3.a(this.bKj);
    }
}
