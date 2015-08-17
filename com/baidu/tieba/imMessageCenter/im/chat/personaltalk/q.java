package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity bGx;
    private final /* synthetic */ boolean bGy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bGx = personalTalkSettingActivity;
        this.bGy = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.bGy) {
            com.baidu.tieba.im.settingcache.j Wy = com.baidu.tieba.im.settingcache.j.Wy();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.bGx.userId;
            Wy.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j Wy2 = com.baidu.tieba.im.settingcache.j.Wy();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.bGx.userId;
        Wy2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
