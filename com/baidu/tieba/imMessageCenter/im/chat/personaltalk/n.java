package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class n implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity duX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.duX = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        r rVar;
        aVar.dismiss();
        TiebaStatic.log("personalchat_morepage_addblack");
        rVar = this.duX.duV;
        rVar.gL(true);
    }
}
