package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    private final /* synthetic */ boolean aWF;
    final /* synthetic */ PersonalTalkSettingActivity bpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bpK = personalTalkSettingActivity;
        this.aWF = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.bpK.bpH;
        yVar.a((com.baidu.adp.widget.BdSwitchView.b) null);
        yVar2 = this.bpK.bpH;
        yVar2.di(!this.aWF);
        yVar3 = this.bpK.bpH;
        yVar3.a(this.bpK);
    }
}
