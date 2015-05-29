package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonalTalkSettingActivity bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bsF = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        s sVar;
        aVar.dismiss();
        com.baidu.tbadk.core.k.A(this.bsF.getPageContext().getContext(), "personalchat_morepage_addblack");
        sVar = this.bsF.bsD;
        sVar.dr(true);
    }
}
