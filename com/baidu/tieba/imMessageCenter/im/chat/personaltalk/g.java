package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity duX;
    private final /* synthetic */ boolean duY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.duX = personalTalkSettingActivity;
        this.duY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.duX.duU;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.duX.duU;
        wVar2.gM(!this.duY);
        wVar3 = this.duX.duU;
        wVar3.a(this.duX);
    }
}
