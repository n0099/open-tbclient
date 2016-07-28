package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class v extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ UserData cJT;
    final /* synthetic */ FloatingPersonalChatActivity dem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.dem = floatingPersonalChatActivity;
        this.cJT = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.arw().bh(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cJT.getUserId())));
    }
}
