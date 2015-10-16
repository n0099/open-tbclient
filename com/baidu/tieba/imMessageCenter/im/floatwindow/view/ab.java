package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.imMessageCenter.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ z bMy;
    private final /* synthetic */ CustomMessage btC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, CustomMessage customMessage) {
        this.bMy = zVar;
        this.btC = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.btC.getData()).getIntent();
        if (((FloatingPersonalChatActivityConfig) this.btC.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.btC.getData()).startActivity(FloatingPersonalChatActivity.class);
        }
    }
}
