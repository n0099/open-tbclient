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
/* loaded from: classes10.dex */
public abstract class TurbonetEngine {

    /* loaded from: classes10.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    /* loaded from: classes10.dex */
    public enum QUICConnectStatus {
        UNKNOWN,
        REACHABLE,
        UNREACHABLE
    }

    /* loaded from: classes10.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes10.dex */
    public enum TCPNetworkQualityStatus {
        UNKNOWN,
        WEAK,
        NORMAL
    }

    /* loaded from: classes10.dex */
    public static final class UrlRequestInfo {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    public abstract boolean dKE();

    abstract boolean isEnabled();

    /* loaded from: classes10.dex */
    public static class Builder {
        private String dKl;
        private String mAppName;
        private final Context mContext;
        private String mUserAgent;
        private boolean nbZ;
        private boolean nbx;
        private long ndA;
        private JSONObject ndB;
        private String ndC;
        private String nds;
        private String ndu;
        private LibraryLoader ndv;
        private String ndw;
        private boolean ndx;
        private boolean ndy;
        private int ndz;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes10.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes10.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this.mContext = context;
            Tn("turbonet");
            this.ndB = new JSONObject();
            xH(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dLd() {
            if (this.ndv == null) {
                if (this.ndw.equals("turbonet")) {
                    System.loadLibrary(this.ndw);
                    return;
                } else {
                    System.load(this.ndw);
                    return;
                }
            }
            this.ndv.loadLibrary(this.ndw);
        }

        public Builder Tn(String str) {
            this.ndw = str;
            return this;
        }

        private void e(String str, String str2, Object obj) {
            try {
                JSONObject optJSONObject = this.ndB.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.ndB.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }

        public Builder To(String str) {
            e(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
            this.mUserAgent = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        public Builder xH(boolean z) {
            e(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.ndx = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dLe() {
            return this.ndx;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dLf() {
            return this.ndy;
        }

        public Builder Tp(String str) {
            if (!new File(str).isDirectory()) {
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            this.nds = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dKZ() {
            return this.nds;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean cacheDisabled() {
            return this.nbx;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long dLg() {
            return this.ndA;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int dLh() {
            return this.ndz;
        }

        public String getAppPackageName() {
            return this.dKl;
        }

        public Builder G(boolean z, String str) {
            e("nq", "network_quality_enabled", Boolean.valueOf(z));
            e("nq", "watched_groups", str);
            this.nbZ = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean dLi() {
            return this.nbZ;
        }

        public Builder Tq(String str) {
            e("app", "cuid", str);
            this.ndu = str;
            return this;
        }

        public Builder Tr(String str) {
            e("app", "app_name", str);
            this.mAppName = str;
            return this;
        }

        public Builder Ts(String str) {
            this.ndC = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dLj() {
            return this.ndC;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String dLk() {
            return this.ndB.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.mContext;
        }

        public TurbonetEngine dLl() {
            String str = "";
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getPath();
            } else {
                Log.e("chromium", "SD card is not mounted correctly");
            }
            e(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
            if (getUserAgent() == null) {
                To(c.fW(this.mContext));
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

    /* loaded from: classes10.dex */
    public static final class UrlRequestMetrics {
        @Nullable
        private final Long nbR;
        @Nullable
        private final Long nbS;
        @Nullable
        private final Long ndD;
        @Nullable
        private final Long ndE;

        public UrlRequestMetrics(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
            this.nbR = l;
            this.nbS = l2;
            this.ndD = l3;
            this.ndE = l4;
        }
    }

    public long dKl() {
        return 0L;
    }
}
