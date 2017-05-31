package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.v;
/* loaded from: classes2.dex */
class k extends v<Void> {
    private final /* synthetic */ UserData cRo;
    final /* synthetic */ PersonalChatActivity diX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.diX = personalChatActivity;
        this.cRo = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: KF */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.ass().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.cRo);
        return null;
    }
}
