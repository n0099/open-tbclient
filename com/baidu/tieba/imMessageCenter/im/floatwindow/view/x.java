package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ UserData cWU;
    final /* synthetic */ FloatingPersonalChatActivity drr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.drr = floatingPersonalChatActivity;
        this.cWU = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Mt */
    public Void doInBackground() {
        String str;
        if (this.cWU != null) {
            com.baidu.tieba.im.settingcache.j awJ = com.baidu.tieba.im.settingcache.j.awJ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.drr.aEj;
            awJ.a(currentAccount, str, this.cWU);
            return null;
        }
        return null;
    }
}
