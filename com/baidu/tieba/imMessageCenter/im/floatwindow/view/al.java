package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView brW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FloatingPersonalChatView floatingPersonalChatView) {
        this.brW = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean Vd;
        ap apVar;
        List list;
        int i;
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        Vd = this.brW.Vd();
        if (!Vd) {
            apVar = this.brW.brU;
            list = this.brW.mUserDataList;
            i = this.brW.currentIndex;
            if (apVar.hj(((UserData) list.get(i)).getUserId())) {
                this.brW.sendSoftkeyEvent();
                return;
            }
            floatingPersonalChatActivity = this.brW.brJ;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.y.add_friend_cannot_send);
        }
    }
}
