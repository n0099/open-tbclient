package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage bbX;
    final /* synthetic */ ab buL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, CustomMessage customMessage) {
        this.buL = abVar;
        this.bbX = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.bbX.getData()).getIntent().setClass(((FloatingPersonalChatActivityConfig) this.bbX.getData()).getContext(), FloatingPersonalChatActivity.class);
        if (((FloatingPersonalChatActivityConfig) this.bbX.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.bbX.getData()).startActivity();
        }
    }
}
