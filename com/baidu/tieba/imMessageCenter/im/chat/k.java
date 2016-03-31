package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.p<Void> {
    private final /* synthetic */ UserData cbc;
    final /* synthetic */ PersonalChatActivity csk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.csk = personalChatActivity;
        this.cbc = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.ain().b(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.cbc);
        return null;
    }
}
