package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData aZl;
    final /* synthetic */ FloatingPersonalChatActivity brX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.brX = floatingPersonalChatActivity;
        this.aZl = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        String str;
        if (this.aZl != null) {
            com.baidu.tieba.im.settingcache.j TD = com.baidu.tieba.im.settingcache.j.TD();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.brX.aqC;
            TD.a(currentAccount, str, this.aZl);
            return null;
        }
        return null;
    }
}
