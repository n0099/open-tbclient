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
/* loaded from: classes14.dex */
public abstract class TurbonetEngine {

    /* loaded from: classes14.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    /* loaded from: classes14.dex */
    public enum QUICConnectStatus {
        UNKNOWN,
        REACHABLE,
        UNREACHABLE
    }

    /* loaded from: classes14.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes14.dex */
    public enum TCPNetworkQualityStatus {
        UNKNOWN,
        WEAK,
        NORMAL
    }

    /* loaded from: classes14.dex */
    public static final class UrlRequestInfo {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    public abstract boolean eht();

    abstract boolean isEnabled();

    /* loaded from: classes14.dex */
    public static class Builder {
        private String mAppName;
        private String mAppPackageName;
        private final Context mContext;
        private String mUserAgent;
        private boolean oDE;
        private boolean oDc;
        private String oEV;
        private String oEX;
        private LibraryLoader oEY;
        private String oEZ;
        private boolean oFa;
        private boolean oFb;
        private int oFc;
        private long oFd;
        private JSONObject oFe;
        private String oFf;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes14.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes14.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this.mContext = context;
            Xr("turbonet");
            this.oFe = new JSONObject();
            Aj(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void ehR() {
            if (this.oEY == null) {
                if (this.oEZ.equals("turbonet")) {
                    System.loadLibrary(this.oEZ);
                    return;
                } else {
                    System.load(this.oEZ);
                    return;
                }
            }
            this.oEY.loadLibrary(this.oEZ);
        }

        public Builder Xr(String str) {
            this.oEZ = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.oFe.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.oFe.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder Xs(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder Aj(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.oFa = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ehS() {
            return this.oFa;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ehT() {
            return this.oFb;
        }

        public Builder Xt(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.oEV = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ehN() {
            return this.oEV;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.oDc;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long ehU() {
            return this.oFd;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int ehV() {
            return this.oFc;
        }

        public String getAppPackageName() {
            return this.mAppPackageName;
        }

        public Builder J(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.oDE = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ehW() {
            return this.oDE;
        }

        public Builder Xu(String str) {
            e("app", "cuid", str);
            this.oEX = str;
            return this;
        }

        public Builder Xv(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Xw(String str) {
            this.oFf = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ehX() {
            return this.oFf;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ehY() {
            return this.oFe.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine ehZ() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                Xs(c.gV(this.mContext));
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

    /* loaded from: classes14.dex */
    public static final class UrlRequestMetrics {
        @Nullable
        private final Long oDw;
        @Nullable
        private final Long oDx;
        @Nullable
        private final Long oFg;
        @Nullable
        private final Long oFh;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.oDw = l;
            this.oDx = l2;
            this.oFg = l3;
            this.oFh = l4;
        }
    }

    public long eha() {
        return 0L;
    }
}
