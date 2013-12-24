package com.baidu.tieba.model;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.a.d {
    private List<RecentChatFriendData> a = new LinkedList();
    private List<RecentChatFriendData> b = new LinkedList();

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(RecentChatFriendData recentChatFriendData, com.baidu.tieba.im.a<Void> aVar) {
        if (recentChatFriendData != null && recentChatFriendData.getOwnerName() != null) {
            if (recentChatFriendData.getOwnerName().equals(String.valueOf(2))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_validate", false);
                com.baidu.tieba.im.c.a.h().b();
                a(TiebaApplication.B(), String.valueOf(2), aVar);
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(3))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_updates", false);
                com.baidu.tieba.im.c.a.h().a();
                a(TiebaApplication.B(), String.valueOf(3), aVar);
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(1))) {
                a(TiebaApplication.B(), recentChatFriendData.getFriendId(), aVar);
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(4))) {
                a(TiebaApplication.B(), recentChatFriendData.getFriendId(), aVar);
            }
        }
    }

    private void a(String str, String str2, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.data.chat.c.a().a(str, str2);
        com.baidu.tieba.im.db.ad.a().a(new j(this, str2, aVar));
    }

    public List<RecentChatFriendData> a() {
        return this.a;
    }

    public void b() {
        this.a.clear();
        this.b.clear();
    }

    public static void a(String str) {
        com.baidu.tieba.data.chat.c.a().a(str, 0, null);
        com.baidu.tieba.im.c.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
    }

    public List<RecentChatFriendData> b(String str) {
        this.a = com.baidu.tieba.data.chat.c.a().a(str);
        for (RecentChatFriendData recentChatFriendData : this.a) {
            recentChatFriendData.setUnReadCount(0);
        }
        return this.a;
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.c.a.h().b(false, (com.baidu.tieba.im.a<Void>) new m(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        this.a.clear();
        if (this.b != null) {
            this.a.addAll(this.b);
        }
        if (com.baidu.tieba.im.c.a.h().o()) {
            RecentChatFriendData l = com.baidu.tieba.im.c.a.h().l();
            if (l != null) {
                this.a.add(l);
            } else {
                com.baidu.tieba.im.c.a.g();
                RecentChatFriendData l2 = com.baidu.tieba.im.c.a.h().l();
                if (l2 != null) {
                    this.a.add(l2);
                }
            }
        }
        if (com.baidu.tieba.im.c.a.h().p()) {
            RecentChatFriendData n = com.baidu.tieba.im.c.a.h().n();
            if (n != null) {
                this.a.add(n);
            } else {
                com.baidu.tieba.im.c.a.a(false);
                RecentChatFriendData n2 = com.baidu.tieba.im.c.a.h().n();
                if (n2 != null) {
                    this.a.add(n2);
                }
            }
        }
        Collections.sort(this.a, new n(this));
    }
}
