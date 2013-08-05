package com.baidu.tieba.kn.pk;

import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public String f1243a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;
    public long i;
    public int j;
    public String k;
    public int l;
    public LinkedList m;

    public x a(JSONObject jSONObject) {
        this.f1243a = jSONObject.optString("player_id");
        this.b = jSONObject.optString("player_name");
        this.c = jSONObject.optString("small_head_url");
        this.d = jSONObject.optString("big_head_url");
        this.e = jSONObject.optString("forum_name");
        this.f = jSONObject.optString("forum_id");
        this.g = jSONObject.optString("member_num");
        this.h = jSONObject.optLong("vote_number");
        this.i = jSONObject.optLong("vote_times");
        this.j = jSONObject.optInt("join_type");
        this.k = jSONObject.optString("join_type_forum_id_liststring");
        this.l = jSONObject.optInt("living");
        this.m = y.a(jSONObject.optJSONArray("users"));
        return this;
    }
}
