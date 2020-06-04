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

    public abstract boolean dqL();

    abstract boolean isEnabled();

    /* loaded from: classes.dex */
    public static class Builder {
        private String dqv;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;
        private boolean meJ;
        private boolean meh;
        private String mgb;
        private String mgd;
        private LibraryLoader mge;
        private String mgf;
        private boolean mgg;
        private boolean mgh;
        private int mgi;
        private long mgj;
        private JSONObject mgk;
        private String mgl;

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
            OQ("turbonet");
            this.mgk = new JSONObject();
            vO(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void drk() {
            if (this.mge == null) {
                if (this.mgf.equals("turbonet")) {
                    System.loadLibrary(this.mgf);
                    return;
                } else {
                    System.load(this.mgf);
                    return;
                }
            }
            this.mge.loadLibrary(this.mgf);
        }

        public Builder OQ(String str) {
            this.mgf = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.mgk.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.mgk.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder OR(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder vO(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.mgg = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean drl() {
            return this.mgg;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean drm() {
            return this.mgh;
        }

        public Builder OS(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.mgb = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String drg() {
            return this.mgb;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.meh;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long drn() {
            return this.mgj;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dro() {
            return this.mgi;
        }

        public String getAppPackageName() {
            return this.dqv;
        }

        public Builder D(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.meJ = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean drp() {
            return this.meJ;
        }

        public Builder OT(String str) {
            e("app", "cuid", str);
            this.mgd = str;
            return this;
        }

        public Builder OU(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder OV(String str) {
            this.mgl = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String drq() {
            return this.mgl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String drr() {
            return this.mgk.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine drs() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                OR(c.fF(this.mContext));
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
        private final Long meB;
        @Nullable
        private final Long meC;
        @Nullable
        private final Long mgm;
        @Nullable
        private final Long mgn;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.meB = l;
            this.meC = l2;
            this.mgm = l3;
            this.mgn = l4;
        }
    }

    public long dqs() {
        return 0L;
    }
}
