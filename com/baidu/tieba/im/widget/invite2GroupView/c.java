package com.baidu.tieba.im.widget.invite2GroupView;

import android.widget.Button;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.u;
import com.slidingmenu.lib.R;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ Invite2GroupView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Invite2GroupView invite2GroupView) {
        this.a = invite2GroupView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        InviteMsgData inviteMsgData;
        InviteMsgData inviteMsgData2;
        InviteMsgData inviteMsgData3;
        Button button;
        Button button2;
        Button button3;
        if (concurrentHashMap != null) {
            inviteMsgData2 = this.a.e;
            if (concurrentHashMap.containsKey(String.valueOf(inviteMsgData2.getGroupId()))) {
                inviteMsgData3 = this.a.e;
                String valueOf = String.valueOf(inviteMsgData3.getGroupId());
                button = this.a.d;
                if (valueOf.equals(button.getTag())) {
                    button2 = this.a.d;
                    button2.setText(R.string.i_want_talk);
                    button3 = this.a.d;
                    button3.setOnClickListener(new d(this));
                    return;
                }
                return;
            }
        }
        String A = TiebaApplication.A();
        inviteMsgData = this.a.e;
        u.a(A, String.valueOf(inviteMsgData.getGroupId()), 60000L, new e(this));
    }
}
