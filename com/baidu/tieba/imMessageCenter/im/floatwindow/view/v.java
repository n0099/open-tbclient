package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class v extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ FloatingPersonalChatActivity bMx;
    private final /* synthetic */ UserData btz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bMx = floatingPersonalChatActivity;
        this.btz = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.Xj().aL(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.btz.getUserId())));
    }
}
