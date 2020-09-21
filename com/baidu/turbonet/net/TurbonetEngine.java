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
/* loaded from: classes15.dex */
public abstract class TurbonetEngine {

    /* loaded from: classes15.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    /* loaded from: classes15.dex */
    public enum QUICConnectStatus {
        UNKNOWN,
        REACHABLE,
        UNREACHABLE
    }

    /* loaded from: classes15.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes15.dex */
    public enum TCPNetworkQualityStatus {
        UNKNOWN,
        WEAK,
        NORMAL
    }

    /* loaded from: classes15.dex */
    public static final class UrlRequestInfo {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    public abstract boolean dOC();

    abstract boolean isEnabled();

    /* loaded from: classes15.dex */
    public static class Builder {
        private String dMp;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;
        private boolean nlY;
        private boolean nlw;
        private JSONObject nnA;
        private String nnB;
        private String nnr;
        private String nnt;
        private LibraryLoader nnu;
        private String nnv;
        private boolean nnw;
        private boolean nnx;
        private int nny;
        private long nnz;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes15.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes15.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this.mContext = context;
            TM("turbonet");
            this.nnA = new JSONObject();
            xQ(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dPb() {
            if (this.nnu == null) {
                if (this.nnv.equals("turbonet")) {
                    System.loadLibrary(this.nnv);
                    return;
                } else {
                    System.load(this.nnv);
                    return;
                }
            }
            this.nnu.loadLibrary(this.nnv);
        }

        public Builder TM(String str) {
            this.nnv = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.nnA.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.nnA.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder TN(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder xQ(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.nnw = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dPc() {
            return this.nnw;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dPd() {
            return this.nnx;
        }

        public Builder TO(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.nnr = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dOX() {
            return this.nnr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.nlw;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long dPe() {
            return this.nnz;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dPf() {
            return this.nny;
        }

        public String getAppPackageName() {
            return this.dMp;
        }

        public Builder G(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.nlY = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dPg() {
            return this.nlY;
        }

        public Builder TP(String str) {
            e("app", "cuid", str);
            this.nnt = str;
            return this;
        }

        public Builder TQ(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder TR(String str) {
            this.nnB = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dPh() {
            return this.nnB;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dPi() {
            return this.nnA.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine dPj() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                TN(c.gc(this.mContext));
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

    /* loaded from: classes15.dex */
    public static final class UrlRequestMetrics {
        @Nullable
        private final Long nlQ;
        @Nullable
        private final Long nlR;
        @Nullable
        private final Long nnC;
        @Nullable
        private final Long nnD;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.nlQ = l;
            this.nlR = l2;
            this.nnC = l3;
            this.nnD = l4;
        }
    }

    public long dOj() {
        return 0L;
    }
}
