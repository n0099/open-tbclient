package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity dcj;
    private final /* synthetic */ boolean dck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.dcj = personalTalkSettingActivity;
        this.dck = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.dck) {
            com.baidu.tieba.im.settingcache.j arw = com.baidu.tieba.im.settingcache.j.arw();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.dcj.userId;
            arw.g(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j arw2 = com.baidu.tieba.im.settingcache.j.arw();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.dcj.userId;
        arw2.g(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
