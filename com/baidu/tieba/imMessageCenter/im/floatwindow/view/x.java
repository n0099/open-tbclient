package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ UserData bJd;
    final /* synthetic */ FloatingPersonalChatActivity cbW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.cbW = floatingPersonalChatActivity;
        this.bJd = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        String str;
        if (this.bJd != null) {
            com.baidu.tieba.im.settingcache.j aaG = com.baidu.tieba.im.settingcache.j.aaG();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.cbW.aAu;
            aaG.a(currentAccount, str, this.bJd);
            return null;
        }
        return null;
    }
}
