package com.baidu.tieba.model;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class ag extends com.baidu.adp.a.d {
    private final List<ImMessageCenterShowItemData> a = new LinkedList();
    private final List<ImMessageCenterShowItemData> b = new LinkedList();

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tieba.im.a<Void> aVar) {
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_validate", false);
                TiebaApplication.v();
                a(String.valueOf(2), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_updates", false);
                TiebaApplication.v();
                a(String.valueOf(3), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
                TiebaApplication.v();
                a(imMessageCenterShowItemData.getFriendId(), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
                TiebaApplication.v();
                a(imMessageCenterShowItemData.getFriendId(), aVar, true);
            }
        }
    }

    private void a(String str, com.baidu.tieba.im.a<Void> aVar, boolean z) {
        ImMessageCenterPojo a = com.baidu.tieba.im.db.h.a().d().a(str);
        if (a != null) {
            a.setIs_hidden(1);
        }
        com.baidu.tieba.im.i.a(new ah(this, z, str), new ai(this, str, aVar));
    }

    public final List<ImMessageCenterShowItemData> a() {
        return this.a;
    }

    public final void b() {
        this.a.clear();
        this.b.clear();
    }

    public static void c() {
        com.baidu.tieba.im.c.a.d().b(false, null);
    }

    public final void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.c.a.d().b(false, new aj(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.a.clear();
        if (this.b != null) {
            this.a.addAll(this.b);
        }
        com.baidu.tieba.im.c.a.d();
        if (com.baidu.tieba.im.c.a.i()) {
            ImMessageCenterShowItemData f = com.baidu.tieba.im.c.a.d().f();
            if (f != null) {
                this.a.add(f);
            } else {
                com.baidu.tieba.im.c.a.c();
                ImMessageCenterShowItemData f2 = com.baidu.tieba.im.c.a.d().f();
                if (f2 != null) {
                    this.a.add(f2);
                }
            }
        }
        com.baidu.tieba.im.c.a.d();
        if (com.baidu.tieba.im.c.a.j()) {
            ImMessageCenterShowItemData h = com.baidu.tieba.im.c.a.d().h();
            if (h != null) {
                this.a.add(h);
            } else {
                com.baidu.tieba.im.c.a.a((String) null, false);
                ImMessageCenterShowItemData h2 = com.baidu.tieba.im.c.a.d().h();
                if (h2 != null) {
                    this.a.add(h2);
                }
            }
        }
        Collections.sort(this.a, new ak(this));
    }
}
