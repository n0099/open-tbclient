package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity dku;
    private final /* synthetic */ boolean dkv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dku = personalTalkSettingActivity;
        this.dkv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.dku.dkr;
        wVar.c(null);
        wVar2 = this.dku.dkr;
        wVar2.gA(!this.dkv);
        wVar3 = this.dku.dkr;
        wVar3.c(this.dku);
    }
}
