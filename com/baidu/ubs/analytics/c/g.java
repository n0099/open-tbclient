package com.baidu.ubs.analytics.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.ubs.analytics.b.b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class g {
    private static int lOD = 0;

    static /* synthetic */ int dlj() {
        int i = lOD;
        lOD = i + 1;
        return i;
    }

    public static void b(com.baidu.ubs.analytics.c cVar) {
        int h = cVar.h();
        if (h < 1000) {
            String i = i.i(cVar.b());
            int length = i.length();
            byte[] bArr = new byte[length << 1];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = i.charAt(i3);
                int i4 = i2 + 1;
                bArr[i2] = (byte) (charAt & 255);
                i2 = i4 + 1;
                bArr[i4] = (byte) (charAt >> '\b');
            }
            int length2 = bArr.length;
            int i5 = (-1756908916) ^ length2;
            int i6 = length2 / 4;
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = i7 * 4;
                int i9 = (((bArr[i8 + 3] & 255) << 24) + (bArr[i8 + 0] & 255) + ((bArr[i8 + 1] & 255) << 8) + ((bArr[i8 + 2] & 255) << 16)) * 1540483477;
                i5 = (i5 * 1540483477) ^ ((i9 ^ (i9 >>> 24)) * 1540483477);
            }
            int i10 = length2 % 4;
            if (i10 == 3) {
                i5 = (((i5 ^ ((bArr[(length2 & (-4)) + 2] & 255) << 16)) ^ ((bArr[(length2 & (-4)) + 1] & 255) << 8)) ^ (bArr[length2 & (-4)] & 255)) * 1540483477;
            } else if (i10 == 2) {
                i5 = ((i5 ^ ((bArr[(length2 & (-4)) + 1] & 255) << 8)) ^ (bArr[length2 & (-4)] & 255)) * 1540483477;
            } else if (i10 == 1) {
                i5 = (i5 ^ (bArr[length2 & (-4)] & 255)) * 1540483477;
            }
            int i11 = (i5 ^ (i5 >>> 13)) * 1540483477;
            if (Math.abs((i11 ^ (i11 >>> 15)) % 1000) >= h) {
                com.baidu.ubs.analytics.a.vp(false);
                return;
            }
        }
        com.baidu.ubs.analytics.d.dkU().a(cVar.b());
        com.baidu.ubs.analytics.a.vp(true);
        com.baidu.ubs.analytics.d.j.c(cVar.c());
        com.baidu.ubs.analytics.d.b.I(com.baidu.ubs.analytics.d.a.u() + "-进行一次 初始化   " + new Date().toLocaleString() + "  " + f(cVar.b()));
        f.a(cVar.d());
        f.b(cVar.e());
        f.b(cVar.g());
        f.c(cVar.f());
        b.c(cVar.b());
        final Context b = cVar.b();
        com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.g.2
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                g.g(b);
                if (com.baidu.ubs.analytics.d.dkU().k() != null && !com.baidu.ubs.analytics.d.dkU().k().equals("")) {
                    com.baidu.ubs.analytics.d.j.G("BaiDuAB sdk  init success");
                } else {
                    String d = g.d(com.baidu.ubs.analytics.d.dkU().getContext());
                    if (d == null || d.equals("")) {
                        com.baidu.ubs.analytics.d.j.I("SDK getToken Error do you have set correct  BAIDUAB_APPKEY in Manifest or network is available");
                        return;
                    }
                }
                g.af();
                g.ae();
                com.baidu.ubs.analytics.d.c.a(new k(), f.dlh(), f.dlg());
                com.baidu.ubs.analytics.d.k.init();
            }
        });
    }

    public static void ae() {
        if (TextUtils.isEmpty(com.baidu.ubs.analytics.d.dkU().l())) {
            af();
        }
        if (!TextUtils.isEmpty(com.baidu.ubs.analytics.d.dkU().l())) {
            HashMap hashMap = new HashMap();
            hashMap.put("package", com.baidu.ubs.analytics.d.dkU().getContext().getPackageName());
            hashMap.put("cuid", com.baidu.ubs.analytics.d.dkU().l());
            com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.m("http://absample.baidu.com/appabapp/appapi/getgroup", hashMap), new b.a<JSONArray>() { // from class: com.baidu.ubs.analytics.c.g.1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.baidu.ubs.analytics.b.b.a
                public final /* synthetic */ void a(JSONArray jSONArray) {
                    JSONArray jSONArray2 = jSONArray;
                    StringBuffer stringBuffer = new StringBuffer();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                        com.baidu.ubs.analytics.a.g gVar = new com.baidu.ubs.analytics.a.g();
                        gVar.setGroup(optJSONObject.optString(TbEnum.ParamKey.GROUP));
                        gVar.setId(optJSONObject.optString("id"));
                        gVar.y(optJSONObject.optString(UbcStatConstant.KEY_CONTENT_EXT_SID));
                        if (i > 0) {
                            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        stringBuffer.append(gVar.getId());
                        arrayList.add(gVar);
                    }
                    com.baidu.ubs.analytics.d.dkU().a(arrayList);
                    g.F(stringBuffer.toString());
                }

                @Override // com.baidu.ubs.analytics.b.b.a
                public final void E(String str) {
                    while (g.lOD < 2) {
                        synchronized (this) {
                            g.dlj();
                        }
                        g.ae();
                    }
                }
            });
        }
    }

    public static String d(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        String e = e(context);
        HashMap hashMap = new HashMap();
        hashMap.put("key", e);
        hashMap.put("package", context.getPackageName());
        com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.m("http://absample.baidu.com/appabapp/appapi/gettoken", hashMap), new b.a<JSONObject>() { // from class: com.baidu.ubs.analytics.c.g.3
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.ubs.analytics.b.b.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                String optString = jSONObject.optString("token");
                if (optString == null || optString.isEmpty()) {
                    return;
                }
                com.baidu.ubs.analytics.d.dkU().a(optString);
                com.baidu.ubs.analytics.d.e.d("token", optString);
                com.baidu.ubs.analytics.d.e.putLong("token_update_time", currentTimeMillis);
                com.baidu.ubs.analytics.d.e.d("lastkey", g.e(context));
            }

            @Override // com.baidu.ubs.analytics.b.b.a
            public final void E(String str) {
                com.baidu.ubs.analytics.d.j.I("SDK getToken Error do you have set correct  BAIDUAB_APPKEY  in Manifest   or network is available");
            }
        });
        return com.baidu.ubs.analytics.d.dkU().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void af() {
        String c = com.baidu.ubs.analytics.d.e.c("cuid", "");
        if (!TextUtils.isEmpty(c)) {
            com.baidu.ubs.analytics.d.b.I("本地 取得  cuid~~");
            com.baidu.ubs.analytics.d.dkU().b(c);
            return;
        }
        com.baidu.ubs.analytics.d.b.I("网络请求  cuid~~");
        HashMap hashMap = new HashMap();
        hashMap.put("imei", i.k(com.baidu.ubs.analytics.d.dkU().getContext()));
        hashMap.put("mac", i.l(com.baidu.ubs.analytics.d.dkU().getContext()));
        com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.m("http://absample.baidu.com/appabapp/appapi/getcuid", hashMap), new b.a<JSONObject>() { // from class: com.baidu.ubs.analytics.c.g.4
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.ubs.analytics.b.b.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                String optString = jSONObject.optString("cuid");
                if (TextUtils.isEmpty(optString)) {
                    com.baidu.ubs.analytics.d.dkU().b("");
                    return;
                }
                com.baidu.ubs.analytics.d.dkU().b(optString);
                com.baidu.ubs.analytics.d.e.d("cuid", optString);
            }

            @Override // com.baidu.ubs.analytics.b.b.a
            public final void E(String str) {
                if (str.equals("1")) {
                    com.baidu.ubs.analytics.d.dkU().b("");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BAIDUAB_APPKEY");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String f(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager.getRunningAppProcesses() == null) {
            return "unknow";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "unknow";
    }

    static /* synthetic */ void F(final String str) {
        com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.g.5
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                if (!com.baidu.ubs.analytics.d.e.NG("status_updated")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("exids", str);
                    com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.m("http://absample.baidu.com/appabapp/appapi/updateStatus", hashMap), new b.a<JSONObject>() { // from class: com.baidu.ubs.analytics.c.g.5.1
                        @Override // com.baidu.ubs.analytics.b.b.a
                        public final void E(String str2) {
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.baidu.ubs.analytics.b.b.a
                        public final /* synthetic */ void a(JSONObject jSONObject) {
                            com.baidu.ubs.analytics.d.e.J("status_updated");
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ String g(Context context) {
        String c = com.baidu.ubs.analytics.d.e.c("lastkey", "");
        long NH = com.baidu.ubs.analytics.d.e.NH("token_update_time");
        if (c.equals(e(context)) && 86400000 + NH >= System.currentTimeMillis()) {
            String c2 = com.baidu.ubs.analytics.d.e.c("token", "");
            if (!c2.equals("")) {
                com.baidu.ubs.analytics.d.dkU().a(c2);
                return c2;
            }
        }
        return d(context);
    }
}
