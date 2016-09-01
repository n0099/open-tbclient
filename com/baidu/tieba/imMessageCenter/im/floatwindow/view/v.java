package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class v extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ UserData cVy;
    final /* synthetic */ FloatingPersonalChatActivity dpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.dpU = floatingPersonalChatActivity;
        this.cVy = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.awk().bi(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cVy.getUserId())));
    }
}
