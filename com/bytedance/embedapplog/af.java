package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class af extends ac {
    @NonNull
    private String h;
    @NonNull
    private String i;

    public af(@NonNull String str, @NonNull JSONObject jSONObject) {
        this.i = str;
        this.h = jSONObject.toString();
    }

    @Override // com.bytedance.embedapplog.ac
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "params", "varchar", ExtraParamsManager.PARAM_LOG_TYPE, "varchar"};
    }

    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public ac B(@NonNull Cursor cursor) {
        this.f6073a = cursor.getLong(0);
        this.f6074b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.d = cursor.getString(3);
        this.h = cursor.getString(4);
        this.i = cursor.getString(5);
        return this;
    }

    @Override // com.bytedance.embedapplog.ac
    protected void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f6073a));
        contentValues.put("tea_event_index", Long.valueOf(this.f6074b));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.d);
        contentValues.put("params", this.h);
        contentValues.put(ExtraParamsManager.PARAM_LOG_TYPE, this.i);
    }

    @Override // com.bytedance.embedapplog.ac
    protected void a(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f6073a);
        jSONObject.put("tea_event_index", this.f6074b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("user_unique_id", this.d);
        jSONObject.put("params", this.h);
        jSONObject.put(ExtraParamsManager.PARAM_LOG_TYPE, this.i);
    }

    @Override // com.bytedance.embedapplog.ac
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f6073a);
        jSONObject.put("tea_event_index", this.f6074b);
        jSONObject.put("session_id", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            jSONObject.put("user_unique_id", this.d);
        }
        jSONObject.put(ExtraParamsManager.PARAM_LOG_TYPE, this.i);
        try {
            JSONObject jSONObject2 = new JSONObject(this.h);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    au.b("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            au.c("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ac
    protected ac eQ(@NonNull JSONObject jSONObject) {
        this.f6073a = jSONObject.optLong("local_time_ms", 0L);
        this.f6074b = jSONObject.optLong("tea_event_index", 0L);
        this.c = jSONObject.optString("session_id", null);
        this.d = jSONObject.optString("user_unique_id", null);
        this.h = jSONObject.optString("params", null);
        this.i = jSONObject.optString(ExtraParamsManager.PARAM_LOG_TYPE, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public String d() {
        return "event_misc";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ac
    public String h() {
        return "param:" + this.h + " logType:" + this.i;
    }
}
