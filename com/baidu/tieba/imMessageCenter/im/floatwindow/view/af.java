package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements FloatingPersonalChatView.a {
    final /* synthetic */ FloatingPersonalChatView cvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FloatingPersonalChatView floatingPersonalChatView) {
        this.cvr = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView.a
    public void delete(int i) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        list = this.cvr.mUserDataList;
        if (list != null) {
            list2 = this.cvr.mUserDataList;
            if (!list2.isEmpty()) {
                list3 = this.cvr.mUserDataList;
                UserData userData = (UserData) list3.remove(i);
                if (userData != null) {
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().ka(userData.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.cvr.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(userData.getUserId(), next.getFriendId())) {
                            this.cvr.mList.remove(next);
                            break;
                        }
                    }
                    list4 = this.cvr.mUserDataList;
                    if (list4.size() <= 0) {
                        this.cvr.akj();
                        return;
                    }
                    FloatingPersonalChatView floatingPersonalChatView = this.cvr;
                    list5 = this.cvr.mUserDataList;
                    floatingPersonalChatView.kq(list5.size() - 1);
                    this.cvr.kr(i);
                }
            }
        }
    }
}
