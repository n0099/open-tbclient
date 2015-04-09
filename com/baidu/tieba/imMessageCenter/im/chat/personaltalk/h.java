package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    private final /* synthetic */ boolean aWV;
    final /* synthetic */ PersonalTalkSettingActivity bqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bqa = personalTalkSettingActivity;
        this.aWV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.bqa.bpX;
        yVar.a((com.baidu.adp.widget.BdSwitchView.b) null);
        yVar2 = this.bqa.bpX;
        yVar2.dg(!this.aWV);
        yVar3 = this.bqa.bpX;
        yVar3.a(this.bqa);
    }
}
