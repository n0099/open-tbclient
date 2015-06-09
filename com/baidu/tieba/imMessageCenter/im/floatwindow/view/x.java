package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ UserData bbU;
    final /* synthetic */ FloatingPersonalChatActivity buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.buK = floatingPersonalChatActivity;
        this.bbU = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.UR().aK(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bbU.getUserId())));
    }
}
