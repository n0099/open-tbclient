package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ UserData cVx;
    final /* synthetic */ FloatingPersonalChatActivity dpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.dpU = floatingPersonalChatActivity;
        this.cVx = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: LP */
    public Void doInBackground() {
        String str;
        if (this.cVx != null) {
            com.baidu.tieba.im.settingcache.j awk = com.baidu.tieba.im.settingcache.j.awk();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.dpU.aEL;
            awk.b(currentAccount, str, this.cVx);
            return null;
        }
        return null;
    }
}
