package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ j ciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.ciw = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l abi = com.baidu.tieba.im.db.l.abi();
        personalTalkSettingActivity = this.ciw.ciu;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(abi.it(String.valueOf(j)));
    }
}
