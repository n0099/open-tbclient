package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class p implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a anl;
    final /* synthetic */ PersonalTalkSettingActivity cZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonalTalkSettingActivity personalTalkSettingActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.cZm = personalTalkSettingActivity;
        this.anl = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.anl.dismiss();
    }
}
