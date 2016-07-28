package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ UserData cJS;
    final /* synthetic */ FloatingPersonalChatActivity dem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.dem = floatingPersonalChatActivity;
        this.cJS = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Jn */
    public Void doInBackground() {
        String str;
        if (this.cJS != null) {
            com.baidu.tieba.im.settingcache.j arw = com.baidu.tieba.im.settingcache.j.arw();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.dem.aBE;
            arw.b(currentAccount, str, this.cJS);
            return null;
        }
        return null;
    }
}
