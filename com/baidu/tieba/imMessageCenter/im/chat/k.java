package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ UserData cVx;
    final /* synthetic */ PersonalChatActivity dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.dnc = personalChatActivity;
        this.cVx = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: LP */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.awk().b(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.cVx);
        return null;
    }
}
