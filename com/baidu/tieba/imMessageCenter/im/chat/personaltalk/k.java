package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonalTalkSettingActivity bpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bpK = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bpK.showLoadingDialog(null);
        com.baidu.tieba.im.l.a(new l(this), new m(this));
    }
}
