package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity ctX;
    private final /* synthetic */ boolean ctY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.ctX = personalTalkSettingActivity;
        this.ctY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.ctX.ctU;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.ctX.ctU;
        wVar2.fc(!this.ctY);
        wVar3 = this.ctX.ctU;
        wVar3.a(this.ctX);
    }
}
