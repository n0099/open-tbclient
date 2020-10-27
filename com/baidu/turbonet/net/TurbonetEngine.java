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

    public abstract boolean dYg();

    abstract boolean isEnabled();

    /* loaded from: classes17.dex */
    public static class Builder {
        private String egN;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;
        private boolean odW;
        private boolean odu;
        private String ofp;
        private String ofr;
        private LibraryLoader ofs;
        private String oft;
        private boolean ofu;
        private boolean ofv;
        private int ofw;
        private long ofx;
        private JSONObject ofy;
        private String ofz;

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
            VO("turbonet");
            this.ofy = new JSONObject();
            zn(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dYE() {
            if (this.ofs == null) {
                if (this.oft.equals("turbonet")) {
                    System.loadLibrary(this.oft);
                    return;
                } else {
                    System.load(this.oft);
                    return;
                }
            }
            this.ofs.loadLibrary(this.oft);
        }

        public Builder VO(String str) {
            this.oft = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.ofy.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.ofy.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder VP(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder zn(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.ofu = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dYF() {
            return this.ofu;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dYG() {
            return this.ofv;
        }

        public Builder VQ(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.ofp = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dYA() {
            return this.ofp;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.odu;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long dYH() {
            return this.ofx;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dYI() {
            return this.ofw;
        }

        public String getAppPackageName() {
            return this.egN;
        }

        public Builder I(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.odW = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dYJ() {
            return this.odW;
        }

        public Builder VR(String str) {
            e("app", "cuid", str);
            this.ofr = str;
            return this;
        }

        public Builder VS(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder VT(String str) {
            this.ofz = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dYK() {
            return this.ofz;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dYL() {
            return this.ofy.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine dYM() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                VP(c.gm(this.mContext));
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
        private final Long odO;
        @Nullable
        private final Long odP;
        @Nullable
        private final Long ofA;
        @Nullable
        private final Long ofB;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.odO = l;
            this.odP = l2;
            this.ofA = l3;
            this.ofB = l4;
        }
    }

    public long dXN() {
        return 0L;
    }
}
