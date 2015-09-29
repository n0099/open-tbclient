package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ FloatingPersonalChatActivity bMm;
    private final /* synthetic */ UserData btn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bMm = floatingPersonalChatActivity;
        this.btn = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gl */
    public Void doInBackground() {
        String str;
        if (this.btn != null) {
            com.baidu.tieba.im.settingcache.j Xj = com.baidu.tieba.im.settingcache.j.Xj();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.bMm.azq;
            Xj.a(currentAccount, str, this.btn);
            return null;
        }
        return null;
    }
}
