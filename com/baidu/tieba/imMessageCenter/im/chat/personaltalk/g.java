package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity dex;
    private final /* synthetic */ boolean dey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dex = personalTalkSettingActivity;
        this.dey = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.dex.deu;
        wVar.b(null);
        wVar2 = this.dex.deu;
        wVar2.gb(!this.dey);
        wVar3 = this.dex.deu;
        wVar3.b(this.dex);
    }
}
