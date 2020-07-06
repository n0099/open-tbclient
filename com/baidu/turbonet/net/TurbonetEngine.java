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

    public abstract boolean dvu();

    abstract boolean isEnabled();

    /* loaded from: classes.dex */
    public static class Builder {
        private String dvh;
        private boolean mAB;
        private String mAppName;
        private String mBV;
        private String mBX;
        private LibraryLoader mBY;
        private String mBZ;
        private boolean mCa;
        private boolean mCb;
        private int mCc;
        private long mCd;
        private JSONObject mCe;
        private String mCf;
        private final Context mContext;
        private String mUserAgent;
        private boolean mzZ;

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
            PD("turbonet");
            this.mCe = new JSONObject();
            wk(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dvT() {
            if (this.mBY == null) {
                if (this.mBZ.equals("turbonet")) {
                    System.loadLibrary(this.mBZ);
                    return;
                } else {
                    System.load(this.mBZ);
                    return;
                }
            }
            this.mBY.loadLibrary(this.mBZ);
        }

        public Builder PD(String str) {
            this.mBZ = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.mCe.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.mCe.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder PE(String str) {
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
            this.mCa = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dvU() {
            return this.mCa;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dvV() {
            return this.mCb;
        }

        public Builder PF(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.mBV = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dvP() {
            return this.mBV;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.mzZ;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long dvW() {
            return this.mCd;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dvX() {
            return this.mCc;
        }

        public String getAppPackageName() {
            return this.dvh;
        }

        public Builder F(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.mAB = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dvY() {
            return this.mAB;
        }

        public Builder PG(String str) {
            e("app", "cuid", str);
            this.mBX = str;
            return this;
        }

        public Builder PH(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder PI(String str) {
            this.mCf = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dvZ() {
            return this.mCf;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dwa() {
            return this.mCe.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine dwb() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                PE(c.fG(this.mContext));
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
        private final Long mAt;
        @Nullable
        private final Long mAu;
        @Nullable
        private final Long mCg;
        @Nullable
        private final Long mCh;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.mAt = l;
            this.mAu = l2;
            this.mCg = l3;
            this.mCh = l4;
        }
    }

    public long dvb() {
        return 0L;
    }
}
