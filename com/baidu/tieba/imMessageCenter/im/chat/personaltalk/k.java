package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ j bZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bZV = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l Xr = com.baidu.tieba.im.db.l.Xr();
        personalTalkSettingActivity = this.bZV.bZT;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(Xr.ie(String.valueOf(j)));
    }
}
