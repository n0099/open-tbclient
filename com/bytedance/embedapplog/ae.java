package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ae extends ac {
    private String h;
    private String i;
    private String j;
    private String k;
    private long l;
    private long m;

    public ae(String str, String str2, String str3, long j, long j2, String str4) {
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.l = j;
        this.m = j2;
        this.k = str4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae() {
    }

    @Override // com.bytedance.embedapplog.ac
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "category", "varchar", "tag", "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", "label", "varchar", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public ac B(@NonNull Cursor cursor) {
        this.f5774a = cursor.getLong(0);
        this.f5775b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.d = cursor.getString(3);
        this.h = cursor.getString(4);
        this.i = cursor.getString(5);
        this.l = cursor.getInt(6);
        this.m = cursor.getInt(7);
        this.k = cursor.getString(8);
        this.j = cursor.getString(9);
        this.e = cursor.getString(10);
        this.f = cursor.getString(11);
        return this;
    }

    @Override // com.bytedance.embedapplog.ac
    protected void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f5774a));
        contentValues.put("tea_event_index", Long.valueOf(this.f5775b));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.d);
        contentValues.put("category", this.h);
        contentValues.put("tag", this.i);
        contentValues.put("value", Long.valueOf(this.l));
        contentValues.put("ext_value", Long.valueOf(this.m));
        contentValues.put("params", this.k);
        contentValues.put("label", this.j);
        contentValues.put("ab_version", this.e);
        contentValues.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.ac
    protected void a(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f5774a);
        jSONObject.put("tea_event_index", this.f5775b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("user_unique_id", this.d);
        jSONObject.put("category", this.h);
        jSONObject.put("tag", this.i);
        jSONObject.put("value", this.l);
        jSONObject.put("ext_value", this.m);
        jSONObject.put("params", this.k);
        jSONObject.put("label", this.j);
        jSONObject.put("ab_version", this.e);
        jSONObject.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.ac
    protected JSONObject b() {
        JSONObject jSONObject = null;
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject = new JSONObject(this.k);
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.f5774a);
        jSONObject.put("tea_event_index", this.f5775b);
        jSONObject.put("session_id", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            jSONObject.put("user_unique_id", this.d);
        }
        jSONObject.put("category", this.h);
        jSONObject.put("tag", this.i);
        jSONObject.put("value", this.l);
        jSONObject.put("ext_value", this.m);
        jSONObject.put("label", this.j);
        jSONObject.put("datetime", this.g);
        if (!TextUtils.isEmpty(this.e)) {
            jSONObject.put("ab_version", this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("ab_sdk_version", this.f);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ac
    protected ac eQ(@NonNull JSONObject jSONObject) {
        this.f5774a = jSONObject.optLong("local_time_ms", 0L);
        this.f5775b = jSONObject.optLong("tea_event_index", 0L);
        this.c = jSONObject.optString("session_id", null);
        this.d = jSONObject.optString("user_unique_id", null);
        this.h = jSONObject.optString("category", null);
        this.i = jSONObject.optString("tag", null);
        this.l = jSONObject.optLong("value", 0L);
        this.m = jSONObject.optLong("ext_value", 0L);
        this.k = jSONObject.optString("params", null);
        this.j = jSONObject.optString("label", null);
        this.e = jSONObject.optString("ab_version", null);
        this.f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public String d() {
        return "event";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ac
    public String h() {
        return "" + this.i + ", " + this.j;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }
}
