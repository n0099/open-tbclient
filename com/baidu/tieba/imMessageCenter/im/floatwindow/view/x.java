package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ UserData cHd;
    final /* synthetic */ FloatingPersonalChatActivity dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.dbp = floatingPersonalChatActivity;
        this.cHd = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Jo */
    public Void doInBackground() {
        String str;
        if (this.cHd != null) {
            com.baidu.tieba.im.settingcache.j aqK = com.baidu.tieba.im.settingcache.j.aqK();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.dbp.aAO;
            aqK.b(currentAccount, str, this.cHd);
            return null;
        }
        return null;
    }
}
