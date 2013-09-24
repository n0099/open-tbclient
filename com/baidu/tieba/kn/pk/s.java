package com.baidu.tieba.kn.pk;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    public String f1291a;
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;
    public long g;
    public int h;
    public String i;
    public x j;
    public x k;
    private long l;

    public String d() {
        return (this.j == null || this.k == null) ? "" : String.valueOf(this.j.b) + " VS " + this.k.b;
    }

    public long e() {
        return System.currentTimeMillis() + this.l;
    }

    public boolean f() {
        return e() / 1000 >= this.f;
    }

    public boolean g() {
        return this.e > e() / 1000;
    }

    public LinkedList<y> h() {
        return this.j.m;
    }

    public LinkedList<y> i() {
        return this.k.m;
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("pk_info");
        if (optJSONObject != null) {
            this.f1291a = optJSONObject.optString("pk_id");
            this.b = optJSONObject.optString("title");
            this.c = optJSONObject.optString("abstract");
            this.d = optJSONObject.optString("pk_url");
            this.e = optJSONObject.optLong("start_time");
            this.f = optJSONObject.optLong("end_time");
            this.g = optJSONObject.optLong("server_time");
            this.l = (this.g * 1000) - System.currentTimeMillis();
            this.h = optJSONObject.optInt("status");
            this.i = optJSONObject.optString("winner_player_id");
            this.j = new x().a(optJSONObject.optJSONObject("player1"));
            this.k = new x().a(optJSONObject.optJSONObject("player2"));
            Iterator<y> it = this.j.m.iterator();
            while (it.hasNext()) {
                y next = it.next();
                next.d = this.g - next.c;
            }
            Iterator<y> it2 = this.k.m.iterator();
            while (it2.hasNext()) {
                y next2 = it2.next();
                next2.d = this.g - next2.c;
            }
        }
        a((String) null);
    }
}
