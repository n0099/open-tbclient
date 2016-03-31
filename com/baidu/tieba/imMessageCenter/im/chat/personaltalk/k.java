package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.p<Boolean> {
    final /* synthetic */ j ctb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.ctb = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l aeE = com.baidu.tieba.im.db.l.aeE();
        personalTalkSettingActivity = this.ctb.csZ;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(aeE.jc(String.valueOf(j)));
    }
}
