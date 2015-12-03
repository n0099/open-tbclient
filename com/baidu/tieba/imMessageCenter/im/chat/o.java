package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.util.d<Void> {
    private final /* synthetic */ CustomMessage bJh;
    final /* synthetic */ m bZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.bZj = mVar;
        this.bJh = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.bJh.getData()).getIntent();
        if (((PersonalChatActivityConfig) this.bJh.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.bJh.getData()).startActivity(PersonalChatActivity.class);
        }
    }
}
