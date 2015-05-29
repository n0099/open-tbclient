package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData bbS;
    final /* synthetic */ FloatingPersonalChatActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.buJ = floatingPersonalChatActivity;
        this.bbS = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        String str;
        if (this.bbS != null) {
            com.baidu.tieba.im.settingcache.j UQ = com.baidu.tieba.im.settingcache.j.UQ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.buJ.ase;
            UQ.a(currentAccount, str, this.bbS);
            return null;
        }
        return null;
    }
}
