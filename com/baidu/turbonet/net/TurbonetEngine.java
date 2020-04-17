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
/* loaded from: classes.dex */
public abstract class TurbonetEngine {

    /* loaded from: classes.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    /* loaded from: classes.dex */
    public enum QUICConnectStatus {
        UNKNOWN,
        REACHABLE,
        UNREACHABLE
    }

    /* loaded from: classes.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes.dex */
    public enum TCPNetworkQualityStatus {
        UNKNOWN,
        WEAK,
        NORMAL
    }

    /* loaded from: classes.dex */
    public static final class UrlRequestInfo {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    public abstract boolean djj();

    abstract boolean isEnabled();

    /* loaded from: classes.dex */
    public static class Builder {
        private String dew;
        private boolean lJC;
        private boolean lKf;
        private String lLA;
        private LibraryLoader lLB;
        private String lLC;
        private boolean lLD;
        private boolean lLE;
        private int lLF;
        private long lLG;
        private JSONObject lLH;
        private String lLI;
        private String lLy;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this.mContext = context;
            MZ("turbonet");
            this.lLH = new JSONObject();
            vo(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void djI() {
            if (this.lLB == null) {
                if (this.lLC.equals("turbonet")) {
                    System.loadLibrary(this.lLC);
                    return;
                } else {
                    System.load(this.lLC);
                    return;
                }
            }
            this.lLB.loadLibrary(this.lLC);
        }

        public Builder MZ(String str) {
            this.lLC = str;
            return this;
        }

        private void d(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.lLH.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.lLH.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder Na(String str) {
            d(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder vo(boolean z) {
            d(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.lLD = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean djJ() {
            return this.lLD;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean djK() {
            return this.lLE;
        }

        public Builder Nb(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.lLy = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String djE() {
            return this.lLy;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.lJC;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long djL() {
            return this.lLG;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int djM() {
            return this.lLF;
        }

        public String getAppPackageName() {
            return this.dew;
        }

        public Builder D(boolean z, String str) {
            d("nq", "network_quality_enabled", Boolean.valueOf(z));
            d("nq", "watched_groups", str);
            this.lKf = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean djN() {
            return this.lKf;
        }

        public Builder Nc(String str) {
            d("app", "cuid", str);
            this.lLA = str;
            return this;
        }

        public Builder Nd(String str) {
            d("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Ne(String str) {
            this.lLI = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String djO() {
            return this.lLI;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String djP() {
            return this.lLH.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine djQ() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            d(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                Na(c.fC(this.mContext));
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

    /* loaded from: classes.dex */
    public static final class UrlRequestMetrics {
        @Nullable
        private final Long lJW;
        @Nullable
        private final Long lJX;
        @Nullable
        private final Long lLJ;
        @Nullable
        private final Long lLK;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.lJW = l;
            this.lJX = l2;
            this.lLJ = l3;
            this.lLK = l4;
        }
    }

    public long diQ() {
        return 0L;
    }
}
