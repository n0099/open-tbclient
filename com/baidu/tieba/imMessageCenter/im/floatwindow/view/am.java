package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView brW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FloatingPersonalChatView floatingPersonalChatView) {
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
                this.brW.SendMore1Event();
                return;
            }
            floatingPersonalChatActivity = this.brW.brJ;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.y.add_friend_cannot_send);
        }
    }
}
