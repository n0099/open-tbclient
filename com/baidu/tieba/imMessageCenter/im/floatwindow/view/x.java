package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.p<Void> {
    private final /* synthetic */ UserData cbc;
    final /* synthetic */ FloatingPersonalChatActivity cvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.cvc = floatingPersonalChatActivity;
        this.cbc = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        String str;
        if (this.cbc != null) {
            com.baidu.tieba.im.settingcache.j ain = com.baidu.tieba.im.settingcache.j.ain();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.cvc.aDP;
            ain.b(currentAccount, str, this.cbc);
            return null;
        }
        return null;
    }
}
