package com.baidu.webkit.internal.blink;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class VideoFreeFlowConfigManager implements INoProGuard {
    public static final String DIRECT = "DIRECT";
    public static final String HOST_MATCH = "HOSTMATCH";
    public static final String HOST_STR = "HOSTSTR";
    public static final String HOST_STR_MATCH = "HOSTSTRMATCH";
    public static final int INDEX_MATCH_RULE = 0;
    public static final int INDEX_MATCH_STR = 1;
    public static final int INDEX_PAC_STR = 2;
    public static final String PROXY = "PROXY";
    public static final String SEPARATOR_STR = "#";
    public static final String TAG = "VideoFreeFlowConfigManager";
    public static final String URL_MATCH = "URLMATCH";
    private static VideoFreeFlowConfigManager sInstance;
    private ArrayList<a> mPacRulesList = new ArrayList<>();
    private byte[] mListLock = new byte[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        String a;
        String b;
        String c;
        int d;
        String e;

        public a(String str) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 2;
            this.e = null;
            if (TextUtils.isEmpty(str) || !str.contains("#")) {
                return;
            }
            String[] split = str.split("#");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (i == 0) {
                        this.a = split[i];
                    } else if (i == 1) {
                        this.b = split[i];
                    } else if (i == 2) {
                        this.c = split[i];
                        String str2 = this.c;
                        if (!TextUtils.isEmpty(str2)) {
                            this.c = str2.trim();
                            if (this.c.startsWith(VideoFreeFlowConfigManager.DIRECT)) {
                                this.d = 2;
                            } else if (this.c.startsWith(VideoFreeFlowConfigManager.PROXY)) {
                                this.d = 1;
                                String trim = this.c.substring(this.c.indexOf(VideoFreeFlowConfigManager.PROXY) + 5).trim();
                                if (!TextUtils.isEmpty(trim)) {
                                    String[] split2 = trim.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                    if (split2.length > 0 && !TextUtils.isEmpty(split2[0])) {
                                        this.e = split2[0];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private VideoFreeFlowConfigManager() {
    }

    public static synchronized VideoFreeFlowConfigManager getInstance() {
        VideoFreeFlowConfigManager videoFreeFlowConfigManager;
        synchronized (VideoFreeFlowConfigManager.class) {
            if (sInstance == null) {
                sInstance = new VideoFreeFlowConfigManager();
            }
            videoFreeFlowConfigManager = sInstance;
        }
        return videoFreeFlowConfigManager;
    }

    private void initPacRule(String str) {
        Log.w(TAG, "initPacRule:" + str);
        synchronized (this.mListLock) {
            this.mPacRulesList.clear();
            for (String str2 : str.split("\n")) {
                this.mPacRulesList.add(new a(str2));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[Catch: all -> 0x0059, TryCatch #0 {, blocks: (B:11:0x0017, B:13:0x0028, B:15:0x0036, B:17:0x003e, B:19:0x0046, B:31:0x005c, B:23:0x0051, B:25:0x0055, B:26:0x0057, B:59:0x00e2, B:61:0x00e7, B:63:0x00eb, B:34:0x0069, B:36:0x0074, B:38:0x007a, B:40:0x0086, B:43:0x009f, B:45:0x00aa, B:48:0x00b4, B:50:0x00bf, B:53:0x00c9, B:55:0x00d4, B:64:0x00f0), top: B:66:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00eb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getFreeFlowProxy(String str) {
        boolean z;
        if (isFreeFlowEnable() && !TextUtils.isEmpty(str)) {
            synchronized (this.mListLock) {
                int size = this.mPacRulesList.size();
                String host = Uri.parse(str).getHost();
                for (int i = 0; i < size; i++) {
                    a aVar = this.mPacRulesList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(aVar.a) || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(aVar.c)) {
                            z = false;
                        } else if (aVar.b.equals("*")) {
                            z = true;
                        } else if (aVar.a.equals(HOST_MATCH)) {
                            if (!TextUtils.isEmpty(host) && host.length() >= aVar.b.length() && host.substring(host.length() - aVar.b.length()).equals(aVar.b)) {
                                z = true;
                            }
                        } else if (aVar.a.equals(HOST_STR)) {
                            if (host.indexOf(aVar.b) != -1) {
                                z = true;
                            }
                        } else if (aVar.a.equals(HOST_STR_MATCH)) {
                            if (host.equals(aVar.b)) {
                                z = true;
                            }
                        } else if (aVar.a.equals(URL_MATCH) && str.indexOf(aVar.b) != -1) {
                            z = true;
                        }
                        if (z) {
                            if (aVar.d == 1) {
                                return aVar.e;
                            } else if (aVar.d == 2) {
                                return null;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
                return null;
            }
        }
        return null;
    }

    public boolean isFreeFlowEnable() {
        return WebSettingsGlobalBlink.canUseFreeFlow();
    }

    public void setPacData(String str) {
        initPacRule(str);
    }
}
