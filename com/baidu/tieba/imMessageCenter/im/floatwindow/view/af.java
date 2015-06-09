package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView buZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FloatingPersonalChatView floatingPersonalChatView) {
        this.buZ = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean WJ;
        ap apVar;
        List list;
        int i;
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        WJ = this.buZ.WJ();
        if (!WJ) {
            apVar = this.buZ.buX;
            list = this.buZ.mUserDataList;
            i = this.buZ.currentIndex;
            if (apVar.hP(((UserData) list.get(i)).getUserId())) {
                this.buZ.sendMore2Event();
                return;
            }
            floatingPersonalChatActivity = this.buZ.buM;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.t.add_friend_cannot_send);
        }
    }
}
