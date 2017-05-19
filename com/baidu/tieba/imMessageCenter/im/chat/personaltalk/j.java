package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes2.dex */
class j implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity dex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dex = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.dex.showLoadingDialog(null);
        com.baidu.tbadk.util.w.b(new k(this), new l(this));
    }
}
