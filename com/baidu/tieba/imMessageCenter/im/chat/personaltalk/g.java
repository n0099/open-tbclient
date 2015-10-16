package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity bKu;
    private final /* synthetic */ boolean bKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bKu = personalTalkSettingActivity;
        this.bKv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.bKu.bKr;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.bKu.bKr;
        wVar2.dA(!this.bKv);
        wVar3 = this.bKu.bKr;
        wVar3.a(this.bKu);
    }
}
