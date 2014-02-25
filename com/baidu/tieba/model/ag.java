package com.baidu.tieba.model;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.a.d {
    private final List<ImMessageCenterShowItemData> a = new LinkedList();
    private final List<ImMessageCenterShowItemData> b = new LinkedList();

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tieba.im.a<Void> aVar) {
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_validate", false);
                a(TiebaApplication.A(), String.valueOf(2), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_updates", false);
                a(TiebaApplication.A(), String.valueOf(3), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
                a(TiebaApplication.A(), imMessageCenterShowItemData.getFriendId(), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
                a(TiebaApplication.A(), imMessageCenterShowItemData.getFriendId(), aVar, true);
            }
        }
    }

    private void a(String str, String str2, com.baidu.tieba.im.a<Void> aVar, boolean z) {
        ImMessageCenterPojo a = com.baidu.tieba.im.db.h.a().d().a(str2);
        if (a != null) {
            a.setIs_hidden(1);
        }
        com.baidu.tieba.im.j.a(new ah(this, z, str2), new ai(this, str2, aVar));
    }

    public List<ImMessageCenterShowItemData> a() {
        return this.a;
    }

    public void b() {
        this.a.clear();
        this.b.clear();
    }

    public static void a(String str) {
        com.baidu.tieba.im.c.a.f().b(false, null);
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.c.a.f().b(false, new aj(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        this.a.clear();
        if (this.b != null) {
            this.a.addAll(this.b);
        }
        if (com.baidu.tieba.im.c.a.f().m()) {
            ImMessageCenterShowItemData j = com.baidu.tieba.im.c.a.f().j();
            if (j != null) {
                this.a.add(j);
            } else {
                com.baidu.tieba.im.c.a.e();
                ImMessageCenterShowItemData j2 = com.baidu.tieba.im.c.a.f().j();
                if (j2 != null) {
                    this.a.add(j2);
                }
            }
        }
        if (com.baidu.tieba.im.c.a.f().n()) {
            ImMessageCenterShowItemData l = com.baidu.tieba.im.c.a.f().l();
            if (l != null) {
                this.a.add(l);
            } else {
                com.baidu.tieba.im.c.a.a((String) null, false);
                ImMessageCenterShowItemData l2 = com.baidu.tieba.im.c.a.f().l();
                if (l2 != null) {
                    this.a.add(l2);
                }
            }
        }
        Collections.sort(this.a, new ak(this));
    }
}
