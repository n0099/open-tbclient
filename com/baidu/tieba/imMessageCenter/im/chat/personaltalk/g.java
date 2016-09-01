package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity dnR;
    private final /* synthetic */ boolean dnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dnR = personalTalkSettingActivity;
        this.dnS = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.dnR.dnO;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.dnR.dnO;
        wVar2.gp(!this.dnS);
        wVar3 = this.dnR.dnO;
        wVar3.a(this.dnR);
    }
}
