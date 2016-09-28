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
    final /* synthetic */ FloatingPersonalChatView drG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FloatingPersonalChatView floatingPersonalChatView) {
        this.drG = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView.a
    public void delete(int i) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        list = this.drG.mUserDataList;
        if (list != null) {
            list2 = this.drG.mUserDataList;
            if (!list2.isEmpty()) {
                list3 = this.drG.mUserDataList;
                UserData userData = (UserData) list3.remove(i);
                if (userData != null) {
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.axL().mz(userData.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.drG.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(userData.getUserId(), next.getFriendId())) {
                            this.drG.mList.remove(next);
                            break;
                        }
                    }
                    list4 = this.drG.mUserDataList;
                    if (list4.size() <= 0) {
                        this.drG.ayD();
                        return;
                    }
                    FloatingPersonalChatView floatingPersonalChatView = this.drG;
                    list5 = this.drG.mUserDataList;
                    floatingPersonalChatView.mn(list5.size() - 1);
                    this.drG.mo(i);
                }
            }
        }
    }
}
