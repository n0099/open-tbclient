package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity bKj;
    private final /* synthetic */ boolean bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bKj = personalTalkSettingActivity;
        this.bKk = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.bKk) {
            com.baidu.tieba.im.settingcache.j Xj = com.baidu.tieba.im.settingcache.j.Xj();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.bKj.userId;
            Xj.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j Xj2 = com.baidu.tieba.im.settingcache.j.Xj();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.bKj.userId;
        Xj2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
