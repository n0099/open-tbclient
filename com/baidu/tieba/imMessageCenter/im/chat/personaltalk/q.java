package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity bKu;
    private final /* synthetic */ boolean bKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.bKu = personalTalkSettingActivity;
        this.bKv = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.bKv) {
            com.baidu.tieba.im.settingcache.j Xf = com.baidu.tieba.im.settingcache.j.Xf();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.bKu.userId;
            Xf.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j Xf2 = com.baidu.tieba.im.settingcache.j.Xf();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.bKu.userId;
        Xf2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
