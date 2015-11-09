package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class h implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity bKP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bKP = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        r rVar;
        aVar.dismiss();
        rVar = this.bKP.bKN;
        rVar.dB(false);
    }
}
