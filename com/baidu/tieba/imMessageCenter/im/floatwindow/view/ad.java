package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage bbW;
    final /* synthetic */ ab buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, CustomMessage customMessage) {
        this.buK = abVar;
        this.bbW = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.bbW.getData()).getIntent().setClass(((FloatingPersonalChatActivityConfig) this.bbW.getData()).getContext(), FloatingPersonalChatActivity.class);
        if (((FloatingPersonalChatActivityConfig) this.bbW.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.bbW.getData()).startActivity();
        }
    }
}
