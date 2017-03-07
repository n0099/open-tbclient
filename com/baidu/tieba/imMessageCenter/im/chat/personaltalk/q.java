package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity djE;
    private final /* synthetic */ boolean djF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.djE = personalTalkSettingActivity;
        this.djF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.djF) {
            com.baidu.tieba.im.settingcache.j atG = com.baidu.tieba.im.settingcache.j.atG();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.djE.userId;
            atG.g(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j atG2 = com.baidu.tieba.im.settingcache.j.atG();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.djE.userId;
        atG2.g(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
