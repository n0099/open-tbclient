package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity bHe;
    private final /* synthetic */ boolean bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bHe = personalTalkSettingActivity;
        this.bHf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.bHf) {
            com.baidu.tieba.im.settingcache.j WA = com.baidu.tieba.im.settingcache.j.WA();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.bHe.userId;
            WA.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j WA2 = com.baidu.tieba.im.settingcache.j.WA();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.bHe.userId;
        WA2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
