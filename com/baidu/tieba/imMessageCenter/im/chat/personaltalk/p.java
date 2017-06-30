package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes2.dex */
class p implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a awZ;
    final /* synthetic */ PersonalTalkSettingActivity drN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonalTalkSettingActivity personalTalkSettingActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.drN = personalTalkSettingActivity;
        this.awZ = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.awZ.dismiss();
    }
}
