package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity csZ;
    private final /* synthetic */ boolean cta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.csZ = personalTalkSettingActivity;
        this.cta = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.csZ.csW;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.csZ.csW;
        wVar2.eA(!this.cta);
        wVar3 = this.csZ.csW;
        wVar3.a(this.csZ);
    }
}
