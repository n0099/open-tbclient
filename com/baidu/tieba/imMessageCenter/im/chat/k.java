package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class k extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData bbS;
    final /* synthetic */ PersonalChatActivity brU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalChatActivity personalChatActivity, UserData userData) {
        this.brU = personalChatActivity;
        this.bbS = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.UQ().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.bbS);
        return null;
    }
}
