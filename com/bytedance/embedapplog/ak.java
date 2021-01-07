package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ak extends ac {
    static String h = "succEvent";
    public int i;
    private String j;
    private int k;
    private String l;
    private int m;
    private long n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak() {
    }

    public ak(String str, String str2, int i) {
        this.k = 1;
        this.i = b.eoX();
        this.j = str;
        this.l = str2;
        this.m = i;
        this.n = at.a();
    }

    @Override // com.bytedance.embedapplog.ac
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", LuaMessageHelper.KEY_EVENT_NAME, "varchar", "is_monitor", "integer", "bav_monitor_rate", "integer", "monitor_status", "varchar", "monitor_num", "integer", "date", "integer"};
    }

    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public ac B(@NonNull Cursor cursor) {
        this.f6074a = cursor.getLong(0);
        this.f6075b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.d = cursor.getString(3);
        this.j = cursor.getString(4);
        this.k = cursor.getInt(5);
        this.i = cursor.getInt(6);
        this.l = cursor.getString(7);
        this.m = cursor.getInt(8);
        this.n = cursor.getLong(9);
        return this;
    }

    @Override // com.bytedance.embedapplog.ac
    protected void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f6074a));
        contentValues.put("tea_event_index", Long.valueOf(this.f6075b));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.d);
        contentValues.put(LuaMessageHelper.KEY_EVENT_NAME, this.j);
        contentValues.put("is_monitor", Integer.valueOf(this.k));
        contentValues.put("bav_monitor_rate", Integer.valueOf(this.i));
        contentValues.put("monitor_status", this.l);
        contentValues.put("monitor_num", Integer.valueOf(this.m));
        contentValues.put("date", Long.valueOf(this.n));
    }

    @Override // com.bytedance.embedapplog.ac
    protected void a(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f6074a);
        jSONObject.put("tea_event_index", this.f6075b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("user_unique_id", this.d);
        jSONObject.put(LuaMessageHelper.KEY_EVENT_NAME, this.j);
        jSONObject.put("is_monitor", this.k);
        jSONObject.put("bav_monitor_rate", this.i);
        jSONObject.put("monitor_status", this.l);
        jSONObject.put("monitor_num", this.m);
        jSONObject.put("date", this.n);
    }

    @Override // com.bytedance.embedapplog.ac
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LuaMessageHelper.KEY_EVENT_NAME, this.j);
        jSONObject.put("is_monitor", this.k);
        jSONObject.put("bav_monitor_rate", this.i);
        jSONObject.put("monitor_status", this.l);
        jSONObject.put("monitor_num", this.m);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ac
    protected ac eQ(@NonNull JSONObject jSONObject) {
        this.f6074a = jSONObject.optLong("local_time_ms", 0L);
        this.f6075b = jSONObject.optLong("tea_event_index", 0L);
        this.c = jSONObject.optString("session_id", null);
        this.d = jSONObject.optString("user_unique_id", null);
        this.j = jSONObject.optString(LuaMessageHelper.KEY_EVENT_NAME, null);
        this.k = jSONObject.optInt("is_monitor", 0);
        this.i = jSONObject.optInt("bav_monitor_rate", 0);
        this.l = jSONObject.optString("monitor_status", null);
        this.m = jSONObject.optInt("monitor_num", 0);
        this.n = jSONObject.optLong("date", 0L);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public String d() {
        return h;
    }
}
