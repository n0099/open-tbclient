package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PersonalTalkSettingActivity dcj;
    private final /* synthetic */ boolean dck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dcj = personalTalkSettingActivity;
        this.dck = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        wVar = this.dcj.dcg;
        wVar.a((BdSwitchView.a) null);
        wVar2 = this.dcj.dcg;
        wVar2.fT(!this.dck);
        wVar3 = this.dcj.dcg;
        wVar3.a(this.dcj);
    }
}
