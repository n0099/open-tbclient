package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class k extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ UserData bQJ;
    final /* synthetic */ PersonalChatActivity chF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.chF = personalChatActivity;
        this.bQJ = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.aeU().b(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.bQJ);
        return null;
    }
}
