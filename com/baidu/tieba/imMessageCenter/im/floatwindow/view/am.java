package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bsm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FloatingPersonalChatView floatingPersonalChatView) {
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
                this.bsm.SendMore1Event();
                return;
            }
            floatingPersonalChatActivity = this.bsm.brZ;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.y.add_friend_cannot_send);
        }
    }
}
