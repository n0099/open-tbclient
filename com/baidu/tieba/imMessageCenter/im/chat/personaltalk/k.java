package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;
/* loaded from: classes2.dex */
class k extends com.baidu.tbadk.util.w<Boolean> {
    final /* synthetic */ j drP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.drP = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        long j;
        com.baidu.tieba.im.db.m aso = com.baidu.tieba.im.db.m.aso();
        personalTalkSettingActivity = this.drP.drN;
        j = personalTalkSettingActivity.userId;
        return Boolean.valueOf(aso.ly(String.valueOf(j)));
    }
}
