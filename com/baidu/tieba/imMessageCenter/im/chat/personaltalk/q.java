package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity csZ;
    private final /* synthetic */ boolean cta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.csZ = personalTalkSettingActivity;
        this.cta = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.cta) {
            com.baidu.tieba.im.settingcache.j ain = com.baidu.tieba.im.settingcache.j.ain();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.csZ.userId;
            ain.f(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j ain2 = com.baidu.tieba.im.settingcache.j.ain();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.csZ.userId;
        ain2.f(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
