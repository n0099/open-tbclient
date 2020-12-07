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

    public abstract boolean ehs();

    abstract boolean isEnabled();

    /* loaded from: classes14.dex */
    public static class Builder {
        private String mAppName;
        private String mAppPackageName;
        private final Context mContext;
        private String mUserAgent;
        private boolean oDC;
        private boolean oDa;
        private String oET;
        private String oEV;
        private LibraryLoader oEW;
        private String oEX;
        private boolean oEY;
        private boolean oEZ;
        private int oFa;
        private long oFb;
        private JSONObject oFc;
        private String oFd;

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
            this.oFc = new JSONObject();
            Aj(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void ehQ() {
            if (this.oEW == null) {
                if (this.oEX.equals("turbonet")) {
                    System.loadLibrary(this.oEX);
                    return;
                } else {
                    System.load(this.oEX);
                    return;
                }
            }
            this.oEW.loadLibrary(this.oEX);
        }

        public Builder Xr(String str) {
            this.oEX = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.oFc.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.oFc.put(str, optJSONObject);
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
            this.oEY = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ehR() {
            return this.oEY;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ehS() {
            return this.oEZ;
        }

        public Builder Xt(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.oET = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ehM() {
            return this.oET;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.oDa;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long ehT() {
            return this.oFb;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int ehU() {
            return this.oFa;
        }

        public String getAppPackageName() {
            return this.mAppPackageName;
        }

        public Builder J(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.oDC = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean ehV() {
            return this.oDC;
        }

        public Builder Xu(String str) {
            e("app", "cuid", str);
            this.oEV = str;
            return this;
        }

        public Builder Xv(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Xw(String str) {
            this.oFd = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ehW() {
            return this.oFd;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String ehX() {
            return this.oFc.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine ehY() {
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
        private final Long oDu;
        @Nullable
        private final Long oDv;
        @Nullable
        private final Long oFe;
        @Nullable
        private final Long oFf;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.oDu = l;
            this.oDv = l2;
            this.oFe = l3;
            this.oFf = l4;
        }
    }

    public long egZ() {
        return 0L;
    }
}
