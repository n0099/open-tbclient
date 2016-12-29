package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ j cZZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cZZ = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l app = com.baidu.tieba.im.db.l.app();
        personalTalkSettingActivity = this.cZZ.cZX;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(app.kq(String.valueOf(j)));
    }
}
