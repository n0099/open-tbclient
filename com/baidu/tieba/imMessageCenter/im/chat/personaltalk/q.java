package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity did;
    private final /* synthetic */ boolean die;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.did = personalTalkSettingActivity;
        this.die = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.die) {
            com.baidu.tieba.im.settingcache.j atz = com.baidu.tieba.im.settingcache.j.atz();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.did.userId;
            atz.h(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j atz2 = com.baidu.tieba.im.settingcache.j.atz();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.did.userId;
        atz2.h(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
