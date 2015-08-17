package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ FloatingPersonalChatActivity bIA;
    private final /* synthetic */ UserData bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bIA = floatingPersonalChatActivity;
        this.bpO = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        String str;
        if (this.bpO != null) {
            com.baidu.tieba.im.settingcache.j Wy = com.baidu.tieba.im.settingcache.j.Wy();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.bIA.azh;
            Wy.a(currentAccount, str, this.bpO);
            return null;
        }
        return null;
    }
}
