package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class l extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ k bqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bqb = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.n Qm = com.baidu.tieba.im.db.n.Qm();
        personalTalkSettingActivity = this.bqb.bqa;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(Qm.gt(String.valueOf(j)));
    }
}
