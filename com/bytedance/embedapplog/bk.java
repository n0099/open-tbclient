package com.bytedance.embedapplog;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class bk {

    /* renamed from: a  reason: collision with root package name */
    final String f6101a;

    /* renamed from: b  reason: collision with root package name */
    final String f6102b;
    final Boolean c;
    final Long d;
    final Long e;
    final Long g;
    final Integer phg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.f6101a = str;
        this.f6102b = str2;
        this.c = bool;
        this.d = l;
        this.e = l2;
        this.phg = num;
        this.g = l3;
    }

    public String toString() {
        return b().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        bh.a(hashMap, "id", this.f6101a);
        bh.a(hashMap, "req_id", this.f6102b);
        bh.a(hashMap, "is_track_limited", String.valueOf(this.c));
        bh.a(hashMap, "take_ms", String.valueOf(this.d));
        bh.a(hashMap, "time", String.valueOf(this.e));
        bh.a(hashMap, "query_times", String.valueOf(this.phg));
        bh.a(hashMap, "hw_id_version_code", String.valueOf(this.g));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        bh.a(jSONObject, "id", this.f6101a);
        bh.a(jSONObject, "req_id", this.f6102b);
        bh.a(jSONObject, "is_track_limited", this.c);
        bh.a(jSONObject, "take_ms", this.d);
        bh.a(jSONObject, "time", this.e);
        bh.a(jSONObject, "query_times", this.phg);
        bh.a(jSONObject, "hw_id_version_code", this.g);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @AnyThread
    public static bk YF(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new bk(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
