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
/* loaded from: classes19.dex */
public abstract class TurbonetEngine {

    /* loaded from: classes19.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    /* loaded from: classes19.dex */
    public enum QUICConnectStatus {
        UNKNOWN,
        REACHABLE,
        UNREACHABLE
    }

    /* loaded from: classes19.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes19.dex */
    public enum TCPNetworkQualityStatus {
        UNKNOWN,
        WEAK,
        NORMAL
    }

    /* loaded from: classes19.dex */
    public static final class UrlRequestInfo {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    public abstract boolean dyH();

    abstract boolean isEnabled();

    /* loaded from: classes19.dex */
    public static class Builder {
        private String dAX;
        private String mAppName;
        private final Context mContext;
        private boolean mIK;
        private boolean mIf;
        private String mKd;
        private String mKf;
        private LibraryLoader mKg;
        private String mKh;
        private boolean mKi;
        private boolean mKj;
        private int mKk;
        private long mKl;
        private JSONObject mKm;
        private String mKn;
        private String mUserAgent;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes19.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes19.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this.mContext = context;
            Qo("turbonet");
            this.mKm = new JSONObject();
            wP(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dzg() {
            if (this.mKg == null) {
                if (this.mKh.equals("turbonet")) {
                    System.loadLibrary(this.mKh);
                    return;
                } else {
                    System.load(this.mKh);
                    return;
                }
            }
            this.mKg.loadLibrary(this.mKh);
        }

        public Builder Qo(String str) {
            this.mKh = str;
            return this;
        }

        private void f(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.mKm.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.mKm.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder Qp(String str) {
            f(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder wP(boolean z) {
            f(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.mKi = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dzh() {
            return this.mKi;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dzi() {
            return this.mKj;
        }

        public Builder Qq(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.mKd = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dzc() {
            return this.mKd;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.mIf;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long dzj() {
            return this.mKl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dzk() {
            return this.mKk;
        }

        public String getAppPackageName() {
            return this.dAX;
        }

        public Builder F(boolean z, String str) {
            f("nq", "network_quality_enabled", Boolean.valueOf(z));
            f("nq", "watched_groups", str);
            this.mIK = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dzl() {
            return this.mIK;
        }

        public Builder Qr(String str) {
            f("app", "cuid", str);
            this.mKf = str;
            return this;
        }

        public Builder Qs(String str) {
            f("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Qt(String str) {
            this.mKn = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dzm() {
            return this.mKn;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dzn() {
            return this.mKm.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine dzo() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            f(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                Qp(c.fJ(this.mContext));
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

    /* loaded from: classes19.dex */
    public static final class UrlRequestMetrics {
        @Nullable
        private final Long mIB;
        @Nullable
        private final Long mIC;
        @Nullable
        private final Long mKo;
        @Nullable
        private final Long mKp;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.mIB = l;
            this.mIC = l2;
            this.mKo = l3;
            this.mKp = l4;
        }
    }

    public long dyo() {
        return 0L;
    }
}
