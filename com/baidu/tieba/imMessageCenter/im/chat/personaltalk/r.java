package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ boolean aZB;
    final /* synthetic */ PersonalTalkSettingActivity bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bsF = personalTalkSettingActivity;
        this.aZB = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.aZB) {
            com.baidu.tieba.im.settingcache.j UQ = com.baidu.tieba.im.settingcache.j.UQ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.bsF.userId;
            UQ.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j UQ2 = com.baidu.tieba.im.settingcache.j.UQ();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.bsF.userId;
        UQ2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
