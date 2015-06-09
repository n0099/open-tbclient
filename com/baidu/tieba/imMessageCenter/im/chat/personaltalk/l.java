package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class l extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ k bsH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bsH = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.n RC = com.baidu.tieba.im.db.n.RC();
        personalTalkSettingActivity = this.bsH.bsG;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(RC.gV(String.valueOf(j)));
    }
}
