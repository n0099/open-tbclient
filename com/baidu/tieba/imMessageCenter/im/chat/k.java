package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ UserData cPx;
    final /* synthetic */ PersonalChatActivity dhj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.dhj = personalChatActivity;
        this.cPx = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Mw */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.atz().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.cPx);
        return null;
    }
}
