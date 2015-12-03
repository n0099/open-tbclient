package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class p implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aoe;
    final /* synthetic */ PersonalTalkSettingActivity bZT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonalTalkSettingActivity personalTalkSettingActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.bZT = personalTalkSettingActivity;
        this.aoe = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aoe.dismiss();
    }
}
