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

    public abstract boolean dvq();

    abstract boolean isEnabled();

    /* loaded from: classes.dex */
    public static class Builder {
        private String dvh;
        private String mAppName;
        private boolean mAy;
        private String mBS;
        private String mBU;
        private LibraryLoader mBV;
        private String mBW;
        private boolean mBX;
        private boolean mBY;
        private int mBZ;
        private long mCa;
        private JSONObject mCb;
        private String mCc;
        private final Context mContext;
        private String mUserAgent;
        private boolean mzW;

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
            PC("turbonet");
            this.mCb = new JSONObject();
            wk(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dvP() {
            if (this.mBV == null) {
                if (this.mBW.equals("turbonet")) {
                    System.loadLibrary(this.mBW);
                    return;
                } else {
                    System.load(this.mBW);
                    return;
                }
            }
            this.mBV.loadLibrary(this.mBW);
        }

        public Builder PC(String str) {
            this.mBW = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.mCb.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.mCb.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder PD(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder wk(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.mBX = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dvQ() {
            return this.mBX;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dvR() {
            return this.mBY;
        }

        public Builder PE(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.mBS = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dvL() {
            return this.mBS;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.mzW;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long dvS() {
            return this.mCa;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dvT() {
            return this.mBZ;
        }

        public String getAppPackageName() {
            return this.dvh;
        }

        public Builder F(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.mAy = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dvU() {
            return this.mAy;
        }

        public Builder PF(String str) {
            e("app", "cuid", str);
            this.mBU = str;
            return this;
        }

        public Builder PG(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder PH(String str) {
            this.mCc = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dvV() {
            return this.mCc;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dvW() {
            return this.mCb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine dvX() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                PD(c.fG(this.mContext));
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
        private final Long mAq;
        @Nullable
        private final Long mAr;
        @Nullable
        private final Long mCd;
        @Nullable
        private final Long mCe;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.mAq = l;
            this.mAr = l2;
            this.mCd = l3;
            this.mCe = l4;
        }
    }

    public long duX() {
        return 0L;
    }
}
