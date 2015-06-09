package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonalTalkSettingActivity bsG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bsG = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        s sVar;
        aVar.dismiss();
        com.baidu.tbadk.core.k.A(this.bsG.getPageContext().getContext(), "personalchat_morepage_addblack");
        sVar = this.bsG.bsE;
        sVar.dr(true);
    }
}
