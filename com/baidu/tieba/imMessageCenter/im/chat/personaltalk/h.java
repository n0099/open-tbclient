package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes2.dex */
class h implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity djR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.djR = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        r rVar;
        aVar.dismiss();
        rVar = this.djR.djP;
        rVar.gn(false);
    }
}
