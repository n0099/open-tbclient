package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class h implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity ctX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ctX = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        r rVar;
        aVar.dismiss();
        rVar = this.ctX.ctV;
        rVar.fb(false);
    }
}
