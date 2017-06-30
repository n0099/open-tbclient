package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity drN;
    private final /* synthetic */ boolean drO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.drN = personalTalkSettingActivity;
        this.drO = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.drN.drK;
        wVar.b(null);
        wVar2 = this.drN.drK;
        wVar2.gG(!this.drO);
        wVar3 = this.drN.drK;
        wVar3.b(this.drN);
    }
}
