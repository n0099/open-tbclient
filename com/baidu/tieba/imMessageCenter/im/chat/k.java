package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.v;
/* loaded from: classes2.dex */
class k extends v<Void> {
    private final /* synthetic */ UserData cLQ;
    final /* synthetic */ PersonalChatActivity ddC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.ddC = personalChatActivity;
        this.cLQ = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: LK */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.aru().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.cLQ);
        return null;
    }
}
