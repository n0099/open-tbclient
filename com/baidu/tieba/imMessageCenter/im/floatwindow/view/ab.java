package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.imMessageCenter.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.util.g<Void> {
    private final /* synthetic */ CustomMessage cbL;
    final /* synthetic */ z cwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, CustomMessage customMessage) {
        this.cwa = zVar;
        this.cbL = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.cbL.getData()).getIntent();
        if (((FloatingPersonalChatActivityConfig) this.cbL.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.cbL.getData()).startActivity(FloatingPersonalChatActivity.class);
        }
    }
}
