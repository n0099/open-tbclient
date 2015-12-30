package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity cdU;
    private final /* synthetic */ boolean cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.cdU = personalTalkSettingActivity;
        this.cdV = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.cdV) {
            com.baidu.tieba.im.settingcache.j abO = com.baidu.tieba.im.settingcache.j.abO();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.cdU.userId;
            abO.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j abO2 = com.baidu.tieba.im.settingcache.j.abO();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.cdU.userId;
        abO2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
