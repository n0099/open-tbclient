package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonalTalkSettingActivity bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bsF = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        s sVar;
        aVar.dismiss();
        sVar = this.bsF.bsD;
        sVar.dr(false);
    }
}
