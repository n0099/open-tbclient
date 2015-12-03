package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView ccl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.ccl = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        floatingPersonalChatActivity = this.ccl.cbY;
        floatingPersonalChatActivity.showToast(n.i.add_friend_cannot_send);
    }
}
