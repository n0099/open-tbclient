package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ j dnT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dnT = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l asu = com.baidu.tieba.im.db.l.asu();
        personalTalkSettingActivity = this.dnT.dnR;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(asu.ln(String.valueOf(j)));
    }
}
