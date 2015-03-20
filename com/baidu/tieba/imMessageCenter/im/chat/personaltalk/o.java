package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonalTalkSettingActivity bpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bpK = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        s sVar;
        aVar.dismiss();
        com.baidu.tbadk.core.k.A(this.bpK.getPageContext().getContext(), "personalchat_morepage_addblack");
        sVar = this.bpK.bpI;
        sVar.dh(true);
    }
}
