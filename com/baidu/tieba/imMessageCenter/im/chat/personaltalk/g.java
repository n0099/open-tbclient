package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity dpq;
    private final /* synthetic */ boolean dpr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dpq = personalTalkSettingActivity;
        this.dpr = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.dpq.dpn;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.dpq.dpn;
        wVar2.gs(!this.dpr);
        wVar3 = this.dpq.dpn;
        wVar3.a(this.dpq);
    }
}
