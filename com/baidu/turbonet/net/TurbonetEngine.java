package com.baidu.turbonet.net;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.turbonet.net.UrlRequest;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public abstract class TurbonetEngine {

    /* loaded from: classes12.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    /* loaded from: classes12.dex */
    public enum QUICConnectStatus {
        UNKNOWN,
        REACHABLE,
        UNREACHABLE
    }

    /* loaded from: classes12.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes12.dex */
    public enum TCPNetworkQualityStatus {
        UNKNOWN,
        WEAK,
        NORMAL
    }

    /* loaded from: classes12.dex */
    public static final class UrlRequestInfo {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    public abstract boolean ebN();

    abstract boolean isEnabled();

    /* loaded from: classes12.dex */
    public static class Builder {
        private String ekX;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;
        private boolean ooE;
        private boolean ooc;
        private String opX;
        private String opZ;
        private LibraryLoader oqa;
        private String oqb;
        private boolean oqc;
        private boolean oqd;
        private int oqe;
        private long oqf;
        private JSONObject oqg;
        private String oqh;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes12.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes12.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this.mContext = context;
            Wc("turbonet");
            this.oqg = new JSONObject();
            zF(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void ecl() {
            if (this.oqa == null) {
                if (this.oqb.equals("turbonet")) {
                    System.loadLibrary(this.oqb);
                    return;
                } else {
                    System.load(this.oqb);
                    return;
                }
            }
            this.oqa.loadLibrary(this.oqb);
        }

        public Builder Wc(String str) {
            this.oqb = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.oqg.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.oqg.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder Wd(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder zF(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.oqc = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ecm() {
            return this.oqc;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ecn() {
            return this.oqd;
        }

        public Builder We(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.opX = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ech() {
            return this.opX;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.ooc;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long eco() {
            return this.oqf;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int ecp() {
            return this.oqe;
        }

        public String getAppPackageName() {
            return this.ekX;
        }

        public Builder J(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.ooE = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ecq() {
            return this.ooE;
        }

        public Builder Wf(String str) {
            e("app", "cuid", str);
            this.opZ = str;
            return this;
        }

        public Builder Wg(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Wh(String str) {
            this.oqh = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ecr() {
            return this.oqh;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ecs() {
            return this.oqg.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine ect() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                Wd(c.gl(this.mContext));
            }
            return TurbonetEngine.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TurbonetEngine a(Builder builder) {
        try {
            TurbonetEngine turbonetEngine = (TurbonetEngine) TurbonetEngine.class.getClassLoader().loadClass("com.baidu.turbonet.net.CronetUrlRequestContext").asSubclass(TurbonetEngine.class).getConstructor(Builder.class).newInstance(builder);
            if (!turbonetEngine.isEnabled()) {
                return null;
            }
            return turbonetEngine;
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("ClassNotFoundException: com.baidu.turbonet.net.CronetUrlRequestContext", e);
        } catch (Exception e2) {
            throw new IllegalStateException("Cannot instantiate: com.baidu.turbonet.net.CronetUrlRequestContext", e2);
        }
    }

    /* loaded from: classes12.dex */
    public static final class UrlRequestMetrics {
        @Nullable
        private final Long oow;
        @Nullable
        private final Long oox;
        @Nullable
        private final Long oqi;
        @Nullable
        private final Long oqj;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.oow = l;
            this.oox = l2;
            this.oqi = l3;
            this.oqj = l4;
        }
    }

    public long ebu() {
        return 0L;
    }
}
