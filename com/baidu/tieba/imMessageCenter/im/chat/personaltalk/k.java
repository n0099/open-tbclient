package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes2.dex */
class k extends com.baidu.tbadk.util.v<Boolean> {
    final /* synthetic */ j dez;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dez = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.m anD = com.baidu.tieba.im.db.m.anD();
        personalTalkSettingActivity = this.dez.dex;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(anD.kq(String.valueOf(j)));
    }
}
