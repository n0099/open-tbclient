package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ j dps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dps = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l asT = com.baidu.tieba.im.db.l.asT();
        personalTalkSettingActivity = this.dps.dpq;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(asT.lA(String.valueOf(j)));
    }
}
