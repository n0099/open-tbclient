package com.baidu.turbonet.net;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.alipay.sdk.cons.b;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.turbonet.net.UrlRequest;
import d.b.k0.b.c;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class TurbonetEngine {

    /* loaded from: classes5.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final Context f22539a;

        /* renamed from: b  reason: collision with root package name */
        public LibraryLoader f22540b;

        /* renamed from: c  reason: collision with root package name */
        public String f22541c;

        /* renamed from: d  reason: collision with root package name */
        public String f22542d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22543e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22544f;

        /* renamed from: g  reason: collision with root package name */
        public String f22545g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22546h;
        public int i;
        public long j;
        public String k;
        public boolean l;
        public JSONObject m;
        public String n;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes5.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes5.dex */
        public static abstract class LibraryLoader {
            public abstract void a(String str);
        }

        public Builder(Context context) {
            this.f22539a = context;
            t("turbonet");
            this.m = new JSONObject();
            d(false);
        }

        public Builder a(String str) {
            this.n = str;
            return this;
        }

        public TurbonetEngine b() {
            String str;
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
                str = "";
            }
            s(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (j() == null) {
                v(c.a(this.f22539a));
            }
            return TurbonetEngine.c(this);
        }

        public boolean c() {
            return this.f22546h;
        }

        public Builder d(boolean z) {
            s(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.f22543e = z;
            return this;
        }

        public Builder e(boolean z, String str) {
            s("nq", "network_quality_enabled", Boolean.valueOf(z));
            s("nq", "watched_groups", str);
            this.l = z;
            return this;
        }

        public String f() {
            return this.k;
        }

        public String g() {
            return this.n;
        }

        public String h() {
            return this.m.toString();
        }

        public Context i() {
            return this.f22539a;
        }

        public String j() {
            return this.f22542d;
        }

        public boolean k() {
            return this.f22543e;
        }

        public long l() {
            return this.j;
        }

        public int m() {
            return this.i;
        }

        public void n() {
            LibraryLoader libraryLoader = this.f22540b;
            if (libraryLoader == null) {
                if (this.f22541c.equals("turbonet")) {
                    System.loadLibrary(this.f22541c);
                    return;
                } else {
                    System.load(this.f22541c);
                    return;
                }
            }
            libraryLoader.a(this.f22541c);
        }

        public boolean o() {
            return this.l;
        }

        public boolean p() {
            return this.f22544f;
        }

        public Builder q(String str) {
            s("app", "cuid", str);
            return this;
        }

        public Builder r(String str) {
            s("app", DpStatConstants.KEY_APP_NAME, str);
            return this;
        }

        public final void s(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.m.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.m.put(str, optJSONObject);
            } catch (JSONException e2) {
                throw new IllegalStateException("JSON expcetion:", e2);
            }
        }

        public Builder t(String str) {
            this.f22541c = str;
            return this;
        }

        public Builder u(String str) {
            if (new File(str).isDirectory()) {
                this.f22545g = str;
                return this;
            }
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }

        public Builder v(String str) {
            s(SchemeCollecter.CLASSIFY_BASE, b.f1877b, str);
            this.f22542d = str;
            return this;
        }

        public String w() {
            return this.f22545g;
        }
    }

    /* loaded from: classes5.dex */
    public enum QUICConnectStatus {
        UNKNOWN,
        REACHABLE,
        UNREACHABLE
    }

    /* loaded from: classes5.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes5.dex */
    public enum TCPNetworkQualityStatus {
        UNKNOWN,
        WEAK,
        NORMAL
    }

    /* loaded from: classes5.dex */
    public static final class UrlRequestInfo {
    }

    /* loaded from: classes5.dex */
    public static final class UrlRequestMetrics {
    }

    public static TurbonetEngine c(Builder builder) {
        try {
            TurbonetEngine turbonetEngine = (TurbonetEngine) TurbonetEngine.class.getClassLoader().loadClass("com.baidu.turbonet.net.CronetUrlRequestContext").asSubclass(TurbonetEngine.class).getConstructor(Builder.class).newInstance(builder);
            if (turbonetEngine.e()) {
                return turbonetEngine;
            }
            return null;
        } catch (ClassNotFoundException e2) {
            throw new IllegalStateException("ClassNotFoundException: com.baidu.turbonet.net.CronetUrlRequestContext", e2);
        } catch (Exception e3) {
            throw new IllegalStateException("Cannot instantiate: com.baidu.turbonet.net.CronetUrlRequestContext", e3);
        }
    }

    public abstract UrlRequest b(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    public long d() {
        return 0L;
    }

    public abstract boolean e();

    public abstract boolean f();

    public abstract void g(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);
}
