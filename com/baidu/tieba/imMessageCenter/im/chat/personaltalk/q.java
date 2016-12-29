package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity cZX;
    private final /* synthetic */ boolean cZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.cZX = personalTalkSettingActivity;
        this.cZY = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.cZY) {
            com.baidu.tieba.im.settingcache.j atf = com.baidu.tieba.im.settingcache.j.atf();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.cZX.userId;
            atf.f(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j atf2 = com.baidu.tieba.im.settingcache.j.atf();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.cZX.userId;
        atf2.f(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
