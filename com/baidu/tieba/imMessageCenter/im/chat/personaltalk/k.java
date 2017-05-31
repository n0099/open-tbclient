package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes2.dex */
class k extends com.baidu.tbadk.util.v<Boolean> {
    final /* synthetic */ j djT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.djT = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.m aoD = com.baidu.tieba.im.db.m.aoD();
        personalTalkSettingActivity = this.djT.djR;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(aoD.kA(String.valueOf(j)));
    }
}
