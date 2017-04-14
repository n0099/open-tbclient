package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity did;
    private final /* synthetic */ boolean die;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.did = personalTalkSettingActivity;
        this.die = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.did.dia;
        wVar.c(null);
        wVar2 = this.did.dia;
        wVar2.gq(!this.die);
        wVar3 = this.did.dia;
        wVar3.c(this.did);
    }
}
