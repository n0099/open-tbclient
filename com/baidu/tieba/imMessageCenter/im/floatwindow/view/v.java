package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class v extends com.baidu.tbadk.util.p<Boolean> {
    private final /* synthetic */ UserData cbd;
    final /* synthetic */ FloatingPersonalChatActivity cvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.cvc = floatingPersonalChatActivity;
        this.cbd = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.ain().bc(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cbd.getUserId())));
    }
}
