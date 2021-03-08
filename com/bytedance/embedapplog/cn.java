package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3931a;
    private final SharedPreferences c;
    private final SharedPreferences e;
    private volatile JSONObject f;
    private volatile JSONObject g;
    private final l pqf;
    private final SharedPreferences pqg;

    public cn(Context context, l lVar) {
        this.f3931a = context;
        this.pqf = lVar;
        this.e = this.f3931a.getSharedPreferences("embed_applog_stats", 0);
        this.c = this.f3931a.getSharedPreferences("embed_header_custom", 0);
        this.pqg = this.f3931a.getSharedPreferences("embed_last_sp_session", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.pqf.enT();
    }

    public String c() {
        return this.pqg.getString("session_last_day", "");
    }

    public void a(String str, int i) {
        this.pqg.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int d() {
        return this.pqg.getInt("session_order", 0);
    }

    public SharedPreferences eox() {
        return this.e;
    }

    public boolean f() {
        return this.pqf.enQ();
    }

    public JSONObject g() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (au.b) {
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
        au.f3906a = optBoolean;
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
        return this.pqf.uE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.pqf.getChannel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.pqf.enR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return this.pqf.getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return this.pqf.enS();
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
        if (this.pqf.getProcess() == 0) {
            this.pqf.AW(!av.a(this.f3931a).contains(":"));
        }
        return this.pqf.getProcess() == 1;
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
        return !TextUtils.isEmpty(this.pqf.enZ()) ? this.pqf.enZ() : this.c.getString("ab_version", null);
    }

    public JSONObject u() {
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

    public long eoy() {
        return this.e.getLong("session_interval", 30000L);
    }

    public long eoz() {
        return this.e.getLong("batch_event_interval", 30000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String A() {
        return this.pqf.enP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String B() {
        return this.e.getString("user_agent", null);
    }

    public boolean bk(ArrayList<ac> arrayList) {
        return true;
    }

    public void a(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public void a(long j) {
    }

    public long eoA() {
        return 10000L;
    }

    public String D() {
        return this.pqf.getAppName();
    }

    public int E() {
        return this.pqf.getVersionCode();
    }

    public int F() {
        return this.pqf.enW();
    }

    public int G() {
        return this.pqf.enX();
    }

    public String H() {
        return this.pqf.getVersion();
    }

    public String I() {
        return this.pqf.enV();
    }

    public String up() {
        return this.pqf.enY();
    }

    public String uq() {
        return this.pqf.eoa();
    }

    public String L() {
        return this.pqf.eob();
    }

    public String M() {
        return this.pqf.eoc();
    }

    public String N() {
        return this.pqf.eog() == null ? "" : this.pqf.eog();
    }

    public boolean O() {
        return this.pqf.eoe();
    }

    public l eoB() {
        return this.pqf;
    }

    public CharSequence eoC() {
        return this.pqf.eod();
    }
}
