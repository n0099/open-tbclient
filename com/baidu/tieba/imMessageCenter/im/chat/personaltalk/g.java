package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity dhm;
    private final /* synthetic */ boolean dhn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dhm = personalTalkSettingActivity;
        this.dhn = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.dhm.dhj;
        wVar.c(null);
        wVar2 = this.dhm.dhj;
        wVar2.gz(!this.dhn);
        wVar3 = this.dhm.dhj;
        wVar3.c(this.dhm);
    }
}
