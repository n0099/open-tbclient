package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity cZm;
    private final /* synthetic */ boolean cZn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.cZm = personalTalkSettingActivity;
        this.cZn = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.cZm.cZj;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.cZm.cZj;
        wVar2.fQ(!this.cZn);
        wVar3 = this.cZm.cZj;
        wVar3.a(this.cZm);
    }
}
