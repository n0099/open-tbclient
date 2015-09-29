package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ j bKl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bKl = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l TU = com.baidu.tieba.im.db.l.TU();
        personalTalkSettingActivity = this.bKl.bKj;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(TU.hI(String.valueOf(j)));
    }
}
