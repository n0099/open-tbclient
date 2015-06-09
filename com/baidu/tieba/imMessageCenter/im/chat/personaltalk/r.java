package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ boolean aZC;
    final /* synthetic */ PersonalTalkSettingActivity bsG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bsG = personalTalkSettingActivity;
        this.aZC = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.aZC) {
            com.baidu.tieba.im.settingcache.j UR = com.baidu.tieba.im.settingcache.j.UR();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.bsG.userId;
            UR.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j UR2 = com.baidu.tieba.im.settingcache.j.UR();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.bsG.userId;
        UR2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
