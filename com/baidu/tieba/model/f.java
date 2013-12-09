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
    private String j;

    /* renamed from: a  reason: collision with root package name */
    private List<RecentChatFriendData> f2033a = new LinkedList();
    private List<RecentChatFriendData> b = new LinkedList();
    private List<RecentChatFriendData> c = new LinkedList();
    private List<RecentChatFriendData> d = new LinkedList();
    private String e = null;
    private String f = null;
    private String g = SocialConstants.TRUE;
    private String h = "20";
    private int i = -1;
    private boolean k = false;
    private n l = null;
    private l m = null;

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
        this.e = str;
        this.g = str2;
        if (this.l == null) {
            this.l = new n(this, null);
            this.l.setPriority(2);
            this.l.execute(new Object[0]);
        }
        return true;
    }

    public void a(String str) {
        if (str != null && str.length() > 0) {
            this.f = str;
            if (this.m == null) {
                this.m = new l(this, null);
                this.m.setPriority(2);
                this.m.execute(new Object[0]);
            }
        }
    }

    public void a(RecentChatFriendData recentChatFriendData, com.baidu.tieba.im.a<Void> aVar) {
        if (recentChatFriendData != null) {
            if (recentChatFriendData.getOwnerName() == null) {
                a(recentChatFriendData.getFriendId());
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(2))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_validate", false);
                com.baidu.tieba.im.pushNotify.a.h().b();
                a(TiebaApplication.B(), String.valueOf(2), aVar);
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(3))) {
                com.baidu.tieba.sharedPref.b.a().b("is_show_updates", false);
                com.baidu.tieba.im.pushNotify.a.h().a();
                a(TiebaApplication.B(), String.valueOf(3), aVar);
            } else if (recentChatFriendData.getOwnerName().equals(String.valueOf(1))) {
                a(TiebaApplication.B(), recentChatFriendData.getFriendId(), aVar);
            } else {
                a(recentChatFriendData.getFriendId());
            }
        }
    }

    private void a(String str, String str2, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.data.chat.c.a().c(str, str2);
        com.baidu.tieba.im.db.ad.a().a(new g(this, str2, aVar));
    }

    public List<RecentChatFriendData> a() {
        return this.f2033a;
    }

    public void b() {
        this.f2033a.clear();
        this.b.clear();
        this.c.clear();
    }

    public static void b(String str) {
        com.baidu.tieba.data.chat.c.a().a(str, 0, null);
        com.baidu.tieba.im.pushNotify.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
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
                this.k = jSONObject.optInt("has_more") != 0;
                JSONArray optJSONArray = jSONObject.optJSONArray("record");
                long currentTimeMillis = System.currentTimeMillis();
                if (optJSONArray != null) {
                    this.d = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        RecentChatFriendData recentChatFriendData = new RecentChatFriendData();
                        recentChatFriendData.setOwnerId(this.e);
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
                        this.d.add(recentChatFriendData);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public List<RecentChatFriendData> d(String str) {
        this.f2033a = com.baidu.tieba.data.chat.c.a().a(str);
        for (RecentChatFriendData recentChatFriendData : this.f2033a) {
            recentChatFriendData.setUnReadCount(0);
        }
        return this.f2033a;
    }

    public boolean c() {
        return this.k;
    }

    public void a(int i) {
        this.i = i;
    }

    public int d() {
        return this.i;
    }

    public void e(String str) {
        this.j = str;
    }

    public String e() {
        return this.j;
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.pushNotify.a.h().b(false, (com.baidu.tieba.im.a<Void>) new j(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        this.f2033a.clear();
        if (this.b != null) {
            this.f2033a.addAll(this.b);
        }
        if (this.c != null) {
            this.f2033a.addAll(this.c);
        }
        if (com.baidu.tieba.im.pushNotify.a.h().o()) {
            RecentChatFriendData l = com.baidu.tieba.im.pushNotify.a.h().l();
            if (l != null) {
                this.f2033a.add(l);
            } else {
                com.baidu.tieba.im.pushNotify.a.g();
                RecentChatFriendData l2 = com.baidu.tieba.im.pushNotify.a.h().l();
                if (l2 != null) {
                    this.f2033a.add(l2);
                }
            }
        }
        if (com.baidu.tieba.im.pushNotify.a.h().p()) {
            RecentChatFriendData n = com.baidu.tieba.im.pushNotify.a.h().n();
            if (n != null) {
                this.f2033a.add(n);
            } else {
                com.baidu.tieba.im.pushNotify.a.a(false);
                RecentChatFriendData n2 = com.baidu.tieba.im.pushNotify.a.h().n();
                if (n2 != null) {
                    this.f2033a.add(n2);
                }
            }
        }
        Collections.sort(this.f2033a, new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.baidu.adp.lib.h.e.d(" get recent list private");
        if (this.d != null) {
            long j = 0;
            Iterator<RecentChatFriendData> it = this.d.iterator();
            while (true) {
                long j2 = j;
                if (it.hasNext()) {
                    j = j2 + it.next().getUnReadCount();
                } else {
                    com.baidu.tieba.mention.t.a().d(j2);
                    com.baidu.tieba.data.chat.c.a().a(TiebaApplication.B(), this.d);
                    return;
                }
            }
        }
    }
}
