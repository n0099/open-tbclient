package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity cdU;
    private final /* synthetic */ boolean cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.cdU = personalTalkSettingActivity;
        this.cdV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.cdU.cdR;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.cdU.cdR;
        wVar2.dX(!this.cdV);
        wVar3 = this.cdU.cdR;
        wVar3.a(this.cdU);
    }
}
