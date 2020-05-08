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

    public abstract boolean djg();

    abstract boolean isEnabled();

    /* loaded from: classes.dex */
    public static class Builder {
        private String deB;
        private boolean lJG;
        private boolean lKj;
        private String lLC;
        private String lLE;
        private LibraryLoader lLF;
        private String lLG;
        private boolean lLH;
        private boolean lLI;
        private int lLJ;
        private long lLK;
        private JSONObject lLL;
        private String lLM;
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
            Nc("turbonet");
            this.lLL = new JSONObject();
            vo(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void djF() {
            if (this.lLF == null) {
                if (this.lLG.equals("turbonet")) {
                    System.loadLibrary(this.lLG);
                    return;
                } else {
                    System.load(this.lLG);
                    return;
                }
            }
            this.lLF.loadLibrary(this.lLG);
        }

        public Builder Nc(String str) {
            this.lLG = str;
            return this;
        }

        private void d(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.lLL.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.lLL.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder Nd(String str) {
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
            this.lLH = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean djG() {
            return this.lLH;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean djH() {
            return this.lLI;
        }

        public Builder Ne(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.lLC = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String djB() {
            return this.lLC;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.lJG;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long djI() {
            return this.lLK;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int djJ() {
            return this.lLJ;
        }

        public String getAppPackageName() {
            return this.deB;
        }

        public Builder D(boolean z, String str) {
            d("nq", "network_quality_enabled", Boolean.valueOf(z));
            d("nq", "watched_groups", str);
            this.lKj = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean djK() {
            return this.lKj;
        }

        public Builder Nf(String str) {
            d("app", "cuid", str);
            this.lLE = str;
            return this;
        }

        public Builder Ng(String str) {
            d("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Nh(String str) {
            this.lLM = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String djL() {
            return this.lLM;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String djM() {
            return this.lLL.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine djN() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            d(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                Nd(c.fq(this.mContext));
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
        private final Long lKa;
        @Nullable
        private final Long lKb;
        @Nullable
        private final Long lLN;
        @Nullable
        private final Long lLO;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.lKa = l;
            this.lKb = l2;
            this.lLN = l3;
            this.lLO = l4;
        }
    }

    public long diN() {
        return 0L;
    }
}
