package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData aYV;
    final /* synthetic */ FloatingPersonalChatActivity brH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.brH = floatingPersonalChatActivity;
        this.aYV = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        String str;
        if (this.aYV != null) {
            com.baidu.tieba.im.settingcache.j Tq = com.baidu.tieba.im.settingcache.j.Tq();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.brH.aqu;
            Tq.a(currentAccount, str, this.aYV);
            return null;
        }
        return null;
    }
}
