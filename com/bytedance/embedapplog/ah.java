package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ah extends ac {
    public int h;
    public String i;
    boolean j;
    volatile boolean k;

    @Override // com.bytedance.embedapplog.ac
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "ver_name", "varchar", "ver_code", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public ac B(@NonNull Cursor cursor) {
        this.f5776a = cursor.getLong(0);
        this.f5777b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.i = cursor.getString(3);
        this.h = cursor.getInt(4);
        this.e = cursor.getString(5);
        this.f = cursor.getString(6);
        return this;
    }

    @Override // com.bytedance.embedapplog.ac
    protected void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f5776a));
        contentValues.put("tea_event_index", Long.valueOf(this.f5777b));
        contentValues.put("session_id", this.c);
        contentValues.put("ver_name", this.i);
        contentValues.put("ver_code", Integer.valueOf(this.h));
        contentValues.put("ab_version", this.e);
        contentValues.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.ac
    protected void a(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f5776a);
        jSONObject.put("tea_event_index", this.f5777b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("ab_version", this.e);
        jSONObject.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.ac
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f5776a);
        jSONObject.put("tea_event_index", this.f5777b);
        jSONObject.put("session_id", this.c);
        if (this.j) {
            jSONObject.put("is_background", this.j);
        }
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
    protected ac eR(@NonNull JSONObject jSONObject) {
        this.f5776a = jSONObject.optLong("local_time_ms", 0L);
        this.f5777b = jSONObject.optLong("tea_event_index", 0L);
        this.c = jSONObject.optString("session_id", null);
        this.e = jSONObject.optString("ab_version", null);
        this.f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public String d() {
        return Config.LAUNCH;
    }
}
