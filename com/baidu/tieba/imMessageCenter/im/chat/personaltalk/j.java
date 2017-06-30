package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.util.x;
/* loaded from: classes2.dex */
class j implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity drN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.drN = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.drN.showLoadingDialog(null);
        x.b(new k(this), new l(this));
    }
}
