package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ j ctZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.ctZ = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l aeF = com.baidu.tieba.im.db.l.aeF();
        personalTalkSettingActivity = this.ctZ.ctX;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(aeF.je(String.valueOf(j)));
    }
}
