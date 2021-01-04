package com.baidu.turbonet.net;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.turbonet.net.UrlRequest;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    public abstract boolean ehI();

    abstract boolean isEnabled();

    /* loaded from: classes5.dex */
    public static class Builder {
        private String mAppName;
        private String mAppPackageName;
        private final Context mContext;
        private boolean mDisableCache;
        private boolean mHttp2Enabled;
        private long mHttpCacheMaxSize;
        private int mHttpCacheMode;
        private boolean mNetworkQualityEstimatorEnabled;
        private boolean mQuicEnabled;
        private String mStoragePath;
        private String mUserAgent;
        private String oLB;
        private LibraryLoader oLC;
        private String oLD;
        private JSONObject oLE;
        private String oLF;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes5.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes5.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this.mContext = context;
            Xa("turbonet");
            this.oLE = new JSONObject();
            Ak(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void eig() {
            if (this.oLC == null) {
                if (this.oLD.equals("turbonet")) {
                    System.loadLibrary(this.oLD);
                    return;
                } else {
                    System.load(this.oLD);
                    return;
                }
            }
            this.oLC.loadLibrary(this.oLD);
        }

        public Builder Xa(String str) {
            this.oLD = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.oLE.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.oLE.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder Xb(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder Ak(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.mHttp2Enabled = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean eih() {
            return this.mHttp2Enabled;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean eii() {
            return this.mQuicEnabled;
        }

        public Builder Xc(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.mStoragePath = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String eic() {
            return this.mStoragePath;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.mDisableCache;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long eij() {
            return this.mHttpCacheMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int httpCacheMode() {
            return this.mHttpCacheMode;
        }

        public String getAppPackageName() {
            return this.mAppPackageName;
        }

        public Builder K(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.mNetworkQualityEstimatorEnabled = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean networkQualityEstimatorEnabled() {
            return this.mNetworkQualityEstimatorEnabled;
        }

        public Builder Xd(String str) {
            e("app", "cuid", str);
            this.oLB = str;
            return this;
        }

        public Builder Xe(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Xf(String str) {
            this.oLF = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String eik() {
            return this.oLF;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String eil() {
            return this.oLE.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine eim() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                Xb(c.from(this.mContext));
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

    /* loaded from: classes5.dex */
    public static final class UrlRequestMetrics {
        @Nullable
        private final Long oKv;
        @Nullable
        private final Long oKw;
        @Nullable
        private final Long oLG;
        @Nullable
        private final Long oLH;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.oKv = l;
            this.oKw = l2;
            this.oLG = l3;
            this.oLH = l4;
        }
    }

    public long ehz() {
        return 0L;
    }
}
