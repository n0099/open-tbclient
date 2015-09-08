package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class v extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ FloatingPersonalChatActivity bJh;
    private final /* synthetic */ UserData bqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bJh = floatingPersonalChatActivity;
        this.bqn = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.WA().aM(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bqn.getUserId())));
    }
}
