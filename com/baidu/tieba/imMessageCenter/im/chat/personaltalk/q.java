package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity dhm;
    private final /* synthetic */ boolean dhn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dhm = personalTalkSettingActivity;
        this.dhn = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.dhn) {
            com.baidu.tieba.im.settingcache.j aul = com.baidu.tieba.im.settingcache.j.aul();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.dhm.userId;
            aul.g(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j aul2 = com.baidu.tieba.im.settingcache.j.aul();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.dhm.userId;
        aul2.g(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
