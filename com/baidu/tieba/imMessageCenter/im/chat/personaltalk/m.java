package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class m implements a.b {
    final /* synthetic */ PersonalTalkSettingActivity ciu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ciu = personalTalkSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
