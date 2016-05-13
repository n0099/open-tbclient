package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ UserData cbH;
    final /* synthetic */ FloatingPersonalChatActivity cvZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.cvZ = floatingPersonalChatActivity;
        this.cbH = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Iq */
    public Void doInBackground() {
        String str;
        if (this.cbH != null) {
            com.baidu.tieba.im.settingcache.j aiw = com.baidu.tieba.im.settingcache.j.aiw();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.cvZ.azX;
            aiw.b(currentAccount, str, this.cbH);
            return null;
        }
        return null;
    }
}
