package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class n implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity bKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bKj = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        r rVar;
        aVar.dismiss();
        TiebaStatic.log("personalchat_morepage_addblack");
        rVar = this.bKj.bKh;
        rVar.dz(true);
    }
}
