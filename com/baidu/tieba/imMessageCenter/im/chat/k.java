package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class k extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ PersonalChatActivity bFJ;
    private final /* synthetic */ UserData bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.bFJ = personalChatActivity;
        this.bpO = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.Wy().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.bpO);
        return null;
    }
}
