package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ j bKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bKR = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l Ul = com.baidu.tieba.im.db.l.Ul();
        personalTalkSettingActivity = this.bKR.bKP;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(Ul.hK(String.valueOf(j)));
    }
}
