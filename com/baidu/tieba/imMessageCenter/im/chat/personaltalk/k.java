package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ j dif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dif = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.m apJ = com.baidu.tieba.im.db.m.apJ();
        personalTalkSettingActivity = this.dif.did;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(apJ.kl(String.valueOf(j)));
    }
}
