package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity bKP;
    private final /* synthetic */ boolean bKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bKP = personalTalkSettingActivity;
        this.bKQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.bKQ) {
            com.baidu.tieba.im.settingcache.j XA = com.baidu.tieba.im.settingcache.j.XA();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.bKP.userId;
            XA.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j XA2 = com.baidu.tieba.im.settingcache.j.XA();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.bKP.userId;
        XA2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
