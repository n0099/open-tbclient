package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ UserData bQJ;
    final /* synthetic */ FloatingPersonalChatActivity ckw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.ckw = floatingPersonalChatActivity;
        this.bQJ = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        String str;
        if (this.bQJ != null) {
            com.baidu.tieba.im.settingcache.j aeU = com.baidu.tieba.im.settingcache.j.aeU();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.ckw.aCR;
            aeU.b(currentAccount, str, this.bQJ);
            return null;
        }
        return null;
    }
}
