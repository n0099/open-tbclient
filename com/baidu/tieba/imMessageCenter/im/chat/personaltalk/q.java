package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity ctX;
    private final /* synthetic */ boolean ctY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.ctX = personalTalkSettingActivity;
        this.ctY = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.ctY) {
            com.baidu.tieba.im.settingcache.j aiu = com.baidu.tieba.im.settingcache.j.aiu();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.ctX.userId;
            aiu.f(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j aiu2 = com.baidu.tieba.im.settingcache.j.aiu();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.ctX.userId;
        aiu2.f(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
