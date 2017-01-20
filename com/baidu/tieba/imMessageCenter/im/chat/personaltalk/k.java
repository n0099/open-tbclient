package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ j dho;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dho = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l aqw = com.baidu.tieba.im.db.l.aqw();
        personalTalkSettingActivity = this.dho.dhm;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(aqw.kE(String.valueOf(j)));
    }
}
