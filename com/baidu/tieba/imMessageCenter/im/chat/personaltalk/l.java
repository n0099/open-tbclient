package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class l extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ k bsG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bsG = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.n RB = com.baidu.tieba.im.db.n.RB();
        personalTalkSettingActivity = this.bsG.bsF;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(RB.gV(String.valueOf(j)));
    }
}
