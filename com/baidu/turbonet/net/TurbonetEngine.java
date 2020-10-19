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

    public abstract boolean dSo();

    abstract boolean isEnabled();

    /* loaded from: classes17.dex */
    public static class Builder {
        private String dYq;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;
        private boolean nAT;
        private boolean nBv;
        private String nCN;
        private String nCP;
        private LibraryLoader nCQ;
        private String nCR;
        private boolean nCS;
        private boolean nCT;
        private int nCU;
        private long nCV;
        private JSONObject nCW;
        private String nCX;

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
            UA("turbonet");
            this.nCW = new JSONObject();
            yx(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dSM() {
            if (this.nCQ == null) {
                if (this.nCR.equals("turbonet")) {
                    System.loadLibrary(this.nCR);
                    return;
                } else {
                    System.load(this.nCR);
                    return;
                }
            }
            this.nCQ.loadLibrary(this.nCR);
        }

        public Builder UA(String str) {
            this.nCR = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.nCW.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.nCW.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder UB(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder yx(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.nCS = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dSN() {
            return this.nCS;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dSO() {
            return this.nCT;
        }

        public Builder UC(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.nCN = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dSI() {
            return this.nCN;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.nAT;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long dSP() {
            return this.nCV;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dSQ() {
            return this.nCU;
        }

        public String getAppPackageName() {
            return this.dYq;
        }

        public Builder G(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.nBv = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dSR() {
            return this.nBv;
        }

        public Builder UD(String str) {
            e("app", "cuid", str);
            this.nCP = str;
            return this;
        }

        public Builder UE(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder UF(String str) {
            this.nCX = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dSS() {
            return this.nCX;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dST() {
            return this.nCW.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine dSU() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                UB(c.gk(this.mContext));
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
        private final Long nBn;
        @Nullable
        private final Long nBo;
        @Nullable
        private final Long nCY;
        @Nullable
        private final Long nCZ;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.nBn = l;
            this.nBo = l2;
            this.nCY = l3;
            this.nCZ = l4;
        }
    }

    public long dRV() {
        return 0L;
    }
}
