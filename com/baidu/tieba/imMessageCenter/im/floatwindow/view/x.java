package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ UserData dcG;
    final /* synthetic */ FloatingPersonalChatActivity dwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.dwY = floatingPersonalChatActivity;
        this.dcG = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Nb */
    public Void doInBackground() {
        String str;
        if (this.dcG != null) {
            com.baidu.tieba.im.settingcache.j ayG = com.baidu.tieba.im.settingcache.j.ayG();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.dwY.aEZ;
            ayG.a(currentAccount, str, this.dcG);
            return null;
        }
        return null;
    }
}
