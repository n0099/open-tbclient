package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes.dex */
class k extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ j bGz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bGz = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.l Tk = com.baidu.tieba.im.db.l.Tk();
        personalTalkSettingActivity = this.bGz.bGx;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(Tk.hv(String.valueOf(j)));
    }
}
