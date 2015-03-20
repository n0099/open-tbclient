package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage aYZ;
    final /* synthetic */ m bpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, CustomMessage customMessage) {
        this.bpb = mVar;
        this.aYZ = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.aYZ.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.aYZ.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.aYZ.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.aYZ.getData()).startActivity();
        }
    }
}
