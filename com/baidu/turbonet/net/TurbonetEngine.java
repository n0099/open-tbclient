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
/* loaded from: classes17.dex */
public abstract class TurbonetEngine {

    /* loaded from: classes17.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    /* loaded from: classes17.dex */
    public enum QUICConnectStatus {
        UNKNOWN,
        REACHABLE,
        UNREACHABLE
    }

    /* loaded from: classes17.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes17.dex */
    public enum TCPNetworkQualityStatus {
        UNKNOWN,
        WEAK,
        NORMAL
    }

    /* loaded from: classes17.dex */
    public static final class UrlRequestInfo {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    public abstract boolean ebO();

    abstract boolean isEnabled();

    /* loaded from: classes17.dex */
    public static class Builder {
        private String emE;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;
        private boolean omy;
        private boolean ona;
        private int ooA;
        private long ooB;
        private JSONObject ooC;
        private String ooD;
        private String oot;
        private String oov;
        private LibraryLoader oow;
        private String oox;
        private boolean ooy;
        private boolean ooz;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes17.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes17.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this.mContext = context;
            Wr("turbonet");
            this.ooC = new JSONObject();
            zy(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void ecm() {
            if (this.oow == null) {
                if (this.oox.equals("turbonet")) {
                    System.loadLibrary(this.oox);
                    return;
                } else {
                    System.load(this.oox);
                    return;
                }
            }
            this.oow.loadLibrary(this.oox);
        }

        public Builder Wr(String str) {
            this.oox = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.ooC.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.ooC.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder Ws(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder zy(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.ooy = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ecn() {
            return this.ooy;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean eco() {
            return this.ooz;
        }

        public Builder Wt(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.oot = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String eci() {
            return this.oot;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.omy;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long ecp() {
            return this.ooB;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int ecq() {
            return this.ooA;
        }

        public String getAppPackageName() {
            return this.emE;
        }

        public Builder I(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.ona = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ecr() {
            return this.ona;
        }

        public Builder Wu(String str) {
            e("app", "cuid", str);
            this.oov = str;
            return this;
        }

        public Builder Wv(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Ww(String str) {
            this.ooD = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ecs() {
            return this.ooD;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ect() {
            return this.ooC.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine ecu() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                Ws(c.gm(this.mContext));
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

    /* loaded from: classes17.dex */
    public static final class UrlRequestMetrics {
        @Nullable
        private final Long omS;
        @Nullable
        private final Long omT;
        @Nullable
        private final Long ooE;
        @Nullable
        private final Long ooF;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.omS = l;
            this.omT = l2;
            this.ooE = l3;
            this.ooF = l4;
        }
    }

    public long ebv() {
        return 0L;
    }
}
