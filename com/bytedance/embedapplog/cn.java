package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5826a;
    private final SharedPreferences c;
    private final SharedPreferences e;
    private volatile JSONObject f;
    private volatile JSONObject g;
    private final l pdh;
    private final SharedPreferences pdi;

    public cn(Context context, l lVar) {
        this.f5826a = context;
        this.pdh = lVar;
        this.e = this.f5826a.getSharedPreferences("embed_applog_stats", 0);
        this.c = this.f5826a.getSharedPreferences("embed_header_custom", 0);
        this.pdi = this.f5826a.getSharedPreferences("embed_last_sp_session", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.pdh.eli();
    }

    public String c() {
        return this.pdi.getString("session_last_day", "");
    }

    public void a(String str, int i) {
        this.pdi.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int d() {
        return this.pdi.getInt("session_order", 0);
    }

    public SharedPreferences elM() {
        return this.e;
    }

    public boolean f() {
        return this.pdh.elf();
    }

    public JSONObject elN() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (au.f5786b) {
            au.a("setConfig, " + jSONObject.toString(), null);
        }
        this.g = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.e.edit();
        long optInt = jSONObject.optInt("session_interval", 0);
        if (optInt > 0 && optInt <= 604800) {
            edit.putLong("session_interval", optInt * 1000);
        } else {
            edit.remove("session_interval");
        }
        long optInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (optInt2 > 0 && optInt2 <= 604800) {
            edit.putLong("batch_event_interval", optInt2 * 1000);
        } else {
            edit.remove("batch_event_interval");
        }
        int optInt3 = jSONObject.optInt("send_launch_timely", 0);
        if (optInt3 > 0 && optInt3 <= 604800) {
            edit.putInt("send_launch_timely", optInt3);
        } else {
            edit.remove("send_launch_timely");
        }
        long optInt4 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (optInt4 > 20 && optInt4 <= 604800) {
            edit.putLong("abtest_fetch_interval", optInt4 * 1000);
        } else {
            edit.remove("abtest_fetch_interval");
        }
        boolean optBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (optBoolean) {
            edit.putBoolean("bav_log_collect", true);
        } else {
            edit.remove("bav_log_collect");
        }
        au.f5785a = optBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            edit.putBoolean("bav_ab_config", true);
        } else {
            edit.remove("bav_ab_config");
        }
        int optInt5 = jSONObject.optInt("bav_monitor_rate", 0);
        if (optInt5 > 0 && optInt5 <= 100) {
            edit.putInt("bav_monitor_rate", optInt5);
            at.a(true);
        } else {
            edit.remove("bav_monitor_rate");
            at.a(false);
        }
        edit.putLong("app_log_last_config_time", currentTimeMillis);
        edit.apply();
    }

    public long h() {
        return this.e.getLong("app_log_last_config_time", 0L);
    }

    public int i() {
        return this.e.getInt("bav_monitor_rate", 0);
    }

    public String j() {
        return this.pdh.uE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.pdh.getChannel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.pdh.elg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return this.pdh.getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return this.pdh.elh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(JSONObject jSONObject) {
        this.c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return this.c.getString("header_custom_info", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String p() {
        return this.c.getString("ab_sdk_version", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String q() {
        return this.c.getString("user_unique_id", null);
    }

    public boolean r() {
        if (this.pdh.getProcess() == 0) {
            this.pdh.AE(!av.a(this.f5826a).contains(":"));
        }
        return this.pdh.getProcess() == 1;
    }

    public long s() {
        return this.e.getLong("abtest_fetch_interval", 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(JSONObject jSONObject) {
        au.a("setAbConfig, " + jSONObject.toString(), null);
        this.c.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f = null;
    }

    public String t() {
        return !TextUtils.isEmpty(this.pdh.elo()) ? this.pdh.elo() : this.c.getString("ab_version", null);
    }

    public JSONObject elO() {
        JSONObject jSONObject = this.f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    jSONObject = v() ? new JSONObject(this.c.getString("ab_configure", "")) : jSONObject;
                } catch (JSONException e) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean v() {
        return this.e.getBoolean("bav_ab_config", false);
    }

    public boolean w() {
        return this.e.getBoolean("bav_log_collect", false);
    }

    public long elP() {
        return this.e.getLong("session_interval", 30000L);
    }

    public long elQ() {
        return this.e.getLong("batch_event_interval", 30000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String A() {
        return this.pdh.ele();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String B() {
        return this.e.getString("user_agent", null);
    }

    public boolean bl(ArrayList<ac> arrayList) {
        return true;
    }

    public void a(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public void a(long j) {
    }

    public long elR() {
        return 10000L;
    }

    public String D() {
        return this.pdh.getAppName();
    }

    public int E() {
        return this.pdh.getVersionCode();
    }

    public int F() {
        return this.pdh.ell();
    }

    public int G() {
        return this.pdh.elm();
    }

    public String H() {
        return this.pdh.getVersion();
    }

    public String I() {
        return this.pdh.elk();
    }

    public String J() {
        return this.pdh.eln();
    }

    public String K() {
        return this.pdh.elp();
    }

    public String L() {
        return this.pdh.elq();
    }

    public String M() {
        return this.pdh.elr();
    }

    public String N() {
        return this.pdh.elu() == null ? "" : this.pdh.elu();
    }

    public boolean O() {
        return this.pdh.elt();
    }

    public l elS() {
        return this.pdh;
    }

    public CharSequence elT() {
        return this.pdh.els();
    }
}
