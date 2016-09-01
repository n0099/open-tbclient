package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity dnR;
    private final /* synthetic */ boolean dnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dnR = personalTalkSettingActivity;
        this.dnS = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.dnS) {
            com.baidu.tieba.im.settingcache.j awk = com.baidu.tieba.im.settingcache.j.awk();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.dnR.userId;
            awk.f(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j awk2 = com.baidu.tieba.im.settingcache.j.awk();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.dnR.userId;
        awk2.f(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
