package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonalTalkSettingActivity bpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bpK = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        s sVar;
        aVar.dismiss();
        sVar = this.bpK.bpI;
        sVar.dh(false);
    }
}
