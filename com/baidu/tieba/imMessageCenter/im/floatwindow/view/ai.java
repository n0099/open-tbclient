package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.UserData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements ao {
    final /* synthetic */ FloatingPersonalChatView bsm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FloatingPersonalChatView floatingPersonalChatView) {
        this.bsm = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.ao
    public void delete(int i) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        list = this.bsm.mUserDataList;
        if (list != null) {
            list2 = this.bsm.mUserDataList;
            if (!list2.isEmpty()) {
                list3 = this.bsm.mUserDataList;
                UserData userData = (UserData) list3.remove(i);
                if (userData != null) {
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy().hk(userData.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.bsm.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(userData.getUserId(), next.getFriendId())) {
                            this.bsm.mList.remove(next);
                            break;
                        }
                    }
                    list4 = this.bsm.mUserDataList;
                    if (list4.size() <= 0) {
                        this.bsm.Vr();
                        return;
                    }
                    FloatingPersonalChatView floatingPersonalChatView = this.bsm;
                    list5 = this.bsm.mUserDataList;
                    floatingPersonalChatView.gB(list5.size() - 1);
                    this.bsm.gC(i);
                }
            }
        }
    }
}
