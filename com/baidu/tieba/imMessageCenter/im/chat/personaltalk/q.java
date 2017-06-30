package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity drN;
    private final /* synthetic */ boolean drO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.drN = personalTalkSettingActivity;
        this.drO = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.drO) {
            com.baidu.tieba.im.settingcache.j awd = com.baidu.tieba.im.settingcache.j.awd();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.drN.userId;
            awd.g(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j awd2 = com.baidu.tieba.im.settingcache.j.awd();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.drN.userId;
        awd2.g(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
