package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.bNh = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        floatingPersonalChatActivity = this.bNh.bMU;
        floatingPersonalChatActivity.showToast(i.h.add_friend_cannot_send);
    }
}
