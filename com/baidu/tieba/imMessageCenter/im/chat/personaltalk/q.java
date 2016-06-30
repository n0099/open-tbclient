package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity cZm;
    private final /* synthetic */ boolean cZn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.cZm = personalTalkSettingActivity;
        this.cZn = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.cZn) {
            com.baidu.tieba.im.settingcache.j aqK = com.baidu.tieba.im.settingcache.j.aqK();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.cZm.userId;
            aqK.g(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j aqK2 = com.baidu.tieba.im.settingcache.j.aqK();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.cZm.userId;
        aqK2.g(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
