package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage aZp;
    final /* synthetic */ ab brY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, CustomMessage customMessage) {
        this.brY = abVar;
        this.aZp = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.aZp.getData()).getIntent().setClass(((FloatingPersonalChatActivityConfig) this.aZp.getData()).getContext(), FloatingPersonalChatActivity.class);
        if (((FloatingPersonalChatActivityConfig) this.aZp.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.aZp.getData()).startActivity();
        }
    }
}
