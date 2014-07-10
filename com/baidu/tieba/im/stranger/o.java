package com.baidu.tieba.im.stranger;

import android.text.TextUtils;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class o {
    private final LinkedList<ImMessageCenterShowItemData> a = new LinkedList<>();

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tieba.im.a<Void> aVar) {
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                a(friendId, aVar);
                Iterator<ImMessageCenterShowItemData> it = this.a.iterator();
                while (it.hasNext()) {
                    if (friendId.equals(it.next().getFriendId())) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void a(String str, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str)) {
            ImMessageCenterPojo a = com.baidu.tieba.im.b.k.a().a(str);
            if (a != null) {
                a.setIs_hidden(1);
                a.setUnread_count(0);
            }
            com.baidu.tieba.im.i.a(new p(this, str), new q(this, str, aVar));
        }
    }

    public void a() {
        this.a.clear();
    }

    public LinkedList<ImMessageCenterShowItemData> b() {
        return this.a;
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.pushNotify.a.i().b(false, (com.baidu.tieba.im.a<Void>) new r(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.a != null && this.a.size() != 0) {
            Collections.sort(this.a, new s(this));
        }
    }

    public void a(l lVar) {
        LinkedList linkedList = new LinkedList();
        Iterator<ImMessageCenterShowItemData> it = this.a.iterator();
        while (it.hasNext()) {
            String friendId = it.next().getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                linkedList.add(friendId);
                ImMessageCenterPojo a = com.baidu.tieba.im.b.k.a().a(friendId);
                if (a != null) {
                    a.setIs_hidden(1);
                    a.setUnread_count(0);
                }
            }
        }
        a();
        com.baidu.tieba.im.i.a(new t(this, linkedList), new u(this, lVar));
    }
}
