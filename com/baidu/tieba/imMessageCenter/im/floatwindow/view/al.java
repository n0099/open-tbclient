package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView buZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FloatingPersonalChatView floatingPersonalChatView) {
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
                this.buZ.sendSoftkeyEvent();
                return;
            }
            floatingPersonalChatActivity = this.buZ.buM;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.t.add_friend_cannot_send);
        }
    }
}
