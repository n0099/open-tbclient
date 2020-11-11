package com.baidu.webkit.internal.blink;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class VideoFreeFlowConfigManager implements INoProGuard {
    public static final String DIRECT = "DIRECT";
    public static final String HOST_MATCH = "HOSTMATCH";
    public static final String HOST_STR = "HOSTSTR";
    public static final String HOST_STR_MATCH = "HOSTSTRMATCH";
    public static final int INDEX_MATCH_RULE = 0;
    public static final int INDEX_MATCH_STR = 1;
    public static final int INDEX_PAC_STR = 2;
    private static final String[] LOCAL_RULE_STRINGS = {"HOSTMATCH#m.baidu.com#DIRECT", "HOSTMATCH#mbd.baidu.com#DIRECT", "HOSTMATCH#vdf1.bdstatic.com#DIRECT", "HOSTMATCH#vdf2.bdstatic.com#DIRECT", "HOSTMATCH#vdf3.bdstatic.com#DIRECT", "HOSTMATCH#vdf4.bdstatic.com#DIRECT", "HOSTMATCH#shouji.baidu.com#DIRECT", "HOSTMATCH#appc.baidu.com#DIRECT", "HOSTMATCH#v.gdown.baidu.com #DIRECT", "HOSTMATCH#pan.baidu.com#DIRECT", "HOSTMATCH#d.pcs.baidu.com#DIRECT", "HOSTMATCH#pcs.baidu.com#DIRECT", "HOSTMATCH#pcsdata.baidu.com#DIRECT", "HOSTMATCH#thumbnail0.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail1.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail2.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail3.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail4.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail5.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail6.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail7.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail8.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail9.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail10.baidupcs.com#DIRECT", "HOSTMATCH#update.pan.baidu.com#DIRECT", "HOSTMATCH#d14.baidupcs.com#DIRECT", "HOSTMATCH#d16.baidupcs.com#DIRECT", "HOSTMATCH#v6.baidupcs.com#DIRECT", "HOSTMATCH#v8.baidupcs.com#DIRECT", "HOSTMATCH#allall05.baidupcs.com#DIRECT", "HOSTMATCH#allall04.baidupcs.com#DIRECT", "HOSTMATCH#allnest.pcs.baidu.com#DIRECT", "HOSTMATCH#c.pcs.baidu.com#DIRECT", "HOSTMATCH#tieba.baidu.com?#DIRECT", "HOSTMATCH#tiebac.baidu.com#DIRECT", "HOSTMATCH#c.tieba.baidu.com#DIRECT", "HOSTMATCH#client.map.baidu.com#DIRECT", "HOSTMATCH#newclient.map.baidu.com#DIRECT", "HOSTMATCH#map.baidu.com#DIRECT", "HOSTMATCH#loc.map.baidu.com#DIRECT", "HOSTMATCH#lbsyun.baidu.com#DIRECT", "HOSTMATCH#api.map.baidu.com#DIRECT", "HOSTMATCH#its.map.baidu.com#DIRECT", "HOSTMATCH#sv.map.baidu.com#DIRECT", "HOSTMATCH#wapmap.baidu.com#DIRECT", "HOSTMATCH#newvector.map.baidu.com#DIRECT", "HOSTMATCH#or.map.baidu.com#DIRECT", "HOSTMATCH#s0.map.bdimg.com#DIRECT", "HOSTMATCH#s1.map.bdimg.com#DIRECT", "HOSTMATCH#offmap2.baidu.com#DIRECT", "HOSTMATCH#offmap1.baidu.com#DIRECT", "HOSTMATCH#offmap0.baidu.com#DIRECT", "HOSTMATCH#wapmap0.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap1.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap2.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap3.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap4.map.bdimg.com#DIRECT", "HOSTMATCH#webapp0.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp1.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp2.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp3.map.bdstatic.com#DIRECT", "HOSTMATCH#webmap0.bdimg.com#DIRECT", "HOSTMATCH#webmap1.bdimg.com#DIRECT", "HOSTMATCH#webmap2.bdimg.com#DIRECT", "HOSTMATCH#webmap3.bdimg.com#DIRECT", "HOSTMATCH#webmap4.bdimg.com#DIRECT", "HOSTMATCH#hiphotos.baidu.com#DIRECT", "HOSTMATCH#imgsrc.baidu.com#DIRECT", "HOSTMATCH#hiphotos.bdimg.com#DIRECT", "HOSTMATCH#picphotos.baidu.com#DIRECT", "HOSTMATCH#imgsrc.bdimg.com#DIRECT", "HOSTMATCH#imagecdn.baidu.com#DIRECT", "HOSTMATCH#q1.baidu.com#DIRECT", "HOSTMATCH#q2.baidu.com#DIRECT", "HOSTMATCH#q3.baidu.com#DIRECT", "HOSTMATCH#q4.baidu.com#DIRECT", "HOSTMATCH#q5.baidu.com#DIRECT", "HOSTMATCH#q6.baidu.com#DIRECT", "HOSTMATCH#q7.baidu.com#DIRECT", "HOSTMATCH#q8.baidu.com#DIRECT", "HOSTMATCH#t1.baidu.com#DIRECT", "HOSTMATCH#t2.baidu.com#DIRECT", "HOSTMATCH#t3.baidu.com#DIRECT", "HOSTMATCH#t4.baidu.com#DIRECT", "HOSTMATCH#t10.baidu.com#DIRECT", "HOSTMATCH#t11.baidu.com#DIRECT", "HOSTMATCH#t12.baidu.com#DIRECT", "HOSTMATCH#i1.baidu.com#DIRECT", "HOSTMATCH#i2.baidu.com#DIRECT", "HOSTMATCH#i3.baidu.com#DIRECT", "HOSTMATCH#i4.baidu.com#DIRECT", "HOSTMATCH#i5.baidu.com#DIRECT", "HOSTMATCH#i6.baidu.com#DIRECT", "HOSTMATCH#i7.baidu.com#DIRECT", "HOSTMATCH#i8.baidu.com#DIRECT", "HOSTMATCH#i9.baidu.com#DIRECT", "HOSTMATCH#i10.baidu.com#DIRECT", "HOSTMATCH#i11.baidu.com#DIRECT", "HOSTMATCH#i12.baidu.com#DIRECT", "HOSTMATCH#tnimg1.baidu.com#DIRECT", "HOSTMATCH#tnimg2.baidu.com#DIRECT", "HOSTMATCH#img0.bdstatic.com#DIRECT", "HOSTMATCH#img1.bdstatic.com#DIRECT", "HOSTMATCH#img2.bdstatic.com#DIRECT", "HOSTMATCH#img3.bdstatic.com#DIRECT", "HOSTMATCH#img4.bdstatic.com#DIRECT", "HOSTMATCH#img5.bdstatic.com#DIRECT", "HOSTMATCH#img6.bdstatic.com#DIRECT", "HOSTMATCH#img7.bdstatic.com#DIRECT", "HOSTMATCH#f10.baidu.com#DIRECT", "HOSTMATCH#f11.baidu.com#DIRECT", "HOSTMATCH#f12.baidu.com#DIRECT", "HOSTMATCH#timg01.bdimg.com#DIRECT", "HOSTMATCH#timg02.bdimg.com#DIRECT", "HOSTMATCH#timg03.bdimg.com#DIRECT", "HOSTMATCH#timg04.bdimg.com#DIRECT", "HOSTMATCH#timg05.bdimg.com#DIRECT", "HOSTMATCH#cdn00.baidu-img.cn#DIRECT", "HOSTMATCH#cdn01.baidu-img.cn#DIRECT", "HOSTMATCH#cdn02.baidu-img.cn#DIRECT", "HOSTMATCH#cdn03.baidu-img.cn#DIRECT", "HOSTMATCH#wiseala.baidu-img.cn#DIRECT", "HOSTMATCH#wa1.baidu-1img.cn#DIRECT", "HOSTMATCH#wa2.baidu-1img.cn#DIRECT", "HOSTMATCH#wa3.baidu-1img.cn#DIRECT", "HOSTMATCH#imgtn.bdimg.com#DIRECT", "HOSTMATCH#browserkernel.baidu.com#DIRECT", "HOSTMATCH#browsersafe.baidu.com#DIRECT", "URLMATCH#https://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "URLMATCH#ws://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "URLMATCH#wss://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "HOSTMATCH#*#PROXY cloudnproxy.baidu.com:443;DIRECT;"};
    public static final String PROXY = "PROXY";
    public static final String SEPARATOR_STR = "#";
    public static final String TAG = "VideoFreeFlowConfigManager";
    public static final String URL_MATCH = "URLMATCH";
    private static VideoFreeFlowConfigManager sInstance;
    private ArrayList<a> mPacRulesList = new ArrayList<>();
    private byte[] mListLock = new byte[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f3925a;
        String b;
        String c;
        int d;
        String e;

        public a(String str) {
            this.f3925a = null;
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
                        this.f3925a = split[i];
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
                        if (TextUtils.isEmpty(aVar.f3925a) || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(aVar.c)) {
                            z = false;
                        } else if (aVar.b.equals("*")) {
                            z = true;
                        } else if (aVar.f3925a.equals(HOST_MATCH)) {
                            if (!TextUtils.isEmpty(host) && host.length() >= aVar.b.length() && host.substring(host.length() - aVar.b.length()).equals(aVar.b)) {
                                z = true;
                            }
                        } else if (aVar.f3925a.equals(HOST_STR)) {
                            if (host.indexOf(aVar.b) != -1) {
                                z = true;
                            }
                        } else if (aVar.f3925a.equals(HOST_STR_MATCH)) {
                            if (host.equals(aVar.b)) {
                                z = true;
                            }
                        } else if (aVar.f3925a.equals(URL_MATCH) && str.indexOf(aVar.b) != -1) {
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

    public void initLocalRule() {
        Log.w(TAG, "initLocalRule called");
        synchronized (this.mListLock) {
            this.mPacRulesList.clear();
            for (String str : LOCAL_RULE_STRINGS) {
                this.mPacRulesList.add(new a(str));
            }
        }
    }

    public boolean isFreeFlowEnable() {
        return WebSettingsGlobalBlink.canUseFreeFlow();
    }

    public void setPacData(String str) {
        initPacRule(str);
    }
}
