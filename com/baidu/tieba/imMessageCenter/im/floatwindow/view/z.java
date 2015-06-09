package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData bbT;
    final /* synthetic */ FloatingPersonalChatActivity buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.buK = floatingPersonalChatActivity;
        this.bbT = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        String str;
        if (this.bbT != null) {
            com.baidu.tieba.im.settingcache.j UR = com.baidu.tieba.im.settingcache.j.UR();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.buK.ase;
            UR.a(currentAccount, str, this.bbT);
            return null;
        }
        return null;
    }
}
