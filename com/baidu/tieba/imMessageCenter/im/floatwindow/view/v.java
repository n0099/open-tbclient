package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class v extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ FloatingPersonalChatActivity bIA;
    private final /* synthetic */ UserData bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bIA = floatingPersonalChatActivity;
        this.bpP = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.Wy().aK(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bpP.getUserId())));
    }
}
