package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView dqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FloatingPersonalChatView floatingPersonalChatView) {
        this.dqj = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        floatingPersonalChatActivity = this.dqj.dpW;
        floatingPersonalChatActivity.showToast(t.j.add_friend_cannot_send);
    }
}
