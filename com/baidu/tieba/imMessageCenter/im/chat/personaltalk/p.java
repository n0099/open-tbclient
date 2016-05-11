package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class p implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amF;
    final /* synthetic */ PersonalTalkSettingActivity ctX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonalTalkSettingActivity personalTalkSettingActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.ctX = personalTalkSettingActivity;
        this.amF = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.amF.dismiss();
    }
}
