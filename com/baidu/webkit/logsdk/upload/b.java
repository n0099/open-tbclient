package com.baidu.webkit.logsdk.upload;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.net.URLEncoder;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f27529a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Long, a> f27530b = new ConcurrentHashMap<>();

    public static JSONObject a(a aVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "1");
            jSONObject.putOpt("log_type", aVar.f27524e.f27489a);
            jSONObject.putOpt("file", Boolean.valueOf(aVar.f27522c));
            jSONObject.putOpt("upload_time", Long.valueOf(j));
            jSONObject.putOpt("retry_count", Integer.valueOf(aVar.f27521b));
            jSONObject.putOpt("f2", aVar.f27525f);
            com.baidu.webkit.logsdk.a.b.a().e();
            jSONObject.putOpt("f1", com.baidu.webkit.logsdk.b.b.e());
            jSONObject.putOpt("f3", com.baidu.webkit.logsdk.b.b.g());
            jSONObject.putOpt("log_level", Integer.valueOf(aVar.f27524e.f27490b));
            String str = aVar.f27528i;
            String a2 = (TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equals(str)) ? "full".equals(aVar.f27524e.f27493e) ? com.baidu.webkit.logsdk.a.b.a().g().a(com.baidu.webkit.logsdk.a.b.d()) : com.baidu.webkit.logsdk.a.b.a().g().b(com.baidu.webkit.logsdk.a.b.d(), aVar.f27524e.f27493e) : aVar.f27528i;
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.putOpt("base_info", Integer.toString(aVar.f27521b));
                aVar.f27528i = a2;
            }
            jSONObject.putOpt("content", aVar.f27520a);
        } catch (Throwable th) {
            com.baidu.webkit.logsdk.d.c.a(th);
        }
        return jSONObject;
    }

    public static void b(a aVar) {
        if (aVar.f27524e.f27490b == 1) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "real: content", com.baidu.webkit.logsdk.d.c.a(aVar.f27520a, aVar.f27525f));
        }
        if (aVar.f27524e.f27490b == 2) {
            try {
                JSONArray jSONArray = new JSONArray(aVar.f27520a);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "short: content", com.baidu.webkit.logsdk.d.c.a(jSONArray.getString(i2), aVar.f27525f));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (aVar.f27524e.f27490b == 3) {
            try {
                JSONObject jSONObject = new JSONObject(aVar.f27520a);
                JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: keyId=" + next);
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(next);
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        String a2 = com.baidu.webkit.logsdk.d.c.a(jSONArray2.getString(i3), next);
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: content=" + a2);
                    }
                }
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "long: static", com.baidu.webkit.logsdk.d.c.a(jSONObject.getString("static"), aVar.f27525f));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "baseinfo", com.baidu.webkit.logsdk.d.c.a(aVar.f27528i, aVar.f27525f));
    }

    public final String a(com.baidu.webkit.logsdk.b.a aVar) {
        String str;
        String str2;
        if ("full".equals(aVar.f27493e)) {
            com.baidu.webkit.logsdk.a.b a2 = com.baidu.webkit.logsdk.a.b.a();
            str = a2.g().a(a2.f27473d, this.f27529a);
            str2 = aVar.f27489a;
        } else {
            com.baidu.webkit.logsdk.a.b a3 = com.baidu.webkit.logsdk.a.b.a();
            String str3 = this.f27529a;
            String str4 = aVar.f27493e;
            if ("full".equals(str4)) {
                str = a3.g().a(a3.f27473d, str3);
            } else {
                com.baidu.webkit.logsdk.a.a g2 = a3.g();
                Context context = a3.f27473d;
                com.baidu.webkit.logsdk.b.c c2 = com.baidu.webkit.logsdk.a.b.a().e().c(str4);
                if ("full".equals(c2.f27500a)) {
                    str = g2.a(context, str3);
                } else {
                    HashSet<String> hashSet = c2.f27501b;
                    if (hashSet != null) {
                        StringBuilder sb = new StringBuilder(str3);
                        if (!hashSet.isEmpty() && str3.indexOf("?") < 0) {
                            sb.append("?");
                        }
                        com.baidu.webkit.logsdk.b c3 = com.baidu.webkit.logsdk.a.b.a().c();
                        Iterator<String> it = hashSet.iterator();
                        String str5 = "";
                        String str6 = "";
                        String str7 = str6;
                        String str8 = str7;
                        while (it.hasNext()) {
                            String next = it.next();
                            Iterator<String> it2 = it;
                            String a4 = g2.a(next, context, c3);
                            if ("ua".equals(next)) {
                                str6 = a4;
                            } else if ("cuid".equals(next)) {
                                str7 = a4;
                            } else if ("uid".equals(next)) {
                                str8 = a4;
                            }
                            if (TextUtils.isEmpty(a4)) {
                                int a5 = g2.a(next, context);
                                if (a5 > 0) {
                                    sb.append("&");
                                    sb.append(next);
                                    sb.append("=");
                                    sb.append(a5);
                                }
                            } else {
                                sb.append("&");
                                sb.append(next);
                                sb.append("=");
                                sb.append(a4);
                            }
                            it = it2;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            str5 = "ua";
                        }
                        if (!TextUtils.isEmpty(str7)) {
                            if (!TextUtils.isEmpty(str6)) {
                                str5 = str5 + "_";
                            }
                            str5 = str5 + "cuid";
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            if (!TextUtils.isEmpty(str7) || !TextUtils.isEmpty(str6)) {
                                str5 = str5 + "_";
                            }
                            str5 = str5 + "uid";
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            sb.append("&cen=");
                            sb.append(str5);
                        }
                        str = sb.toString();
                    } else {
                        str = str3;
                    }
                }
            }
            str2 = aVar.f27493e;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            if (sb2.indexOf("?") < 0) {
                sb2.append("?");
            } else {
                sb2.append("&");
            }
        }
        try {
            String encode = URLEncoder.encode(str2, "UTF-8");
            if (TextUtils.isEmpty(encode)) {
                sb2.append("lt=");
                sb2.append(str2);
            } else {
                sb2.append("lt=");
                sb2.append(encode);
            }
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
        return sb2.toString();
    }

    public final void a(long j) {
        if (j > 0) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mNetTasks remove " + j);
            this.f27530b.remove(Long.valueOf(j));
        }
    }

    public final void a(a aVar) {
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "onUploadFailed", null);
        if (this.f27530b.containsValue(aVar)) {
            com.baidu.webkit.logsdk.a.b.a().a(aVar, System.currentTimeMillis(), true);
        } else {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "onUploadFailed aTask not exists");
        }
    }

    public final boolean a() {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "isNetTaskAllComplete = " + this.f27530b.isEmpty());
        try {
            if (com.baidu.webkit.logsdk.a.f27457a && !this.f27530b.isEmpty()) {
                Iterator<Map.Entry<Long, a>> it = this.f27530b.entrySet().iterator();
                while (it.hasNext()) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "inComplete NetTask = " + it.next());
                }
            }
        } catch (ConcurrentModificationException e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
        return this.f27530b.isEmpty();
    }
}
