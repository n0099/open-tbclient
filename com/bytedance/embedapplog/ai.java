package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.cache.BdCacheNSItem;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ai extends ac {
    private JSONObject asJ;
    public byte[] h;
    int i;
    public int j;
    private JSONArray k;
    private JSONArray l;
    private ah pco;
    private JSONArray pcp;
    private am pcq;
    private JSONArray q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, JSONObject jSONObject, ah ahVar, am amVar, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        this.f5774a = j;
        this.asJ = jSONObject;
        this.pco = ahVar;
        this.pcq = amVar;
        if ("autoChina".contains("Base") || "autoChina".contains(SchemeCollecter.CLASSIFY_BASE)) {
            this.pcp = null;
        } else {
            this.pcp = jSONArray;
        }
        this.k = jSONArray2;
        this.l = jSONArray3;
        this.q = jSONArray4;
    }

    @Override // com.bytedance.embedapplog.ac
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "_data", BdCacheNSItem.CACHE_TYPE_BLOB, "_fail", "integer", "_full", "integer"};
    }

    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public ac B(@NonNull Cursor cursor) {
        this.f5774a = cursor.getLong(0);
        this.h = cursor.getBlob(1);
        this.i = cursor.getInt(2);
        this.asJ = null;
        this.pco = null;
        this.pcq = null;
        this.pcp = null;
        this.k = null;
        this.l = null;
        this.q = null;
        return this;
    }

    @Override // com.bytedance.embedapplog.ac
    protected void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_data", b.Xt(f().toString()));
    }

    @Override // com.bytedance.embedapplog.ac
    protected void a(@NonNull JSONObject jSONObject) {
        au.a(null);
    }

    @Override // com.bytedance.embedapplog.ac
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, this.asJ);
        jSONObject.put("time_sync", aa.f5770a);
        if (this.pco != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.pco.f());
            jSONObject.put(Config.LAUNCH, jSONArray);
        }
        if (this.pcq != null) {
            JSONObject f = this.pcq.f();
            int length = this.pcp != null ? this.pcp.length() : 0;
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < length; i++) {
                JSONArray jSONArray3 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(new JSONObject(this.pcp.optString(i)).optString("params"));
                jSONArray3.put(0, jSONObject2.optString("page_key", ""));
                jSONArray3.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
                jSONArray2.put(jSONArray3);
            }
            if (length > 0) {
                f.put("activites", jSONArray2);
            }
            JSONArray jSONArray4 = new JSONArray();
            jSONArray4.put(f);
            jSONObject.put("terminate", jSONArray4);
        }
        int length2 = this.k != null ? this.k.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.k);
        }
        int length3 = this.pcp != null ? this.pcp.length() : 0;
        if (this.l == null) {
            this.l = this.pcp;
        } else if (length3 > 0) {
            for (int i2 = 0; i2 < length3; i2++) {
                this.l.put(this.pcp.get(i2));
            }
        }
        int length4 = this.l != null ? this.l.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.l);
        }
        int length5 = this.q != null ? this.q.length() : 0;
        if (length5 > 0) {
            jSONObject.put(ExtraParamsManager.PARAM_LOG_DATA, this.q);
        }
        StringBuilder sb = new StringBuilder("wP {");
        sb.append(this.pco != null ? this.pco : "la");
        sb.append(", ").append(this.pcq != null ? this.pcq : "te");
        sb.append(", p: ").append(length3);
        sb.append(", v1: ").append(length2);
        sb.append(", v3: ").append(length4).append("}");
        sb.append(", m: ").append(length5).append("}");
        au.d(sb.toString(), null);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ac
    protected ac eQ(@NonNull JSONObject jSONObject) {
        au.a(null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.ac
    @NonNull
    public String d() {
        return "pack";
    }
}
