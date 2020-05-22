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

    public abstract boolean dqx();

    abstract boolean isEnabled();

    /* loaded from: classes.dex */
    public static class Builder {
        private String dqv;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;
        private boolean mcX;
        private boolean mdz;
        private String meR;
        private String meT;
        private LibraryLoader meU;
        private String meV;
        private boolean meW;
        private boolean meX;
        private int meY;
        private long meZ;
        private JSONObject mfa;
        private String mfb;

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
            OP("turbonet");
            this.mfa = new JSONObject();
            vM(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dqW() {
            if (this.meU == null) {
                if (this.meV.equals("turbonet")) {
                    System.loadLibrary(this.meV);
                    return;
                } else {
                    System.load(this.meV);
                    return;
                }
            }
            this.meU.loadLibrary(this.meV);
        }

        public Builder OP(String str) {
            this.meV = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.mfa.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.mfa.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder OQ(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder vM(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.meW = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dqX() {
            return this.meW;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dqY() {
            return this.meX;
        }

        public Builder OR(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.meR = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dqS() {
            return this.meR;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.mcX;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long dqZ() {
            return this.meZ;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dra() {
            return this.meY;
        }

        public String getAppPackageName() {
            return this.dqv;
        }

        public Builder D(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.mdz = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean drb() {
            return this.mdz;
        }

        public Builder OS(String str) {
            e("app", "cuid", str);
            this.meT = str;
            return this;
        }

        public Builder OT(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder OU(String str) {
            this.mfb = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String drc() {
            return this.mfb;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String drd() {
            return this.mfa.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine dre() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                OQ(c.fF(this.mContext));
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
        private final Long mdr;
        @Nullable
        private final Long mds;
        @Nullable
        private final Long mfc;
        @Nullable
        private final Long mfd;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.mdr = l;
            this.mds = l2;
            this.mfc = l3;
            this.mfd = l4;
        }
    }

    public long dqe() {
        return 0L;
    }
}
