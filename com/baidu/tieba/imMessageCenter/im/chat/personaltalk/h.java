package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class h implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity did;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.did = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        r rVar;
        aVar.dismiss();
        rVar = this.did.dib;
        rVar.gp(false);
    }
}
