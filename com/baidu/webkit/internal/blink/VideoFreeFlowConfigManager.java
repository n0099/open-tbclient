package com.baidu.webkit.internal.blink;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class VideoFreeFlowConfigManager implements INoProGuard {
    public static final String DIRECT = "DIRECT";
    public static final String HOST_MATCH = "HOSTMATCH";
    public static final String HOST_STR = "HOSTSTR";
    public static final String HOST_STR_MATCH = "HOSTSTRMATCH";
    public static final int INDEX_MATCH_RULE = 0;
    public static final int INDEX_MATCH_STR = 1;
    public static final int INDEX_PAC_STR = 2;
    public static final String[] LOCAL_RULE_STRINGS = {"HOSTMATCH#m.baidu.com#DIRECT", "HOSTMATCH#mbd.baidu.com#DIRECT", "HOSTMATCH#vdf1.bdstatic.com#DIRECT", "HOSTMATCH#vdf2.bdstatic.com#DIRECT", "HOSTMATCH#vdf3.bdstatic.com#DIRECT", "HOSTMATCH#vdf4.bdstatic.com#DIRECT", "HOSTMATCH#shouji.baidu.com#DIRECT", "HOSTMATCH#appc.baidu.com#DIRECT", "HOSTMATCH#v.gdown.baidu.com #DIRECT", "HOSTMATCH#pan.baidu.com#DIRECT", "HOSTMATCH#d.pcs.baidu.com#DIRECT", "HOSTMATCH#pcs.baidu.com#DIRECT", "HOSTMATCH#pcsdata.baidu.com#DIRECT", "HOSTMATCH#thumbnail0.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail1.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail2.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail3.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail4.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail5.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail6.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail7.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail8.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail9.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail10.baidupcs.com#DIRECT", "HOSTMATCH#update.pan.baidu.com#DIRECT", "HOSTMATCH#d14.baidupcs.com#DIRECT", "HOSTMATCH#d16.baidupcs.com#DIRECT", "HOSTMATCH#v6.baidupcs.com#DIRECT", "HOSTMATCH#v8.baidupcs.com#DIRECT", "HOSTMATCH#allall05.baidupcs.com#DIRECT", "HOSTMATCH#allall04.baidupcs.com#DIRECT", "HOSTMATCH#allnest.pcs.baidu.com#DIRECT", "HOSTMATCH#c.pcs.baidu.com#DIRECT", "HOSTMATCH#tieba.baidu.com?#DIRECT", "HOSTMATCH#tiebac.baidu.com#DIRECT", "HOSTMATCH#c.tieba.baidu.com#DIRECT", "HOSTMATCH#client.map.baidu.com#DIRECT", "HOSTMATCH#newclient.map.baidu.com#DIRECT", "HOSTMATCH#map.baidu.com#DIRECT", "HOSTMATCH#loc.map.baidu.com#DIRECT", "HOSTMATCH#lbsyun.baidu.com#DIRECT", "HOSTMATCH#api.map.baidu.com#DIRECT", "HOSTMATCH#its.map.baidu.com#DIRECT", "HOSTMATCH#sv.map.baidu.com#DIRECT", "HOSTMATCH#wapmap.baidu.com#DIRECT", "HOSTMATCH#newvector.map.baidu.com#DIRECT", "HOSTMATCH#or.map.baidu.com#DIRECT", "HOSTMATCH#s0.map.bdimg.com#DIRECT", "HOSTMATCH#s1.map.bdimg.com#DIRECT", "HOSTMATCH#offmap2.baidu.com#DIRECT", "HOSTMATCH#offmap1.baidu.com#DIRECT", "HOSTMATCH#offmap0.baidu.com#DIRECT", "HOSTMATCH#wapmap0.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap1.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap2.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap3.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap4.map.bdimg.com#DIRECT", "HOSTMATCH#webapp0.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp1.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp2.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp3.map.bdstatic.com#DIRECT", "HOSTMATCH#webmap0.bdimg.com#DIRECT", "HOSTMATCH#webmap1.bdimg.com#DIRECT", "HOSTMATCH#webmap2.bdimg.com#DIRECT", "HOSTMATCH#webmap3.bdimg.com#DIRECT", "HOSTMATCH#webmap4.bdimg.com#DIRECT", "HOSTMATCH#hiphotos.baidu.com#DIRECT", "HOSTMATCH#imgsrc.baidu.com#DIRECT", "HOSTMATCH#hiphotos.bdimg.com#DIRECT", "HOSTMATCH#picphotos.baidu.com#DIRECT", "HOSTMATCH#imgsrc.bdimg.com#DIRECT", "HOSTMATCH#imagecdn.baidu.com#DIRECT", "HOSTMATCH#q1.baidu.com#DIRECT", "HOSTMATCH#q2.baidu.com#DIRECT", "HOSTMATCH#q3.baidu.com#DIRECT", "HOSTMATCH#q4.baidu.com#DIRECT", "HOSTMATCH#q5.baidu.com#DIRECT", "HOSTMATCH#q6.baidu.com#DIRECT", "HOSTMATCH#q7.baidu.com#DIRECT", "HOSTMATCH#q8.baidu.com#DIRECT", "HOSTMATCH#t1.baidu.com#DIRECT", "HOSTMATCH#t2.baidu.com#DIRECT", "HOSTMATCH#t3.baidu.com#DIRECT", "HOSTMATCH#t4.baidu.com#DIRECT", "HOSTMATCH#t10.baidu.com#DIRECT", "HOSTMATCH#t11.baidu.com#DIRECT", "HOSTMATCH#t12.baidu.com#DIRECT", "HOSTMATCH#i1.baidu.com#DIRECT", "HOSTMATCH#i2.baidu.com#DIRECT", "HOSTMATCH#i3.baidu.com#DIRECT", "HOSTMATCH#i4.baidu.com#DIRECT", "HOSTMATCH#i5.baidu.com#DIRECT", "HOSTMATCH#i6.baidu.com#DIRECT", "HOSTMATCH#i7.baidu.com#DIRECT", "HOSTMATCH#i8.baidu.com#DIRECT", "HOSTMATCH#i9.baidu.com#DIRECT", "HOSTMATCH#i10.baidu.com#DIRECT", "HOSTMATCH#i11.baidu.com#DIRECT", "HOSTMATCH#i12.baidu.com#DIRECT", "HOSTMATCH#tnimg1.baidu.com#DIRECT", "HOSTMATCH#tnimg2.baidu.com#DIRECT", "HOSTMATCH#img0.bdstatic.com#DIRECT", "HOSTMATCH#img1.bdstatic.com#DIRECT", "HOSTMATCH#img2.bdstatic.com#DIRECT", "HOSTMATCH#img3.bdstatic.com#DIRECT", "HOSTMATCH#img4.bdstatic.com#DIRECT", "HOSTMATCH#img5.bdstatic.com#DIRECT", "HOSTMATCH#img6.bdstatic.com#DIRECT", "HOSTMATCH#img7.bdstatic.com#DIRECT", "HOSTMATCH#f10.baidu.com#DIRECT", "HOSTMATCH#f11.baidu.com#DIRECT", "HOSTMATCH#f12.baidu.com#DIRECT", "HOSTMATCH#timg01.bdimg.com#DIRECT", "HOSTMATCH#timg02.bdimg.com#DIRECT", "HOSTMATCH#timg03.bdimg.com#DIRECT", "HOSTMATCH#timg04.bdimg.com#DIRECT", "HOSTMATCH#timg05.bdimg.com#DIRECT", "HOSTMATCH#cdn00.baidu-img.cn#DIRECT", "HOSTMATCH#cdn01.baidu-img.cn#DIRECT", "HOSTMATCH#cdn02.baidu-img.cn#DIRECT", "HOSTMATCH#cdn03.baidu-img.cn#DIRECT", "HOSTMATCH#wiseala.baidu-img.cn#DIRECT", "HOSTMATCH#wa1.baidu-1img.cn#DIRECT", "HOSTMATCH#wa2.baidu-1img.cn#DIRECT", "HOSTMATCH#wa3.baidu-1img.cn#DIRECT", "HOSTMATCH#imgtn.bdimg.com#DIRECT", "HOSTMATCH#browserkernel.baidu.com#DIRECT", "HOSTMATCH#browsersafe.baidu.com#DIRECT", "URLMATCH#https://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "URLMATCH#ws://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "URLMATCH#wss://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "HOSTMATCH#*#PROXY cloudnproxy.baidu.com:443;DIRECT;"};
    public static final String PROXY = "PROXY";
    public static final String SEPARATOR_STR = "#";
    public static final String TAG = "VideoFreeFlowConfigManager";
    public static final String URL_MATCH = "URLMATCH";
    public static VideoFreeFlowConfigManager sInstance;
    public ArrayList<a> mPacRulesList = new ArrayList<>();
    public byte[] mListLock = new byte[0];

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26569a;

        /* renamed from: b  reason: collision with root package name */
        public String f26570b;

        /* renamed from: c  reason: collision with root package name */
        public String f26571c;

        /* renamed from: d  reason: collision with root package name */
        public int f26572d;

        /* renamed from: e  reason: collision with root package name */
        public String f26573e;

        public a(String str) {
            this.f26569a = null;
            this.f26570b = null;
            this.f26571c = null;
            this.f26572d = 2;
            this.f26573e = null;
            if (TextUtils.isEmpty(str) || !str.contains("#")) {
                return;
            }
            String[] split = str.split("#");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (i == 0) {
                        this.f26569a = split[i];
                    } else if (i == 1) {
                        this.f26570b = split[i];
                    } else if (i == 2) {
                        String str2 = split[i];
                        this.f26571c = str2;
                        if (!TextUtils.isEmpty(str2)) {
                            String trim = str2.trim();
                            this.f26571c = trim;
                            if (trim.startsWith(VideoFreeFlowConfigManager.DIRECT)) {
                                this.f26572d = 2;
                            } else if (this.f26571c.startsWith(VideoFreeFlowConfigManager.PROXY)) {
                                this.f26572d = 1;
                                String str3 = this.f26571c;
                                String trim2 = str3.substring(str3.indexOf(VideoFreeFlowConfigManager.PROXY) + 5).trim();
                                if (!TextUtils.isEmpty(trim2)) {
                                    String[] split2 = trim2.split(";");
                                    if (split2.length > 0 && !TextUtils.isEmpty(split2[0])) {
                                        this.f26573e = split2[0];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009f, code lost:
        if (r3.indexOf(r6.f26570b) != (-1)) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb A[Catch: all -> 0x00e0, TryCatch #0 {, blocks: (B:10:0x0012, B:12:0x0024, B:14:0x0033, B:16:0x003b, B:18:0x0043, B:21:0x004d, B:50:0x00cb, B:52:0x00cf, B:53:0x00d1, B:55:0x00d3, B:57:0x00d8, B:59:0x00da, B:24:0x005a, B:26:0x0064, B:28:0x006a, B:30:0x0076, B:33:0x008e, B:35:0x0099, B:38:0x00a2, B:40:0x00ac, B:43:0x00b5, B:45:0x00bf, B:60:0x00de), top: B:65:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00da A[SYNTHETIC] */
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
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.f26569a) && !TextUtils.isEmpty(aVar.f26570b) && !TextUtils.isEmpty(aVar.f26571c)) {
                        if (!aVar.f26570b.equals("*")) {
                            if (aVar.f26569a.equals(HOST_MATCH)) {
                                if (!TextUtils.isEmpty(host) && host.length() >= aVar.f26570b.length() && host.substring(host.length() - aVar.f26570b.length()).equals(aVar.f26570b)) {
                                }
                            } else if (!aVar.f26569a.equals(HOST_STR)) {
                                if (aVar.f26569a.equals(HOST_STR_MATCH)) {
                                    if (host.equals(aVar.f26570b)) {
                                    }
                                } else if (aVar.f26569a.equals(URL_MATCH) && str.indexOf(aVar.f26570b) != -1) {
                                }
                            }
                            if (z) {
                                if (aVar.f26572d == 1) {
                                    return aVar.f26573e;
                                } else if (aVar.f26572d == 2) {
                                    return null;
                                }
                            }
                        }
                        z = true;
                        if (z) {
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
