package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class w implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ FloatingPersonalChatActivity cvZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.cvZ = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.cvZ.caG;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.cvZ.caG;
            absMsglistView.showNotNotfiy();
        }
    }
}
