package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity dpq;
    private final /* synthetic */ boolean dpr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dpq = personalTalkSettingActivity;
        this.dpr = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.dpr) {
            com.baidu.tieba.im.settingcache.j awJ = com.baidu.tieba.im.settingcache.j.awJ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.dpq.userId;
            awJ.f(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j awJ2 = com.baidu.tieba.im.settingcache.j.awJ();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.dpq.userId;
        awJ2.f(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
