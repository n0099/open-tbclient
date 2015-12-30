package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ UserData bML;
    final /* synthetic */ FloatingPersonalChatActivity cfW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.cfW = floatingPersonalChatActivity;
        this.bML = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Ha */
    public Void doInBackground() {
        String str;
        if (this.bML != null) {
            com.baidu.tieba.im.settingcache.j abO = com.baidu.tieba.im.settingcache.j.abO();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.cfW.aCb;
            abO.b(currentAccount, str, this.bML);
            return null;
        }
        return null;
    }
}
