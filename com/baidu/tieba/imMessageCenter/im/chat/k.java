package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ UserData cbH;
    final /* synthetic */ PersonalChatActivity cth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.cth = personalChatActivity;
        this.cbH = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Iq */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.aiw().b(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.cbH);
        return null;
    }
}
