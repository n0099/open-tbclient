package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bsm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FloatingPersonalChatView floatingPersonalChatView) {
        this.bsm = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean Vq;
        ap apVar;
        List list;
        int i;
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        Vq = this.bsm.Vq();
        if (!Vq) {
            apVar = this.bsm.bsk;
            list = this.bsm.mUserDataList;
            i = this.bsm.currentIndex;
            if (apVar.hm(((UserData) list.get(i)).getUserId())) {
                this.bsm.sendMore2Event();
                return;
            }
            floatingPersonalChatActivity = this.bsm.brZ;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.y.add_friend_cannot_send);
        }
    }
}
