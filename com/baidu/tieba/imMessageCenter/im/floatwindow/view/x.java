package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ FloatingPersonalChatActivity bMx;
    private final /* synthetic */ UserData bty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bMx = floatingPersonalChatActivity;
        this.bty = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gh */
    public Void doInBackground() {
        String str;
        if (this.bty != null) {
            com.baidu.tieba.im.settingcache.j Xf = com.baidu.tieba.im.settingcache.j.Xf();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.bMx.azB;
            Xf.a(currentAccount, str, this.bty);
            return null;
        }
        return null;
    }
}
