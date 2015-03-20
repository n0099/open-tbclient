package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBl;
    final /* synthetic */ PersonalTalkSettingActivity bpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.bpK = personalTalkSettingActivity;
        this.aBl = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aBl.dismiss();
    }
}
