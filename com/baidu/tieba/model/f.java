package com.baidu.tieba.model;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.d {
    private String i;

    /* renamed from: a  reason: collision with root package name */
    private List<RecentChatFriendData> f1920a = new LinkedList();
    private List<RecentChatFriendData> b = new LinkedList();
    private List<RecentChatFriendData> c = new LinkedList();
    private String d = null;
    private String e = null;
    private String f = SocialConstants.TRUE;
    private String g = "20";
    private int h = -1;
    private boolean j = false;
    private n k = null;
    private l l = null;

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public boolean a(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return false;
        }
        this.d = str;
        this.f = str2;
        if (this.k == null) {
            this.k = new n(this, null);
            this.k.setPriority(2);
            this.k.execute(new Object[0]);
        }
        return true;
    }

    public void a(String str) {
        if (str != null && str.length() > 0) {
            this.e = str;
            if (this.l == null) {
                this.l = new l(this, null);
                this.l.setPriority(2);
                this.l.execute(new Object[0]);
            }
        }
    }

    public void a(RecentChatFriendData recentChatFriendData, com.baidu.tieba.im.a<Void> aVar) {
        if (recentChatFriendData != null) {
            if (recentChatFriendData.getOwnerName() == null) {
                a(recentChatFriendData.getFriendId());
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(2))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_validate", false);
                com.baidu.tieba.im.pushNotify.a.g().b();
                a(TiebaApplication.A(), String.valueOf(2), aVar);
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(3))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_updates", false);
                com.baidu.tieba.im.pushNotify.a.g().a();
                a(TiebaApplication.A(), String.valueOf(3), aVar);
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(1))) {
                a(TiebaApplication.A(), recentChatFriendData.getFriendId(), aVar);
            } else {
                a(recentChatFriendData.getFriendId());
            }
        }
    }

    private void a(String str, String str2, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.data.chat.c.a().c(str, str2);
        com.baidu.tieba.im.db.x.a().a(new g(this, str2, aVar));
    }

    public List<RecentChatFriendData> a() {
        return this.f1920a;
    }

    public void b() {
        this.f1920a.clear();
        this.b.clear();
        this.c.clear();
    }

    public static void b(String str) {
        com.baidu.tieba.data.chat.c.a().a(str, 0, null);
        com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) null);
    }

    public void c(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    a(optJSONObject.optInt("errno"));
                    e(optJSONObject.optString("usermsg"));
                }
                this.j = jSONObject.optInt("has_more") != 0;
                JSONArray optJSONArray = jSONObject.optJSONArray("record");
                long currentTimeMillis = System.currentTimeMillis();
                if (optJSONArray != null) {
                    this.c = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        RecentChatFriendData recentChatFriendData = new RecentChatFriendData();
                        recentChatFriendData.setOwnerId(this.d);
                        recentChatFriendData.setFriendId(optJSONObject2.optString(PushConstants.EXTRA_USER_ID));
                        recentChatFriendData.setFriendName(optJSONObject2.optString("user_name"));
                        recentChatFriendData.setStatus(1);
                        recentChatFriendData.setServerTime(optJSONObject2.optLong("time") * 1000);
                        recentChatFriendData.setUnReadCount(optJSONObject2.optInt("unread_count"));
                        recentChatFriendData.setFriendPortrait(optJSONObject2.optString("portrait"));
                        recentChatFriendData.setLocalTime(currentTimeMillis);
                        String optString = optJSONObject2.optString("abstract");
                        if (optString != null && optString.length() >= 1) {
                            recentChatFriendData.setMsgContent(optString);
                        }
                        this.c.add(recentChatFriendData);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public List<RecentChatFriendData> d(String str) {
        this.f1920a = com.baidu.tieba.data.chat.c.a().a(str);
        for (RecentChatFriendData recentChatFriendData : this.f1920a) {
            recentChatFriendData.setUnReadCount(0);
        }
        return this.f1920a;
    }

    public boolean c() {
        return this.j;
    }

    public void a(int i) {
        this.h = i;
    }

    public int d() {
        return this.h;
    }

    public void e(String str) {
        this.i = str;
    }

    public String e() {
        return this.i;
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) new j(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        this.f1920a.clear();
        if (this.b != null) {
            this.f1920a.addAll(this.b);
        }
        if (this.c != null) {
            this.f1920a.addAll(this.c);
        }
        if (com.baidu.tieba.im.pushNotify.a.g().n()) {
            RecentChatFriendData k = com.baidu.tieba.im.pushNotify.a.g().k();
            if (k != null) {
                this.f1920a.add(k);
            } else {
                com.baidu.tieba.im.pushNotify.a.f();
                RecentChatFriendData k2 = com.baidu.tieba.im.pushNotify.a.g().k();
                if (k2 != null) {
                    this.f1920a.add(k2);
                }
            }
        }
        if (com.baidu.tieba.im.pushNotify.a.g().o()) {
            RecentChatFriendData m = com.baidu.tieba.im.pushNotify.a.g().m();
            if (m != null) {
                this.f1920a.add(m);
            } else {
                com.baidu.tieba.im.pushNotify.a.a(false);
                RecentChatFriendData m2 = com.baidu.tieba.im.pushNotify.a.g().m();
                if (m2 != null) {
                    this.f1920a.add(m2);
                }
            }
        }
        Collections.sort(this.f1920a, new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.baidu.adp.lib.h.d.d(" get recent list private");
        if (this.c != null) {
            long j = 0;
            Iterator<RecentChatFriendData> it = this.c.iterator();
            while (true) {
                long j2 = j;
                if (it.hasNext()) {
                    j = j2 + it.next().getUnReadCount();
                } else {
                    com.baidu.tieba.mention.t.a().d(j2);
                    com.baidu.tieba.data.chat.c.a().a(TiebaApplication.A(), this.c);
                    this.c = com.baidu.tieba.data.chat.c.a().a(TiebaApplication.A());
                    return;
                }
            }
        }
    }
}
