package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity djR;
    private final /* synthetic */ boolean djS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.djR = personalTalkSettingActivity;
        this.djS = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.djR.djO;
        wVar.b(null);
        wVar2 = this.djR.djO;
        wVar2.go(!this.djS);
        wVar3 = this.djR.djO;
        wVar3.b(this.djR);
    }
}
