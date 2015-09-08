package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ FloatingPersonalChatActivity bJh;
    private final /* synthetic */ UserData bqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bJh = floatingPersonalChatActivity;
        this.bqm = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Gr */
    public Void doInBackground() {
        String str;
        if (this.bqm != null) {
            com.baidu.tieba.im.settingcache.j WA = com.baidu.tieba.im.settingcache.j.WA();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.bJh.aAP;
            WA.a(currentAccount, str, this.bqm);
            return null;
        }
        return null;
    }
}
