package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView buY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FloatingPersonalChatView floatingPersonalChatView) {
        this.buY = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean WI;
        ap apVar;
        List list;
        int i;
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        WI = this.buY.WI();
        if (!WI) {
            apVar = this.buY.buW;
            list = this.buY.mUserDataList;
            i = this.buY.currentIndex;
            if (apVar.hP(((UserData) list.get(i)).getUserId())) {
                this.buY.sendSoftkeyEvent();
                return;
            }
            floatingPersonalChatActivity = this.buY.buL;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.t.add_friend_cannot_send);
        }
    }
}
