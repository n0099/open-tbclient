package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity bGx;
    private final /* synthetic */ boolean bGy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bGx = personalTalkSettingActivity;
        this.bGy = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.bGx.bGu;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.bGx.bGu;
        wVar2.dv(!this.bGy);
        wVar3 = this.bGx.bGu;
        wVar3.a(this.bGx);
    }
}
