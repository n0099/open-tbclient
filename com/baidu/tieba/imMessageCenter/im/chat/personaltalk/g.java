package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity djE;
    private final /* synthetic */ boolean djF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.djE = personalTalkSettingActivity;
        this.djF = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.djE.djB;
        wVar.c(null);
        wVar2 = this.djE.djB;
        wVar2.gq(!this.djF);
        wVar3 = this.djE.djB;
        wVar3.c(this.djE);
    }
}
