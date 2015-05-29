package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    private final /* synthetic */ boolean aZB;
    final /* synthetic */ PersonalTalkSettingActivity bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bsF = personalTalkSettingActivity;
        this.aZB = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.bsF.bsC;
        yVar.a((com.baidu.adp.widget.BdSwitchView.b) null);
        yVar2 = this.bsF.bsC;
        yVar2.ds(!this.aZB);
        yVar3 = this.bsF.bsC;
        yVar3.a(this.bsF);
    }
}
