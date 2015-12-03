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
    final /* synthetic */ FloatingPersonalChatView ccl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FloatingPersonalChatView floatingPersonalChatView) {
        this.ccl = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView.a
    public void delete(int i) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        list = this.ccl.mUserDataList;
        if (list != null) {
            list2 = this.ccl.mUserDataList;
            if (!list2.isEmpty()) {
                list3 = this.ccl.mUserDataList;
                UserData userData = (UserData) list3.remove(i);
                if (userData != null) {
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().iZ(userData.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.ccl.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(userData.getUserId(), next.getFriendId())) {
                            this.ccl.mList.remove(next);
                            break;
                        }
                    }
                    list4 = this.ccl.mUserDataList;
                    if (list4.size() <= 0) {
                        this.ccl.acx();
                        return;
                    }
                    FloatingPersonalChatView floatingPersonalChatView = this.ccl;
                    list5 = this.ccl.mUserDataList;
                    floatingPersonalChatView.iN(list5.size() - 1);
                    this.ccl.iO(i);
                }
            }
        }
    }
}
