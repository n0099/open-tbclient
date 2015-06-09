package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    private final /* synthetic */ boolean aZC;
    final /* synthetic */ PersonalTalkSettingActivity bsG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bsG = personalTalkSettingActivity;
        this.aZC = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.bsG.bsD;
        yVar.a((com.baidu.adp.widget.BdSwitchView.b) null);
        yVar2 = this.bsG.bsD;
        yVar2.ds(!this.aZC);
        yVar3 = this.bsG.bsD;
        yVar3.a(this.bsG);
    }
}
