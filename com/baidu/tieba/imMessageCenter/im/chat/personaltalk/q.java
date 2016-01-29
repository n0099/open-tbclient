package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity ciu;
    private final /* synthetic */ boolean civ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.ciu = personalTalkSettingActivity;
        this.civ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.civ) {
            com.baidu.tieba.im.settingcache.j aeU = com.baidu.tieba.im.settingcache.j.aeU();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.ciu.userId;
            aeU.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j aeU2 = com.baidu.tieba.im.settingcache.j.aeU();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.ciu.userId;
        aeU2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
