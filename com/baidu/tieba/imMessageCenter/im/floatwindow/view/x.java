package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ FloatingPersonalChatActivity bMS;
    private final /* synthetic */ UserData btY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bMS = floatingPersonalChatActivity;
        this.btY = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Ge */
    public Void doInBackground() {
        String str;
        if (this.btY != null) {
            com.baidu.tieba.im.settingcache.j XA = com.baidu.tieba.im.settingcache.j.XA();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.bMS.ayp;
            XA.a(currentAccount, str, this.btY);
            return null;
        }
        return null;
    }
}
