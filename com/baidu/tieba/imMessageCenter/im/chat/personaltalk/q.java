package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity duX;
    private final /* synthetic */ boolean duY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.duX = personalTalkSettingActivity;
        this.duY = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.duY) {
            com.baidu.tieba.im.settingcache.j ayG = com.baidu.tieba.im.settingcache.j.ayG();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.duX.userId;
            ayG.f(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j ayG2 = com.baidu.tieba.im.settingcache.j.ayG();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.duX.userId;
        ayG2.f(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
