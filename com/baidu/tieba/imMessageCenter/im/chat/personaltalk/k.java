package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ j dcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dcl = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l anF = com.baidu.tieba.im.db.l.anF();
        personalTalkSettingActivity = this.dcl.dcj;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(anF.kE(String.valueOf(j)));
    }
}
